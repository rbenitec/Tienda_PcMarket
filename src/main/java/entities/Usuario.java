
package entities;

public class Usuario {
    private int id;
    private int id_rol;
    private String email;
    private String password;
    private String nombres;
    private String sexo;
    private String fecnacimiento;
    private String telefono;
    private String direccion;
    private String estado;
    private String dni;
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecnacimiento() {
        return fecnacimiento;
    }

    public void setFecnacimiento(String fecnacimiento) {
        this.fecnacimiento = fecnacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{id=").append(id);
        sb.append(", id_rol=").append(id_rol);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", nombres=").append(nombres);
        sb.append(", sexo=").append(sexo);
        sb.append(", fecnacimiento=").append(fecnacimiento);
        sb.append(", telefono=").append(telefono);
        sb.append(", direccion=").append(direccion);
        sb.append(", estado=").append(estado);
        sb.append(", dni=").append(dni);
        sb.append(", username=").append(username);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
