<%@page import="controller.ProductoDao"%>
<%@page import="entities.Categoria"%>
<%@page import="entities.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Productos</title>
        <link href="static/css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav>
            <ol class="breadcrumb my-3">
                <li class="breadcrumb-item"><a href="#">Inicio</a></li>
                <li class="breadcrumb-item"><a href="#">Mantenimiento</a></li>
                <li class="breadcrumb-item"><a href="#">Productos</a></li>
                <li class="breadcrumb-item active" aria-current="page">Editar</li>
            </ol>
        </nav>
        <%  
            ProductoDao obj = new ProductoDao();
            Producto p=(Producto)request.getAttribute("dato");
        %>
        <form action="../controlador" method="post" >
            <div class="card mb-3">
                <div class="card-header">
                    Editar Producto
                </div>
                <div class="card-body">
                    <input type="hidden" name="id"">

                    
                    
<!--                    <div class="form-group">
                        <label for="id_categoria">Categor&iacute;a</label>
                        <select id="id_categoria" class="form-control"  onchange="select()"" name="categoria" required="required">
                            <option value="1" >aa</option>
                            <option value="2" >bb</option>
                            <option value="3" >cc</option>
                        </select>
                    </div>-->
                    
                    <div class="form-group">
                        <label for="id_categoria">Categor&iacute;a</label>
                        <select id="id_categoria" class="form-control"  name="categoria" required="required">
                            <%
                                for(Categoria c : obj.listarCategoria()){
//                                    out.print("<option value="+c.getId()+">"+c.getNombre()+"</option>");
                                    %>
                                    <option value=<%=c.getId()+""%> ><%=c.getNombre()%></option>
                                    <%
                                }
                            %>
                        </select>
                    </div>
                    
                    
                    

                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" id="nombre" class="form-control" name="nombre" required="required" maxlength="128" value="<%=p.getNombre()%>" />
                    </div>

                    <div class="form-group">
                        <label for="descripcion">Descripci&oacute;n</label>
                        <textarea id="descripcion" class="form-control" name="descripcion" maxlength="256" value="<%=p.getDescripcion()%>"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="precio">Precio</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">S/</div>
                            </div>
                            <input type="number" id="precio" class="form-control" name="precio" step="0.01" min="0" value="<%=p.getPrecio()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="stock">Stock</label>
                        <input type="number" id="stock" name="stock" class="form-control"  step="1" min="0" value="<%=p.getStock()%>"/>
                    </div>

                    <div class="form-group">
                        <label for="file">Imagen</label>
                        <div class="custom-file">
                            <input type="file" id="file" name="file" class="custom-file-input">
                            <label for="imagen" class="custom-file-label" data-browse="Elegir"><%=p.getImagen_nombre()+""%></label>
                        </div>
                    </div>
                    <input type="hidden" name="imagen_nombre">

                    <input type="hidden"  id="estado" name="estado" >

                </div>
                <div class="card-footer">
                    <button type="submit" class="btn btn-success"><i class="fa fa-save"></i> Guardar</button>
                    <button type="button" class="btn btn-secondary" onclick="history.back()"><i class="fa fa-times"></i> Cancelar</button>
                </div>
            </div>
        </form>
    </body>
    
    <script>
        window.addEventListener('DOMContentLoaded', function() {
        document.getElementById("id_categoria").value = <%=p.getCategorias_id()+""%>;
  });
    </script>
</html>