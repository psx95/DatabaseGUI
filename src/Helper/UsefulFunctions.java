/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author pranav
 */
public class UsefulFunctions {
    
    
  public static ArrayList<?> resturnResultSetAsJavaList (ResultSet rs, Class c) {
      ArrayList<String> listAnswer = new ArrayList<>();
      try {        
          while (rs.next()) {           
             listAnswer.add(rs.getString("TABLE_CAT"));
          }         
      } catch (SQLException ex) {
          Logger.getLogger(UsefulFunctions.class.getName()).log(Level.SEVERE, null, ex);
      }
      return listAnswer;
  }
  
  public static Stage prepareAnotherStage (String location_scene, Class s, String title) {
      Stage stage = new Stage();
      Scene sc;
      try {
          sc = new Scene(FXMLLoader.load(s.getResource(location_scene)));
          stage.setScene(sc);         
          stage.setTitle(title);
          stage.initModality(Modality.APPLICATION_MODAL);
      } catch (IOException ex) {
          Logger.getLogger(UsefulFunctions.class.getName()).log(Level.SEVERE, null, ex);
      }     
      return stage;
  }
  
  public static Stage prepareAnotherStage (String location_scene, Class s) {
     return prepareAnotherStage(location_scene, s, "");
  }
  
}
