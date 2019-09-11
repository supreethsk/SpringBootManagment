<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SAKHA</title>
<style>
body{
background-color: #ADD8E6;
}
a{
color:black;
}

</style>

</head>
<body>
<center><h1>Welcome to Sakha-Gloabl Employee Page</h1></center><br><br><br><br><br><br>
<center>
<table border="3">

          <tr>
              <th>Employee ID</th>
              <th>Employee Name</th>
              <th>Date of Birth</th>
              <th>Basic Salary</th>
              <th>Age</th>
              <th colspan="2">Delete/Update</th>
          </tr>
        
  <c:forEach items="${empList}" var="emp">
    <tr>
      <td>${emp.empId}</td>
      <td>${emp.empName}</td>
      <td>${emp.dob}</td>
      <td>${emp.salary}</td>
      <td>${emp.age }</td>
      <td><a href='delete.jsp?empid=${emp.id}'>Delete</a></td>
      <td><a href='update.jsp?empId=${emp.id}'>Update</a></td>
      </tr>
  </c:forEach>
</table>
</center>
<%-- <h1> ${empList }</h1> --%>
</body>
</html>
