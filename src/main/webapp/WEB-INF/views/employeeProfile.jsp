<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Profile</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"> <!-- CSS file path -->
</head>
<body>
    <h2>Employee Profile</h2>
    <div>
        <label for="fullName">Full Name:</label>
        <span>${employee.fullName}</span>
    </div>
    <div>
        <label for="email">Email:</label>
        <span>${employee.email}</span>
    </div>
    <div>
        <label for="mobileNumber">Mobile Number:</label>
        <span>${employee.mobileNumber}</span>
    </div>
    <div>
        <label for="gender">Gender:</label>
        <span>${employee.gender}</span>
    </div>
    <div>
        <label
