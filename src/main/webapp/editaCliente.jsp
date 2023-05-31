
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.Cliente" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>       
        <%  
        Cliente c=(Cliente)request.getAttribute("dato");
           %>
        <h1>Modificar datos del Cliente</h1>
        <form id="form" action="servlet">
        <input type="hidden" name="opc" value="2"> 
         <div class="form-group"> 
             <label for="nrodoc">Dni</label> 
             <input type="text" class="form-control" id="nrodoc" name="nrodoc" value="<%=c.getNrodoc()+""%>" readonly>
         </div>
         <div class="form-group">
             <label for="tipo">Tipo</label> 
            <input type="text" class="form-control" id="tipo" name="tipo" value="<%=c.getTipo()%>" readonly>
         </div>
         <div class="form-group">
           <label for="nombre">Nombre</label>
         <input type="text" class="form-control" id="nombre" name="nombre" value="<%=c.getNombre()%>"> 
          </div>    
         <div class="form-group">
           <label for="ape">Apellido</label>
         <input type="text" class="form-control" id="ape" name="ape" value="<%=c.getApe()%>"> 
          </div>    
            <div class="form-group">
           <label for="correo">Correo</label>
         <input type="text" class="form-control" id="correo" name="correo" value="<%=c.getCorreo()%>"> 
          </div>  
          <div class="form-group">
           <label for="telef">Telefono</label>
         <input type="text" class="form-control" id="telef" name="telef" value="<%=c.getTelef()%>" >
          </div> 
           <div class="form-group">
           <label for="fecha">Fecha</label>
         <input type="text" class="form-control" id="fecha" name="fecha" value="<%=c.getFecha()%>"> 
          </div> 
          <button type="submit" class="btn btn-default">Submit</button>    
        </form>
    </body>
</html>
