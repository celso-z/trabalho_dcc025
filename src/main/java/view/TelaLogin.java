/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ControladorLogin;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends Janela {

    private final JLabel labelUsuario;
    private final JTextField textUsuario;

    private final JLabel labelSenha;
    private final JPasswordField textSenha;

    private final JButton botaoEntrar;

    public TelaLogin() {
        super("Login");

        JPanel painel = gridBagLayoutConfig();
        GridBagConstraints gbc = gridBagConstraintsConfig();

        labelUsuario = new JLabel("Usuário");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(labelUsuario, gbc);

        textUsuario = new JTextField();
        textUsuario.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel.add(textUsuario, gbc);

        labelSenha = new JLabel("Senha");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(labelSenha, gbc);

        textSenha = new JPasswordField();
        textSenha.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel.add(textSenha, gbc);

        botaoEntrar = new JButton("Entrar");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(botaoEntrar, gbc);

        this.add(painel);
        this.setVisible(true);

        botaoEntrar.addActionListener((ActionEvent e) -> {
            ControladorLogin.entrar(TelaLogin.this, getTextUsuario(), getTextSenha());
        });
    }

    public String getTextUsuario() {
        return textUsuario.getText();
    }

    public String getTextSenha() {
        return new String(textSenha.getPassword());
    }

}
