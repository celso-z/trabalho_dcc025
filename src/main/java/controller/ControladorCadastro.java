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
import view.TelaUsuario;

/**
 *
 * @author dhayana
 */
public class ControladorCadastro {

    public static void cadastrar(JFrame frame, ActionEvent event, String nome, String usuario, String senha, String telefone) {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente;

        try {
            clientes = DataManager.getFromDisk("Cliente");
        } catch (DataException e) {
            System.out.println(e.getClasseErro());
        } finally {
            if (telefone.trim().isEmpty()) {
                cliente = new Cliente(nome, usuario, senha);
            } else {
                cliente = new Cliente(nome, usuario, senha, telefone);
            }

            clientes.add(cliente);

            try {
                DataManager.escreveRegistros(clientes);
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso! Iremos te direcionar para a tela inicial.");

                frame.dispose();
                new TelaUsuario();
            } catch (DataException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel realizar cadastro! Verifique informações ou em caso de persistencia entre em contato com a empresa pelo email logsystem@oo.ufjf.br.");
            }
        }

    }
}
