/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author dhayana
 */
public class HomeUsuario extends Janela {

    String[] opt = {"opt1", "opt2", "opt3", "opt4", "opt5"};

    JLabel label_meus_pedidos;
    JList text_meus_pedidos;

    JLabel label_unidade_origem;
    JTextField text_unidade_origem;

    JLabel label_unidade_destino;
    JTextField text_unidade_destino;

    JLabel label_nome_destinatario;
    JTextField text_nome_destinatario;

    JLabel label_cpf_destinatario;
    JTextField text_cpf_destinatario;

    JButton botao_realizar_pedido;
    JButton botao_adicionar_credito;

    public HomeUsuario() {
        super("Home");
        
        JPanel painel1 = gridBagLayoutConfig();
        JPanel painel2 = gridBagLayoutConfig();

        GridBagConstraints gbc = gridBagConstraintsConfig();

        label_unidade_origem = new JLabel("Unidade de origem");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel2.add(label_unidade_origem, gbc);

        text_unidade_origem = new JTextField();
        text_unidade_origem.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel2.add(text_unidade_origem, gbc);

        label_unidade_destino = new JLabel("Unidade de destino");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel2.add(label_unidade_destino, gbc);

        text_unidade_destino = new JTextField();
        text_unidade_destino.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
        text_unidade_destino.setBounds(0, 1, 100, 100);
        painel2.add(text_unidade_destino, gbc);

        label_nome_destinatario = new JLabel("Nome do destinatário");
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel2.add(label_nome_destinatario, gbc);

        text_nome_destinatario = new JTextField();
        text_nome_destinatario.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel2.add(text_nome_destinatario, gbc);

        label_cpf_destinatario = new JLabel("CPF do destinatário");
        gbc.gridx = 0;
        gbc.gridy = 3;
        painel2.add(label_cpf_destinatario, gbc);

        text_cpf_destinatario = new JTextField();
        text_cpf_destinatario.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 3;
        painel2.add(text_cpf_destinatario, gbc);

        botao_realizar_pedido = new JButton("Realizar pedido");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel2.add(botao_realizar_pedido, gbc);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        botao_adicionar_credito = new JButton("Realizar recarga");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel1.add(botao_adicionar_credito, gbc);

        label_meus_pedidos = new JLabel("Meus pedidos");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel1.add(label_meus_pedidos, gbc);

        text_meus_pedidos = new JList(opt);
        text_meus_pedidos.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel1.add(text_meus_pedidos, gbc);

        JSplitPane painel = new JSplitPane(SwingConstants.VERTICAL, painel1, painel2);
        painel.setEnabled(false); //remove a opção de "resize" do painel
        painel.setVisible(true);

        add(painel);
    }
}
