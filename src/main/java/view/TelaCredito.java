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
public class TelaCredito extends Janela {
    JLabel labelNomeCartao;
    JTextField textNomeCartao;

    JLabel labelCvv;
    JTextField textCvv;

    JLabel labelNumeroCartao;
    JTextField textNumeroCartao;

    JLabel labelDataCartao;
    JTextField textDataCartao;

    JLabel labelValor;
    JTextField textValor;

    JButton botaoFinalizar;

    public TelaCredito() {
        super("Credito");
        
        JPanel painel = gridBagLayoutConfig();
        GridBagConstraints gbc = gridBagConstraintsConfig();

        labelNomeCartao = new JLabel("Nome do cartão");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(labelNomeCartao, gbc);

        textNomeCartao = new JTextField();
        textNomeCartao.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel.add(textNomeCartao, gbc);

        labelCvv = new JLabel("CVV");
        gbc.gridx = 2;
        gbc.gridy = 0;
        painel.add(labelCvv, gbc);

        textCvv = new JTextField();
        textCvv.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 3;
        gbc.gridy = 0;
        painel.add(textCvv, gbc);

        labelNumeroCartao = new JLabel("Numero do cartão");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(labelNumeroCartao, gbc);

        textNumeroCartao = new JTextField();
        textNumeroCartao.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel.add(textNumeroCartao, gbc);

        labelDataCartao = new JLabel("Data");
        gbc.gridx = 2;
        gbc.gridy = 1;
        painel.add(labelDataCartao, gbc);

        textDataCartao = new JTextField();
        textDataCartao.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 3;
        gbc.gridy = 1;
        painel.add(textDataCartao, gbc);

        labelValor = new JLabel("Valor da recarga");
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(labelValor, gbc);

        textValor = new JTextField();
        textValor.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel.add(textValor, gbc);

        botaoFinalizar = new JButton("Finalizar");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(botaoFinalizar, gbc);

        add(painel);
    }
}
