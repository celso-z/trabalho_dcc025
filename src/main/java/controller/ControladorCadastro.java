/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mycompany.logsystem.LogSystem;
import model.Cliente;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.TelaLogin;

/**
 *
 * @author dhayana
 */
public class ControladorCadastro {

    public static void cadastrar(JFrame frame, ActionEvent event, String nome, String usuario, String senha, String telefone) {
        List<Cliente> clientes = LogSystem.getClientes();
        Cliente cliente;
        if (telefone.trim().isEmpty()) {
            cliente = new Cliente(nome, usuario, senha);
        } else {
            cliente = new Cliente(nome, usuario, senha, telefone);
        }
        clientes.add(cliente);
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso! Iremos te direcionar para a tela de Login.");
        frame.dispose();
        new TelaLogin();
    }
}
