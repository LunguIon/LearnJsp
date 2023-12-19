package DAO;

import database.ConnectionToDbo;
import model.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    public static final Connection connection = ConnectionToDbo.getConnection();


    public static void deleteCar(int id) {
        try{
            String sql = "DELETE FROM car WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Record deleted");
        }catch (SQLException e){
            System.out.print("Could not delete the record");
        }
    }

    public static void updateCar(Car car) {
        try {
            String sql = "UPDATE car SET carName = ?, carType = ?, engineCapacity = ? WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car.getCarName());
            preparedStatement.setString(2, car.getCarType());
            preparedStatement.setDouble(3, car.getEngineCapacity());
            preparedStatement.setInt(4, car.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No record found with ID: " + car.getId());
            }
        } catch (SQLException e) {
            System.out.println("Could not update the record: " + e.getMessage());
        }
    }

    public static Car getCarById(int id) {
        Car car = null; // Initialize the Car object to null

        try (Connection connection = ConnectionToDbo.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM car WHERE ID = ?");
            ps.setInt(1, id); // Set the ID parameter in the prepared statement
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // If a row is found, create a Car object
                car = new Car(rs.getInt("id"), rs.getString("carName"), rs.getString("carType"), rs.getDouble("engineCapacity"));
            }
        } catch (SQLException e) {
            // Handle any SQL errors here
            e.printStackTrace();
        }

        return car; // Return the Car object, which may be null if no car with the given ID was found
    }

}
