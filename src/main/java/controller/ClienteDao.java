
package controller;
import entities.Cliente;
import java.util.*;
import util.MySQLConexion;
import java.sql.*;
public class ClienteDao {
   public void adicion(Cliente c){
   Connection cn=MySQLConexion.getConexion();
       System.out.println("LLego al DAO: "+ c.toString());
   try{
     String sql="insert into Cliente values(?,?,?,?,?,?,?)";  
     //prepara una instruccion sql que sera ejecutada mediante la conexion
     PreparedStatement st=cn.prepareStatement(sql);
     st.setInt(1, c.getNrodoc());
     st.setString(2, c.getTipo());
     st.setString(3, c.getNombre());
     st.setString(4, c.getApe());
     st.setString(5, c.getCorreo());
     st.setInt(6, c.getTelef());
     st.setString(7, c.getFecha());
     st.executeUpdate();
   }catch(Exception ex){
       ex.printStackTrace();
   }}
    public void modifica(Cliente c){
   Connection cn=MySQLConexion.getConexion();
   try{
     String sql="update cliente set nombres=?,apellidos=?, email=?, telefono=?, creado=? where numeroDocumento=?";  
     //prepara una instruccion sql que sera ejecutada mediante la conexion
     PreparedStatement st=cn.prepareStatement(sql);
   
     st.setString(1, c.getNombre());
     st.setString(2, c.getApe());
     st.setString(3, c.getCorreo());
     st.setInt(4, c.getTelef());
     st.setString(5, c.getFecha());
     st.setInt(6, c.getNrodoc());
     st.executeUpdate();
   }catch(Exception ex){
       ex.printStackTrace();
   }}
   //anulacion
    public void anula(int nro){
   Connection cn=MySQLConexion.getConexion();
   try{
     String sql="delete from cliente where numeroDocumento=?";  
     //prepara una instruccion sql que sera ejecutada mediante la conexion
     PreparedStatement st=cn.prepareStatement(sql);
     st.setInt(1, nro);
     st.executeUpdate();
   }catch(Exception ex){
       ex.printStackTrace();
   }
   
  
   
   }  //listado
   public List<Cliente> listado(){
    List<Cliente> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
      String slq="select numeroDocumento,tipoDocumento , nombres, apellidos, email, telefono, creado from cliente";  
        PreparedStatement st=cn.prepareStatement(slq);
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            Cliente c=new Cliente();
            c.setNrodoc(rs.getInt(1));
            c.setTipo(rs.getString(2));
            c.setNombre(rs.getString(3));
            c.setApe(rs.getString(4));
            c.setCorreo(rs.getString(5));
            c.setTelef(rs.getInt(6));
            c.setFecha(rs.getString(7));
            
            lis.add(c); //el objeto prestamo de un cliente pasar a la lista
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return lis;
       
   } 
public Cliente consulta(int nro){
    Cliente c=null;
    Connection cn=MySQLConexion.getConexion();
    try{
      String slq="select numeroDocumento, tipoDocumento ,nombres, apellidos, email,telefono, creado from cliente where numeroDocumento=?";  
        PreparedStatement st=cn.prepareStatement(slq);
        st.setInt(1, nro);
        ResultSet rs=st.executeQuery();
        if(rs.next()){//leer cada fila de la tabla
            c=new Cliente();
            c.setNrodoc(rs.getInt(1));
            c.setTipo(rs.getString(2));
            c.setNombre(rs.getString(3));
            c.setApe(rs.getString(4));
            c.setCorreo(rs.getString(5));
            c.setTelef(rs.getInt(6));
            c.setFecha(rs.getString(7));
                  }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return c;
       
   } 
}
