
package controller;

import entities.Usuario;

public class prueba {

    public static void main(String[] args) {
        loginDao login = new loginDao();
        String username = "jaraujo";
        String password = "tecsup";
        
        Usuario usuarioValidado = loginDao.validarUsuario(username, password);


        if (usuarioValidado != null) {
            System.out.println("El usuario y contraseña son válidos.");
  
        } else {
            System.out.println("El usuario y contraseña son invalidos válidos.");
            
        }
    }
    
}
