/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.mysql;

import Helper.UsefulFunctions;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author pranav
 */
public class MySQLPerformanceController implements Initializable {

    @FXML
    private Button back_button_mysql_performance;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void moveBackToMainScreen () {
        UsefulFunctions.changeScene("/javafxapplication1/MainStage.fxml", getClass(), back_button_mysql_performance);
    }
    
}
