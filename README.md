# DatabaseGUI
### A JAVAFX powered project to visually compare the performance of 4 most popular SQL and NoSQL databases
The analysis is done on a dataset generated using nobench

### Pre-requisites
* You must have Mysql, Cassandra, Postgres and MongoDB installed on your system
* Services of the above mentioned databases must be running simultaneously.
* If you have passwords set for any of the above the above database services, you will have to edit the Constants.java file, if these services are running on some port other than the default port, it can be changed in Constants.java too.  Support for the GUI to change default password and port numbers will be added later.

### Project Structure 
* All the drivers for the various databases are kept under the folder 'Connectors'.
* Helper package has files containing code that are not related to the application logic. The file UsefulFunctions.java has functions used multiple times throughout the application. All functions defined in this file must be static and should have public access.
* Helper.UI Components contain the UI components that are often used in the application.
* Logic and query execution for each type of databases must be done under seperate packages. For Instance - MySQL's query analysis related logic is placed under a package javafxapplication1.mysql. 
* All the media files (Images/Sounds) must go in 'res' folder.

### Application Driver 
App.java in the package 'javafxapplication1' is the driver program for this application. The program execution starts with the main method as usual, however the main method calls the static 'launch()' method defined in the javafx.application.Application class which then becomes the entry point for any JavaFX Application.
To read about the lifecycle of this class follow this link - https://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.html

### About the project & how it works
#### About
> Performance Evaluation of every datastore is done by testing the performance of the database on the parameters of time. To get the best accuracy possible, the use of any kind of abstraction layer like Hibernate has been omitted. Due to absence of this abstraction layer, the equivalent JAVA code of every Query has to be written manually. At this point, the best use of this application is that it can run the same query multiple times (which can be decided by the user) and display the query performance (in terms of time) along with the average time of the query. Plotting the time in a graph, helps to visualise the performance a little better. 
#### How it works 
> From the main screen (called a Stage in JAVAFX) of the application, there are 4 options corresponding to 4 datastores, clicking on anyone of them will change the screen to the selected datastore. Corresspondingly, the code for every datastore evaluation is placed separately in a package named after the name of the datastore. For Instance, *the code for performance evaluation of MongoDB can be found under the package mongodb.* 
> Each of these packages have a similar structure to maintain consistency throughout the code. Each package has 3 files - 
* A queries.java file which contains the java equivalent of the datastore specific queries.
* A performance.fxml file which is mostly auto generated by the IDE and defines how the UI should look.
* A controller.java file which links the UI generated via the FXML file with the queries.java file to execute the desired query appropriate number of times and updates the UI to display the result.
> **All the queries are executed asynchronously as [Task](https://docs.oracle.com/javafx/2/api/javafx/concurrent/Task.html)s, so as to avoid the UI from freezing up. Executing the queries on the main UI thread will lead to serious performacnce issues of the application.**
> *The functions and variables have been properly named so as to make the intent of them as clear as possible*

### Known Issues & Incompletes
* The reconnect databases button on the main screen is not working. 
* The queries for the Postgres & MySQL datastores are not done. Since these are simlple RDBMS, the same java code will be used to run the same query on both the datastores. 
* The select databases option is not linked to the databases, however the GUI is complete for the same. Thus, the database has to be set in the code.

### Important Links
1. [**Oracle's JavaFX Documentation**](https://docs.oracle.com/javafx/2/overview/jfxpub-overview.htm)
2. [**Oracle's Getting Started Tutorial**](https://docs.oracle.com/javafx/2/get_started/jfxpub-get_started.htm)

### Screenshots
1.Main Screen: 
![alt text][main_screen]
2. Performance Evaluation : 
* MongoDB
![alt text][mongo_graph]
* Cassandra
![alt text][cassandra_graph]

[main_screen]: https://github.com/psx95/DatabaseGUI/blob/master/images/main%20screen.png "Application Main Screen"
[mongo_graph]: https://github.com/psx95/DatabaseGUI/blob/master/images/mongo%20db.png "Performance Evaluation - MongoDB"
[cassandra_graph]: https://github.com/psx95/DatabaseGUI/blob/master/images/cassandra.png "Performance Evaluation - Cassandra"

### P.S -  The project is still under development and is developed using the Netbeans 8.2 IDE
