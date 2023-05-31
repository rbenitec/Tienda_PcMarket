
package entities;

public class Cliente {
    
    private int nrodoc;
    private String tipo;
    private String nombre;
    private String ape;
    private String correo;
    private int telef;
    private String fecha;
    

    public Cliente() {
    }

    public Cliente(int nrodoc, String tipo, String nombre,
            String ape, String correo, int telef, String fecha) {
        this.nrodoc = nrodoc;
        this.tipo = tipo;
        this.nombre = nombre;
        this.ape = ape;
        this.correo = correo;
        this.telef = telef;
        this.fecha = fecha;
    }

    public int getNrodoc() {
        return nrodoc;
    }

    public void setNrodoc(int nrodoc) {
        this.nrodoc = nrodoc;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelef() {
        return telef;
    }

    public void setTelef(int telef) {
        this.telef = telef;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("nrodoc=").append(nrodoc);
        sb.append(", tipo=").append(tipo);
        sb.append(", nombre=").append(nombre);
        sb.append(", ape=").append(ape);
        sb.append(", correo=").append(correo);
        sb.append(", telef=").append(telef);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }
    
    
    
          
            
    
}
