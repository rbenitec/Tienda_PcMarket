
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
        <h2>Registro de Usuarios</h2>      
        <form id="form" action="servletUser?opc=1"> 
<!--            <input type="hidden" name="opc" value="1"> -->
             <div class="form-group"> 
                 <div class="form-group"> 
                <label for="rol">Rol</label> 
                <input type="text" class="form-control" id="rol" name="rol"> 
            
            <div class="form-group"> 
                <label for="email">Email</label> 
                <input type="text" class="form-control" id="email" name="email"> 
            </div>
            
            <div class="form-group"> 
                <label for="pass">Password</label> 
                <input type="password" class="form-control" id="pass" name="pass"> 
            </div> 
            
            <div class="form-group"> 
                <label for="nombre">Nombres</label> 
                <input type="text" class="form-control" id="nombre" name="nombre"> 
            </div> 
            
            <div class="form-group"> 
                <label for="sexo">Sexo</label> 
                <input type="text" class="form-control" id="sexo" name="sexo"> 
            </div> 
            
            <div class="form-group"> 
                <label for="naci">Nacimiento</label> 
                <input type="text" class="form-control" id="naci" name="naci"> 
            </div> 
            
            <div class="form-group"> 
                <label for="telef">Telefono</label> 
                <input type="text" class="form-control" id="telef" name="telef"> 
            </div> 
            <div class="form-group"> 
                <label for="direc">Direccion</label> 
                <input type="text" class="form-control" id="direc" name="dir"> 
            </div> 
            <div class="form-group"> 
                <label for="estado">Estado</label> 
                <input type="text" class="form-control" id="estado" name="estado"> 
            </div> 
            <div class="form-group"> 
                <label for="dni">DNI</label> 
                <input type="text" class="form-control" id="dni" name="dni"> 
            </div> 
            <div class="form-group"> 
                <label for="user">Username</label> 
                <input type="text" class="form-control" id="user" name="user"> 
            </div> 
            
            <button type="submit" class="btn btn-default">Submit</button> 
        </form> 
    </body> 
</html> 
