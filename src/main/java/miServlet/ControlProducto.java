
package miServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.*;
import controller.ClienteDao;
import controller.ProductoDao;
import java.time.LocalDateTime;

public class ControlProducto extends HttpServlet {
    ProductoDao obj=new ProductoDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op=Integer.parseInt(request.getParameter("opc"));
        if(op==1)adicion(request, response);
        if(op==2)consulta(request, response);
        if(op==3)cambia(request, response);
        if(op==4)anular(request, response);
          
    }
     protected void adicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    // if(!obj.busNombre(request.getParameter("cliente"))){
         Producto p=new Producto();
//         p.setCategorias_id(Integer.parseInt(request.getParameter("nrodoc")));
         p.setNombre(request.getParameter("tipo"));
        p.setDescripcion(request.getParameter("nombre"));
        p.setPrecio(Double.parseDouble(request.getParameter("ape")));
        p.setStock(Integer.parseInt(request.getParameter("telef")));
        p.setImagen_nombre(request.getParameter("telef"));
        p.setCreado(LocalDateTime.now());
        
        obj.registrarProducto(p);
        String pag="productos/listarProductos.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
        // }
    }
     
       protected void consulta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           int nro=Integer.parseInt(request.getParameter("cod"));
           Producto p=obj.obtenerPorId(nro);
           //reenviar el dato encontrado a la pagina pagEditar.jsp
           request.setAttribute("dato", p);
        String pag="productos/editarProductos.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
           
    } 
       protected void cambia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Producto p=new Producto();
//        p.setNro(Integer.parseInt(request.getParameter("numero")));
//        p.setCliente(request.getParameter("cliente"));
//        p.setMonto(Double.parseDouble(request.getParameter("monto")));
//        p.setMes(Integer.parseInt(request.getParameter("mes")));
//        obj.modifica(p);
        String pag="/pagListado.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
        
    }
          protected void anular(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int nro=Integer.parseInt(request.getParameter("cod"));
         obj.anula(nro);
           String pag="/pagListado.jsp";
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
