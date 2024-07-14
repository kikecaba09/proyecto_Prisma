package pe.edu.utp.Servlets.Vacantes;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.utp.Implement.UsuarioDAOImpl;
import pe.edu.utp.model.Usuario;
import pe.edu.utp.repository.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/listarVacantes")
public class ListarVacantesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Listado de Vacantes</title></head><body>");
        out.println("<h1>Listado de Vacantes</h1>");

        // Obtener la lista de usuarios que han solicitado vacante
        UsuarioDAO userDAO = new UsuarioDAOImpl();
        List<Usuario> listaUsuarios = userDAO.obtenerUsuariosPorTipo("POSTULANTE");

        if (listaUsuarios.isEmpty()) {
            out.println("<p>No hay vacantes solicitadas actualmente.</p>");
        } else {
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Nombre</th><th>Apellido</th><th>Fecha de Nacimiento</th><th>DNI</th><th>Email</th><th>Teléfono</th><th>Acción</th></tr>");

            for (Usuario usuario : listaUsuarios) {
                out.println("<tr>");
                out.println("<td>" + usuario.getId() + "</td>");
                out.println("<td>" + usuario.getNombre() + "</td>");
                out.println("<td>" + usuario.getApellido() + "</td>");
                out.println("<td>" + usuario.getFechaNacimiento() + "</td>");
                out.println("<td>" + usuario.getDni() + "</td>");
                out.println("<td>" + usuario.getEmail() + "</td>");
                out.println("<td>" + usuario.getTelefono() + "</td>");
                out.println("<td><a href='/aceptarVacante?id=" + usuario.getId() + "'>Aceptar</a></td>");
                out.println("</tr>");
            }

            out.println("</table>");
        }

        out.println("</body></html>");
    }
}
