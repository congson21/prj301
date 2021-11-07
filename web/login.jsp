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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>
        <div class="login-form">           
            <div class="wrapper fadeInDown">
                <div id="formContent">
                    <div class="fadeIn first">                       
                        <img src="img/icon.png" id="icon" alt="User Icon" />
                        <h2>Student management</h2>
                    </div>
                    <form action="login" method="POST">
                        <input type="text" id="login" class="fadeIn second" name="user" placeholder="username">
                        <input type="text" id="password" class="fadeIn third" name="pass" placeholder="password">
                        <input type="submit" class="fadeIn fourth" value="Login">
                    </form>
                </div>                         
            </div>
        </div>  
    </body>
</html>

