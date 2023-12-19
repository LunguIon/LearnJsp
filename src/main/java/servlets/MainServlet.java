package servlets;

import database.ConnectionToDbo;
import model.Car;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MainServlet", value = "/MainServlet")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Car> carList = new ArrayList<>();
        try (Connection connection = ConnectionToDbo.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM car");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Car car = new Car(rs.getInt("id"), rs.getString("carName"), rs.getString("carType"), rs.getDouble("engineCapacity"));
                carList.add(car);
            }

            request.setAttribute("carList", carList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("SQL error", e);
        }
    }
}
