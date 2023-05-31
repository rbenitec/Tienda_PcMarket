
package miServlet;

import entities.*;
import controller.ClienteDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servlet extends HttpServlet {
    ClienteDao obj= new ClienteDao();

 
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
         Cliente c=new Cliente();
         c.setNrodoc(Integer.parseInt(request.getParameter("nrodoc")));
         c.setTipo(request.getParameter("tipo"));
        c.setNombre(request.getParameter("nombre"));
        c.setApe(request.getParameter("ape"));
        c.setCorreo(request.getParameter("correo"));
        c.setTelef(Integer.parseInt(request.getParameter("telef")));
        c.setFecha(request.getParameter("fecha"));       
        
         System.out.println("Se manda el cliente: "+ c.toString());
        obj.adicion(c);
        String pag="/listaClientes.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
      
    }
      protected void cambia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente c=new Cliente();
        c.setNrodoc(Integer.parseInt(request.getParameter("nrodoc")));
        c.setNombre(request.getParameter("nombre"));
         c.setApe(request.getParameter("ape"));
          c.setCorreo(request.getParameter("correo"));
          c.setTelef(Integer.parseInt(request.getParameter("telef")));
          c.setFecha(request.getParameter("fecha"));    
         
          obj.modifica(c);
        String pag="/listaClientes.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
        
    } 
      protected void anular(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int nro=Integer.parseInt(request.getParameter("cod"));
         obj.anula(nro);
           String pag="/listaClientes.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
 
    
    }
       protected void consulta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           int nro=Integer.parseInt(request.getParameter("cod"));
           System.out.println("dni: " +nro);
           Cliente c=obj.consulta(nro);
            System.out.println("cliente: "+c.toString())   ;
    //reenviar el dato encontrado a la pagina editaCliente.jsp
           request.setAttribute("dato", c);
        String pag="/editaCliente.jsp";
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
