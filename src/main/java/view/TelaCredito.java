/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.CreditoController;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCredito extends Janela {

    private final JLabel label_nome_cartao;
    private final JTextField text_nome_cartao;

    private final JLabel label_cvv;
    private final JTextField text_cvv;

    private final JLabel label_numero_cartao;
    private final JTextField text_numero_cartao;

    private final JLabel label_data;
    private final JTextField text_data;

    private final JLabel label_valor;
    private final JTextField text_valor;

    private final JButton botao_finalizar;

    public TelaCredito() {
        super("Credito");

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

        this.add(painel);
        this.setVisible(true);

        botao_finalizar.addActionListener((ActionEvent event) -> {
            CreditoController.addCredito(this, getValorRecarga(), isPreenchidoNumeroCartao(), isPreenchidoNomeCartao(), isPreenchidoCVV(), isPreenchidoData());
        });
    }

    public Float getValorRecarga() {
        return Float.valueOf(text_valor.getText());
    }

    public boolean isPreenchidoNumeroCartao() {
        boolean ret = (!text_numero_cartao.getText().equals(""));
        return ret;
    }

    public boolean isPreenchidoNomeCartao() {
        boolean ret = (!text_nome_cartao.getText().equals(""));
        return ret;
    }

    public boolean isPreenchidoData() {
        boolean ret = (!text_data.getText().equals(""));
        return ret;
    }

    public boolean isPreenchidoCVV() {
        boolean ret = (!text_cvv.getText().equals(""));
        return ret;
    }
}
