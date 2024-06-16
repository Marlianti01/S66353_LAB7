<%-- 
    Document   : user
    Created on : Jun 8, 2024, 3:38:07 PM
    Author     : marli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Record</title>
    </head>
    <body>
        <h1>New Record</h1>
        <form name="frmAddUser" action="UserController" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>User ID: </td>
                        <td><input type="text" name="userid" value="" size="25" required</td>
                    </tr>
                    <tr>
                        <td>First Name: </td>
                        <td><input type="text" name="firstname" value="" size="25" required</td>
                    </tr>
                    <tr>
                        <td>Last Name: </td>
                        <td><input type="text" name="lastname" value="" size="25" required</td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="action" value="insert" required></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit"</td>
                        <td><input type="reset" value="Cancel"</td>
                    </tr>
                </tbody>
            </table>
            
        </form>
    </body>
</html>
