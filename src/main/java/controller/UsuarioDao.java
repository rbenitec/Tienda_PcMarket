
package controller;
import entities.Usuarios;
import java.util.*;
import util.MySQLConexion;
import java.sql.*;
public class UsuarioDao {
       public void adicion(Usuarios u){
   Connection cn=MySQLConexion.getConexion();
       System.out.println("LLego al DAO: "+ u.toString());
   try{
     String sql="INSERT INTO tienda.usuarios (id, roles_id, email, password, nombres, sexo, dni, username) VALUES(null,?, ?, ?, ?, ?, ?, ?)";
     //prepara una instruccion sql que sera ejecutada mediante la conexion
     PreparedStatement st=cn.prepareStatement(sql);
     st.setInt(1, u.getRol());
     st.setString(2, u.getEmail());
     st.setString(3, u.getPass());
     st.setString(4, u.getNombre());
     st.setString(5, u.getSexo());
//     st.setString(6, u.getNacimiento());
//     st.setString(7, u.getTelefono());
//     st.setString(8, u.getDireccion());
//     st.setString(9, u.getEstado());
     st.setString(6, u.getDni());
     st.setString(7, u.getUser());
     st.executeUpdate();
   }catch(Exception ex){
       ex.printStackTrace();
   }
       }
       public void modifica(Usuarios u){
   Connection cn=MySQLConexion.getConexion();
   try{
     String sql="update usuarios set roles_id=?, email=?, password=?,nombres=?, sexo=?, fecnacimiento=?, direccion=?, estado=?, dni=?, username=? where id=?";  
     //prepara una instruccion sql que sera ejecutada mediante la conexion
     PreparedStatement st=cn.prepareStatement(sql);
     st.setInt(1, u.getRol());
     st.setString(2, u.getEmail());
     st.setString(3, u.getPass());
     st.setString(4, u.getNombre());
     st.setString(5, u.getSexo());
     st.setString(6, u.getNacimiento());
     st.setString(7, u.getTelefono());
     st.setString(8, u.getDireccion());
     st.setString(9, u.getEstado());
     st.setString(10, u.getDni());
     st.setString(11, u.getUser());
     st.setInt(12, u.getId());
     st.executeUpdate();
   }catch(Exception ex){
       ex.printStackTrace();
   }}
      //anulacion
    public void anula(int nro){
   Connection cn=MySQLConexion.getConexion();
   try{
     String sql="delete from usuarios where id=?";  
     //prepara una instruccion sql que sera ejecutada mediante la conexion
     PreparedStatement st=cn.prepareStatement(sql);
     st.setInt(1, nro);
     st.executeUpdate();
   }catch(Exception ex){
       ex.printStackTrace();
   }}
   //listado
   public List<Usuarios> listado(){
   
       List<Usuarios> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
      String slq="select id,roles_id, email , password, nombres, sexo, fecnacimiento, telefono, direccion, estado, dni, username from usuarios";  
        PreparedStatement st=cn.prepareStatement(slq);
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            Usuarios u=new Usuarios();
            u.setId(rs.getInt(1));
            u.setRol(rs.getInt(2));
            u.setEmail(rs.getString(3));
            u.setPass(rs.getString(4));
            u.setNombre(rs.getString(5));
            u.setSexo(rs.getString(6));
            u.setNacimiento(rs.getString(7));
            u.setTelefono(rs.getString(8));
            u.setDireccion(rs.getString(9));
            u.setEstado(rs.getString(10));
            u.setDni(rs.getString(11));
            u.setUser(rs.getString(12));
            lis.add(u); //el objeto prestamo de un cliente pasar a la lista
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return lis;
       
   
    }

   public Usuarios consulta(int nro){
    Usuarios u=null;
    Connection cn=MySQLConexion.getConexion();
    try{
      String slq="select id,rol,password,nombres , sexo, fecnacimiento, telefono, direccion,  from prestamo  where nropre=?";  
        PreparedStatement st=cn.prepareStatement(slq);
        st.setInt(1, nro);
        ResultSet rs=st.executeQuery();
        if(rs.next()){//leer cada fila de la tabla
            u=new Usuarios();
            u.setId(rs.getInt(1));
            u.setRol(rs.getInt(2));
            u.setEmail(rs.getString(3));
            u.setPass(rs.getString(4));
            u.setNombre(rs.getString(5));
            u.setSexo(rs.getString(6));
            u.setNacimiento(rs.getString(7));
            u.setTelefono(rs.getString(8));
            u.setDireccion(rs.getString(9));
            u.setEstado(rs.getString(10));
            u.setDni(rs.getString(11));
            u.setUser(rs.getString(12));
                  }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return u;
       
   
    
}}
