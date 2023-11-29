<%-- 
    Document   : index
    Created on : 30-oct-2023, 9:00:13
    Author     : alejandro
--%>

<%@page import="misclases.usuario"%>
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
        usuario log=(usuario)session.getAttribute("logueado");
        if(session.isNew() || log==null)
        {
 out.println("<form name=\"formulario1\" action=\"s1\" method=\"post\"><p> usuario <input type=\"input\" name=\"usuario\"> <br>contraseña <input type=\"password\" name=\"pass\"><br><button type=\"submit\" name=\"boton1\" value=\"Entrar\"> Entrar</button>     </p> </form>");
        }else
        {   out.println(log.getId());
            out.println(log.getUsu());
            out.println(log.getPass());
            out.println(log.getCredito());
            out.println(log.getFecha());
            
        }

        %>
    </body>
</html>
