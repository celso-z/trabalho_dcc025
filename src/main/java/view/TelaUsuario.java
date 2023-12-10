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

/**
 *
 * @author dhayana
 */
public class TelaUsuario extends Janela {

    private final String[] colunas = {"ID PEDIDO", "QUANTIDADE ITENS","SITUAÇÂO"};
    private final int numCols = 0;
    private Object data[][] = new Object[50][3];
    private DefaultTableModel modeloTabela = new DefaultTableModel(colunas, numCols) ;

    JLabel labelMeusPedidos;
    JTable textMeusPedidos;

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
        
        JScrollPane container_meus_itens = new JScrollPane(textMeusPedidos);
        container_meus_itens.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        painel1.add(container_meus_itens, gbc);

        JSplitPane painel = new JSplitPane(SwingConstants.VERTICAL, painel1, painel2);
        painel.setEnabled(false); //remove a opção de "resize" do painel
        painel.setVisible(true);

        botaoAdicionarCredito.addActionListener((ActionEvent e) -> {
            ControladorUsuario.adicionarCredito(TelaUsuario.this);
        });

        botaoRealizarPedido.addActionListener((ActionEvent e) -> {
            ControladorUsuario.realizarPedido(TelaUsuario.this, getTextUnidadeOrigem(),getTextUnidadeDestino(),getTextNomeDestinatario(), getTextCpfDestinatario());
        });
       
       this.add(painel);
    this.setVisible(true);
        
        atualizaTabela();
    }

    public void atualizaTabela() {
        List<Pedido> pedidos  = LogSystem.getPedidos();        
        List<Pedido> pedidosUsuario = new ArrayList<>();


        for (Pedido pedido : pedidos) {
            if(pedido.getIdSoliciante() == LogSystem.getClienteAtual().getMatricula()){
                pedidosUsuario.add(pedido);
            }
        }
  
        for (int i = 0; i < pedidosUsuario.size(); i++) {
            Pedido pedido = pedidosUsuario.get(i);
            data[i][0] = pedido.getIdPedido();            
            data[i][1] = pedido.getItensPedido().size();
            data[i][2] = pedido.isEntregue();
        }
        modeloTabela.setDataVector(data, colunas);
        modeloTabela.setNumRows(pedidosUsuario.size());
        modeloTabela.fireTableDataChanged();
    }

    public Integer getTextUnidadeOrigem() {
        return Integer.valueOf(textUnidadeOrigem.getText());
    }

    public Integer getTextUnidadeDestino() {
        return Integer.valueOf(textUnidadeDestino.getText());
    }

    public String getTextNomeDestinatario() {
        return textNomeDestinatario.getText();
    }

    public String getTextCpfDestinatario() {
        return textCpfDestinatario.getText();
    }
    
    
}
