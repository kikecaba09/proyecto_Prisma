package pe.edu.utp.model;

public class LoginAdmin {
    private String idAdmin;
    private String password;

    public LoginAdmin(String idAdmin, String password) {
        this.idAdmin = idAdmin;
        this.password = password;
    }

    public LoginAdmin() {
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginAdmin{" +
                "idAdmin='" + idAdmin + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
