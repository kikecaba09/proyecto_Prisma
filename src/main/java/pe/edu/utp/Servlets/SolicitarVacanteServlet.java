package pe.edu.utp.Servlets;

import pe.edu.utp.Implement.SolicitarVacanteDAOImpl;
import pe.edu.utp.repository.SolicitarVacanteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/solicitarVacante")
public class SolicitarVacanteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
         super.doGet(req, resp);
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String lastName = request.getParameter("last_name");
        String birthDate = request.getParameter("birth_date");
        String dni = request.getParameter("dni");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String type = request.getParameter("type");

        SolicitarVacanteDAO solicitarVacanteDAO = new SolicitarVacanteDAOImpl();

        if (solicitarVacanteDAO.solicitarVacante(name, lastName, birthDate, dni, email, phone, type)) {
            response.sendRedirect("solicitud_exitosa.html");
        } else {
            request.setAttribute("mensajeError", "Error al solicitar la vacante");
            request.getRequestDispatcher("solicitar_vacante.html").forward(request, response);
        }
    }
}
