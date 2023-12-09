/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Cliente;
import exceptions.DataException;
import storage.DataManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Administrador;
import view.TelaAdministrador;

import model.Funcionario;
import storage.ArmazenamentoTemporario;
import view.TelaCadastro;
import view.TelaFuncionario;
import view.TelaUsuario;

/**
 *
 * @author dhayana
 */
public class ControladorLogin {

    public static void entrar(JFrame frame, String usuario, String senha) {
        List<Cliente> clientes = new ArrayList<>();
        List<Administrador> administradores = new ArrayList<>();
        List<Funcionario> funcionarios = new ArrayList<>();

        //Verificação de administrador
        try {
            administradores = DataManager.getFromDisk("Administrador");
        } catch (DataException e) {
            System.out.println(e.getClasseErro());
        }

        for (Administrador administrador : administradores) {
            if (administrador != null && administrador.getUsername().equals(usuario) && administrador.getSenha().equals(senha)) {
                frame.dispose(); //fecha a tela atual
                salvaDadosTemporarios(administrador.getNome(), administrador.getMatricula());
                new TelaAdministrador();
                return; 
            } else if (administrador != null && administrador.getUsername().equals(usuario)) {
                senhaIncorreta();
                return;
            }
        }

        //Verificação de funcionario
        try {
            funcionarios = DataManager.getFromDisk("Funcionario");
        } catch (DataException e) {
            System.out.println(e.getClasseErro());
        }

        for (Funcionario funcionario : funcionarios) {
            if (funcionario != null && funcionario.getUsername().equals(usuario) && funcionario.getSenha().equals(senha)) {
                frame.dispose(); //fecha a tela atual
                salvaDadosTemporarios(funcionario.getNome(), funcionario.getMatricula());
                new TelaFuncionario();
                return;
            } else if (funcionario != null && funcionario.getUsername().equals(usuario)) {
                senhaIncorreta();
                return;
            }
        }

        //Verificação de cliente
        try {
            clientes = DataManager.getFromDisk("Cliente");
        } catch (DataException e) {
            cadastro(frame);
            return;
        }

        for (Cliente cliente : clientes) {
            if (cliente != null && cliente.getUsername().equals(usuario) && cliente.getSenha().equals(senha)) {
                frame.dispose(); //fecha a tela atual
                salvaDadosTemporarios(cliente.getNome(), cliente.getMatricula());
                new TelaUsuario();
                return;
            } else if(cliente != null && cliente.getUsername().equals(usuario)) {
                senhaIncorreta();
                return;
            }
        }

        cadastro(frame);

    }

    private static void cadastro(JFrame frame) {
        JOptionPane.showMessageDialog(null, "Usuário não encontrado, você será direcionado para a tela de cadastro!");
        frame.dispose(); //fecha a tela atual
        new TelaCadastro();
    }

    private static void senhaIncorreta() {
        JOptionPane.showMessageDialog(null, "Senha incorreta! Verifique e tente novamente.");
    }
    
    private static void salvaDadosTemporarios(String nome, int matricula) {
        List<ArmazenamentoTemporario> armazenamentos = new ArrayList<>();
        ArmazenamentoTemporario armazenamento = new ArmazenamentoTemporario(nome, matricula);
        armazenamentos.add(armazenamento);
        
        try {
            DataManager.escreveRegistros(armazenamentos);
        } catch (DataException ex) {
            System.out.println("Falha ao salvar dados do usuario");
        }
    }
}
