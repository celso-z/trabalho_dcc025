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
public class Administrador extends Janela {
    JLabel label_nome_funcionario;
    JTextField text_nome_funcionario;

    JLabel label_usuario_funcionario;
    JTextField text_usuario_funcionario;

    JLabel label_telefone_funcionario;
    JTextField text_telefone_funcionario;

    JLabel label_senha_funcionario;
    JPasswordField text_senha_funcionario;

    JButton botao_cadastrar_funcionario;

    public Administrador() {
        super("Administrador");

        JPanel painel = gridBagLayoutConfig();
        GridBagConstraints gbc = gridBagConstraintsConfig();

        label_nome_funcionario = new JLabel("Nome do funcionário");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(label_nome_funcionario, gbc);

        text_nome_funcionario = new JTextField();
        text_nome_funcionario.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel.add(text_nome_funcionario, gbc);

        label_usuario_funcionario = new JLabel("Usuário do funcionário");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(label_usuario_funcionario, gbc);

        text_usuario_funcionario = new JTextField();
        text_usuario_funcionario.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel.add(text_usuario_funcionario, gbc);

        label_telefone_funcionario = new JLabel("Telefone do funcionário");
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(label_telefone_funcionario, gbc);

        text_telefone_funcionario = new JTextField();
        text_telefone_funcionario.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel.add(text_telefone_funcionario, gbc);

        label_senha_funcionario = new JLabel("Senha do funcionário");
        gbc.gridx = 0;
        gbc.gridy = 3;
        painel.add(label_senha_funcionario, gbc);

        text_senha_funcionario = new JPasswordField();
        text_senha_funcionario.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 3;
        painel.add(text_senha_funcionario, gbc);

        botao_cadastrar_funcionario = new JButton("Cadastrar funcionário");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(botao_cadastrar_funcionario, gbc);

        add(painel);
    }
}
