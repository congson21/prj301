<%-- 
    Document   : update
    Created on : Nov 3, 2021, 2:51:52 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
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
        <div style="background-color:#FFA500;height: 100vh;display: flex;justify-content: center; align-items: center">
            <button style="position: absolute; left: 5px; top: 5px" type="button" onclick="viewList()" class="btn btn-secondary">Back</button>
            <div class="container-update">
                <div style="text-align: center"><h2>Update student</h2></div>
                <form action="update" method="POST">
                    <table style="margin-top: 10px" class="table table-striped">
                        <tr>
                            <td scope="row">ID:</td>
                            <td>${requestScope.student.id} <input type="hidden" name="id" value="${requestScope.student.id}" /></td>
                        </tr>

                        <tr>
                            <td>Student code:</td>
                            <td><input type="text" value="${requestScope.student.student_code}" name="student_code"/></td>
                        </tr>

                        <tr>
                            <td>Name: </td>
                            <td><input type="text" value="${requestScope.student.name}" name="name"/></td>
                        </tr>

                        <tr>
                            <td>User name:</td>
                            <td><input type="text" value="${requestScope.student.user_name}" name="user_name"/></td>
                        </tr>

                        <tr>
                            <td>Gender:</td>
                            <td><input type="radio" 
                                       ${ requestScope.student.gender? "checked=\"checked\"" : ""}
                                       name="gender" value="male"/> Male
                                <input type="radio"
                                       ${ !requestScope.student.gender? "checked=\"checked\"" : ""}
                                       name="gender" value="female"/> Female</td>
                        </tr>

                        <tr>
                            <td>Dob:</td>
                            <td><input type="date" value="${requestScope.student.dob}" name="dob"/></td>
                        </tr>

                        <tr>
                            <td>Classification: </td>
                            <td><select name="cid">
                                    <c:forEach items="${requestScope.classifications}" var="c">
                                        <option 
                                            <c:if test="${c.id eq requestScope.student.classi.id}">
                                                selected="selected"
                                            </c:if>
                                            value="${c.id}">
                                            ${c.name}
                                        </option>
                                    </c:forEach></div>
                                </select></td>
                        </tr>

                        <tr>
                            <td>Room:</td>
                            <td><c:forEach items="${requestScope.rooms}" var="r">
                                    <input name="rid"
                                           <c:forEach items="${requestScope.student.rooms}" var="sr">
                                               ${(sr.room.id eq r.id) ? "checked=\"checked\"" : ""}
                                           </c:forEach>
                                           type="checkbox" value="${r.id}"/> ${r.name} <br/>
                                </c:forEach></td>
                        </tr>                                                         
                    </table>

                    <button type="submit"class="btn btn-primary">Save</button>
                </form>
            </div>
        </div>
    </body>

    <style>
        .container-update{    
            background-color:white;
            margin: 100px; 
            border: 1px solid #cccccc;
            width: 400px;
            padding: 10px;
            border-radius: 10px}
    </style>
</html>
