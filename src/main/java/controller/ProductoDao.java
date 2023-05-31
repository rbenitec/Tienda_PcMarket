package controller;

import entities.Categoria;
import entities.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import util.MySQLConexion;

public class ProductoDao {
    
    public List<Producto> listarProductos(){
        List<Producto> lis = new ArrayList<>();
        Connection cn = MySQLConexion.getConexion();
        System.out.println("Llegamo Repositorio Listar!");
        try{
            String sql = "select id, categorias_id, nombre, descripcion, precio, stock, imagen_nombre, creado, estado from productos";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setId(rs.getLong(1));
                p.setCategorias_id(rs.getInt(2));
                p.setNombre(rs.getString(3));
                p.setDescripcion(rs.getString(4));
                p.setPrecio(rs.getDouble(5));
                p.setStock(rs.getInt(6));
                p.setImagen_nombre(rs.getString(7));
                p.setCreado(rs.getTimestamp(8).toLocalDateTime());
                p.setEstado(rs.getInt(9));
                lis.add(p);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return lis;
    }
    
    public void registrarProducto(Producto p){
        String sql = "INSERT INTO tienda.productos (categorias_id, nombre, descripcion, precio, stock, imagen_nombre, creado, estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        Connection cn =  MySQLConexion.getConexion();
        System.out.println("ProductoDoa a registrar: "+ p.toString());
        try{
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, p.getCategorias_id());
            st.setString(2, p.getNombre());
            st.setString(3, p.getDescripcion());
            st.setDouble(4, p.getPrecio());
            st.setInt(5, p.getStock());
            st.setString(6, p.getImagen_nombre());
            st.setTimestamp(7, Timestamp.valueOf(p.getCreado()));
            st.setInt(8, p.getEstado());
            st.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
    
    public void modificarProducto(Producto p, Long idProducto){
        String sql = "UPDATE tienda.productos SET categorias_id=?, nombre=?, descripcion=?, precio=?, stock=?, imagen_nombre=?, creado=?, estado=? WHERE id=?;";
        Connection cn =  MySQLConexion.getConexion();
        
        try{
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, p.getCategorias_id());
            st.setString(2, p.getNombre());
            st.setString(3, p.getDescripcion());
            st.setDouble(4, p.getPrecio());
            st.setInt(5, p.getStock());
            st.setString(6, p.getImagen_nombre());
            st.setTimestamp(7, Timestamp.valueOf(p.getCreado()));
            st.setInt(8, p.getEstado());
            st.setLong(9, idProducto);
            st.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }   
    
    public void anula(int idProducto){
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="delete from productos where id=?";  
            //prepara una instruccion sql que sera ejecutada mediante la conexion
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, idProducto);
            st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
   } 
    
   public Producto obtenerPorId(int idProducto){
        Producto p=null;
        Connection cn = MySQLConexion.getConexion();
        System.out.println("Llegamo Repositorio Listar!");
        try{
            String sql = "select id, categorias_id, nombre, descripcion, precio, stock, imagen_nombre, creado, estado from productos where id = ?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, idProducto);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                p = new Producto();
                p.setId(rs.getLong(1));
                p.setCategorias_id(rs.getInt(2));
                p.setNombre(rs.getString(3));
                p.setDescripcion(rs.getString(4));
                p.setPrecio(rs.getDouble(5));
                p.setStock(rs.getInt(6));
                p.setImagen_nombre(rs.getString(7));
                p.setCreado(rs.getTimestamp(8).toLocalDateTime());
                p.setEstado(rs.getInt(9));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return p;
    }
   
   public List<Categoria> listarCategoria(){
        List<Categoria> lis = new ArrayList<>();
        Connection cn = MySQLConexion.getConexion();
        System.out.println("Listar Categorias!");
        try{
            String sql = "select id, nombre, orden from categorias";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Categoria c = new Categoria();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setOrden(rs.getInt(3));
                lis.add(c);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return lis;
    }
   
   public Categoria obtenerCategoriaPorId(int idCategoria){
        Categoria c = null;
        Connection cn = MySQLConexion.getConexion();
        System.out.println("obtenerCategoriaPorId");
        try{
            String sql = "select id, nombre, orden from categorias where id = ?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, idCategoria);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                c = new Categoria();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setOrden(rs.getInt(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return c;
    }
   
   public Categoria obtenerCategoriaPorNombre(String nombreCategoria){
        Categoria c = null;
        Connection cn = MySQLConexion.getConexion();
        System.out.println("obtenerCategoriaPorId");
        try{
            String sql = "select id, nombre, orden from categorias where nombre = ?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, nombreCategoria);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                c = new Categoria();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setOrden(rs.getInt(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return c;
    }
}
