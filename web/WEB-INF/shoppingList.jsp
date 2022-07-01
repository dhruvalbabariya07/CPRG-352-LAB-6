<%-- 
    Document   : shoppingList
    Created on : 30 Jun, 2022, 8:12:00 PM
    Author     : luffy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "d" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Shopping List</title>
    </head>
    <body>
    <center>
         <h1>Shopping List</h1>
         Hello ${username}
         
        <h2>List</h2>
        <form method="post" action="">
            
            <label>Add item: </label>
            <input type="text" name="itemName"  required=""> 
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="Add">
            <br>
            <a href="ShoppingList?action=logout">Logout</a>
        </form>
        <form method="post" action="">
            <ul>
                <d:forEach items="${List}" var="item">
                    <ui>
                <input type="radio" name="item" value="${item}">
                ${item}
                    </ui>
            </d:forEach>
            </ul>
            <input type="submit" value="Delete"> 
            <input type="hidden" name="action" value="Delete">
        </form>
</center>
    </body>
</html>
