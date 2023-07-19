package miServlet;

import controller.UsuarioDao;
import entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlUser extends HttpServlet {

    UsuarioDao obj = new UsuarioDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op = Integer.parseInt(request.getParameter("opc"));
        System.out.println("processRequest: " + op);
        if (op == 1) {
            adicion(request, response);
        }
        if (op == 2) {
            cambia(request, response);
        }
        if (op == 3) {
            anular(request, response);
        }
        if (op == 4) {
            consulta(request, response);
        }
    }

    protected void adicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Se llamo al metodo adicion:!");
        Usuario u = new Usuario();
        u.setId(Integer.parseInt(request.getParameter("id")));
        u.setNombres(request.getParameter("Nombres"));
        u.setUsername(request.getParameter("user"));
        u.setDni(request.getParameter("dni"));
        u.setEmail(request.getParameter("correo_register"));
        u.setPassword(request.getParameter("contrasena_register"));
        u.setSexo(request.getParameter("genero"));
        //obj.adicion(u);
        String pag = "/listaUser.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void consulta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("cod"));
        //Usuario u = obj.consulta(nro);
        //reenviar el dato encontrado a la pagina pagEditar.jsp
       // request.setAttribute("dato", u);
        String pag = "/pagEditar.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void cambia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario u = new Usuario();
        u.setId(Integer.parseInt(request.getParameter("id")));
        u.setNombres(request.getParameter("Nombres"));
        u.setUsername(request.getParameter("user"));
        u.setDni(request.getParameter("dni"));
        u.setEmail(request.getParameter("correo_register"));
        u.setPassword(request.getParameter("contrasena_register"));
        u.setSexo(request.getParameter("genero"));
        //obj.modifica(u);
        String pag = "/listaUser.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void anular(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("cod"));
        obj.anula(nro);
        String pag = "/listaUser.jsp";
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
