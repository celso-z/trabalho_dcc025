package view;

import controller.ControladorCadastro;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dhayana
 */
public class TelaCadastro extends Janela {

    JLabel labelNome;
    JTextField textNome;

    JLabel labelUsuario;
    JTextField textUsuario;

    JLabel labelTelefone;
    JTextField textTelefone;

    JLabel labelSenha;
    JPasswordField textSenha;

    JButton botaoCadastrar;

    public TelaCadastro() {
        super("Cadastro");

        JPanel painel = gridBagLayoutConfig();
        GridBagConstraints gbc = gridBagConstraintsConfig();

        labelNome = new JLabel("Nome");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(labelNome, gbc);

        textNome = new JTextField();
        textNome.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel.add(textNome, gbc);

        labelUsuario = new JLabel("Usuário");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(labelUsuario, gbc);

        textUsuario = new JTextField();
        textUsuario.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel.add(textUsuario, gbc);

        labelTelefone = new JLabel("Telefone");
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(labelTelefone, gbc);

        textTelefone = new JTextField();
        textTelefone.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel.add(textTelefone, gbc);

        labelSenha = new JLabel("Senha");
        gbc.gridx = 0;
        gbc.gridy = 3;
        painel.add(labelSenha, gbc);

        textSenha = new JPasswordField();
        textSenha.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 3;
        painel.add(textSenha, gbc);

        botaoCadastrar = new JButton("Cadastrar");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(botaoCadastrar, gbc);

        botaoCadastrar.addActionListener((ActionEvent event) -> {

            ControladorCadastro.cadastrar(this, event, getTextNome(), getTextUsuario(), getTextSenha(), getTextTelefone());

        });

        add(painel);
    }

    public String getTextNome() {
        return textNome.getText();
    }

    public String getTextUsuario() {
        return textUsuario.getText();
    }

    public String getTextTelefone() {
        return textTelefone.getText();
    }

    public String getTextSenha() {
        return new String(textSenha.getPassword());
    }

}
