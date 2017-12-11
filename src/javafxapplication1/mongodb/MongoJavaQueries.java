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
import com.mongodb.client.model.Filters;
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
    private ArrayList<Long> executionTimes;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    
    Task<Void> executeQuery1 = new Task<Void>() {
            @Override
            protected Void call() throws Exception {                
                performQuery1();                
                return null;    
            }          
        };
    Task<Void> executeQuery2 = new Task<Void>() {
            @Override
            protected Void call() throws Exception {                
                performQuery2();                
                return null;    
            }          
        };
    Task<Void> executeQuery3 = new Task<Void>() {
            @Override
            protected Void call() throws Exception {                
                performQuery3();                
                return null;    
            }          
        };
    Task<Void> executeQuery4 = new Task<Void>() {
                @Override
                protected Void call() throws Exception {                
                    performQuery4();                
                    return null;    
                }          
            };
    Task<Void> executeQuery5 = new Task<Void>() {
                @Override
                protected Void call() throws Exception {                
                    performQuery5();                
                    return null;    
                }          
            };
    Task<Void> executeQuery6 = new Task<Void>() {
                @Override
                protected Void call() throws Exception {                
                    performQuery6();                
                    return null;    
                }          
            };
    Task<Void> executeQuery7 = new Task<Void>() {
                @Override
                protected Void call() throws Exception {                
                    performQuery7();                
                    return null;    
                }          
            };
    Task<Void> executeQuery8 = new Task<Void>() {
                @Override
                protected Void call() throws Exception {                
                    performQuery8();                
                    return null;    
                }          
            };
    Task<Void> executeQuery9 = new Task<Void>() {
                @Override
                protected Void call() throws Exception {                
                    performQuery9();                
                    return null;    
                }          
            };
    Task<Void> executeQuery10 = new Task<Void>() {
                @Override
                protected Void call() throws Exception {                
                    performQuery10();                
                    return null;    
                }          
            };    
   
    public MongoJavaQueries() {                
        init();
    }
    
    public void init () {              
          executeQuery1.setOnRunning(new EventHandler<WorkerStateEvent>() {
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
        
        executeQuery1.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {                                
                System.out.println (time_taken+" time to query");
                progressIndicator.close();                               
                MongoPerformanceController.getController().updateTime(time_taken);               
                System.out.println ("Thread "+Thread.currentThread().getName());               
            }
        });
        
        executeQuery2.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
              @Override
              public void handle(WorkerStateEvent event) {
                System.out.println (time_taken+" time to query");
                progressIndicator.close();                               
                MongoPerformanceController.getController().updateTime(time_taken);               
                System.out.println ("Thread "+Thread.currentThread().getName());               
              }
          });
        
        executeQuery2.setOnRunning(new EventHandler<WorkerStateEvent>() {
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
        
        executeQuery3.setOnRunning(new EventHandler<WorkerStateEvent>() {
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
        executeQuery3.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
              @Override
              public void handle(WorkerStateEvent event) {
                 System.out.println (time_taken+" time to query");
                progressIndicator.close();                               
                MongoPerformanceController.getController().updateTime(time_taken);               
                System.out.println ("Thread "+Thread.currentThread().getName());               
              }
          });
        
        executeQuery4.setOnRunning(new EventHandler<WorkerStateEvent>() {
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
        executeQuery4.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
              @Override
              public void handle(WorkerStateEvent event) {
                 System.out.println (time_taken+" time to query");
                progressIndicator.close();                               
                MongoPerformanceController.getController().updateTime(time_taken);               
                System.out.println ("Thread "+Thread.currentThread().getName());               
              }
          });
        executeQuery5.setOnRunning(new EventHandler<WorkerStateEvent>() {
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
        executeQuery5.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
              @Override
              public void handle(WorkerStateEvent event) {
                 System.out.println (time_taken+" time to query");
                progressIndicator.close();                               
                MongoPerformanceController.getController().updateTime(time_taken);               
                System.out.println ("Thread "+Thread.currentThread().getName());               
              }
          });
        executeQuery6.setOnRunning(new EventHandler<WorkerStateEvent>() {
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
        executeQuery6.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
              @Override
              public void handle(WorkerStateEvent event) {
                 System.out.println (time_taken+" time to query");
                progressIndicator.close();                               
                MongoPerformanceController.getController().updateTime(time_taken);               
                System.out.println ("Thread "+Thread.currentThread().getName());               
              }
          });
        executeQuery7.setOnRunning(new EventHandler<WorkerStateEvent>() {
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
        executeQuery7.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
              @Override
              public void handle(WorkerStateEvent event) {
                 System.out.println (time_taken+" time to query");
                progressIndicator.close();                               
                MongoPerformanceController.getController().updateTime(time_taken);               
                System.out.println ("Thread "+Thread.currentThread().getName());               
              }
          });
        executeQuery8.setOnRunning(new EventHandler<WorkerStateEvent>() {
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
        executeQuery8.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
              @Override
              public void handle(WorkerStateEvent event) {
                 System.out.println (time_taken+" time to query");
                progressIndicator.close();                               
                MongoPerformanceController.getController().updateTime(time_taken);               
                System.out.println ("Thread "+Thread.currentThread().getName());               
              }
          });
        executeQuery9.setOnRunning(new EventHandler<WorkerStateEvent>() {
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
        executeQuery9.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
              @Override
              public void handle(WorkerStateEvent event) {
                 System.out.println (time_taken+" time to query");
                progressIndicator.close();                               
                MongoPerformanceController.getController().updateTime(time_taken);               
                System.out.println ("Thread "+Thread.currentThread().getName());               
              }
          });
        executeQuery10.setOnRunning(new EventHandler<WorkerStateEvent>() {
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
        executeQuery10.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
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
        database = (App.mongodbClient).getDatabase(Constants.DATABASE_TO_USE_MONGO);        
        collection = database.getCollection("mycol");
        Bson queryProjection = Projections.fields(Projections.include(Arrays.asList("str1", "num")));                              
        Bson modify = new Document("$explain",true);                        
        List <Document> d2 = collection.find().projection(queryProjection).modifiers(modify).into(new ArrayList<Document>());              
        try {
        String stats =  (d2.get(0).toJson());
        JSONObject stats_json = new JSONObject(stats);
        System.out.println (stats_json);        
        time_taken = stats_json.getJSONObject("executionStats").getInt("executionTimeMillis");
        if (executionTimes!=null) {
            executionTimes.add(time_taken);
        }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(String.valueOf(time_taken));        
    }
    
    private void performQuery2() {
        database = (App.mongodbClient).getDatabase(Constants.DATABASE_TO_USE_MONGO);        
        collection = database.getCollection("mycol");
        Bson queryProjection = Projections.fields(Projections.include(Arrays.asList("nested_obj.str", "nested_obj.num")));                              
        Bson modify = new Document("$explain",true);
        List <Document> d2 = collection.find().projection(queryProjection).modifiers(modify).into(new ArrayList<Document>());              
        /*List <Document> d3 = collection.find().projection(queryProjection).into(new ArrayList<Document>());
        d3.forEach((d) -> {
            System.out.println (d.toJson());
        });*/
        try {
        String stats =  (d2.get(0).toJson());
        JSONObject stats_json = new JSONObject(stats);
        System.out.println (stats_json);        
        time_taken = stats_json.getJSONObject("executionStats").getInt("executionTimeMillis");
        if (executionTimes!=null) {
            executionTimes.add(time_taken);
        }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(String.valueOf(time_taken));        
    }     
    
    private void performQuery3() {
        database = (App.mongodbClient).getDatabase(Constants.DATABASE_TO_USE_MONGO);        
        collection = database.getCollection("mycol");
        String stats = "";
        Bson queryProjection = Projections.fields(Projections.include(Arrays.asList("sparse_550", "sparse_559")));                              
        Bson modify = new Document("$explain",true);                
        Bson filter = Filters.or(Arrays.asList(Filters.exists("sparse_550"),Filters.exists("sparse_559")));
        List <Document> d2 = collection.find(filter).projection(queryProjection).modifiers(modify).into(new ArrayList<Document>());
        List <Document> d3 = collection.find(filter).projection(queryProjection).into(new ArrayList<Document>());
        d3.forEach((d) -> {
            System.out.println (d.toJson());
        });
        try {
        stats =  (d2.get(0).toJson());
        JSONObject stats_json = new JSONObject(stats);
        System.out.println (stats_json);        
        time_taken = stats_json.getJSONObject("executionStats").getInt("executionTimeMillis");
        if (executionTimes!=null) {
            executionTimes.add(time_taken);
        }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(String.valueOf(time_taken));        
    }
    
    private void performQuery4() {
        database = (App.mongodbClient).getDatabase(Constants.DATABASE_TO_USE_MONGO);        
        collection = database.getCollection("mycol");
        String stats = "";
        //Bson queryProjection = Projections.fields(Projections.include(Arrays.asList("sparse_550", "sparse_559")));                              
        Bson modify = new Document("$explain",true);
        Bson filter = Filters.eq("str1", "GBRDCMBQGEYDCMBQGEYDAMBRGE======");
        //Bson filter = Filters.or(Arrays.asList(Filters.exists("sparse_550"),Filters.exists("sparse_559")));
        List <Document> d2 = collection.find(filter).modifiers(modify).into(new ArrayList<Document>());
        List <Document> d3 = collection.find(filter).into(new ArrayList<Document>());
        d3.forEach((d) -> {
            System.out.println (d.toJson());
        });
        try {
        stats =  (d2.get(0).toJson());
        JSONObject stats_json = new JSONObject(stats);
        System.out.println (stats_json);        
        time_taken = stats_json.getJSONObject("executionStats").getInt("executionTimeMillis");
        if (executionTimes!=null) {
            executionTimes.add(time_taken);
        }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(String.valueOf(time_taken));        
    }
    
    private void performQuery5() {
        
    }
    
    private void performQuery6() {
        
    }
    
    private void performQuery7() {
        
    }
    
    private void performQuery8() {
        
    }
    
    private void performQuery9 () {
        
    }
    
    private void performQuery10 () {
        
    }
    
    public void performTask (Task<Void> task) {                                   
        Thread t = new Thread(task);
        t.setDaemon(true);
        t.start();        
        System.out.println ("Thread perform Task"+Thread.currentThread().getName());
    }      
    
    public void performTask (List<String> selectedQueries) {
        String selectedTask = selectedQueries.get(0);       
        Thread t = null;
        if (selectedTask.equals("Query 1")) {
            t = new Thread(executeQuery1);
        } else if (selectedTask.equals("Query 2")) {
            t = new Thread(executeQuery2);
        } else if (selectedTask.equals("Query 3")){
            t = new Thread(executeQuery3);
        } else if (selectedTask.equals("Query 4")){
            t = new Thread(executeQuery4);
        }     
        t.setDaemon(true);
        t.start();        
        System.out.println ("Thread perform Task"+Thread.currentThread().getName());
    }
    
    public void performTaskNTimes (final int n, String selectedQuery) {
        executionTimes = new ArrayList<Long>();
        executionTimes.clear();
            Task<Void> executeQuer1Ntimes = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = 0; i< n; i++) {                    
                    if (selectedQuery.equals("Query 1")) {
                        performQuery1();
                    } else if (selectedQuery.equals("Query 2")) {
                        performQuery2();
                    } else if (selectedQuery.equals("Query 3")){
                        performQuery3();
                    } else if (selectedQuery.equals("Query 4")) {
                        performQuery4();
                    }
                }
               return null;
            }
        };
            executeQuer1Ntimes.setOnRunning(new EventHandler<WorkerStateEvent>() {
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
            
            executeQuer1Ntimes.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                progressIndicator.close();
                // generateGraphfrom here
                MongoPerformanceController.getController().generateGraph(executionTimes);
            }
        });
            Thread t = new Thread(executeQuer1Ntimes);
            t.setDaemon(true);
            t.start();
    }
    
}
