
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.Usuarios,controller.UsuarioDao" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            UsuarioDao obj=new UsuarioDao();          
        %>

        <h1 class="alert-info">Lista de Usuarios</h1>
        <a href="RegistroUuario.jsp">Registrar nuevos usuarios</a>
        <table class="table table-hover">
            <thead>
                <tr class="bg-dark"><th>ID<th>ROL<th>EMAIL<th>PASSWORD<th>NOMBRE<th>SEXO<th>FECNACIMIENTO<th>TELEFONO<th>DIRECCION<th>ESTADO<th>DNI<th>USERNAME
                    <th>Modificar<th>Eliminar
                </tr>
            </thead>
            <%
               for(Usuarios x:obj.listado()){ 
               out.print("<tr><td>"+x.getId()+"<td>"+x.getRol()+"<td>"+x.getEmail()+"<td>"+x.getPass()+
               "<td>"+x.getNombre()+"<td>"+x.getSexo()+"<td>"+x.getNacimiento()+"<td>"+x.getTelefono()+"<td>"+x.getDireccion()+"<td>"+x.getEstado()+"<td>"+x.getDni()+"<td>"+x.getUser());
                
            %>
                <td><a href="servletUser?opc=4&cod=<%=x.getId()%>">Editar</a>
                <td><a href="servletUser?opc=3&cod=<%=x.getId()%>">Anula</a>
            <%
                }
            %>
        </table>
        
    </body>
</html>

