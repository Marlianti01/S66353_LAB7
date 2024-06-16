<%-- 
    Document   : indexProfile
    Created on : Jun 15, 2024, 7:34:37 AM
    Author     : marli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Profile</title>
    </head>
    <body>
        <jsp:forward page="/userProfileServlet?action=profileList"/>
    </body>
</html>
