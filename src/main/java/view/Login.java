/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author dhayana
 */
public class Login extends Janela {

    JLabel label_usuario;
    JTextField text_usuario;

    JLabel label_senha;
    JPasswordField text_senha;

    JButton botao_entrar;

    public Login() {
        super("Login");
        
        JPanel painel = gridBagLayoutConfig();
        GridBagConstraints gbc = gridBagConstraintsConfig();
       
        label_usuario = new JLabel("Usuário");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(label_usuario, gbc);

        text_usuario = new JTextField();
        text_usuario.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel.add(text_usuario, gbc);

        label_senha = new JLabel("Senha");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(label_senha, gbc);

        text_senha = new JPasswordField();
        text_senha.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel.add(text_senha, gbc);

        botao_entrar = new JButton("Entrar");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(botao_entrar, gbc);

        add(painel);
    }

}
