/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dhayana
 */
public class Credito extends Janela {
    JLabel label_nome_cartao;
    JTextField text_nome_cartao;

    JLabel label_cvv;
    JTextField text_cvv;

    JLabel label_numero_cartao;
    JTextField text_numero_cartao;

    JLabel label_data;
    JTextField text_data;

    JLabel label_valor;
    JTextField text_valor;

    JButton botao_finalizar;

    public Credito() {
        JPanel painel = gridBagLayoutConfig();
        GridBagConstraints gbc = gridBagConstraintsConfig();

        label_nome_cartao = new JLabel("Nome do cartão");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(label_nome_cartao, gbc);

        text_nome_cartao = new JTextField();
        text_nome_cartao.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel.add(text_nome_cartao, gbc);

        label_cvv = new JLabel("CVV");
        gbc.gridx = 2;
        gbc.gridy = 0;
        painel.add(label_cvv, gbc);

        text_cvv = new JTextField();
        text_cvv.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 3;
        gbc.gridy = 0;
        painel.add(text_cvv, gbc);

        label_numero_cartao = new JLabel("Numero do cartão");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(label_numero_cartao, gbc);

        text_numero_cartao = new JTextField();
        text_numero_cartao.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel.add(text_numero_cartao, gbc);

        label_data = new JLabel("Data");
        gbc.gridx = 2;
        gbc.gridy = 1;
        painel.add(label_data, gbc);

        text_data = new JTextField();
        text_data.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 3;
        gbc.gridy = 1;
        painel.add(text_data, gbc);

        label_valor = new JLabel("Valor da recarga");
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(label_valor, gbc);

        text_valor = new JTextField();
        text_valor.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel.add(text_valor, gbc);

        botao_finalizar = new JButton("Finalizar");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(botao_finalizar, gbc);

        add(painel);
    }
}
