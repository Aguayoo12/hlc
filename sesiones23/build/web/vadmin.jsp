<%-- 
    Document   : vadmin
    Created on : 16-nov-2023, 13:35:51
    Author     : alejandro
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="misclases.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vadmin</h1>
        <%
        usuario mu=(usuario)session.getAttribute("logueado");
        ResultSet rs=(ResultSet)request.getAttribute("miresult");

         out.println(mu.getUsu());
         out.println("<form name='form1'  action='actualizar' method='post'>");     
         while(rs.next()){
             
            
             out.println(rs.getInt(1));
             out.println(rs.getString(2));
             out.println(rs.getString(3));
             out.println(rs.getInt(4));
             out.println(rs.getString(6));
       out.println("<button name='boton' value='e"+rs.getInt(1)+"'>Editar</button>");      
       out.println("<button name='boton' value='b"+rs.getInt(1)+"'>Borrar</button><br>");      
               
             
         }
        out.println("</form>");
         %>
        
    </body>
</html>
