package pe.edu.utp.Implement;

import pe.edu.utp.BaseDatos.ConexionBD;
import pe.edu.utp.model.Curso;
import pe.edu.utp.repository.CursoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOImp implements CursoDAO {
    private static final String INSERTAR_CURSO_SQL = "INSERT INTO course (name) VALUES (?)";
    private static final String LISTAR_CURSOS_SQL = "SELECT * FROM course";

    @Override
    public void agregarCurso(Curso curso) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_CURSO_SQL)) {
            preparedStatement.setString(1, curso.getNombre());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al agregar el curso: " + ex.getMessage());
        }
    }

    @Override
    public List<Curso> listarCursos() {
        List<Curso> cursos = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement(LISTAR_CURSOS_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Curso curso = new Curso();
                curso.setIdCurso(resultSet.getLong("id_course"));
                curso.setNombre(resultSet.getString("name"));
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar los cursos: " + ex.getMessage());
        }
        return cursos;
    }
}
