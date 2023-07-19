
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <link href="static/css/login_register.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h2>Registro de Usuarios</h2>      
<!--        <form id="form" action="servletUser?opc=1"> 
            <input type="hidden" name="opc" value="1"> 
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
        </form> -->
        <div class="contenedor__todo">

                <!--Formulario registro-->
                <div class="contenedor__login-register">
                    
                    <!--Register-->
                    <form action="controlador?opc=6" method="post" class="formulario__register">
                        <h2>Registrarse</h2>
                        <div class="registro-control">
                        <input type="text" id="nombres" placeholder="Nombres">
                        <div class="error"></div>
                        </div>
                        
                        <div class="registro-control">
                        <input type="text" id="user" placeholder="Usuario">
                        <div class="error"></div>
                        </div>
                        
                        <div class="registro-control">
                        <input type="text" id="dni" placeholder="Documento de DNI">
                        <div class="error"></div>
                        </div>
                        
                        <div class="registro-control">
                        <input type="text" id="correo_register" placeholder="Correo Electronico">
                        <div class="error"></div>
                        </div>
                        
                        <div class="registro-control">
                        <input type="password" id="contrasena_register" placeholder="Contraseña">
                        <div class="error"></div>
                        </div>
                        
                        <div class="registro-control">
                        <div class="opciones-genero" id="genero">
                            <input type="radio" value="N" id="genero-femenino" name="genero">
                            <label for="genero-femenino">Masculino</label>
                            <input type="radio" value="E" id="genero-masculino" name="genero">
                            <label for="genero-masculino">Femenino</label>
                        </div>
                            <div class="error"></div>
                        </div>
                        <button type="submit" id="btn_registrarse_form" >Registrarse</button>
                    </form>
                </div>
            </div>
    </body> 
</html> 
