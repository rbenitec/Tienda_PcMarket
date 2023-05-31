<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.Categoria" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Categoria pe=(Categoria)request.getAttribute("dato");
        %>
        
        <h2>Modifica datos de la Categoria</h2>
        <form id="form" action="controlCategoria">
            <input type="hidden" name="opc" value="3"> 
        <div class="form-group"> 
            <label for="id">ID de la Categoria</label> 
            <input type="text" class="form-control" id="id" name="id" value="<%=pe.getCatid()%>" readonly> 
        </div>
        <div class="form-group"> 
            <label for="nombre">Nombre de la Categoria</label> 
            <input type="text" class="form-control" id="nombre" name="nombre" value="<%=pe.getCatnom()%>"> 
        </div> 
        <div class="form-group"> 
            <label for="orden">Nro. de orden</label> 
            <input type="text" class="form-control" id="orden" name="orden" value="<%=pe.getCatord()%>"> 
        </div> 
   
      <button type="submit" class="btn btn-default">Modificar</button> 
        </form>
        
    </body>
</html>
