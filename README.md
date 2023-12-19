# Java Web Application - Car Management System
## Overview
* This Java web application is designed to manage car information. It provides functionalities like viewing car details, adding new cars, updating existing car information, and deleting cars. The application is built using Java Servlets, JSP, Bootstrap for styling, and MySQL for data storage.

## Features
* User authentication (login system).
* View a list of cars with details such as car name, type, and engine capacity.
* Add new car entries to the system.
* Update existing car information.
* Delete cars from the system.
## Technologies Used
* Java Servlets
* JavaServer Pages (JSP)
* MySQL
* Bootstrap (for frontend styling)
* Apache Tomcat (as the servlet container)
* Maven (for dependency management)
## Prerequisites
* Java Development Kit (JDK)
* MySQL Server
* Apache Tomcat Server
* IntelliJ IDEA (recommended IDE)
* Maven
## Setup and Installation
1. Database Setup:

* Create a MySQL database named LearnJsp (or your chosen name).
* Use the provided SQL script to create necessary tables.
2. Project Configuration:

* Clone the repository or download the source code.
   ```bash
   git clone https://github.com/LunguIon/LearnJsp.git
* Open the project in IntelliJ IDEA or your preferred IDE.
* Configure the database connection in src/main/java/DAO/DBConnection.java with your MySQL credentials.
3. Running the Application:

* Build the project to generate a WAR file.
* Deploy the WAR file to Apache Tomcat Server.
* Access the application at http://localhost:8080/YourAppName/.
## Usage
1. Login:
* Access the login page and enter your credentials.
2. View Cars:
* Navigate to the main page to see the list of cars.
3. Add Car:
* Use the form on the main page to add a new car.
4. Update Car:
* Click the 'Update' button next to any car to modify its details.
5. Delete Car:
* Click the 'Delete' button to remove a car from the system.



