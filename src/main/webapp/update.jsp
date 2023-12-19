<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Car"%>
<%
    Car car = (Car) request.getAttribute("car");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Car</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2>Update Car Information</h2>
        <form action="UpdateCarServlet" method="post" class="mt-3">
            <input type="hidden" name="id" value="<%= car.getId() %>" />

            <div class="form-group">
                <label for="carName">Car Name:</label>
                <input type="text" id="carName" name="carName" class="form-control" value="<%= car.getCarName() %>" required>
            </div>

            <div class="form-group">
                <label for="carType">Car Type:</label>
                <input type="text" id="carType" name="carType" class="form-control" value="<%= car.getCarType() %>" required>
            </div>

            <div class="form-group">
                <label for="engineCapacity">Engine Capacity:</label>
                <input type="text" id="engineCapacity" name="engineCapacity" class="form-control" value="<%= car.getEngineCapacity() %>" required>
            </div>

            <button type="submit" class="btn btn-primary">Update Car</button>
        </form>
    </div>
</body>
</html>
