/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Helper.DatabaseConnections;
import Helper.TestQueries;
import Helper.UsefulFunctions;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author pranav
 */
public class MainStageController implements Initializable {
    
    @FXML
    private Label label_no_open_db;
    @FXML
    private ImageView mysql_image_view;
    @FXML
    private ImageView postgresql_image_view;
    @FXML
    private ImageView mongodb_image_view;
    @FXML
    private ImageView cassandra_image_view;
    @FXML
    private Label conn_status_mysql;
    @FXML
    public  Label conn_status_mongo; 
    @FXML
    public  Label conn_status_postgres;
    @FXML
    public  Label conn_status_cassandra;
    @FXML
    public Button update_all_button;        
    
    Stage popupOpenDBStage = null;
    private TestQueries testQueries = new TestQueries();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        update_all_button.fire();
    }    
    
    public void createNewDatabase () {
        
    }
    
    public void updateAllConnectionStatus () {
        updateConnectionStatusCassandra();
        updateConnectionStatusMongodb();
        updateConnectionStatusMySql();
        updateConnectionStatusPostgres();
    }
    
    public Stage getPopupOpenDBStage () {
        return popupOpenDBStage;
    }
    
    public void updateConnectionStatusMySql () {
        if (App.mysqlConnection != null && testQueries.performTestQueriesOnMysql()) {
            conn_status_mysql.setText("Connection OK");
        } else {
            conn_status_mysql.setText("Checked_still_prob");
        }
    }
   
    public void updateConnectionStatusMongodb () {        
        if (App.mongodbClient != null && testQueries.performTestQuriesOnMongo()) {
            conn_status_mongo.setText("Connection OK");
        } else {
            conn_status_mongo.setText("Checked_still_prob");
        }
    }
    
    public void updateConnectionStatusCassandra() {
        if (App.cassandra_session!=null && testQueries.performTestQueriesOnCassandra()) {
            conn_status_cassandra.setText("Connection OK");            
        } else {
            conn_status_cassandra.setText("Checked_still_prob");
        }
    }
    
    public void updateConnectionStatusPostgres() {
        if (App.postgresConnection!= null && testQueries.performTestQueriesOnPostgres()) {
            conn_status_postgres.setText("Connection OK ");          
        } else {
            conn_status_postgres.setText("Checked_still_prob");
        }
    }
    
    public void handleClickOnMySQL () {
        loadScene("MySQLPerformance.fxml", mysql_image_view);
    }
    
    public void handleClickOnPostgres() {
        loadScene("PostgresPerformance.fxml", postgresql_image_view);
    }
    
    public void handleClickOnMongoDB () {
        loadScene("MongoPerformance.fxml", mongodb_image_view);
    }
    
    public void handleClickOnCassandra () {
        loadScene("CassandraPerformance.fxml", cassandra_image_view);
    }
    
    private void loadScene(String resourceName, ImageView im) {
        try {            
            Parent root = FXMLLoader.load(getClass().getResource(resourceName));
            Scene newScene = new Scene(root);            
            Stage curr_stage = (Stage) im.getScene().getWindow();
            curr_stage.setScene(newScene);
            curr_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainStageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void exitApp() {
        UsefulFunctions.universalExit();
    }
}
