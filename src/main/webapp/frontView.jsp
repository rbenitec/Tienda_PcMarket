<%-- 
    Document   : frontView
    Created on : 18/07/2023, 10:18:54 PM
    Author     : rbeni
--%>

<%@page import="controller.ProductoDao"%>
<%@page import="entities.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="static/css/stylesFrontPage.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@2.1.4/css/boxicons.min.css">
        <link href="https://fonts.googleapis.com/css2?family=PT+Sans:wght@400;700&display=swap" rel="stylesheet">
        <title>Tienda electronica</title>
    </head>
    <body>
        <header id="inicio">
            <nav class="nav">
                <div class="logo">TIENDA ELECTRONICA</div>
                <ul class="menu">
                    <li><a href="login_registro.html">Login</a></li>
                    <li><a href="#inicio">Inicio</a></li>
                    <li><a href="#tienda">Tienda</a></li>
                    <li><a href="#">Contacto</a></li>
                    <li><i class='bx bx-shopping-bag' id="cart-icon"></i>
                </ul>
            </nav>

            <div class="caja_trasera">
                <h1>Bienvenido a nuestra tienda de productos electronicos</h1>
                <h3>Encontraras cualquier tipo de producto a un precio accesible</h3>
                <div class="container_busqueda">
                    <input class="input_busqueda" type="text" placeholder="Buscar">
                    <div class="btn">
                        <i class="fa fa-search"></i>
                    </div>
                </div>
            </div>
            <!-- CARRITO -->
            <div class="cart">
                <h2 class="titulo_carrito">Tu Carrito</h2>
                <!-- CONTENIDO -->
                <div class="contenido_Carrito">
                    
                </div>
                <!-- TOTAL -->
                <div class="total">
                    <div class="titulo_total">TOTAL</div>
                    <div class="total_precio">$0</div>
                </div>
                <!-- BOTON COMPRA -->
                <button type="button" class="btn-buy">Comprar ahora</button>
                <!-- cerrar carrito -->
                <i class='bx bx-x' id="close_cart" ></i>
                
            </div>

        </header>

        <%
            ProductoDao obj = new ProductoDao();
            String userName =(String)request.getAttribute("user");
            int cuenta = 0;
        %>
            <div class="tienda container">
            <h2 class="titulo_seccion">Tienda de productos</h2>
         
                    
                        <div class="contenido_tienda" id="tienda">
                            
                                <%
                                    for(Producto x : obj.listarProductos()){
                                %>
                                <div class="caja_producto">
                                    <td>
                                        <img class="imagen_producto" alt="alt" src="static/img/<%=x.getImagen_nombre()%>" width="150">
                                        
                     
                                            <h2 class="titulo_producto"><%=x.getNombre()%></h2>
                                            <span class="price"><%=x.getPrecio()%></span>
                                            <i class='bx bx-shopping-bag add-cart'></i>

                                        
                                </div>
                                <%  
                                    }   
                                %>             
                        </div>
                
            </div>

       

        <section class="contenedor_tienda">

        </section>
        
        <script src="static/js/remover_carrito.js" type="text/javascript"></script>
        <script src="static/js/menu.js" type="text/javascript"></script>
        <script src="static/js/carrito.js" type="text/javascript"></script>
    </body>
</html>
