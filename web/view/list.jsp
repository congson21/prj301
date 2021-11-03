<%-- 
    Document   : list
    Created on : Nov 2, 2021, 5:32:24 PM
    Author     : Asus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Student</title>
        <script>
            function viewDetail(id)
            {
                window.location.href = "detail?id=" + id;
            }
            function doUpdate(id)
            {
                window.location.href = "update?id=" + id;
            }
            function doDelete(id)
            {
                var c = confirm("are you sure?");
                if (c)
                {
                    window.location.href = "delete?id=" + id;
                }
            }
            
            
        </script>
    </head>
    <body>
         <table border="1px"> 
            <tr> 
                <td>Id</td>
                <td>Student code</td>
                <td>Name</td>
                <td>Dob</td>
                <td>Gender</td>
                <td>Classification</td>
                <td>Action</td>

            </tr>

            <c:forEach items="${requestScope.students}" var="s">
                <tr> 
                    <td>${s.id}</td>
                    <td>${s.student_code}</td>
                    <td>${s.name}</td>
                    <td><fmt:formatDate type = "date" value = "${s.dob}" /></td>
                    <td><c:if test="${s.gender}">Male</c:if>
                        <c:if test="${!s.gender}">Female</c:if>
                    </td>                   
                    <td>${s.classi.name}</td>
                    <td>
                    <input type="button" onclick="viewDetail(${s.id});" value="Detail"/>
                    <input type="button" onclick="doUpdate(${s.id});" value="Update"/>
                    <input type="button" onclick="doDelete(${s.id});" value="Delete"/></td>
                </tr>
            </c:forEach>
        </table>
        <a href="insert">Insert</a>
    </body>
</html>
