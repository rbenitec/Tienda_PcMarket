<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.Categoria,controller.CategoriaDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            CategoriaDAO obj=new CategoriaDAO();
        %>
        <h2 class="text-cyan">Lista de Categorias</h2>
        <table class="table table-hover">
            <thead>
                <tr class="text-white bg-black"><th>Id<th>Nombre de Categoria<th>Orden<th>Modificar<th>Eliminar
            </thead>
            <%
                for(Categoria x:obj.listado()){
                out.print("<tr><td>"+x.getId()+"<td>"+x.getNombre()+"<td>"+x.getOrden());
            %>
            <td><a href="controlCategoria?opc=2&cod=<%=x.getId()%>">Editar</a>
            <td><a href="controlCategoria?opc=4&cod=<%=x.getId()%>">Borrar</a>
            <%
                }
            %>
        </table>
    
    </body>
</html>
