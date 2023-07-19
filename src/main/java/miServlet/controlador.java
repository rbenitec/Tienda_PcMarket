package miServlet;

import controller.LoginDao;
import controller.ProductoDao;
import controller.UsuarioDao;
import entities.Producto;
import entities.Usuario;
import entities.Usuarios;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class controlador extends HttpServlet {
    UsuarioDao objUser = new UsuarioDao();
 
    ProductoDao obj = new ProductoDao();
    LoginDao log= new LoginDao();
    private static final String RUTA_DESTINO = "statis/img/";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op = Integer.parseInt(request.getParameter("opc"));
        if (op == 1) {
            adicion(request, response);
        }
        if (op == 2) {
            consulta(request, response);
        }
        if (op == 3) {
            cambia(request, response);
        }
        if (op == 4) {
            anular(request, response);
        }
        if (op == 5) {
            validar(request, response);
        }
        if (op == 6) {
            adicionUser(request, response);
        }
    }

    protected void adicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // if(!obj.busNombre(request.getParameter("cliente"))){
        int idCategoria = Integer.parseInt(request.getParameter("categoria"));
        String nombre = request.getParameter("nombre");
        String decripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        System.out.println("categoria: " + idCategoria);
        System.out.println("nombre: " + nombre);
        System.out.println("decripcion: " + decripcion);
        System.out.println("precio: " + precio);
//        System.out.println("stock: "+ stock);

        Producto p = new Producto();
        p.setCategorias_id(idCategoria);
        p.setNombre(request.getParameter("nombre"));
        p.setDescripcion(request.getParameter("descripcion"));
        p.setPrecio(Double.parseDouble(request.getParameter("precio")));
        p.setStock(Integer.parseInt(request.getParameter("stock")));
        p.setImagen_nombre(request.getParameter("file"));
        p.setCreado(LocalDateTime.now());
        p.setEstado(1);

        obj.registrarProducto(p);
        System.out.println("Se registro el producto: " + p.toString());
        String pag = "listarProductos.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
        // }
    }

    protected void consulta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Se llamo al metodo consulta!");
        int nro = Integer.parseInt(request.getParameter("cod"));
        Producto p = obj.obtenerPorId(nro);
        //reenviar el dato encontrado a la pagina pagEditar.jsp
        request.setAttribute("dato", p);
        String pag = "editarProductos.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void cambia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Producto p = new Producto();
//        p.setNro(Integer.parseInt(request.getParameter("numero")));
//        p.setCliente(request.getParameter("cliente"));
//        p.setMonto(Double.parseDouble(request.getParameter("monto")));
//        p.setMes(Integer.parseInt(request.getParameter("mes")));
//        obj.modifica(p);
        String pag = "pagListado.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void anular(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("cod"));
        obj.anula(nro);
        String pag = "listarProductos.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void validar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String pag = "";
        String error="";
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        Usuario user= new Usuario();  
        user=log.obtenerUsuario(email, pass);
        String userName = user.getNombres();
        System.out.println("email: "+email);
        System.out.println("pass: "+pass);
        if(user!=null){
            System.out.println("Usuario Valido");
            System.out.println("user: "+user.toString());
            request.setAttribute("user", userName);
            pag = "listarProductos.jsp";
        }else{
            System.out.println("Usuario Invalido");
            pag="login_registro.html";
            error="falso";
            request.setAttribute("dato", error);
        }
        
        
        request.getRequestDispatcher(pag).forward(request, response);

    }
    
    protected void adicionUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    // if(!obj.busNombre(request.getParameter("cliente"))){
         System.out.println("Se llamo al metodo adicion:!");
         int rol = 1;
         String email = (String)request.getParameter("email");
         String nombre = (String)request.getParameter("nombres");
         String pass = (String)request.getParameter("pass");
         String sexo = (String)request.getParameter("genero");
//         String nacimiento = (String)request.getParameter("naci");
//         String telef = (String)request.getParameter("telef");
//         String direccion = (String)request.getParameter("dir");
//         String estado = (String)request.getParameter("estado");
         String dni = (String)request.getParameter("dni");
         String user = (String)request.getParameter("user");
         
         
         Usuarios u=new Usuarios();       
         u.setRol(1);
         u.setEmail(email);
         u.setPass(pass);
         u.setNombre(nombre);
         u.setSexo(sexo);
//         u.setNacimiento(nacimiento);
//         u.setTelefono(telef);
//         u.setDireccion(direccion);
//         u.setEstado(estado);
         u.setDni(dni);
         u.setUser(user);
        
        
         System.out.println("Se manda el cliente: "+ u.toString());
        objUser.adicion(u);
        String pag="/listarUsuarios.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
         
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
