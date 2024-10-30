<%-- 
    Document   : AddUser
    Created on : 25-Oct-2024, 9:49:30 pm
    Author     : rushendra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/RegistrarFunctionalities/AddUser.css">

    </head>
    <body>
        <h1>Create User</h1>
        <div class="formDiv">
            <form action="<%=request.getContextPath()%>/createUser" method="post">
                <label for="name">Username:</label>
                <input type="text" id="name" name="name"/>
                <br><br><!-- comment -->
                <label for='email'>Email:</label>
                <input type="email" id="email" name="email"/>
                <br><br><!-- comment -->
                <label for="password">Password:</label>
                <input type="password" id="password" name="password">
                <br><!-- comment -->
                <br><!-- comment -->
                <label for='role'>Role:</label>
                <select id="role" name="role">
                    <option>Judge</option>
                    <option>Lawyer</option>
                    <option>Police</option>
                </select>
                <br><br><!-- comment -->
                <button type='submit'>Create User</button>
            </form>
        </div>
    </body>
</html>
