/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Helper.UsefulFunctions;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pranav
 */
public class CassandraPerformanceController implements Initializable {

    @FXML
    private Button back_button_cassandra_performance;
    
    @FXML 
    private ListView<String> query_list_cassandra;
    
    @FXML 
    private Button generate_graph;
    
    @FXML 
    private Button reset_graph;
    
    @FXML 
    private Button run_selected_query;
    
    @FXML 
    private TextField number_of_points;
    
    @FXML 
    private Button clear_last_point_graph;
    
    @FXML 
    private Label query_execution_time;
    
    @FXML 
    private Label graph_avg_time;
    
    @FXML 
    private Button select_database;
    
    @FXML
    private LineChart<Long, Long> execution_time_chart_cs;
    
    //non-FXML variables
    private int number_of_lines_generated = 0;
    private ArrayList<String> list_queries = new ArrayList<String>();
    private static CassandraPerformanceController controllerInstance;
    private LineChart.Series<Long,Long> chartSeries;
    private ArrayList<Long> executionTimeList = null;
    public long avg_time = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        list_queries = UsefulFunctions.initilizeQueryList();
        query_list_cassandra.getItems().addAll(list_queries);
        query_list_cassandra.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);   
        number_of_points.textProperty().addListener(new ChangeListener<String>() {           
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    number_of_points.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        controllerInstance = this;
    }    
    
     public void moveBackToMainScreen () {
        UsefulFunctions.changeScene("MainStage.fxml", getClass(), back_button_cassandra_performance);
    }
     
    public void generateGraph() {
        String s = number_of_points.getText();
        if (s!=null) {
            int n = Integer.parseInt(s);        
            number_of_lines_generated+=1;
            List<String> selectedQueries = new ArrayList<String>();
            selectedQueries = query_list_cassandra.getSelectionModel().getSelectedItems();      
            if (selectedQueries.size() == 1) {
                new CassandraJavaQueries().performTaskNTimes(n,selectedQueries.get(0));            
            } else {
                // add functionality here
            }
        }
    } 
    
    public void plotGraph (ArrayList<Long> executionTimes) {
        
        chartSeries = new XYChart.Series<>();
        this.executionTimeList = executionTimes;     
        System.out.println ("HEre in graph "+executionTimeList.size());
        for (int i = 0;i < executionTimeList.size(); i++){
            chartSeries.getData().add(new XYChart.Data<Long,Long>((long)(i+1), executionTimeList.get(i)));
            avg_time+=executionTimeList.get(i);
        }        
        execution_time_chart_cs.setCreateSymbols(true);
        execution_time_chart_cs.getData().add(chartSeries);        
        execution_time_chart_cs.getXAxis().setLabel("Number of Points");
        execution_time_chart_cs.getYAxis().setLabel("Execution Time in ms"); 
        if (avg_time!=0)
            graph_avg_time.setText(String.valueOf((avg_time/executionTimeList.size()))+" ms");
        avg_time = 0;
    }
    
    public void updateTime(long time) {        
        query_execution_time.setText(String.valueOf(time)+" ms");
    }
    
    public void clearGraphPoint() {
        if (execution_time_chart_cs.getData().size()>0) {
            System.out.println ("Clearing graph");
            //chartSeries.getData().removeAll(execution_time_chart.getData());
            number_of_lines_generated-=1;
            execution_time_chart_cs.getData().remove(execution_time_chart_cs.getData().size()-1);            
        }
    }
    
    public void resetGraph () {
        int s = number_of_lines_generated;
        for (int i = 0; i<s;i++) {
            clearGraphPoint();
        }      
    }
    
    public void selectDatabase() {
        Stage openDBStage = UsefulFunctions.prepareAnotherStage("/Helper/UIComponents/PopupOpenDB.fxml", getClass(), "Select Database");
        openDBStage.show();
    }
    
    public void runSelectedQueries () {
        List<String> selectedQueries = new ArrayList<String> ();
        selectedQueries = query_list_cassandra.getSelectionModel().getSelectedItems();
        if (selectedQueries.size() == 1) {
            new CassandraJavaQueries().perfromTask(selectedQueries);
        } else {
            UsefulFunctions.displayPopup("/Helper/UIComponents/NoQuerySelected.fxml", getClass());
        }
    }
    
    public static CassandraPerformanceController getController() {
        return controllerInstance;
    }
}
