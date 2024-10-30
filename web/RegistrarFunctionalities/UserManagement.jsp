<%-- 
    Document   : UserManagement
    Created on : 25-Oct-2024, 9:40:11 pm
    Author     : rushendra
--%>
<%@ page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management</title>
                <link rel="stylesheet" href="<%= request.getContextPath() %>/RegistrarFunctionalities/UserManagement.css">

    </head>
    <body>
        <table cellpadding="10px" class="usersTable" border="1px">
            <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Role</th>
            <th>Actions</th>
            </tr>
            <%
            ResultSet resultSet = (ResultSet) request.getAttribute("resultSet");
            while (resultSet.next()) {
        %>
        <tr>
            <td><%= resultSet.getString("name") %></td>
            <td><%= resultSet.getString("email") %></td>
            <td><%= resultSet.getString("role") %></td>
            <td><button>Edit</button>&nbsp;<button>Delete</button></td>
        </tr>
        <%
            }
        %>
        </table>
        <br><!-- comment -->
        <a href="<%= request.getContextPath() %>/RegistrarFunctionalities/AddUser.jsp">
    <button>Add a new user</button>
</a>
    </body>
</html>
