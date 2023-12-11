/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */
package view;

import controller.ControladorCredito;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCredito extends Janela {

    private JLabel labelNomeCartao;
    private JTextField textNomeCartao;

    private JLabel labelCvv;
    private JTextField textCvv;

    private JLabel labelNumeroCartao;
    private JTextField textNumeroCartao;

    private JLabel labelData;
    private JTextField textData;

    private JLabel labelValor;
    private JTextField textValor;

    private JButton botaoFinalizar;

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

        labelData = new JLabel("Data");
        gbc.gridx = 2;
        gbc.gridy = 1;
        painel.add(labelData, gbc);

        textData = new JTextField();
        textData.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 3;
        gbc.gridy = 1;
        painel.add(textData, gbc);

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

        this.add(painel);
        this.setVisible(true);

        botaoFinalizar.addActionListener((ActionEvent event) -> {
            ControladorCredito.addCredito(this, getValorRecarga(), isPreenchidoNumeroCartao(), isPreenchidoNomeCartao(), isPreenchidoCVV(), isPreenchidoData());
        });
    }

    private Float getValorRecarga() {
        return Float.valueOf(textValor.getText());
    }

    private boolean isPreenchidoNumeroCartao() {
        boolean ret = (!textNumeroCartao.getText().equals(""));
        return ret;
    }

    private boolean isPreenchidoNomeCartao() {
        boolean ret = (!textNomeCartao.getText().equals(""));
        return ret;
    }

    private boolean isPreenchidoData() {
        boolean ret = (!textData.getText().equals(""));
        return ret;
    }

    private boolean isPreenchidoCVV() {
        boolean ret = (!textCvv.getText().equals(""));

        return ret;
    }
}
