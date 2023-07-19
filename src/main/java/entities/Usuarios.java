
package entities;

public class Usuarios {
    
    private int id;
    private int rol;
    private String email;
    private String pass;
    private String nombre;
    private String sexo;
    private String nacimiento;
    private String telefono;
    private String direccion;
    private String estado;
    private String dni;
    private String user;

    public Usuarios() {
    }

    public Usuarios(int id, int rol, String email, String pass, String nombre, String sexo, String nacimiento, String telefono, String direccion, String estado, String dni, String user) {
        this.id = id;
        this.rol= rol;
        this.email = email;
        this.pass = pass;
        this.nombre = nombre;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
        this.dni = dni;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     public int getRol() {
        return id;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuarios{");
        sb.append("id=").append(id);
        sb.append(", rol=").append(rol);
        sb.append(", email=").append(email);
        sb.append(", pass=").append(pass);
        sb.append(", nombre=").append(nombre);
        sb.append(", sexo=").append(sexo);
        sb.append(", nacimiento=").append(nacimiento);
        sb.append(", telefono=").append(telefono);
        sb.append(", direccion=").append(direccion);
        sb.append(", estado=").append(estado);
        sb.append(", dni=").append(dni);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
