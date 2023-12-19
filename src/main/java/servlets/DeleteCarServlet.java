package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import  DAO.CarDAO;

@WebServlet("/DeleteCarServlet")
public class DeleteCarServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get car ID from request
        int id = Integer.parseInt(request.getParameter("id"));

        // Delete the car from the database
        CarDAO.deleteCar(id);

        // Redirect back to the main page
        response.sendRedirect("MainServlet");
    }
}

