<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Record</title>
</head>
<body>
    <h2>Create Record</h2>
    <form action="${pageContext.request.contextPath}/records/create" method="POST">
        <div>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div>
            <label for="mobileNumber">Mobile Number:</label>
            <input type="text" id="mobileNumber" name="mobileNumber" required>
        </div>
        <div>
            <input type="submit" value="Create">
        </div>
    </form>
    <a href="${pageContext.request.contextPath}/records/list">View Records</a>
</body>
</html>
