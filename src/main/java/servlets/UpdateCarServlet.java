package servlets;

import model.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import DAO.CarDAO;
@WebServlet("/UpdateCarServlet")
public class UpdateCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract car details and ID from request
        int id = Integer.parseInt(request.getParameter("id"));
        String model = request.getParameter("carName");
        String make = request.getParameter("carType");
        double year = Double.parseDouble(request.getParameter("engineCapacity"));

        // Update the car in the database
        CarDAO.updateCar(new Car(id, model, make, year));

        // Redirect back to the main page
        response.sendRedirect("MainServlet");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Car car = CarDAO.getCarById(id); // Assuming you have a method to fetch a car by ID

        request.setAttribute("car", car);
        RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
        dispatcher.forward(request, response);
    }

}

