/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejb.UsuarioFacadeLocal;
import modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
public class procesarLogin extends HttpServlet {

    @EJB
    private UsuarioFacadeLocal x;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("txtUsername");
        String clave = request.getParameter("txtClave"); 
        String MensajE;

        if (usuario.trim().equals("") || clave.trim().equals("")) {
            MensajE = "<center><h3>Llene los campos</h3><br />"
                    + "<a href='index.jsp'><button type='button' id='boton' style='width:300px'>Volver</button></a>"
                    + "</center>";
            request.getSession().setAttribute("MensajE", MensajE);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            Usuario u = x.find(usuario);
            if (x.findUsuario(usuario)) {
                if (u.getContrasenia().equals(clave)) {
                    request.getSession().setAttribute("usuario", usuario);
                    request.getRequestDispatcher("inicio.jsp").forward(request, response);
                } else {
                    MensajE = "<center><h3>Usuario o contraseña incorrecto</h3>"
                            + "<a href='index.jsp'><button type='button' id='boton' style='width:300px'>Volver</button></a>"
                            + "</center>";
                    request.getSession().setAttribute("MensajE", MensajE);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            } else {
                MensajE = "<center><h3>Usuario o contraseña incorrecto</h3>"
                            + "<a href='index.jsp'><button type='button' id='boton' style='width:300px'>Volver</button></a>"
                            + "</center>";
                request.getSession().setAttribute("MensajE", MensajE);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        }
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
