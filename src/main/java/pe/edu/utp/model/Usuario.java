package pe.edu.utp.model;

public class Usuario {
    private String name;
    private String lastName;
    private String birthDate;
    private String dni;
    private String email;
    private String phone;
    private String type;
    private String grade;

    public Usuario(String name, String lastName, String birthDate, String dni, String email,
                   String phone, String type, String grade) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.dni = dni;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.grade = grade;
    }

    public Usuario() {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
