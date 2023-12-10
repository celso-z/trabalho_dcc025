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
import java.util.List;
import javax.swing.JOptionPane;
import model.Funcionario;

public class ControladorAdministrador {
    public static void cadastrar(Integer unidade, String nome, String usuario, String senha, String telefone) {
        List<Funcionario> funcionarios = LogSystem.getFuncionarios();
        Funcionario funcionario;
        funcionario = new Funcionario(unidade, nome, usuario, senha); //TODO: Administrador informa unidade
        funcionarios.add(funcionario);
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
    }
}
