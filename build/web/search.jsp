<%-- 
    Document   : search
    Created on : Nov 5, 2021, 1:23:02 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
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
        <form style="background-color: #FFA500;padding: 10px" action="search">
            <h2 style="color: white">Search Student</h2>
            <table style="background-color: white;padding: 10px; border: 1px solid #cccccc">
                <tr>
                    <td scope=>ID:</td>
                    <td><input type="text" value="${param.id}" name="id"/></td>

                    <td>Student code:</td>
                    <td><input type="text" name="student_code" value="${param.student_code}"/></td>
                </tr>
                <tr style="height: 10px"></tr>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" value="${param.name}"/></td>

                    <td>User name:</td>
                    <td><input type="text" name="user_name" value="${param.user_name}"/></td>
                </tr>
                <tr style="height: 10px"></tr>
                <tr>
                    <td>From:</td>
                    <td><input type="date" value="${param.from}" name="from"/></td>

                    <td>To:</td>
                    <td><input type="date" value="${param.to}" name="from"/></td>
                </tr> 
                <tr style="height: 10px"></tr>
                <tr>
                    <td>Gender:</td>
                    <td><input type="radio"
                               ${param.gender!=null && param.gender eq "male"?"checked=\"checked\"":""}
                               name="gender" value="male"/> Male
                        <input type="radio"
                               ${param.gender!=null && param.gender eq "female"?"checked=\"checked\"":""}
                               name="gender" value="female"/> Female
                        <input type="radio"
                               ${param.gender==null || param.gender eq "" || param.gender eq "all"?"checked=\"checked\"":""}
                               name="gender" value="all"/> All</td>
                </tr>
                <tr style="height: 10px"></tr>
                <tr>
                    <td>Classification: </td>
                    <td><select name="cid">
                            <option 
                                value="-1">
                                all
                            </option>
                            <c:forEach items="${requestScope.classifications}" var="c">
                                <option 
                                    <c:if test="${c.id eq param.cid}">
                                        selected="selected"
                                    </c:if>
                                    value="${c.id}">
                                    ${c.name}
                                </option>
                            </c:forEach>
                        </select></td>
                </tr> 

            </table>
            </br>
            <button type="button" onclick="viewList()" class="btn btn-secondary">Back</button>
            <button type="submit"class="btn btn-info">Search</button>

        </form>


        <div style="margin: 20px; border: 1px solid #cccccc">
            <table class="table table-striped"> 
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Student code</th>
                        <th scope="col">Name</th>
                        <th scope="col">Dob</th>
                        <th scope="col">Gender</th>
                        <th scope="col">Classification</th>
                    </tr>
                </thead>    
                <tbody>
                    <c:forEach items="${requestScope.students}" var="s">
                        <tr>
                            <td scope="row">${s.id}</td>
                            <td>${s.student_code}</td>
                            <td>${s.name}</td>
                            <td>${s.dob}</td>
                            <td><c:if test="${s.gender}">Male</c:if>
                                <c:if test="${!s.gender}">Female</c:if>
                                </td>   

                                <td>${s.classi.name}</td>
                        </tr>
                    </c:forEach>
                </tbody>           
            </table>

        </div>
    </body>

    <style>
        td{
            padding:5px;  
        }
    </style>
</html>
