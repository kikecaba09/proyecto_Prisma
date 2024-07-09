package pe.edu.utp.Implement;

import pe.edu.utp.BaseDatos.ConexionBD;
import pe.edu.utp.repository.SolicitarVacanteDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SolicitarVacanteDAOImpl implements SolicitarVacanteDAO {

    @Override
    public boolean solicitarVacante(String name, String lastName, String birthDate, String dni, String email, String phone, String type) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        boolean resultado = false;

        try {
            conexion = ConexionBD.obtenerConexion();
            pstmt = conexion.prepareStatement("{ CALL solicitar_vacante(?, ?, ?, ?, ?, ?, ?) }");
            pstmt.setString(1, name);
            pstmt.setString(2, lastName);
            pstmt.setString(3, birthDate);
            pstmt.setString(4, dni);
            pstmt.setString(5, email);
            pstmt.setString(6, phone);
            pstmt.setString(7, type);
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
