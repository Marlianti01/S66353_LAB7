<%-- 
    Document   : comfirmRegister
    Created on : Jun 16, 2024, 11:23:08 AM
    Author     : marli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="com.model.Student"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>comfirm Register</title>
    </head>
    <body>
        <h1>Comfirm Registration</h1>
        
            <%
               
                Student student = (Student) session.getAttribute("student");
            %>
            
            <p>Student ID: <%=student.getStudentid()%></p>
            <p>Student Name: <%=student.getName()%></p>
        <form action="notificationRegister.jsp" method="Post">
            <input type="submit" value="Preceed">
        </form>
    </body>
</html>
