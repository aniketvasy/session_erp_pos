<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"> <!-- CSS file path -->
    <style>
        /* Inline styles specific to this page (if needed) */

        /* Example styles */
        body {
            font-family: Arial, sans-serif;
        }
        h2 {
            color: #333;
        }
        form {
            margin-top: 20px;
        }
        label {
            display: inline-block;
            width: 100px;
            font-weight: bold;
            margin-bottom: 5px;
        }
        input[type="text"],
        input[type="email"],
        input[type="date"] {
            width: 200px;
            padding: 5px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h2>Add Employee</h2>
    <form action="/add" method="POST">
        <div>
            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="fullName" required>
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div>
            <label for="mobileNumber">Mobile Number:</label>
            <input type="text" id="mobileNumber" name="mobileNumber" required>
        </div>
        <div>
            <label for="gender">Gender:</label>
            <input type="text" id="gender" name="gender" required>
        </div>
        <div>
            <label for="dateOfBirth">Date of Birth:</label>
            <input type="date" id="dateOfBirth" name="dateOfBirth" required>
        </div>
        <div>
            <input type="submit" value="Add Employee">
        </div>
    </form>
</body>
</html>
