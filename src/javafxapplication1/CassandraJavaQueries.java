/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author pranav
 */
public class CassandraJavaQueries {
    
    private Stage progressIndicator = null;
    private  Scene progress = null;  
    private long time_start = 0;
    private long time_end = 0;
    private long start_time = 0;
    private long end_time = 0;
    private ArrayList<Long> executionTimes = null;
    private  Calendar calendar = Calendar.getInstance();
    
    private Task<Void> executeQ1 = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            time_start = System.nanoTime();
            performQuery1();
            return null;
        }
    };
    private Task<Void> executeQ2 = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            time_start = System.nanoTime();
            performQuery2();
            return null;
        }
    };
    private Task<Void> executeQ3 = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            time_start = System.nanoTime();
            performQuery3();
            return null;
        }
    };
    private Task<Void> executeQ4 = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            time_start = System.nanoTime();
            performQuery4();
            return null;
        }
    };
    private Task<Void> executeQ5 = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            time_start = System.nanoTime();
            performQuery5();
            return null;
        }
    };
    private Task<Void> executeQ6 = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            time_start = System.nanoTime();
            time_start = System.nanoTime();
            performQuery6();
            return null;
        }
    };
    
    public CassandraJavaQueries () {
        init();
    }
    
    private void showProgressIndicator () {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Helper/UIComponents/QueryProgress.fxml"));
            progress = new Scene(root);
            progressIndicator = new Stage();
            progressIndicator.setScene(progress);
            progressIndicator.initModality(Modality.APPLICATION_MODAL);
            progressIndicator.show();
        } catch (IOException ex) {
            Logger.getLogger(CassandraJavaQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void closeProgressIndicatorAndNoteTime () {
        if (progressIndicator!=null) {
            progressIndicator.close();
            time_end = calendar.getTimeInMillis();
            System.out.println("computed time = "+(time_end - time_start));
        }
    }
     
    public void init () {
        executeQ1.setOnRunning(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                 try {
                    Parent root = FXMLLoader.load(getClass().getResource("/Helper/UIComponents/QueryProgress.fxml"));
                    progress = new Scene(root);
                    progressIndicator = new Stage();
                    progressIndicator.setScene(progress);
                    progressIndicator.initModality(Modality.APPLICATION_MODAL);
                    progressIndicator.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        executeQ1.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {    
                System.out.println ("Success");
            progressIndicator.close();
            time_end = System.nanoTime();
            System.out.println("computed time = "+(time_end - time_start));
            long time_taken = time_end - time_start;
            time_taken/=1000000;
            if (executionTimes!=null) {
                executionTimes.add(time_taken);
            }
            CassandraPerformanceController.getController().updateTime(time_taken);
            }
        });
        executeQ2.setOnRunning(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/Helper/UIComponents/QueryProgress.fxml"));
                    progress = new Scene(root);
                    progressIndicator = new Stage();
                    progressIndicator.setScene(progress);
                    progressIndicator.initModality(Modality.APPLICATION_MODAL);
                    progressIndicator.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
            }
        });
        executeQ2.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                System.out.println ("Success");
            progressIndicator.close();
            time_end = System.nanoTime();
            System.out.println("computed time = "+(time_end - time_start));
            long time_taken = time_end - time_start;            
            time_taken/=1000000;
            if (executionTimes!=null) {
                executionTimes.add(time_taken);
            }
            CassandraPerformanceController.getController().updateTime(time_taken);
            }
        });
        executeQ3.setOnRunning(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/Helper/UIComponents/QueryProgress.fxml"));
                    progress = new Scene(root);
                    progressIndicator = new Stage();
                    progressIndicator.setScene(progress);
                    progressIndicator.initModality(Modality.APPLICATION_MODAL);
                    progressIndicator.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        executeQ3.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                System.out.println ("Success");
            progressIndicator.close();
            time_end = System.nanoTime();
            System.out.println("computed time = "+(time_end - time_start));
            long time_taken = time_end - time_start;
            time_taken/=1000000;
            if (executionTimes!=null) {
                executionTimes.add(time_taken);
            }
            CassandraPerformanceController.getController().updateTime(time_taken);
            }
        });
        executeQ4.setOnRunning(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/Helper/UIComponents/QueryProgress.fxml"));
                    progress = new Scene(root);
                    progressIndicator = new Stage();
                    progressIndicator.setScene(progress);
                    progressIndicator.initModality(Modality.APPLICATION_MODAL);
                    progressIndicator.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        executeQ4.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                System.out.println ("Success");
            progressIndicator.close();
            time_end = System.nanoTime();
            System.out.println("computed time = "+(time_end - time_start));
            long time_taken = time_end - time_start;            
            time_taken/=1000000;
            if (executionTimes!=null) {
                executionTimes.add(time_taken);
            }
            CassandraPerformanceController.getController().updateTime(time_taken);
            }
        });
        executeQ5.setOnRunning(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/Helper/UIComponents/QueryProgress.fxml"));
                    progress = new Scene(root);
                    progressIndicator = new Stage();
                    progressIndicator.setScene(progress);
                    progressIndicator.initModality(Modality.APPLICATION_MODAL);
                    progressIndicator.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        executeQ5.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                System.out.println ("Success");
            progressIndicator.close();
            time_end = System.nanoTime();
            System.out.println("computed time = "+(time_end - time_start));
            long time_taken = time_end - time_start;
            time_taken/=1000000;
            if (executionTimes!=null) {
                executionTimes.add(time_taken);
            }
            CassandraPerformanceController.getController().updateTime(time_taken);
            }
        });
        executeQ6.setOnRunning(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                 try {
                    Parent root = FXMLLoader.load(getClass().getResource("/Helper/UIComponents/QueryProgress.fxml"));
                    progress = new Scene(root);
                    progressIndicator = new Stage();
                    progressIndicator.setScene(progress);
                    progressIndicator.initModality(Modality.APPLICATION_MODAL);
                    progressIndicator.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        executeQ6.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {    
                System.out.println ("Success");
            progressIndicator.close();
            time_end = System.nanoTime();
            long time_taken = time_end - time_start;
            time_taken/=1000000;
            if (executionTimes!=null) {
                executionTimes.add(time_taken);
            }
            CassandraPerformanceController.getController().updateTime(time_taken);        
            }
        });
    }
    
    public void perfromTask (List<String> selectedQueries) {
        String selectedQuery = selectedQueries.get(0);
        Thread t = null;
        if (selectedQuery.equals("Query 1")) {
            System.out.println ("Here");
            t = new Thread(executeQ1);
        } else if (selectedQuery.equals("Query 2")) {
            t = new Thread(executeQ2);
        } else if (selectedQuery.equals("Query 3")) {
            t = new Thread(executeQ3);
        } else if (selectedQuery.equals("Query 4")) {
            t = new Thread(executeQ4);
        } else if (selectedQuery.equals("Query 5")) {
            t = new Thread(executeQ5);
        } else if (selectedQuery.equals("Query 6")) {
            t = new Thread(executeQ6);
        }
        t.setDaemon(true);
        t.start();        
    }
    
    private void performQuery1 () {
        System.out.println ("Performing Query 1");
        try {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        start_time = System.nanoTime();
            ResultSet rs =  (App.cassandra_session).execute("Select * from demo where Patient_ID = 1004");
            for (Row r : rs) {
                System.out.println (r.getFloat("sy"));
            }
            end_time = System.nanoTime();
        long time_taken = end_time - start_time;
            time_taken/=1000000;
            if (executionTimes!=null) {
                executionTimes.add(time_taken);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.out.println ("Query complete");
    }
    
    private void performQuery2 () {
        System.out.println ("Performing Query 2");
        try {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        start_time = System.nanoTime();
            ResultSet rs =  (App.cassandra_session).execute("Select * from demo where Patient_ID = 924");
            for (Row r : rs) {
                System.out.println (r.getFloat("sy"));
            }
            end_time = System.nanoTime();
         long time_taken = end_time - start_time;
            time_taken/=1000000;
            if (executionTimes!=null) {
                executionTimes.add(time_taken);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.out.println ("Query complete");
    }
    
    private void performQuery3 () {
        System.out.println ("Performing Query 3");
        try {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        start_time = System.nanoTime();
            ResultSet rs =  (App.cassandra_session).execute("Select * from demo where Patient_ID = 14306");
            for (Row r : rs) {
                System.out.println (r.getFloat("sy"));
            }
            end_time = System.nanoTime();
         long time_taken = end_time - start_time;
            time_taken/=1000000;
            if (executionTimes!=null) {
                executionTimes.add(time_taken);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.out.println ("Query complete");
    }
    
    private void performQuery4 () {
        System.out.println ("Performing Query 4");
        try {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        start_time = System.nanoTime();
            ResultSet rs =  (App.cassandra_session).execute("Select * from demo where Patient_ID = 14");
            for (Row r : rs) {
                System.out.println (r.getFloat("sy"));
            }
            end_time = System.nanoTime();
         long time_taken = end_time - start_time;
            time_taken/=1000000;
            if (executionTimes!=null) {
                executionTimes.add(time_taken);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.out.println ("Query complete");
    }
    
    private void performQuery5 () {
        System.out.println ("Performing Query 5");
        try {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        start_time = System.nanoTime();
            ResultSet rs =  (App.cassandra_session).execute("Select * from demo where Patient_ID = 5126");
            for (Row r : rs) {
                System.out.println (r.getFloat("sy"));
            }
            end_time = System.nanoTime();
         long time_taken = end_time - start_time;
            time_taken/=1000000;
            if (executionTimes!=null) {
                executionTimes.add(time_taken);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.out.println ("Query complete");
    }
    
    private void performQuery6 () {
        try {
        String query = "Select sy from demo";
        start_time = System.nanoTime();
        ResultSet rs = (App.cassandra_session).execute(query);
        for (Row r : rs) {
            System.out.println (r.getFloat("sy"));
        }
        end_time = System.nanoTime();        
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
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
                    } else if (selectedQuery.equals("Query 2")){
                        performQuery2();
                    } else if (selectedQuery.equals("Query 3")){
                        performQuery3();
                    } else if (selectedQuery.equals("Query 4")){
                        performQuery4();
                    } else if (selectedQuery.equals("Query 5")){
                        performQuery5();
                    } else if (selectedQuery.equals("Query 6")){
                        performQuery6();
                    } else if (selectedQuery.equals("Query 7")){
                       // performQuery7();
                    } else if (selectedQuery.equals("Query 8")){
                       // performQuery8();
                    } else if (selectedQuery.equals("Query 9")){
                       // performQuery9();
                    } else if (selectedQuery.equals("Query 10")){
                       // performQuery10();
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
                    Logger.getLogger(CassandraJavaQueries.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
            
            executeQuer1Ntimes.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                progressIndicator.close();
                // generateGraphfrom here
                CassandraPerformanceController.getController().plotGraph(executionTimes);
            }
        });
            Thread t = new Thread(executeQuer1Ntimes);
            t.setDaemon(true);
            t.start();
    }
}
