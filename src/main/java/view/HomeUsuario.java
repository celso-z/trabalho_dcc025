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

    JLabel labelMeusPedidos;
    JList textMeusPedidos;

    JLabel labelUnidadeOrigem;
    JTextField textUnidadeOrigem;

    JLabel labelUnidadeDestino;
    JTextField textUnidadeDestino;

    JLabel labelNomeDestinatario;
    JTextField textNomeDestinatario;

    JLabel labelCpfDestinatario;
    JTextField textCpfDestinatario;

    JButton botaoRealizarPedido;
    JButton botaoAdicionarCredito;

    public HomeUsuario() {
        super("Home");
        
        JPanel painel1 = gridBagLayoutConfig();
        JPanel painel2 = gridBagLayoutConfig();

        GridBagConstraints gbc = gridBagConstraintsConfig();

        labelUnidadeOrigem = new JLabel("Unidade de origem");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel2.add(labelUnidadeOrigem, gbc);

        textUnidadeOrigem = new JTextField();
        textUnidadeOrigem.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel2.add(textUnidadeOrigem, gbc);

        labelUnidadeDestino = new JLabel("Unidade de destino");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel2.add(labelUnidadeDestino, gbc);

        textUnidadeDestino = new JTextField();
        textUnidadeDestino.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
//        textUnidadeDestino.setBounds(0, 1, 100, 100);
        painel2.add(textUnidadeDestino, gbc);

        labelNomeDestinatario = new JLabel("Nome do destinatário");
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel2.add(labelNomeDestinatario, gbc);

        textNomeDestinatario = new JTextField();
        textNomeDestinatario.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel2.add(textNomeDestinatario, gbc);

        labelCpfDestinatario = new JLabel("CPF do destinatário");
        gbc.gridx = 0;
        gbc.gridy = 3;
        painel2.add(labelCpfDestinatario, gbc);

        textCpfDestinatario = new JTextField();
        textCpfDestinatario.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 3;
        painel2.add(textCpfDestinatario, gbc);

        botaoRealizarPedido = new JButton("Realizar pedido");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel2.add(botaoRealizarPedido, gbc);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        botaoAdicionarCredito = new JButton("Realizar recarga");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel1.add(botaoAdicionarCredito, gbc);

        labelMeusPedidos = new JLabel("Meus pedidos");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel1.add(labelMeusPedidos, gbc);

        textMeusPedidos = new JList(opt);
        textMeusPedidos.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel1.add(textMeusPedidos, gbc);

        JSplitPane painel = new JSplitPane(SwingConstants.VERTICAL, painel1, painel2);
        painel.setEnabled(false); //remove a opção de "resize" do painel
        painel.setVisible(true);

        add(painel);
    }
}
