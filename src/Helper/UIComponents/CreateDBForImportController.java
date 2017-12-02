/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper.UIComponents;

import Helper.Constants;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafxapplication1.App;

/**
 * FXML Controller class
 *
 * @author pranav
 */
public class CreateDBForImportController implements Initializable {

    @FXML
    private TextField database_name_import;
    @FXML
    private Button button_ok;
    @FXML
    private Button button_cancel;    
    
    private Stage progressBar_import;
    private Scene progressBar_Scene;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO\
            Parent root = FXMLLoader.load(getClass().getResource("/Helper/UIComponents/ImportDatasetProgress.fxml"));
            progressBar_Scene = new Scene(root);
        } catch (IOException ex) {
            Logger.getLogger(CreateDBForImportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void handleActionOK () {
        // create DB and import in RespectiveDatabase
        switch (App.current_selcted_db) {
            case Constants.DB_NAME_MYSQL :
                handleImportForMySQL();
                break;
            case Constants.DB_NAME_MONGO :
                handleImportForMongoDB();
                break;
            case Constants.DB_NAME_POSTGRES :
                handleImportForPostgres();
                break;
            case Constants.DB_NAME_CASSANDRA :
                handleImportForCassandra();
                break;
            default: 
                break;
        }
    }
    
    public void handleActionCancel () {
        Stage curr_stage = (Stage) button_cancel.getScene().getWindow();
        curr_stage.close();
    }
    
    private void handleImportForMongoDB () {        
        System.out.println ("Control OK");
        String database_name = database_name_import.getText();
        if (database_name.equals("")) {
            return;
        }        
        Task executeImportTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                importMongoData();
                return null;
            }            
        }; 
        executeImportTask.setOnRunning(new EventHandler() {
            @Override
            public void handle(Event event) {
                progressBar_import = new Stage ();
                progressBar_import.setScene(progressBar_Scene);
                progressBar_import.initModality(Modality.APPLICATION_MODAL);
                progressBar_import.show();
            }
        });
        executeImportTask.setOnSucceeded(new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/Helper/UIComponent/InfoBox.fxml"));
                    Scene completed_import_scene = new Scene(root);
                    Label info = (Label) completed_import_scene.lookup("#info_label");
                    info.setText("Import Complete");
                    progressBar_import.setScene(completed_import_scene);
                } catch (IOException ex) {
                    Logger.getLogger(CreateDBForImportController.class.getName()).log(Level.SEVERE, null, ex);
                }                               
            }
        });
        executeImportTask.run();
    }
    
    private void importMongoData() {
        
    }
    
    private void handleImportForMySQL () {
        
    }
    
    private void handleImportForPostgres () {
        
    }
    
    private void handleImportForCassandra () {
        
    }
}
