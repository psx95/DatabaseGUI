/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Helper.DatabaseConnections;
import com.mongodb.MongoClient;
import java.sql.Connection;
import java.sql.Driver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pranav
 */
public class App extends Application {
    
    public static Scene mainScene = null;
    public static String current_db_name = "";  
    public static Driver mysqlDriver = null;
    public static Connection mysqlConnection = null;
    public static MongoClient mongodbConnection = null;    
    public static Driver cassandraDriver = null;
    public static Driver postresDriver = null;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainStage.fxml"));
        mainScene = new Scene(root);        
        stage.setScene(mainScene);
        stage.show();   
        DatabaseConnections.prepareDatabaseDrivers();     
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
