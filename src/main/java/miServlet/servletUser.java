package miServlet;
import entities.*;
import controller.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class servletUser extends HttpServlet {
    UsuarioDao obj = new UsuarioDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op=Integer.parseInt(request.getParameter("opc"));
        System.out.println("processRequest: "+op);
        if(op==1)adicion(request, response);
        if(op==2)cambia(request, response);
        if(op==3)anular(request, response);
        if(op==4)consulta(request, response);
    }
    protected void adicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    // if(!obj.busNombre(request.getParameter("cliente"))){
         System.out.println("Se llamo al metodo adicion:!");
         int rol = 1;
         String email = (String)request.getParameter("email");
         String nombre = (String)request.getParameter("nombre");
         String pass = (String)request.getParameter("pass");
         String sexo = (String)request.getParameter("sexo");
         String nacimiento = (String)request.getParameter("naci");
         String telef = (String)request.getParameter("telef");
         String direccion = (String)request.getParameter("dir");
         String estado = (String)request.getParameter("estado");
         String dni = (String)request.getParameter("dni");
         String user = (String)request.getParameter("user");
         
         
         Usuarios u=new Usuarios();       
         u.setRol(1);
         u.setEmail(email);
         u.setPass(pass);
         u.setNombre(nombre);
         u.setSexo(sexo);
         u.setNacimiento(nacimiento);
         u.setTelefono(telef);
         u.setDireccion(direccion);
         u.setEstado(estado);
         u.setDni(dni);
         u.setUser(user);
        
        
         System.out.println("Se manda el cliente: "+ u.toString());
        obj.adicion(u);
        String pag="/listarUsuarios.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
         
    }
    protected void cambia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuarios u=new Usuarios();
       u.setId(Integer.parseInt(request.getParameter("id")));
       u.setId(Integer.parseInt(request.getParameter("rol")));
         u.setEmail(request.getParameter("email"));
        u.setPass(request.getParameter("pass"));
        u.setNombre(request.getParameter("nombre"));
        u.setSexo(request.getParameter("sexo"));
        u.setNacimiento(request.getParameter("naci"));
        u.setTelefono(request.getParameter("telef"));  
        u.setDireccion(request.getParameter("direc"));  
        u.setEstado(request.getParameter("estado"));  
        u.setDni(request.getParameter("dni"));  
        u.setUser(request.getParameter("user"));     
         
          obj.modifica(u);
        String pag="/listarUsuarios.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
        
    } 
    protected void anular(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int nro=Integer.parseInt(request.getParameter("cod"));
         obj.anula(nro);
           String pag="/listarUsuarios.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    
    }
    protected void consulta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           int nro=Integer.parseInt(request.getParameter("cod"));
           System.out.println("id: " +nro);
           Usuarios u=obj.consulta(nro);
            System.out.println("Usuario: "+u.toString())   ;
    //reenviar el dato encontrado a la pagina editaCliente.jsp
           request.setAttribute("dato", u);
        String pag="/editaUsuario.jsp";
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
