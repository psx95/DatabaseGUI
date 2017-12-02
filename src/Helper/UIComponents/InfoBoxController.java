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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pranav
 */
public class InfoBoxController implements Initializable {

    @FXML
    private Button ok_button;
    
    @FXML
    private static Label info_label;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public static void chnageInfo (String newInfo) {
        info_label.setText(newInfo);
    }
    
    public void handleOKAction () {
        Stage curr_stage = (Stage) ok_button.getScene().getWindow();
        curr_stage.close();
    }
}
