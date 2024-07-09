package pe.edu.utp.repository;

public interface SolicitarVacanteDAO {

    boolean solicitarVacante(String name, String lastName, String birthDate, String dni, String email, String phone, String type);
}
