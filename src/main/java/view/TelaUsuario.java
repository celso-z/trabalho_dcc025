/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.mycompany.logsystem.LogSystem;
import controller.ControladorUsuario;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import model.Pedido;

public class TelaUsuario extends Janela {

    private final String[] colunas = {"ID PEDIDO", "QUANTIDADE ITENS", "ENTREGUE"};
    private final int numCols = 0;
    private final Object data[][] = new Object[50][3];
    private final DefaultTableModel modeloTabela = new DefaultTableModel(colunas, numCols);

    private final JLabel labelMeusPedidos;
    private final JTable textMeusPedidos;

    private final JLabel labelUnidadeOrigem;
    private final JTextField textUnidadeOrigem;

    private final JLabel labelUnidadeDestino;
    private final JTextField textUnidadeDestino;

    private final JLabel labelNomeDestinatario;
    private final JTextField textNomeDestinatario;

    private final JLabel labelCpfDestinatario;
    private final JTextField textCpfDestinatario;

    private final JButton botaoRealizarPedido;
    private final JButton botaoAdicionarCredito;

    public TelaUsuario() {
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
        textUnidadeDestino.setBounds(0, 1, 100, 100);
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

        textMeusPedidos = new JTable(modeloTabela);
        textMeusPedidos.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JScrollPane containerMeusItens = new JScrollPane(textMeusPedidos);
        containerMeusItens.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        painel1.add(containerMeusItens, gbc);

        JSplitPane painel = new JSplitPane(SwingConstants.VERTICAL, painel1, painel2);
        painel.setEnabled(false); //remove a opção de "resize" do painel
        painel.setVisible(true);

        botaoAdicionarCredito.addActionListener((ActionEvent e) -> {
            ControladorUsuario.adicionarCredito(TelaUsuario.this);
        });

        botaoRealizarPedido.addActionListener((ActionEvent e) -> {
            ControladorUsuario.realizarPedido(TelaUsuario.this, getTextUnidadeOrigem(), getTextUnidadeDestino(), getTextNomeDestinatario(), getTextCpfDestinatario());
        });

        this.add(painel);
        this.setVisible(true);

        atualizaTabela();
    }

    private void atualizaTabela() {
        int numPedidosDisponiveis = ControladorUsuario.getPedidosUsuario(data);
        
        modeloTabela.setDataVector(data, colunas);
        modeloTabela.setNumRows(numPedidosDisponiveis);
        modeloTabela.fireTableDataChanged();
    }

    private Integer getTextUnidadeOrigem() {
        return Integer.valueOf(textUnidadeOrigem.getText());
    }

    private Integer getTextUnidadeDestino() {
        return Integer.valueOf(textUnidadeDestino.getText());
    }

    private String getTextNomeDestinatario() {
        return textNomeDestinatario.getText();
    }

    private String getTextCpfDestinatario() {
        return textCpfDestinatario.getText();
    }

}
