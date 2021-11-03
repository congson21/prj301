<%-- 
    Document   : login
    Created on : Nov 3, 2021, 5:15:49 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
         <body>
        <form action="login" method="POST"> 
            Username: <input type="text" name="user"/> <br/>
            Password: <input type="password" name="pass"/> <br/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>

