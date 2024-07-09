package pe.edu.utp.repository;

import pe.edu.utp.model.Curso;
import java.util.List;

public interface CursoDAO {

    void agregarCurso(Curso curso);
    List<Curso> listarCursos();
}
