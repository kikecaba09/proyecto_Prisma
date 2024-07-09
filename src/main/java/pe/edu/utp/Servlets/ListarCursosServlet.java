package pe.edu.utp.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.utp.Implement.CursoDAOImp;
import pe.edu.utp.model.Curso;
import pe.edu.utp.repository.CursoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/listarCursos")
public class ListarCursosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Configurar respuesta HTTP como HTML
        response.setContentType("text/html;charset=UTF-8");

        // Obtener PrintWriter para escribir la respuesta
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Listado de Cursos</title></head><body>");
        out.println("<h1>Listado de Cursos</h1>");

        // Obtener lista de cursos desde la base de datos
        CursoDAO cursoDAO = new CursoDAOImp();
        List<Curso> cursos = cursoDAO.listarCursos();

        // Construir tabla HTML con los cursos
        out.println("<table border='1'>");
        out.println("<tr><th>ID del Curso</th><th>Nombre del Curso</th></tr>");
        for (Curso curso : cursos) {
            out.println("<tr><td>" + curso.getIdCurso() + "</td><td>" + curso.getNombre() + "</td></tr>");
        }
        out.println("</table>");

        // Agregar enlace para registrar nuevo curso
        out.println("<br><a href='/HTML/Curso/agregarCurso.html'>Registrar nuevo curso</a>");

        out.println("</body></html>");
    }
}
