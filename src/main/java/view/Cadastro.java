package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JLabel;
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
public class Cadastro extends Janela {
     JLabel label_nome;
    JTextField text_nome;
    
    JLabel label_usuario;
    JTextField text_usuario;
    
    JLabel label_telefone;
    JTextField text_telefone;

    JLabel label_senha;
    JPasswordField text_senha;

    JButton botao_cadastrar;

    public Cadastro() {

        label_nome = new JLabel("Nome");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(label_nome, gbc);
        
        text_nome = new JTextField();
        text_nome.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel.add(text_nome, gbc);
        
        label_usuario = new JLabel("Usuário");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(label_usuario, gbc);
        
        text_usuario = new JTextField();
        text_usuario.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel.add(text_usuario, gbc);
        
        label_telefone = new JLabel("Telefone");
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(label_telefone, gbc);
        
        text_telefone = new JTextField();
        text_telefone.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel.add(text_telefone, gbc);
        
        label_senha = new JLabel("Senha");
        gbc.gridx = 0;
        gbc.gridy = 3;
        painel.add(label_senha, gbc);
        
        text_senha = new JPasswordField();
        text_senha.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 3;
        painel.add(text_senha, gbc);

        botao_cadastrar = new JButton("Cadastrar");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;        
        painel.add(botao_cadastrar, gbc);

        add(painel);
    }
}
