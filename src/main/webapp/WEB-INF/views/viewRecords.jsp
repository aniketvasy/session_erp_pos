<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Records</title>
</head>
<body>
    <h2>Records List</h2>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Mobile Number</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${recordList}" var="record">
                <tr>
                    <td>${record.name}</td>
                    <td>${record.mobileNumber}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/records/create">Create Record</a>
</body>
</html>
