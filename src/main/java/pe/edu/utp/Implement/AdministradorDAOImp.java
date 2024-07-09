package pe.edu.utp.Implement;

import pe.edu.utp.BaseDatos.ConexionBD;
import pe.edu.utp.model.Administrador;
import pe.edu.utp.repository.AdministradorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdministradorDAOImp implements AdministradorDAO {

    @Override
    public boolean registrarAdmin(Administrador adminDTO) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        boolean resultado = false;

        try {
            conexion = ConexionBD.obtenerConexion();
            pstmt = conexion.prepareStatement("{ CALL sp_register_admin(?, ?, ?, ?, ?, ?) }");
            pstmt.setString(1, adminDTO.getName());
            pstmt.setString(2, adminDTO.getLastName());
            pstmt.setString(3, adminDTO.getEmail());
            pstmt.setString(4, adminDTO.getPassword());
            pstmt.setString(5, adminDTO.getProfile());
            pstmt.setString(6, adminDTO.getAdminCode());
            resultado = pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ConexionBD.cerrarConexion(conexion);
        }

        return resultado;
    }
}
