<%-- 
    Document   : editar
    Created on : 27-nov-2023, 8:59:52
    Author     : alejandro
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="misclases.ConnMysql"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%
        int nreg=(Integer)request.getAttribute("nreg");
        Connection con=new ConnMysql().getConnection();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(""
                + "select * from cliente where id="+nreg);
        while(rs.next()){%>
        <form name="f1" action="actualizar2" method="post">
            id: <input type="text" name="id" value="<%=rs.getInt(1)%>">
            nombre: <input type="text" name="usuario" value="<%=rs.getString(2)%>">
            contraseña: <input type="text" name="pass" value="<%=rs.getString(3)%>">
            credito: <input type="text" name="credito" value="<%=rs.getInt(4)%>">
            <button name="actualizar">Actualizar</button>
        </form>   
        <%}
        rs.close();stmt.close();con.close();
        %>
    </body>
</html>
