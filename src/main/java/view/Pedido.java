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
public class Pedido extends Janela {
    String[] itens = {"item1", "item2", "item3", "item4", "item5"};

    JLabel label_meus_itens;
    JList text_meus_itens;

    JLabel label_nome_item;
    JTextField text_nome_item;

    JLabel label_valor_item;
    JTextField text_valor_item;

    JLabel label_peso_item;
    JTextField text_peso_item;

    JButton botao_adicionar_item;
    JButton botao_finalizar;

    public Pedido() {  
        super("Pedido");
        
        JPanel painel1 = gridBagLayoutConfig();
        JPanel painel2 = gridBagLayoutConfig();

        GridBagConstraints gbc = gridBagConstraintsConfig();

        label_nome_item = new JLabel("Nome do item");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel2.add(label_nome_item, gbc);

        text_nome_item = new JTextField();
        text_nome_item.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel2.add(text_nome_item, gbc);

        label_valor_item = new JLabel("Valor do item");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel2.add(label_valor_item, gbc);

        text_valor_item = new JTextField();
        text_valor_item.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel2.add(text_valor_item, gbc);

        label_peso_item = new JLabel("Peso do item");
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel2.add(label_peso_item, gbc);

        text_peso_item = new JTextField();
        text_peso_item.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel2.add(text_peso_item, gbc);

        botao_adicionar_item = new JButton("Adicionar item");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel2.add(botao_adicionar_item, gbc);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        label_meus_itens = new JLabel("Meus itens");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel1.add(label_meus_itens, gbc);

        text_meus_itens = new JList(itens);
        text_meus_itens.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel1.add(text_meus_itens, gbc);
        
        botao_finalizar = new JButton("Finalizar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel1.add(botao_finalizar, gbc);

        JSplitPane painel = new JSplitPane(SwingConstants.VERTICAL, painel1, painel2);
        painel.setEnabled( false ); //remove a opção de "resize" do painel
        painel.setVisible(true);

        add(painel);
    }
}
