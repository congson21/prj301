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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script>
            function viewList()
            {
                window.location.href = "list";
            }
        </script>
    </head>
    <body>
        <div style="background-color: #FFA500;height: 100vh;display: flex;justify-content: center; align-items: center">
            <button style="position: absolute; left: 5px; top: 5px" type="button" onclick="viewList()" class="btn btn-secondary">Back</button>
            <div class="container-detail">

                <div style="text-align: center"><h2>Student Detail</h2></div>
                <table style="margin-top: 10px" class="table table-striped">
                    <tr>
                        <td scope="row">ID:</td>
                        <td>${requestScope.student.id}</td>
                    </tr>

                    <tr>
                        <td>Student code:</td>
                        <td>${requestScope.student.student_code}</td>
                    </tr>

                    <tr>
                        <td>Name: </td>
                        <td>${requestScope.student.name}</td>
                    </tr>

                    <tr>
                        <td>User name:</td>
                        <td>${requestScope.student.user_name}</td>
                    </tr>

                    <tr>
                        <td>Gender:</td>
                        <td>${requestScope.student.gender?"Male":"Female"}
                    </tr>
                    <tr>
                        <td>Dob:</td>
                        <td><fmt:formatDate type = "date" value = "${requestScope.student.dob}" /></td>
                    </tr>
                    <tr>
                        <td>Classification: </td>
                        <td>${requestScope.student.classi.name}</td>
                    </tr>
                    <tr>
                        <td>Room:</td>
                        <td><c:forEach items="${requestScope.student.rooms}" var="sr">
                                ${sr.room.name} <br/>
                            </c:forEach>  </td>
                    </tr>                                                         
                </table>
            </div>
        </div>
    </body>

    <style>
        .container-detail{
            background-color: white;
            margin: 100px;
            border: 1px solid #cccccc;
            width: 400px;
            padding: 10px;
            border-radius: 10px;
        }
    </style>
</html>
