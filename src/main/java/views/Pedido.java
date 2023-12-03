/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

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
        label_nome_item = new JLabel("Nome do item");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(label_nome_item, gbc);

        text_nome_item = new JTextField();
        text_nome_item.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel.add(text_nome_item, gbc);

        label_valor_item = new JLabel("Valor do item");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(label_valor_item, gbc);

        text_valor_item = new JTextField();
        text_valor_item.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel.add(text_valor_item, gbc);

        label_peso_item = new JLabel("Peso do item");
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(label_peso_item, gbc);

        text_peso_item = new JTextField();
        text_peso_item.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel.add(text_peso_item, gbc);

        botao_adicionar_item = new JButton("Adicionar item");
        gbc.gridx = 1;
        gbc.gridy = 3;
        painel.add(botao_adicionar_item, gbc);

        label_meus_itens = new JLabel("Meus itens");
        gbc.gridx = 1;
        gbc.gridy = 4;
        painel.add(label_meus_itens, gbc);

        text_meus_itens = new JList(itens);
        text_meus_itens.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(text_meus_itens, gbc);

        botao_finalizar = new JButton("Finalizar");
        gbc.gridx = 1;
        gbc.gridy = 6;
        painel.add(botao_finalizar, gbc);

        add(painel);
    }
}
