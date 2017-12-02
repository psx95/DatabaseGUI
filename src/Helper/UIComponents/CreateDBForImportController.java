/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper.UIComponents;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void handleActionOK () {
        // create DB and import in RespectiveDatabase
    }
    
    public void handleActionCancel () {
        Stage curr_stage = (Stage) button_cancel.getScene().getWindow();
        curr_stage.close();
    }
    
}
