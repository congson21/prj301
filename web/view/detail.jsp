<%-- 
    Document   : detail
    Created on : Nov 3, 2021, 2:10:55 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail</title>
    </head>
    <body>
         <body>
        ID: ${requestScope.student.id} <br/>
        Student code: ${requestScope.student.student_code} <br/>
        Name: ${requestScope.student.name} <br/>
        User name: ${requestScope.student.user_name} <br/>
        Dob:<fmt:formatDate type = "date" value = "${requestScope.student.dob}" />  <br/>
        Gender: ${requestScope.student.gender?"Male":"Female"} <br/>
        Classification: ${requestScope.student.classi.name} <br/>
        Class: 

    </body>
    </body>
</html>
