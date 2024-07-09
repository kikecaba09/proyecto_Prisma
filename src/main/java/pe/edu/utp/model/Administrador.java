package pe.edu.utp.model;

public class Administrador {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String profile;
    private String adminCode;

    public Administrador(String name, String lastName, String email, String password,
                         String profile, String adminCode) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.adminCode = adminCode;
    }

    public Administrador() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profile='" + profile + '\'' +
                ", adminCode='" + adminCode + '\'' +
                '}';
    }
}
