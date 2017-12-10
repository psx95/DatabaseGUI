/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.mongodb;

import Helper.Constants;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOptions;
import com.mongodb.client.model.Projections;
import com.mongodb.util.JSON;
import com.sun.javafx.property.adapter.PropertyDescriptor;
import io.netty.util.concurrent.SucceededFuture;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafxapplication1.App;
import javafxapplication1.MainStageController;
import org.bson.Document;
import org.json.JSONObject;
import org.bson.conversions.Bson;
import org.json.JSONException;

/**
 *
 * @author pranav
 */
public class MongoJavaQueries {
    
    private  Stage progressIndicator = null;
    private  Calendar calendar = Calendar.getInstance();
    public static long time_taken;
    private  Scene progress = null;      
    Task<Void> executeQuery = new Task<Void>() {
            @Override
            protected Void call() throws Exception {                
                performQuery1();                
                return null;    
            }          
        };
    
    public MongoJavaQueries() {                
        init();
    }
    
    public void init () {              
          executeQuery.setOnRunning(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {               
                try {
                    // display the progressbar
                    Parent root = FXMLLoader.load(getClass().getResource("/Helper/UIComponents/QueryProgress.fxml"));
                    progress = new Scene(root);
                    progressIndicator = new Stage();
                    progressIndicator.setScene(progress);
                    progressIndicator.initModality(Modality.APPLICATION_MODAL);                    
                    progressIndicator.show();
                   
                } catch (IOException ex) {
                    Logger.getLogger(MongoJavaQueries.class.getName()).log(Level.SEVERE, null, ex);
                }                              
            }
        });
        
        executeQuery.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {                                
                System.out.println (time_taken+" time to query");
                progressIndicator.close();                               
                MongoPerformanceController.getController().updateTime(time_taken);               
                System.out.println ("Thread "+Thread.currentThread().getName());               
            }
        });
    }

    private void performQuery1() {        
        MongoDatabase database = (App.mongodbClient).getDatabase(Constants.DATABASE_TO_USE_MONGO);        
        MongoCollection<Document> collection = database.getCollection("mycol");
        Bson queryProjection = Projections.fields(Projections.include(Arrays.asList("str1", "num")));                              
        Bson modify = new Document("$explain",true);                        
        List <Document> d2 = collection.find().projection(queryProjection).modifiers(modify).into(new ArrayList<Document>());              
        try {
        String stats =  (d2.get(0).toJson());
        JSONObject stats_json = new JSONObject(stats);
        System.out.println (stats_json);        
        time_taken = stats_json.getJSONObject("executionStats").getInt("executionTimeMillis");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(String.valueOf(time_taken));        
    }                          
    
    public void performTask () {                                   
        Thread t = new Thread(executeQuery);
        t.setDaemon(true);
        t.start();        
        System.out.println ("Thread perform Task"+Thread.currentThread().getName());
    }      
}
