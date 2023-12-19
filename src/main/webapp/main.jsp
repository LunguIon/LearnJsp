<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Car"%>
<%
    List<Car> cars = (List<Car>) request.getAttribute("carList");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Optional: jQuery and Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.7.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>
    <h2>Car Information</h2>
    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Car Name</th>
                <th>Car Type</th>
                <th>Engine Capacity</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% for(Car car : cars) { %>
            <tr>
                <td><%= car.getId() %></td>
                <td><%= car.getCarName() %></td>
                <td><%= car.getCarType() %></td>
                <td><%= car.getEngineCapacity() %></td>
                <td>
                    <a href="UpdateCarServlet?id=<%= car.getId() %>" class="btn btn-primary btn-sm">Update</a>
                    <a href="DeleteCarServlet?id=<%= car.getId() %>" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>

    <br>
    <form action="AddCarServlet" method="post" class="mb-4">
        <h3>Add New Car</h3>
        <div class="form-group">
            <label for="carName">Car Name:</label>
            <input type="text" id="carName" name="carName" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="carType">Car Type:</label>
            <input type="text" id="carType" name="carType" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="engineCapacity">Engine Capacity:</label>
            <input type="text" id="engineCapacity" name="engineCapacity" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-success">Add Car</button>
    </form>
</body>
</html>
