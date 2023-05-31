
package miServlet;

import controller.CategoriaDAO;
import entities.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class controlCategoria extends HttpServlet {

    CategoriaDAO obj=new CategoriaDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int op=Integer.parseInt(request.getParameter("opc"));
        if(op==1)adicion(request,response);
        if(op==2)consulta(request,response);
        if(op==3)cambia(request,response);
        if(op==4)anular(request,response);

    }

        protected void adicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Categoria p=new Categoria();
        p.setNombre(request.getParameter("nombre"));
        p.setOrden(Integer.parseInt(request.getParameter("orden")));
        obj.adicion(p);
        String pag="/listadoCategoria.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }
        
        protected void consulta(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int nro=Integer.parseInt(request.getParameter("cod"));
        Categoria p=obj.consulta(nro);
        //reenviar el dato encontrado a la pagina modificaCategoria.jsp
        request.setAttribute("dato", p);
        String pag="/modificaCategoria.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }  
    
     protected void cambia(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Categoria p=new Categoria();
        p.setId(Integer.parseInt(request.getParameter("id")));
        p.setNombre(request.getParameter("nombre"));
        p.setOrden(Integer.parseInt(request.getParameter("orden")));
        obj.modifica(p);
        String pag="/listadoCategoria.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }
     
          protected void anular(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         int nro=Integer.parseInt(request.getParameter("cod"));
         obj.anula(nro);
         String pag="/listadoCategoria.jsp";
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
