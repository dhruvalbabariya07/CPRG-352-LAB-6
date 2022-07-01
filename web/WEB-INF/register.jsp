<%-- 
    Document   : register
    Created on : 30 Jun, 2022, 8:11:29 PM
    Author     : luffy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Here</title>
    </head>
    <body>
    <center>
        <h3>Shopping List</h3>
        <form method="post" action="ShoppingList" >
            <label>Username: </label>
            <input type="text" name="username" required>
            <input type="submit" value="Register name"> 
            <input type="hidden" name="action" value="register">       
        </form>
    </center>
    </body>
</html>
