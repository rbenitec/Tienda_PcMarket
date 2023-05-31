package controller;

import entities.Categoria;
import java.util.*;
import util.MySQLConexion;
import java.sql.*;

public class CategoriaDAO {
    
    public List<Categoria> listado(){
        List<Categoria> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try {
            String sql="select id, nombre, orden from categorias";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Categoria c=new Categoria();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setOrden(rs.getInt(3));
                lis.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lis;
    }
    
    public void adicion(Categoria p){
        Connection cn=MySQLConexion.getConexion();
        try {
            String sql="insert into categorias values(null,?,?)";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setString(1, p.getNombre());
            st.setInt(2, p.getOrden());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public Categoria consulta(int nro){
        Categoria p=null;
        Connection cn=MySQLConexion.getConexion();
        try {
            String sql="select id,nombre,orden from categorias where id=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, nro);
            ResultSet rs=st.executeQuery();
            if(rs.next()){
                p=new Categoria();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setOrden(rs.getInt(3));
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return p;
    }
    
    
    public void modifica(Categoria p){
        Connection cn=MySQLConexion.getConexion();
        try {
            String sql="update categorias set nombre=?,orden=? where id=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setString(1, p.getNombre());
            st.setInt(2, p.getOrden());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    public void anula(int nro){
        Connection cn=MySQLConexion.getConexion();
        try {
            String sql="delete from categorias where id=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, nro);
            st.executeUpdate();
                    
        } catch (Exception e) {
        }
    }
    
}
