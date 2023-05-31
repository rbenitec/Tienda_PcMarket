<%@page import="entities.Categoria"%>
<%@page import="controller.ProductoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Productos</title>
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
        %> 
        <form name="fr" action="controlador?opc=1" method="post" >
            <div class="card mb-3">
                <div class="card-header">
                    Crear Producto
                </div>
                <div class="card-body">
                    <input type="hidden" name="id"">

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
                        <input type="text" id="nombre" class="form-control" name="nombre" required="required" maxlength="128"/>
                    </div>

                    <div class="form-group">
                        <label for="descripcion">Descripci&oacute;n</label>
                        <textarea id="descripcion" class="form-control" name="descripcion" maxlength="256"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="precios">Precio</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">S/</div>
                            </div>
                            <input type="number" id="precio" class="form-control" name="precio" step="0.01" min="0" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="stock">Stock</label>
                        <input type="number" id="stock" name="stock" class="form-control"  step="1" min="0" />
                    </div>

                    <div class="form-group">
                        <label for="file">Imagen</label>
                        <div class="custom-file">
                            <input type="file" id="file" name="file" onchange="mostrarNombre()" class="custom-file-input">
                            <label id="lbl" for="imagen" class="custom-file-label" data-browse="Elegir" ></label>
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
        function mostrarNombre(){
            let name = fr.file.value;

            console.log(name);
            let array = name.split("\\")
            let size = array.length;
            console.log(size)
            let nombreJpg = array[size-1]

            console.log(array);
            document.getElementById("lbl").textContent = nombreJpg;
//            fr.lbl.value = costo+" soles";
        }   
    </script>
</html>
