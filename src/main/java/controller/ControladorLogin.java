/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mycompany.logsystem.LogSystem;
import model.Cliente;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Administrador;
import view.TelaAdministrador;
import model.Funcionario;
import view.TelaCadastro;
import view.TelaFuncionario;
import view.TelaUsuario;

public class ControladorLogin {

    public static void entrar(JFrame frame, String usuario, String senha) {
        List<Cliente> clientes = LogSystem.getClientes();
        List<Administrador> administradores = LogSystem.getAdministradores();
        List<Funcionario> funcionarios = LogSystem.getFuncionarios();

        for (Administrador administrador : administradores) {
            if (administrador != null && administrador.getUsername().equals(usuario) && administrador.getSenha().equals(senha)) {
                frame.dispose(); //fecha a tela atual
                LogSystem.setAdministradorAtual(administrador);
                new TelaAdministrador();
                return; 
            } else if (administrador != null && administrador.getUsername().equals(usuario)) {
                senhaIncorreta();
                return;
            }
        }

      
        for (Funcionario funcionario : funcionarios) {
            if (funcionario != null && funcionario.getUsername().equals(usuario) && funcionario.getSenha().equals(senha)) {
                frame.dispose(); //fecha a tela atual
                LogSystem.setFuncionarioAtual(funcionario);
                new TelaFuncionario();
                return;
            } else if (funcionario != null && funcionario.getUsername().equals(usuario)) {
                senhaIncorreta();
                return;
            }
        }

        for (Cliente cliente : clientes) {
            if (cliente != null && cliente.getUsername().equals(usuario) && cliente.getSenha().equals(senha)) {
                frame.dispose(); //fecha a tela atual
                LogSystem.setClienteAtual(cliente);
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
}
