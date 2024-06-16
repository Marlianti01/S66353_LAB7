<%-- 
    Document   : profileList
    Created on : Jun 15, 2024, 8:48:13 AM
    Author     : marli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List User Profile</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Ic Number</th>
                    <th>First Name</th>
                    
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${userProfiles}" var="user">
                <tr>
                    <td><c:out value="${user.username}"/></td>
                    <td><c:out value="${user.icno}"/></td>
                    <td><c:out value="${user.firstname}"/></td>
                    
            </tr>
            </c:forEach>
            </tbody>
        </table>
                    <p><a href="userProfileServlet?action=insert">Add User</a></p>
        
    </body>
</html>
