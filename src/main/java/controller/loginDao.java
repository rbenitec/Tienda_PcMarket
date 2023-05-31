
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
        String sql = "SELECT username, password FROM usuarios WHERE username = ? AND password = ?";
        try (PreparedStatement st = cn.prepareStatement(sql)) {
            st.setString(1, username);
            st.setString(2, password);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    p = new Usuario();
                    p.setUsername(rs.getString(1));
                    p.setPassword(rs.getString(2));
                    
                    
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return p;
}
    
    
}