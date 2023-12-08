/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author dhayana
 */
public class Adm extends Janela {
    JLabel labelNomeFuncionario;
    JTextField textNomeFuncionario;

    JLabel labelUsuarioFuncionario;
    JTextField textUsuarioFuncionario;

    JLabel labelTelefoneFuncionario;
    JTextField textTelefoneFuncionario;

    JLabel labelSenhaFuncionario;
    JPasswordField textSenhaFuncionario;

    JButton botaoCadastrarFuncionario;

    public Adm() {
        super("Administrador");

        JPanel painel = gridBagLayoutConfig();
        GridBagConstraints gbc = gridBagConstraintsConfig();

        labelNomeFuncionario = new JLabel("Nome do funcionário");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(labelNomeFuncionario, gbc);

        textNomeFuncionario = new JTextField();
        textNomeFuncionario.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel.add(textNomeFuncionario, gbc);

        labelUsuarioFuncionario = new JLabel("Usuário do funcionário");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(labelUsuarioFuncionario, gbc);

        textUsuarioFuncionario = new JTextField();
        textUsuarioFuncionario.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel.add(textUsuarioFuncionario, gbc);

        labelTelefoneFuncionario = new JLabel("Telefone do funcionário");
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(labelTelefoneFuncionario, gbc);

        textTelefoneFuncionario = new JTextField();
        textTelefoneFuncionario.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel.add(textTelefoneFuncionario, gbc);

        labelSenhaFuncionario = new JLabel("Senha do funcionário");
        gbc.gridx = 0;
        gbc.gridy = 3;
        painel.add(labelSenhaFuncionario, gbc);

        textSenhaFuncionario = new JPasswordField();
        textSenhaFuncionario.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 3;
        painel.add(textSenhaFuncionario, gbc);

        botaoCadastrarFuncionario = new JButton("Cadastrar funcionário");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(botaoCadastrarFuncionario, gbc);

        add(painel);
    }
}
