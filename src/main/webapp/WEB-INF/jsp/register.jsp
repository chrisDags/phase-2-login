<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 1/31/2021
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <style>
        strong {text-align: center;}
        head {text-align: center;}
        div {text-align: center; font-size: large;}
        br {text-align: center;}
        body {text-align: center;}
        span, input {margin: 5px;}
    </style>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Registration</title>
        <h1>Register New Account</h1>
    </head>

    <body>
        <form method="post" action="/register">
            <div>
                Username:<input type="text" name="username" minlength="3" maxlength="32" required><br>
                Password: <input type="password" name="password" minlength="3" maxlength="32" required><br>
                <button type="submit" class="btn btn-success">Register</button>
            </div>
        </form>
    </body>
</html>