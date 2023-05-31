package entities;

import java.time.LocalDateTime;

public class Producto {
    private Long id;
    private int categorias_id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private LocalDateTime creado;
    private String imagen_nombre;
    private Integer estado;
    
    //Getter and Setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCategorias_id() {
        return categorias_id;
    }

    public void setCategorias_id(int categorias_id) {
        this.categorias_id = categorias_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public LocalDateTime getCreado() {
        return creado;
    }

    public void setCreado(LocalDateTime creado) {
        this.creado = creado;
    }

    public String getImagen_nombre() {
        return imagen_nombre;
    }

    public void setImagen_nombre(String imagen_nombre) {
        this.imagen_nombre = imagen_nombre;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
    // ToString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{id=").append(id);
        sb.append(", categorias_id=").append(categorias_id);
        sb.append(", nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", precio=").append(precio);
        sb.append(", stock=").append(stock);
        sb.append(", creado=").append(creado);
        sb.append(", imagen_nombre=").append(imagen_nombre);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
