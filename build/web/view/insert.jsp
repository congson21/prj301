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
    </head>
    <body>
            
        <body>
        <form action="insert" method="POST"> 
            Student code: <input type="text" name="student_code"/> <br/>
            Name: <input type="text" name="name"/> <br/>
            User name: <input type="text" name="user_name"/> <br/>
            Gender: <input type="radio" checked="checked" name="gender" value="male" /> Male
            <input type="radio" name="gender" value="female" /> Female <br/>
            Dob: <input type="date" name="dob"/> <br/>
            Classification <select name="cid"> 
                <c:forEach items="${requestScope.classifications}" var="c">
                    <option value="${c.id}">${c.name}</option>
                </c:forEach>
            </select>
            <br/>
            <c:forEach items="${requestScope.rooms}" var="r">
                <input name="rid" type="checkbox" value="${r.id}"/> ${r.name}
                </c:forEach><br/>           
            <input type="submit" value="Save"/>
        </form>
    </body>
    </body>
</html>
