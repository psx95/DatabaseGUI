/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.mongodb;

import Helper.UsefulFunctions;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafxapplication1.MainStageController;

/**
 * FXML Controller class
 *
 * @author pranav
 */
public class MongoPerformanceController implements Initializable {

    @FXML 
    private Button back_button_mongo_performance;
    
    @FXML
    private Button import_dataset_mongo;
    
    @FXML
    private Button select_db_mongo;
    
    @FXML 
    private ListView mongo_queries;
    
    @FXML
    private Button run_query_mongo;
    
    @FXML
    private Label query_time;
    
    @FXML 
    private Button generate_graph_button;
    
    @FXML
    private TextField number_of_graph_points;
    
    @FXML
    private LineChart<Long,Long> execution_time_chart;
        
    
    public long time = 0;
    private static MongoPerformanceController controllerInstance;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<String> queries = UsefulFunctions.initilizeQueryListForMongo();
        mongo_queries.getItems().addAll(queries);
        mongo_queries.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);   
        number_of_graph_points.textProperty().addListener(new ChangeListener<String>() {           
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    number_of_graph_points.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        controllerInstance = this;
    }   
    
    
    public void handleImportDatabase () {
        try {
            //open popup for CreateDBFor Import
            Parent root = FXMLLoader.load(getClass().getResource("/Helper/UIComponents/CreateDBForImport.fxml"));
            Stage s = new Stage();
            Scene scene = new Scene(root);
            s.setScene(scene);
            s.initModality(Modality.APPLICATION_MODAL);
            s.show();
        } catch (IOException ex) {
            Logger.getLogger(MongoPerformanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void handleSelectDB () {
        Stage openDBStage = UsefulFunctions.prepareAnotherStage("/Helper/UIComponents/PopupOpenDB.fxml", getClass(), "Select Database");
        openDBStage.show();
    }
    
    public void moveBackToMainScreen () {
        UsefulFunctions.changeScene("/javafxapplication1/MainStage.fxml", getClass(), back_button_mongo_performance);
    }
    
    public void runSelectedQueries() {
        List<String> selectedQueries = new ArrayList<String>();
        selectedQueries = mongo_queries.getSelectionModel().getSelectedItems();        
        new MongoJavaQueries().performTask();       
        System.out.println ("Thread "+Thread.currentThread().getName() +" COntroller");
    }
    
    public Label getQueryLabel () {
        return query_time;
    }
    
    public void generateGraph(ArrayList<Long> executionTimeList) {
        LineChart.Series<Long,Long> chartSeries = new XYChart.Series<>();
        for (int i = 0;i < executionTimeList.size(); i++){
            chartSeries.getData().add(new XYChart.Data<Long,Long>((long)(i+1), executionTimeList.get(i)));
        }
        execution_time_chart.getData().add(chartSeries);
        execution_time_chart.getXAxis().setLabel("Number of Points");
        execution_time_chart.getYAxis().setLabel("Execution Time in ms");
    }
    
    public void performGraphTasks() {
        String s = number_of_graph_points.getText();
        if (s!=null) {
            int n = Integer.parseInt(s);        
            new MongoJavaQueries().performTaskNTimes(n);        
        }
    }
    
    public void updateTime (long time) {
        this.time = time;
        query_time.setText(String.valueOf(time)+" ms");
    }
    
    public static MongoPerformanceController getController () {
        return controllerInstance;
    }
}
