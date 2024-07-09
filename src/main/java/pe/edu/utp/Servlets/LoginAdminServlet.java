package pe.edu.utp.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.utp.Implement.AdministradorDAOImp;
import pe.edu.utp.model.Administrador;
import pe.edu.utp.repository.AdministradorDAO;
import java.io.IOException;

@WebServlet("/loginAdmin")
public class LoginAdminServlet extends HttpServlet {

    private final AdministradorDAO adminDAO = new AdministradorDAOImp(); // Instancia única del DAO

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idAdmin = request.getParameter("id_admin");
        String password = request.getParameter("password");

        Administrador admin = adminDAO.iniciarSesion(idAdmin, password);

        if (admin != null) {
            // Inicio de sesión exitoso
            request.setAttribute("adminSession", admin); // No se utiliza setAttribute en la sesión
            response.sendRedirect("/HTML/administrador/dashboardAdmin.html");
        } else {
            // Error en inicio de sesión
            request.setAttribute("errorMensaje", "Código de administrador o contraseña incorrectos.");
            request.getRequestDispatcher("/HTML/login/login.html").forward(request, response);
        }
    }
}
