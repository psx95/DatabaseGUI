/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Helper.UsefulFunctions;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void handleImportDatabase () {
        try {
            //open popup for CreateDBFor Import
            Parent root = FXMLLoader.load(getClass().getResource("/Helper/UIComponents/CreateDBForImport.fxml"));
            Stage s = new Stage();
            Scene scene = new Scene(root);
            s.setScene(scene);
            s.show();
        } catch (IOException ex) {
            Logger.getLogger(MongoPerformanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void moveBackToMainScreen () {
        UsefulFunctions.changeScene("MainStage.fxml", getClass(), back_button_mongo_performance);
    }
}
