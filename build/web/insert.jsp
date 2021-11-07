<%-- 
    Document   : insert
    Created on : Nov 2, 2021, 11:06:14 PM
    Author     : Asus
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="model.Classification"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert</title>
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
    <body style="background-color: #FFA500">     
        <div style="height: 80vh;display: flex;justify-content: center; align-items: center">   
            <button style="position: absolute; left: 5px; top: 5px" type="button" onclick="viewList()" class="btn btn-secondary">Back</button>
            <div class="container-insert">           
                <form style="" action="insert" method="POST">
                    <div style="text-align: center"><h2>Insert student</h2></div>
                    <table style="margin-top: 10px" class="table">
                        <tr>
                            <td>Student code:</td>
                            <td><input type="text" name="student_code"/></td>
                        </tr>

                        <tr>
                            <td>Name: </td>
                            <td><input type="text" name="name"/></td>
                        </tr>

                        <tr>
                            <td>User name:</td>
                            <td><input type="text" name="user_name"/></td>
                        </tr>

                        <tr>
                            <td>Gender:</td>
                            <td><input type="radio" checked="checked" name="gender" value="male" /> Male
                                <input type="radio" name="gender" value="female" /> Female</td>
                        </tr>

                        <tr>
                            <td>Dob:</td>
                            <td><input type="date" name="dob"/></td>
                        </tr>

                        <tr>
                            <td>Classification: </td>
                            <td><select name="cid"> 
                                    <c:forEach items="${requestScope.classifications}" var="c">
                                        <option value="${c.id}">${c.name}</option>
                                    </c:forEach>
                                </select></td>
                        </tr>

                        <tr>
                            <td>Room:</td>
                            <td><c:forEach items="${requestScope.rooms}" var="r">
                                    <input name="rid" type="checkbox" value="${r.id}"/> ${r.name}
                                </c:forEach><br/></td>
                        </tr>                                                         
                    </table>
                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
            </div>
        </div>
    </body>

    <style>
        .container-insert{
            background-color: white; 
            margin: 80px;
            border: 1px solid #cccccc;
            width: 600px;
            padding: 10px;
            display: flex;
            justify-content: center;
            align-items: center;
            border-radius: 10px
        }
    </style>

</html>
