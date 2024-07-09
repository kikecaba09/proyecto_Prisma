package pe.edu.utp.repository;

import pe.edu.utp.model.Administrador;

public interface AdministradorDAO {

    boolean registrarAdmin(Administrador adminDTO);
    Administrador iniciarSesion(String idAdmin, String password);
}
