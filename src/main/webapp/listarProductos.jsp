<%@page import="controller.ProductoDao"%>
<%@page import="entities.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Productos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="static/css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="font-family: Leelawadee UI, Consolas, Georgia, Arial Narrow ">
        
        <%
            ProductoDao obj = new ProductoDao();
            String userName =(String)request.getAttribute("user");
        %>  
        
        <nav>
            <ol class="breadcrumb my-3">
                <li class="breadcrumb-item"><a href="login_html.html">Login</a></li>
                <li class="breadcrumb-item"><a href="listadoCategoria.jsp">Categorias</a></li>
                <li class="breadcrumb-item active">Productos</li>
                <li class="breadcrumb-item" style="text-align: right"><a style="text-align: right" href="login_registro.html">Bienvenido: <%=userName%> </a></li>
            </ol>
        </nav>

        

        <div class="card">
            <div class="card-header">
                Lista de Productos
            </div>
            <div class="card-body">
                <table class="table table-borderless table-striped mb-0">
                    <thead>
                        <tr class="table-primary"><th>Id<th>Categoria<th>Nombre<th>Precio<th>Stock<th>imagen
                            <th><th>
                        </tr>
                    </thead>   
                    <%
                        for (Producto x : obj.listarProductos()) {
                            out.print("<tr><td>" + x.getId() + "<td>" + obj.obtenerCategoriaPorId(x.getCategorias_id()).getNombre() + "<td>" + x.getNombre() + "<td>" + x.getPrecio() + "<td>" + x.getStock()
                                    + "<td><img class='img-thumbnail' style='height: 50px' src= static/img/"+x.getImagen_nombre()+" />");
                    %>        
                    <td class="text-right" ><a class="btn btn-warning btn-sm" href="controlador?opc=2&cod=<%=x.getId()%>">Editar</a>
                    <td class="text-right" ><a class="btn btn-danger btn-sm" href="controlador?opc=4&cod=<%=x.getId()%>">Anula</a>

                    <%
                        }
                    %>   
                </table>
            </div>
            <div class="card-footer">
                <a class="btn btn-success" href="registrarProducto.jsp">Nuevo</a>
            </div>
        </div>

    </body>
</html>