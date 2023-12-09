/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import exceptions.DataException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Funcionario;
import storage.DataManager;
import view.TelaUsuario;

/**
 *
 * @author dhayana
 */
public class ControladorAdministrador {

    public static void cadastrar(String nome, String usuario, String senha, String telefone) {
        List<Funcionario> funcionarios = new ArrayList<>();
        Funcionario funcionario;

        try {
            funcionarios = DataManager.getFromDisk("Funcionario");
        } catch (DataException e) {
            System.out.println(e.getClasseErro());
        } finally {
            if (telefone.trim().isEmpty()) {
                funcionario = new Funcionario(nome, usuario, senha);
            } else {
                funcionario = new Funcionario(nome, usuario, senha, telefone);
            }

            funcionarios.add(funcionario);

            try {
                DataManager.escreveRegistros(funcionarios);
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

            } catch (DataException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel realizar cadastro! Verifique informações ou em caso de persistencia entre em contato com a empresa pelo email logsystem@oo.ufjf.br.");
            }
        }

    }
}
