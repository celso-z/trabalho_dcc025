/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mycompany.logsystem.LogSystem;
import java.util.List;
import javax.swing.JOptionPane;
import model.Funcionario;

/**
 *
 * @author dhayana
 */
public class ControladorAdministrador {
    public static void cadastrar(String nome, String usuario, String senha, String telefone) {
        List<Funcionario> funcionarios = LogSystem.getFuncionarios();
        Funcionario funcionario;
        funcionario = new Funcionario(0, nome, usuario, senha); //TODO: Administrador informa unidade
        funcionarios.add(funcionario);
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
    }
}
