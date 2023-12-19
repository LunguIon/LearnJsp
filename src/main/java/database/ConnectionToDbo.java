package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDbo {

    public static Connection getConnection() {
        Connection connection = null;
        String connectionUrl = "jdbc:mysql://localhost:3306/LearnJsp";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionUrl, "root", "");
            System.out.println("Connected successfuly");
        }catch (SQLException e) {
            System.out.println("Could not connect to mysql server " + e);
        }catch (ClassNotFoundException e){
            System.out.println("Mysql - could not find suitable driver for mysql");
        }
       return connection;
    }
}
