/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Helper.DatabaseConnections;
import Helper.UsefulFunctions;
import com.mongodb.client.MongoDatabase;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
    
    Stage popupOpenDBStage = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void openExistingDatabase () {
        /*try {
            Connection c = DatabaseConnections.connectToLocalhost();
            if (!c.equals(null)) {
                // continue further              
                //label_no_open_db.setText("Database Found !!");
                Class curr_class = getClass();                       
                popupOpenDBStage = UsefulFunctions.prepareAnotherStage("/Helper/UIComponents/PopupOpenDB.fxml",curr_class, "Select Database");
                popupOpenDBStage.show();
                System.out.println ("Connected to localhost successfully ");
            } else {
                System.out.println("Unable to connect to Localhost");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainStageController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    public void createNewDatabase () {
        
    }
    
    public Stage getPopupOpenDBStage () {
        return popupOpenDBStage;
    }
    
    public void updateConnectionStatusMySql () {
        if (App.mysqlConnection != null && performTestQueriesOnMysql()) {
            conn_status_mysql.setText("Connection OK");
        } else {
            conn_status_mysql.setText("Checked_still_prob");
        }
    }
   
    public void updateConnectionStatusMongodb () {        
        if (App.mongodbClient != null && performTestQuriesOnMongo()) {
            conn_status_mongo.setText("Connection OK");
        } else {
            conn_status_mongo.setText("Checked_still_prob");
        }
    }
    
    public void updateConnectionStatusCassandra() {
        if (App.cassandra_session!=null && performTestQueriesOnCassandra()) {
            conn_status_cassandra.setText("Connection OK");            
        } else {
            conn_status_cassandra.setText("Checked_still_prob");
        }
    }
    
    public void updateConnectionStatusPostgres() {
        if (App.postgresConnection!= null && performTestQueriesOnPostgres()) {
            conn_status_postgres.setText("Connection OK ");          
        } else {
            conn_status_postgres.setText("Checked_still_prob");
        }
    }
    
    public boolean performTestQuriesOnMongo() {
        MongoDatabase database = (App.mongodbClient).getDatabase("test_db");
        if (database!=null) {
            for (String name : database.listCollectionNames()) {
                System.out.println(name);
            }
        } else {
            return false;
        }
        return true;
    }
    
    public boolean performTestQueriesOnMysql () {
        try {
            DatabaseMetaData meta = (App.mysqlConnection).getMetaData(); 
            ResultSet res = meta.getCatalogs();
            if (res == null) {
                return false;
            }
            while (res.next()){
                String db = res.getString("TABLE_CAT");
                System.out.println (db);
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainStageController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean performTestQueriesOnPostgres () {     
        try {
            Statement stmt = null;
            String testQuery = "Select datname from pg_database";
            stmt = App.postgresConnection.createStatement();
            ResultSet resultSet = stmt.executeQuery(testQuery);
            while (resultSet.next()) {
                System.out.println (resultSet.getString("datname"));
            }            
        } catch (SQLException ex) {            
            Logger.getLogger(MainStageController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean performTestQueriesOnCassandra () {
        return true;
    }
}
