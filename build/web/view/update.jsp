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
    </head>
    <body>
        <form action="update" method="POST">
            Id: ${requestScope.student.id} <input type="hidden" name="id" value="${requestScope.student.id}" /> <br/>
            Student code: <input type="text" value="${requestScope.student.student_code}" name="student_code"/> <br/>
            Name: <input type="text" value="${requestScope.student.name}" name="name"/> <br/>
            User name: <input type="text" value="${requestScope.student.user_name}" name="user_name"/> <br/>
            Gender: <input type="radio" 
                           ${ requestScope.student.gender? "checked=\"checked\"" : ""}
                           name="gender" value="male"/> Male
            <input type="radio"
                   ${ !requestScope.student.gender? "checked=\"checked\"" : ""}
                   name="gender" value="female"/> Female<br/>
            Dob: <input type="date" value="${requestScope.student.dob}" name="dob"/> <br/>
            Classification <select name="cid">
                <c:forEach items="${requestScope.classifications}" var="c">
                    <option 
                        <c:if test="${c.id eq requestScope.student.classi.id}">
                            selected="selected"
                        </c:if>
                        value="${c.id}">
                        ${c.name}
                    </option>
                </c:forEach>
            </select>
            <br/>
            Room <br/><c:forEach items="${requestScope.rooms}" var="r">
                <input name="rid"
                       <c:forEach items="${requestScope.student.rooms}" var="sr">
                           ${(sr.room.id eq r.id) ? "checked=\"checked\"" : ""}
                       </c:forEach>
                       type="checkbox" value="${r.id}"/> ${r.name} <br/>
            </c:forEach>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
