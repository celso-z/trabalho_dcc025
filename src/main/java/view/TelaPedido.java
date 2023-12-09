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
public class TelaPedido extends Janela {

    String[] itens = {"item1", "item2", "item3", "item4", "item5"};

    JLabel labelMeusItens;
    JList textMeusItens;

    JLabel labelNomeItem;
    JTextField textNomeItem;

    JLabel labelValorItem;
    JTextField textValorItem;

    JLabel labelPesoItem;
    JTextField textPesoItem;

    JButton botaoAdicionarItem;
    JButton botaoFinalizar;

    public TelaPedido(String textUnidadeOrigem, String textUnidadeDestino, String textNomeDestinatario, String textCpfDestinatario) {
        super("Pedido");

        JPanel painel1 = gridBagLayoutConfig();
        JPanel painel2 = gridBagLayoutConfig();

        GridBagConstraints gbc = gridBagConstraintsConfig();

        labelNomeItem = new JLabel("Nome do item");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel2.add(labelNomeItem, gbc);

        textNomeItem = new JTextField();
        textNomeItem.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel2.add(textNomeItem, gbc);

        labelValorItem = new JLabel("Valor do item");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel2.add(labelValorItem, gbc);

        textValorItem = new JTextField();
        textValorItem.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel2.add(textValorItem, gbc);

        labelPesoItem = new JLabel("Peso do item");
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel2.add(labelPesoItem, gbc);

        textPesoItem = new JTextField();
        textPesoItem.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel2.add(textPesoItem, gbc);

        botaoAdicionarItem = new JButton("Adicionar item");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel2.add(botaoAdicionarItem, gbc);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        labelMeusItens = new JLabel("Meus itens");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel1.add(labelMeusItens, gbc);

        textMeusItens = new JList(itens);
        textMeusItens.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel1.add(textMeusItens, gbc);

        botaoFinalizar = new JButton("Finalizar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel1.add(botaoFinalizar, gbc);

        JSplitPane painel = new JSplitPane(SwingConstants.VERTICAL, painel1, painel2);
        painel.setEnabled(false); //remove a opção de "resize" do painel
        painel.setVisible(true);

        add(painel);
    }
}
