/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ControladorAdministrador;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaAdministrador extends Janela {

    private JLabel labelUnidade;
    private JTextField textUnidade;
    
    private JLabel labelNomeFuncionario;
    private JTextField textNomeFuncionario;

    private JLabel labelUsuarioFuncionario;
    private JTextField textUsuarioFuncionario;

    private JLabel labelTelefoneFuncionario;
    private JTextField textTelefoneFuncionario;

    private JLabel labelSenhaFuncionario;
    private JPasswordField textSenhaFuncionario;

    private JButton botaoCadastrarFuncionario;

    public TelaAdministrador() {
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
        
        labelUnidade = new JLabel("Unidade");
        gbc.gridx = 0;
        gbc.gridy = 4;
        painel.add(labelUnidade, gbc);
        
        textUnidade = new JTextField();
        textUnidade.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 4;
        painel.add(textUnidade, gbc);

        botaoCadastrarFuncionario = new JButton("Cadastrar funcionário");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(botaoCadastrarFuncionario, gbc);

        botaoCadastrarFuncionario.addActionListener((ActionEvent event) -> {

            ControladorAdministrador.cadastrar(getTextUnidade(), getTextNome(), getTextUsuario(), getTextSenha(), getTextTelefone());

        });
        
        this.add(painel);
        this.setVisible(true);
    }

    private Integer getTextUnidade() {
        return Integer.valueOf(textUnidade.getText());
    }
    
    private String getTextNome() {
        return textNomeFuncionario.getText();
    }

    private String getTextUsuario() {
        return textUsuarioFuncionario.getText();
    }

    private String getTextTelefone() {
        return textTelefoneFuncionario.getText();
    }

    private String getTextSenha() {
        return new String(textSenhaFuncionario.getPassword());
    }
}
