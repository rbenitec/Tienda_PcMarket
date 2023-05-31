
package entities;

public class Categoria {
     private int id;
    private String nombre;
    private int orden;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Categoria{id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", orden=").append(orden);
        sb.append('}');
        return sb.toString();
    }
}
