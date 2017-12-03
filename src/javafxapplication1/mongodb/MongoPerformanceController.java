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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<String> queries = UsefulFunctions.initilizeQueryListForMongo();
        mongo_queries.getItems().addAll(queries);
        mongo_queries.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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
        UsefulFunctions.changeScene("MainStage.fxml", getClass(), back_button_mongo_performance);
    }
    
    public void runSelectedQueries() {
        List<String> selectedQueries = new ArrayList<String>();
        selectedQueries = mongo_queries.getSelectionModel().getSelectedItems();
        
    }
}
