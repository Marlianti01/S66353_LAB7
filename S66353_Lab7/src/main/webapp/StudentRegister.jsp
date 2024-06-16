<%-- 
    Document   : StudentRegister
    Created on : Jun 16, 2024, 11:08:58 AM
    Author     : marli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Register</title>
    </head>
    <body>
        <h1>Student Registration</h1>
        
        <form action="StudentServlet" method="post">
            <label>Student ID: </label>
            <input type="text" name="studid"><br><br>
            
            <label>Student Name: </label>
            <input type="text" name="name"><br><br>
            
            <input type="submit" name="Submit">
            
        </form>
    </body>
</html>
