
package miServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.*;
import controller.ClienteDao;

public class control extends HttpServlet {
    ClienteDao obj=new ClienteDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op=Integer.parseInt(request.getParameter("opc"));
        if(op==1)adicion(request, response);
          
    }
     protected void adicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    // if(!obj.busNombre(request.getParameter("cliente"))){
         Cliente c=new Cliente();
         c.setNrodoc(Integer.parseInt(request.getParameter("nrodoc")));
         c.setTipo(request.getParameter("tipo"));
        c.setNombre(request.getParameter("nombre"));
        c.setApe(request.getParameter("ape"));
        c.setCorreo(request.getParameter("correo"));
        c.setTelef(Integer.parseInt(request.getParameter("telef")));
        c.setFecha(request.getParameter("fecha"));
        
        obj.adicion(c);
        String pag="/listaClientes.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
        // }
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
