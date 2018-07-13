package controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ejb.UsuarioFacadeLocal;
import modelo.Usuario;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
public class procesarRegistrar extends HttpServlet {

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

        String username = request.getParameter("txtNickname");
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String contraseña = request.getParameter("txtClave");
        String edad = request.getParameter("txtEdad");
        String detalle = request.getParameter("txtDetalle");
        String correo = request.getParameter("txtCorreo");
        String sexo = request.getParameter("rdSexo");
        String MensajE;
        String mensaje;

        if (nombre.trim().equals("") || apellido.trim().equals("") || username.trim().equals("")
                || sexo.trim().equals("") || contraseña.trim().equals("") || sexo.trim().equals("")) {
            MensajE = "<center><h3>Campos vacios, Por favor completelos</h3> <br />"
                    + "<a href='Registrar.jsp'><button type='button' id='boton' style='width:300px'>Volver</button></a>"
                    + "</center>";
            request.getSession().setAttribute("MensajE", MensajE);
            request.getRequestDispatcher("error.jsp").forward(request, response);

        } else {
            if (x.findUsuario(username)) {
                MensajE = "<center><h3>Usuario Preexistente</h3> <br />"
                        + "<a href='Registrar.jsp'><button type='button' id='boton' style='width:300px'>Volver</button></a>"
                        + "</center>";
                request.getSession().setAttribute("MensajE", MensajE);
                request.getRequestDispatcher("error.jsp").forward(request, response);

            } else {
                try {

                    int ed = Integer.parseInt(edad);
                    if (ed <= 18 || ed >= 100) {
                        MensajE = "<center><h3>Ingrese una Edad Valida</h3> <br />"
                                + "<a href='index.jsp'><button type='button' id='boton' style='width:300px'>Volver</button></a>"
                                + "</center>";
                        request.getSession().setAttribute("MensajE", MensajE);
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    } else {
                        if (sexo.equals("Masculino")) {
                            x.create(new Usuario(username, contraseña, nombre, apellido, correo, ed, "Masculino"));
                            mensaje = "<center><h3>Registrado Exitoso</h3><br />"
                                    + "<a href='index.jsp'><button type='button' id='boton' style='width:300px'>Home</button></a>"
                                    + "</center>";
                            request.getSession().setAttribute("mensaje", mensaje);
                            request.getRequestDispatcher("exito.jsp").forward(request, response);

                        } else {
                            x.create(new Usuario(username, contraseña, nombre, apellido, correo, ed, "Femenino"));
                            mensaje = "<center><h3>Registrado Exitoso</h3> <br />"
                                    + "<a href='index.jsp'><button type='button' id='boton' style='width:300px'>Home</button></a>"
                                    + "</center>";
                            request.getSession().setAttribute("mensaje", mensaje);
                            request.getRequestDispatcher("exito.jsp").forward(request, response);
                        }
                    }
                } catch (NumberFormatException e) {

                    MensajE = "<center><h3>Campo Edad se ingresa solo numero</h3> <br />"
                            + "<a href='index.jsp'><button type='button' id='boton' style='width:300px'>Volver</button></a>"
                            + "</center>";
                    request.getSession().setAttribute("MensajE", MensajE);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
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
