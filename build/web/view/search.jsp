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
    </head>
    <body>
        <form action="search">
            Id: <input type="text" value="${param.id}" name="id"/> <br/>
            Student code: <input type="text" name="student_code" value="${param.student_code}"/> <br/>
            Name: <input type="text" name="name" value="${param.name}"/> <br/>
            User name: <input type="text" name="user_name" value="${param.user_name}"/> <br/>
            Gender: 
            <input type="radio"
                   ${param.gender!=null && param.gender eq "male"?"checked=\"checked\"":""}
                   name="gender" value="male"/> Male
            <input type="radio"
                   ${param.gender!=null && param.gender eq "female"?"checked=\"checked\"":""}
                   name="gender" value="female"/> Female
            <input type="radio"
                   ${param.gender==null || param.gender eq "" || param.gender eq "all"?"checked=\"checked\"":""}
                   name="gender" value="all"/> All
            <br/>
            From: <input type="date" value="${param.from}" name="from"/> <br/>
            To: <input type="date" value="${param.to}" name="to"/> <br/>
            Classification: <select name="cid">
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
            </select>
            <br/>
            <input type="submit" value="Search"/>
        </form>
        <table border="1px"> 
            <tr> 
                <td>Id</td>
                <td>Student code</td>
                <td>Name</td>
                <td>User name</td>
                <td>Gender</td>
                <td>Dob</td>
                <td>Classification</td>
            </tr>
            <c:forEach items="${requestScope.students}" var="s">
            <tr> 
                <td>${s.id}</td>
                <td>${s.student_code}</td>
                <td>${s.name}</td>
                <td>${s.user_name}</td>
                <td><c:if test="${s.gender}">
                    Male
                    </c:if>
                    <c:if test="${!s.gender}">
                    Female
                    </c:if>
                </td>
                <td>${s.dob}</td>
                <td>${s.classi.name}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
