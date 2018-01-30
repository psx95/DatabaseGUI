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
