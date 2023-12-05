/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dhayana
 */
public class HomeUsuario extends Janela {
    String[] opt = {"opt1", "opt2", "opt3", "opt4", "opt5"};

    JLabel label_meus_pedidos;
    JList text_meus_pedidos;

    JLabel label_unidade_origem;
    JComboBox text_unidade_origem;

    JLabel label_unidade_destino;
    JComboBox text_unidade_destino;

    JLabel label_nome_destinatario;
    JTextField text_nome_destinatario;

    JLabel label_cpf_destinatario;
    JTextField text_cpf_destinatario;

    JButton botao_realizar_pedido;
    JButton botao_adicionar_credito;

    public HomeUsuario() {
        JPanel painel = gridBagLayoutConfig();
        GridBagConstraints gbc = gridBagConstraintsConfig();
        
        botao_adicionar_credito = new JButton("Realizar recarga");
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel.add(botao_adicionar_credito, gbc);

        label_unidade_origem = new JLabel("Unidade de origem");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(label_unidade_origem, gbc);

        text_unidade_origem = new JComboBox(opt);
        text_unidade_origem.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel.add(text_unidade_origem, gbc);

        label_unidade_destino = new JLabel("Unidade de destino");
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(label_unidade_destino, gbc);

        text_unidade_destino = new JComboBox(opt);
        text_unidade_destino.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel.add(text_unidade_destino, gbc);

        label_nome_destinatario = new JLabel("Nome do destinatário");
        gbc.gridx = 0;
        gbc.gridy = 3;
        painel.add(label_nome_destinatario, gbc);

        text_nome_destinatario = new JTextField();
        text_nome_destinatario.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 3;
        painel.add(text_nome_destinatario, gbc);

        label_cpf_destinatario = new JLabel("CPF do destinatário");
        gbc.gridx = 0;
        gbc.gridy = 4;
        painel.add(label_cpf_destinatario, gbc);

        text_cpf_destinatario = new JTextField();
        text_cpf_destinatario.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 4;
        painel.add(text_cpf_destinatario, gbc);

        botao_realizar_pedido = new JButton("Realizar pedido");
        gbc.gridx = 1;
        gbc.gridy = 5;
        painel.add(botao_realizar_pedido, gbc);

        label_meus_pedidos = new JLabel("Meus pedidos");
        gbc.gridx = 1;
        gbc.gridy = 6;
        painel.add(label_meus_pedidos, gbc);

        text_meus_pedidos = new JList(opt);
        text_meus_pedidos.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(text_meus_pedidos, gbc);

        add(painel);
    }
}
