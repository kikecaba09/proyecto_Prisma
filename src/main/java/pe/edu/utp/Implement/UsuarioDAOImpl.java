package pe.edu.utp.Implement;

import pe.edu.utp.BaseDatos.ConexionBD;
import pe.edu.utp.model.Usuario;
import pe.edu.utp.repository.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    private static final String INSERTAR_USUARIO_SQL = "CALL solicitar_vacante(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String ACTUALIZAR_TIPO_USUARIO_SQL = "CALL aceptar_vacante(?)";
    private static final String OBTENER_USUARIOS_POR_TIPO_SQL = "SELECT * FROM usuario WHERE tipo = ?";

    @Override
    public boolean insertarUsuario(Usuario usuario) {
        boolean exito = false;
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_USUARIO_SQL)) {
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getApellido());
            preparedStatement.setString(3, usuario.getFechaNacimiento());
            preparedStatement.setString(4, usuario.getDni());
            preparedStatement.setString(5, usuario.getEmail());
            preparedStatement.setString(6, usuario.getTelefono());
            preparedStatement.setString(7, usuario.getTipo());
            preparedStatement.setBoolean(8, usuario.isActivo());

            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                exito = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar el usuario: " + ex.getMessage());
        }
        return exito;
    }

    @Override
    public boolean actualizarTipoUsuario(int idUsuario) {
        boolean exito = false;
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement(ACTUALIZAR_TIPO_USUARIO_SQL)) {
            preparedStatement.setInt(1, idUsuario);

            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                exito = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el tipo de usuario: " + ex.getMessage());
        }
        return exito;
    }

    @Override
    public List<Usuario> obtenerUsuariosPorTipo(String tipoUsuario) {
        List<Usuario> listaUsuarios = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement(OBTENER_USUARIOS_POR_TIPO_SQL)) {
            preparedStatement.setString(1, tipoUsuario);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setNombre(resultSet.getString("nombre"));
                    usuario.setApellido(resultSet.getString("apellido"));
                    usuario.setFechaNacimiento(resultSet.getString("fecha_nacimiento"));
                    usuario.setDni(resultSet.getString("dni"));
                    usuario.setEmail(resultSet.getString("email"));
                    usuario.setTelefono(resultSet.getString("telefono"));
                    usuario.setTipo(resultSet.getString("tipo"));
                    usuario.setActivo(resultSet.getBoolean("activo"));
                    listaUsuarios.add(usuario);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener usuarios por tipo: " + ex.getMessage());
        }
        return listaUsuarios;
    }
}
