/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxapplication1.App;
import javafxapplication1.MainStageController;

/**
 *
 * @author pranav
 * This class contains functions that are used to connect to the back-end databases
 */
public class DatabaseConnections {
    
    
    public static void prepareDatabaseDrivers () {
        try {
            prepareMysqlDriver();
            prepareMongoDBDriver();
            prepareCassandraDriver();
            preparePostgresDriver();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    private static void prepareMysqlDriver() throws SQLException {
        try {
                File jar = new File ("/connectors/mysql_java_driver.jar");
                URL[] cp = new URL[1];
                cp[0] = jar.toURI().toURL();
                URLClassLoader classLoader = new URLClassLoader(cp,ClassLoader.getSystemClassLoader());
                Class driverClass = classLoader.loadClass(Constants.JDBC_DRIVER_MYSQL);           
                App.mysqlDriver = (Driver) driverClass.newInstance();         
                Properties props = new Properties();
                props.setProperty("username", Constants.USER_MYSQL);
                props.setProperty("password", Constants.PASS_MYSQL);
                App.mysqlConnection = App.mysqlDriver.connect(Constants.DB_URL_MYSQL,props);               
            } catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DatabaseConnections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void preparePostgresDriver() {
       try {
           File jar  = new File ("/connectors/postgresql-42.1.4.jar");
           URL[] cp = new URL[1];
           cp[0] = jar.toURI().toURL();
           URLClassLoader loader = new URLClassLoader(cp, ClassLoader.getSystemClassLoader());
           Class driverClass = loader.loadClass(Constants.JDBC_DRIVER_POSTGRES);
           App.postresDriver = (Driver) driverClass.newInstance();
           Properties props = new Properties();
           props.setProperty("user", "postgres");
           props.setProperty("password", "");           
           App.postgresConnection = App.postresDriver.connect(Constants.DB_URL_POSTGRES, props);
       } catch (MalformedURLException ex) {
            Logger.getLogger(DatabaseConnections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DatabaseConnections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DatabaseConnections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void prepareCassandraDriver() {
       Builder b = Cluster.builder().addContactPoint(Constants.CASSANDRA_HOST);
       b.withPort(Constants.CASSANDRA_PORT);
       App.cassandraCluster = b.build();
       App.cassandra_session = App.cassandraCluster.connect(); 
    }

    private static void prepareMongoDBDriver() {      
        App.mongodbClient = new MongoClient(Constants.MONGO_HOST,Constants.MONGO_PORT);
        MongoDatabase database = (App.mongodbClient).getDatabase("test_db");
    }

}
