/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Cliente;
import exceptions.DataException;
import storage.DataManager;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.Cadastro;
import view.HomeUsuario;

/**
 *
 * @author dhayana
 */
public class LoginController {

    public static void entrar(JFrame frame, ActionEvent event, String usuario, String senha) {
        List<Cliente> clientes = new ArrayList<>();

        try {
            clientes = DataManager.getFromDisk("Cliente");
        } catch (DataException e) {
            telaCadastro(frame);
            return;
        }

        for (Cliente cliente : clientes) {
            if (cliente != null && cliente.getUsername().equals(usuario) && cliente.getSenha().equals(senha)) {
                frame.dispose(); //fecha a tela atual
                new HomeUsuario();
                return;
            }
        }

        telaCadastro(frame);

    }

    public static void telaCadastro(JFrame frame) {
        JOptionPane.showMessageDialog(null, "Usuário não encontrado, você será direcionado para a tela de cadastro!");
        frame.dispose(); //fecha a tela atual
        new Cadastro();
    }
}
