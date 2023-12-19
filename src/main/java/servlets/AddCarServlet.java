package servlets;

import database.ConnectionToDbo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "AddCarServlet", value = "/AddCarServlet")
public class AddCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String make = request.getParameter("carName");
        String model = request.getParameter("carType");
        double year = Double.parseDouble(request.getParameter("engineCapacity"));

        try (Connection connection = ConnectionToDbo.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO car (carName, carType, engineCapacity) VALUES (?, ?, ?)");
            ps.setString(1, make);
            ps.setString(2, model);
            ps.setDouble(3, year);
            ps.executeUpdate();

            response.sendRedirect("MainServlet");
        } catch (SQLException e) {
            throw new ServletException("SQL error", e);
        }
    }
}
