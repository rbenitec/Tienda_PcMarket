
package controller;

import entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.MySQLConexion;

public class loginDao {
    static Usuario validarUsuario(String username, String password) {
    Usuario p = null;
    try (Connection cn = MySQLConexion.getConexion()) {
        String sql = "SELECT id, roles_id, email, password, nombres, sexo, fecnacimiento, telefono, direccion, estado, dni, username FROM usuarios WHERE username = ? AND password = ?";
        try (PreparedStatement st = cn.prepareStatement(sql)) {
            st.setString(1, username);
            st.setString(2, password);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    p = new Usuario();
                    p.setId(rs.getString(1));
                    p.setId_rol(rs.getInt(2));
                    p.setEmail(rs.getString(3));
                    p.setPassword(rs.getString(4));
                    p.setNombres(rs.getString(5));
                    p.setSexo(rs.getString(6));
                    p.setFecnacimiento(rs.getString(7));
                    p.setTelefono(rs.getString(8));
                    p.setDireccion(rs.getString(9));
                    p.setEstado(rs.getString(10));
                    p.setDni(rs.getString(11));
                    p.setUsername(rs.getString(12));
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return p;
}
    
    
}
