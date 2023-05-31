
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.Usuarios" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <%  
        Usuarios u=(Usuarios)request.getAttribute("dato");
           %>
        <h1>Modificar datos del Cliente</h1>
        <form id="form" action="servletUser" method="post">
        <input type="hidden" name="opc" value="2"> 
         <div class="form-group"> 
             <label for="id">ID</label> 
             <input type="text" class="form-control" id="id" name="id" value="<%=u.getId()%>" readonly>
         </div>
         <div class="form-group"> 
             <label for="rol">ROL</label> 
             <input type="text" class="form-control" id="rol" name="rol" value="<%=u.getRol()%>">
         </div>
         <div class="form-group">
             <label for="email">Tipo</label> 
            <input type="text" class="form-control" id="email" name="email" value="<%=u.getEmail()%>">
         </div>
         <div class="form-group">
           <label for="pass">Contraseña</label>
           <input type="password" class="form-control" id="pass" name="pass" value="<%=u.getPass()%>>"> 
          </div>    
         <div class="form-group">
           <label for="nombre">Nombres</label>
         <input type="text" class="form-control" id="nombre" name="nombre" value="<%=u.getNombre()%>>"> 
          </div>    
            <div class="form-group">
           <label for="sexo">Sexo</label>
         <input type="text" class="form-control" id="sexo" name="sexo" value="<%=u.getSexo()%>>"> 
          </div>  
          <div class="form-group">
           <label for="naci">Fecha de Nacimiento</label>
         <input type="text" class="form-control" id="naci" name="naci" value="<%=u.getNacimiento()%>>"> 
          </div> 
           <div class="form-group">
           <label for="fecha">Direccion</label>
         <input type="text" class="form-control" id="fecha" name="fecha" value="<%=u.getDireccion()%>>"> 
          </div> 
          <div class="form-group">
           <label for="estado">Estado</label>
         <input type="text" class="form-control" id="estado" name="estado" value="<%=u.getEstado()%>>"> 
          </div>
          <div class="form-group">
           <label for="dni">Dni</label>
         <input type="text" class="form-control" id="dni" name="dni" value="<%=u.getDni()%>>"> 
          </div>
          <div class="form-group">
           <label for="user">User</label>
         <input type="text" class="form-control" id="user" name="user" value="<%=u.getUser()%>>"> 
          </div>
          <button type="submit" class="btn btn-default">Submit</button> 
        
        </form>
    </body>
</html>
