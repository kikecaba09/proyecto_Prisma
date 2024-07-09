package pe.edu.utp.Servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.utp.Implement.AdministradorDAOImp;
import pe.edu.utp.model.Administrador;
import pe.edu.utp.repository.AdministradorDAO;
import java.io.IOException;

@WebServlet("/registrarAdmin")
public class RegistrarAdminServlet extends HttpServlet {
    private AdministradorDAO adminDAO = new AdministradorDAOImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String profile = request.getParameter("profile");
        String adminCode = request.getParameter("id_admin");

        Administrador adminDTO = new Administrador
                (name, lastName, email, password, profile, adminCode);

        if (adminDAO.registrarAdmin(adminDTO)) {
            response.sendRedirect("login.html"); // Página de éxito
        } else {
            response.sendRedirect("registro_fallido.jsp"); // Página de error
        }
    }
}
