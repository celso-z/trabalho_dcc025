/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.mycompany.logsystem.Cliente;
import com.mycompany.logsystem.DataException;
import com.mycompany.logsystem.DataManager;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import view.Cadastro;
import view.HomeUsuario;

/**
 *
 * @author dhayana
 */
public class LoginController {

    public static void entrar(JFrame frame, ActionEvent event, String usuario, String senha) {

        frame.dispose(); //fecha a tela atual
        List<Cliente> clientes = new ArrayList<>();
        
//        try {
//            clientes = DataManager.getFromDisk("Cliente");
//            for (Cliente cliente : clientes) {
//                if (cliente != null && cliente.getUsername().equals(usuario) && cliente.getSenha().equals(senha)) {
//                    System.out.println("Found result: " + cliente.getUsername());
//                    System.out.println(usuario);
//                    System.out.println(senha);
//                     new HomeUsuario();
//                }
//            }
//        } catch (DataException e) {
//        }
       
        
        new Cadastro();

    }
}
