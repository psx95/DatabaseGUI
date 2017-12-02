/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Helper.DatabaseConnections;
import Helper.UsefulFunctions;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.mongodb.MongoClient;
import java.sql.Connection;
import java.sql.Driver;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author pranav
 */
public class App extends Application {
    
    // Variables live through the lifetime of the application
    public static Scene mainScene = null;
    public Stage mainStage = null;    
    public static int current_selcted_db = 0;
    
    // Drivers/Clients for the data stores
    public static Driver mysqlDriver = null;
    public static MongoClient mongodbClient = null;    
    public static Driver postresDriver = null;
    public static Session cassandra_session = null;
    
    // connection for the various data stores 
    public static Connection mysqlConnection = null;      
    public static Connection postgresConnection = null;
    public static Cluster cassandraCluster = null;
    
    @Override
    public void start(Stage stage) throws Exception {
        Platform.setImplicitExit(true);
        Parent root = FXMLLoader.load(getClass().getResource("MainStage.fxml"));
        mainScene = new Scene(root);        
        stage.setScene(mainScene);       
        stage.show();   
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                UsefulFunctions.universalExit();
            }
        });
        mainStage = stage;       
        DatabaseConnections.prepareDatabaseDrivers();     
    }
    
    public Stage getMainStage() {
        return this.mainStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
