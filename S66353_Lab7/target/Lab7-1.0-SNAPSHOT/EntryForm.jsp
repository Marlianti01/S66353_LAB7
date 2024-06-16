<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entry Form</title>
    </head>
    <body>
        <h1>Entry Form</h1>
        
        <form name="entryForm" action="userProfileServlet" method="POST">
            <label>Username: </label>
            <input type="text" name="username" required><br>
            
            <label>Icno: </label>
            <input type="text" name="icno" required><br>
            
            <label>Firstname: </label>
            <input type="text" name="firstname" required><br>
            
            <input type="submit" value="Submit">
            <input type="reset" value="Cancel"><br>
            
            <input type="hidden" name="action" value="insert">
        </form>
    </body>
</html>
