
package controller;

import entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.MySQLConexion;

public class LoginDao {
    public Usuario obtenerUsuario(String username, String password) {
    Usuario p = null;
    try (Connection cn = MySQLConexion.getConexion()) {
        String sql = "SELECT email, password, nombres FROM usuarios WHERE email = ? AND password = ?";
        try (PreparedStatement st = cn.prepareStatement(sql)) {
            st.setString(1, username);
            st.setString(2, password);
            
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    p = new Usuario();
                    p.setEmail(rs.getString(1));
                    p.setPassword(rs.getString(2));
                    p.setNombres(rs.getString(3));
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return p;
}
    
    
}
