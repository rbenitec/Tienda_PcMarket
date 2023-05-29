
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Registro de Categoria</h2>
        <form id="form" action="controlCategoria">
            <input type="hidden" name="opc" value="1">
            <div class="form-group">
                <label for="nombre">Nombre de Categoria</label>
                <input type="text" class="form-control" id="nombre" name="nombre">
            </div>
            <div class="form-group">
                <label for="orden">Numero de Orden</label>
                <input type="text" class="form-control" id="orden" name="orden">
            </div>
            <button type="submit" class="btn btn-default">Registrar</button>
        </form>
    </body>
</html>
