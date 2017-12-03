/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import com.datastax.driver.core.Row;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxapplication1.App;
import javafxapplication1.MainStageController;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author pranav
 */
public class TestQueries {
    
    public boolean performTestQuriesOnMongo() {
        MongoDatabase database = (App.mongodbClient).getDatabase(Constants.DATABASE_TO_USE_MONGO);        
        MongoCollection<Document> collection = database.getCollection("mycol");       
        Bson queryProjection = Projections.fields(Projections.include(Arrays.asList("str1","num")));
        Bson querySort = new Document("_id",1); //ascending order
        List<Document> imgDocs = collection.find().projection(queryProjection).sort(querySort).into(new ArrayList<Document>());
        if (database!=null) {
            for (String name : database.listCollectionNames()) {
                System.out.println(name);
            }
        } else {
            return false;
        }
        for (Document d : imgDocs) {
            System.out.println (d.toJson());
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
        try {
            String query = "select * from system_schema.keyspaces;";
            com.datastax.driver.core.ResultSet rs = (App.cassandra_session).execute(query);
            for (Row row : rs) {
                System.out.println (row.getString("keyspace_name"));
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
