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
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafxapplication1.App;

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
  
  public static void universalExit () {
      try {
          if (App.cassandra_session != null)
            App.cassandra_session.close();
          if (App.cassandraCluster != null)
            App.cassandraCluster.close();
          if (App.mongodbClient != null)
            App.mongodbClient.close();
          if (App.mysqlConnection != null)
            App.mysqlConnection.close();         
          if (App.postgresConnection != null)
            App.postgresConnection.close();
          App.mysqlDriver = null;
          App.postresDriver = null;
          Platform.exit();
      } catch (SQLException ex) {
          Logger.getLogger(UsefulFunctions.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  public static void changeScene (String resourceName, Class curr_class, Node object) {
      try {
          Parent root = FXMLLoader.load(curr_class.getResource(resourceName));
          Stage curr_stage = (Stage) object.getScene().getWindow();          
          curr_stage.setScene(new Scene(root));
          curr_stage.show();
      } catch (IOException ex) {
          Logger.getLogger(UsefulFunctions.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  public static ArrayList<String> initilizeQueryListForMongo () {
      ArrayList<String> arrayList = new ArrayList<>();
      String[] queries = new String[] {
          "Query 1",
          "Query 2",
          "Query 3",
          "Query 4",
          "Query 5",
          "Query 6",
          "Query 7",
          "Query 8",
          "Query 9",
          "Query 10",
          "Query 11",
          "Query 12",
      }; 
      arrayList.addAll(Arrays.asList(queries));
      return arrayList;
  }
}
