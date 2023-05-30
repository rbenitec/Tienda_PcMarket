
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h2>Registro de Cliente</h2>      
        <form id="form" action="servlet"> 
            <input type="hidden" name="opc" value="1"> 
            <div class="form-group"> 
                <label for="documento">Nro Documento</label> 
                <input type="text" class="form-control" id="nro" name="nrodoc"> 
            </div> 
            <div class="form-group"> 
                <label for="tipo">Tipo de Documento</label> 
                <input type="text" class="form-control" id="tipo" name="tipo"> 
            </div>
            <div class="form-group"> 
                <label for="nombre">Nombres</label> 
                <input type="text" class="form-control" id="nombre" name="nombre"> 
            </div> 
            <div class="form-group"> 
                <label for="ape">Apellidos</label> 
                <input type="text" class="form-control" id="ape" name="ape"> 
            </div> 
            <div class="form-group"> 
                <label for="correo">Email</label> 
                <input type="email" class="form-control" id="correo" name="correo"> 
            </div> 
            <div class="form-group"> 
                <label for="telef">Telefono</label> 
                <input type="text" class="form-control" id="telef" name="telef"> 
            </div> 
            <div class="form-group"> 
                <label for="fecha">Fecha de Creacion</label> 
                <input type="text" class="form-control" id="fecha" name="fecha"> 
            </div> 
            <button type="submit" class="btn btn-default">Submit</button> 
        </form> 
    </body> 
</html> 
