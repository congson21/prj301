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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
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
            function insert()
            {
                window.location.href = "insert";
            }
            function search()
            {
                window.location.href = "search";
            }


        </script>
    </head>
    <body>
        <div style="display: flex; justify-content: space-between; margin: 70px;">
            <div><h2>List student</h2></div>
            <div><button style="width: 100px" type="button" onclick="insert();" class="btn btn-success">Insert</button>
                <button style="width: 100px" type="button" onclick="search();" class="btn btn-secondary">Search</button></div>
        </div>       
        <div style="margin: 70px; border: 1px solid #cccccc">
            <table class="table table-striped"> 
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Student code</th>
                        <th scope="col">Name</th>
                        <th scope="col">Dob</th>
                        <th scope="col">Gender</th>
                        <th scope="col">Classification</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>    
                <tbody>
                    <c:forEach items="${requestScope.students}" var="s">
                        <tr>
                            <td scope="row">${s.id}</td>
                            <td>${s.student_code}</td>
                            <td>${s.name}</td>
                            <td><fmt:formatDate type = "date" value = "${s.dob}" /></td>
                            <td><c:if test="${s.gender}">Male</c:if>
                                <c:if test="${!s.gender}">Female</c:if>
                                </td>                   
                                <td>${s.classi.name}</td>
                            <td>                           
                                <button type="button" onclick="viewDetail(${s.id});" class="btn btn-primary">Detail</button>
                                <button type="button" onclick="doUpdate(${s.id});" class="btn btn-warning">Update</button>
                                <button type="button" onclick="doDelete(${s.id});" class="btn btn-danger">Delete</button>
                        </tr>
                    </c:forEach>
                </tbody>           
            </table>

        </div>
    </div>
</body>


</html>
