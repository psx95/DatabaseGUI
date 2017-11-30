/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

/**
 *
 * @author pranav
 * This class contains the variables that remain Constant for lifetime of the application
 */
public class Constants {
    //MySQL
    public static final String JDBC_DRIVER_MYSQL = "com.mysql.jdbc.Driver";  
    public static final String DB_URL_MYSQL = "jdbc:mysql://localhost/";        
    public static final String USER_MYSQL = "root";
    public static final String PASS_MYSQL = "";
    //MongoDB 
    public static final String JAVA_MONGO_DRIVER = "com.mongodb.MongoClient";
    public static final String MONGO_HOST = "localhost";
    public static final int MONGO_PORT = 27017;
    //PostGres
    public static final String JDBC_DRIVER_POSTGRES = "org.postgresql.Driver";
    public static final String DB_URL_POSTGRES = "jdbc:postgresql://localhost/";
    //Cassandra 
    public static final String CASSANDRA_HOST = "localhost";
    public static final int CASSANDRA_PORT = 9042;
}
