/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import entities.Cliente;

/**
 *
 * @author arcan
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ClienteDao c =  new ClienteDao();
        
        Cliente c1 =  new Cliente();
        c1.setNrodoc(60977856);
        c1.setTipo("dni");
        c1.setNombre("xiomara");
        c1.setApe("espinoza");
        c1.setCorreo("xio@gmail.com");
        c1.setTelef(978549250);
        c1.setFecha("2023/05/25");
        c.adicion(c1);
        
        Cliente c2 =  new Cliente();
        c2.setNrodoc(78945612);
        c2.setTipo("dni");
        c2.setNombre("roberto");
        c2.setApe("junior");
        c2.setCorreo("rob@gmail.com");
        c2.setTelef(987654321);
        c2.setFecha("2023/05/20 ");
        c.adicion(c2);
        
        
        Cliente c3 =  new Cliente();
        c3.setNrodoc(87451263);
        c3.setTipo("dni");
        c3.setNombre("carlos");
        c3.setApe("dsds");
        c3.setCorreo("carlos@gmail.com");
        c3.setTelef(963852741);
        c3.setFecha("2023/05/22");
        c.adicion(c3);
        
        
        
        List<Cliente> clientes = new ArrayList<>();
        for(Cliente x : clientes){
            System.out.println(x.toString());
        }
    }
    
}
