<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.Cliente,controller.ClienteDao" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            ClienteDao obj=new ClienteDao();          
        %>
        <center>
        <h1 class="alert-info">Lista de Clientes Registrados</h1>
        </center>
        <br>
        <a href="RegistrarClientes.jsp">Registrar nuevos Clientes</a>
        <br>
        <table class="table table-hover">
            <br>
            <thead>
                <tr class="bg-blue"><th>NroDoc<th>Tipo<th>Nombre<th>Apellidos<th>Email<th>Telefono<th>Fecha
                    <th>Modificar<th>Eliminar
                </tr>
            </thead>
            <%
               for(Cliente x:obj.listado()){ 
               out.print("<tr><td>"+x.getNrodoc()+"<td>"+x.getTipo()+"<td>"+x.getNombre()+
               "<td>"+x.getApe()+"<td>"+x.getCorreo()+"<td>"+x.getTelef()+"<td>"+x.getFecha());
                
            %>
                <td><a href="servlet?opc=4&cod=<%=x.getNrodoc()%>">Editar</a>
                <td><a href="servlet?opc=3&cod=<%=x.getNrodoc()%>">Anula</a>
            <%
                }
            %>
        </table>
        
    </body>
</html>
