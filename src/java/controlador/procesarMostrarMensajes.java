/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejb.MensajeFacadeLocal;
import java.io.IOException;
import static java.lang.System.out;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Mensaje;

/**
 *
 * @author dell
 */
public class procesarMostrarMensajes extends HttpServlet {

    @EJB
    private MensajeFacadeLocal msj;

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
        String mensaje;
        String MensajE;
            List<Mensaje> lista = msj.findAll();
            if (lista != null) {
                for (int i = lista.size() - 1; i > 0; i--) {
                    
                    mensaje ="<p>" + lista.get(i).getUsuarioUsername().getCorreo() + "</p>"
                    +"<h6>< style='color:gray'>" + lista.get(i).getFecha() + "</h6><br/>"
                    +"<textarea cols='30' rows='4' disabled>" + lista.get(i).getMensaje() + "</textarea><br/>";
                    request.getSession().setAttribute("lista", lista);
                    request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                }
            } else {
                MensajE ="<center><h3>Lo sentimos, No hay mensajes que mostrar</h3></center>";
                request.getSession().setAttribute("MensajE", MensajE);
                request.getRequestDispatcher("error.jsp").forward(request, response);
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
