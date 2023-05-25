
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.Cliente,controller.ClienteDao" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ClienteDao obj=new ClienteDao();          
         %>

        <h1>Lista de Clientes Registrados</h1>
        <table>
            <thead>
                <tr class="bg-dark"><th>NroDoc<th>Tipo<th>Nombre<th>Apellidos<th>Email<th>Telefono<th>Fecha
                </tr>
            </thead>
            <%
               for(Cliente x:obj.listado()){ 
               out.print("<tr><td>"+x.getNrodoc()+"<td>"+x.getTipo()+"<td>"+x.getNombre()+
               "<td>"+x.getApe()+"<td>"+x.getCorreo()+"<td>"+x.getTelef()+"<td>"+x.getFecha());
                
            %>
            
            <%
                }
            %>
        </table>
        
    </body>
</html>
