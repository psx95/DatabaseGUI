/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper.UIComponents;

import Helper.Constants;
import Helper.DatabaseConnections;
import Helper.UsefulFunctions;
import com.datastax.driver.core.Row;
import com.mongodb.client.MongoCursor;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
        try {
            /*try {
                // TODO
                Connection c = DatabaseConnections.connectToLocalhost();
                ResultSet resultSet = c.getMetaData().getCatalogs();
                ArrayList<String> answer = (ArrayList<String>) UsefulFunctions.resturnResultSetAsJavaList(resultSet, String.class); 
                list_created_dbs.getItems().addAll(answer);
            } catch (SQLException ex) {
                Logger.getLogger(PopupController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            list_created_dbs.getItems().clear();
            ArrayList<String> dbs = new ArrayList<>();
            // display the databases of the currently selected data store
            switch (App.current_selcted_db) {
                case Constants.DB_NAME_MYSQL:
                    DatabaseMetaData meta = (App.mysqlConnection).getMetaData();
                    ResultSet res = meta.getCatalogs();                    
                    while (res.next()){
                        String db = res.getString("TABLE_CAT");
                        dbs.add(db);
                    }
                    res.close();                   
                    break;
                case Constants.DB_NAME_MONGO: 
                    MongoCursor<String> dbsCursor = App.mongodbClient.listDatabaseNames().iterator();
                    while(dbsCursor.hasNext()) {
                       dbs.add(dbsCursor.next());
                    }
                    break;
                case Constants.DB_NAME_POSTGRES:
                    Statement stmt = null;
                    String testQuery = "Select datname from pg_database";
                    stmt = App.postgresConnection.createStatement();
                    ResultSet resultSet = stmt.executeQuery(testQuery);
                    while (resultSet.next()) {
                        dbs.add(resultSet.getString("datname"));
                    }
                    break;
                case Constants.DB_NAME_CASSANDRA:
                    String query = "select * from system_schema.keyspaces;";
                    com.datastax.driver.core.ResultSet rs = (App.cassandra_session).execute(query);
                    for (Row row : rs) {
                        dbs.add(row.getString("keyspace_name"));
                    }
                    break;
            }
            list_created_dbs.getItems().addAll(dbs);
        } catch (SQLException ex) {
            Logger.getLogger(PopupController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void openSelectedDB() {
       String selected_db = (String) list_created_dbs.getSelectionModel().getSelectedItem();       
       closePopup();
       // change scene to display the current DB 
    }
    
    public void closePopup() {
        Stage popup_stage = (Stage) close_open_db_popup.getScene().getWindow();
        popup_stage.close();
    }
    
}
