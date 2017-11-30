/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper.UIComponents;

import Helper.DatabaseConnections;
import Helper.UsefulFunctions;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafxapplication1.App;

/**
 * FXML Controller class
 *
 * @author pranav
 */
public class PopupController implements Initializable {

    @FXML
    ListView list_created_dbs;
    
    @FXML 
    Button close_open_db_popup;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*try {
            // TODO
            Connection c = DatabaseConnections.connectToLocalhost();          
            ResultSet resultSet = c.getMetaData().getCatalogs();
            ArrayList<String> answer = (ArrayList<String>) UsefulFunctions.resturnResultSetAsJavaList(resultSet, String.class);
            list_created_dbs.getItems().addAll(answer); 
        } catch (SQLException ex) {
            Logger.getLogger(PopupController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }    
    
    public void openSelectedDB() {
       String selected_db = (String) list_created_dbs.getSelectionModel().getSelectedItem();
       App.current_db_name = selected_db;
       closePopup();
       // change scene to display the current DB 
    }
    
    public void closePopup() {
        Stage popup_stage = (Stage) close_open_db_popup.getScene().getWindow();
        popup_stage.close();
    }
    
}
