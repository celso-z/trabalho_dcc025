/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.FuncionarioController;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TelaFuncionario extends Janela {
    private final String[] colunasPedidos = {"ID", "NOME RET.", "PESO", "VALOR", "FRETE"};
    private final String[] colunasCargas = {"ID", "PESO", "VALOR MERC.", "FRETE"};
    private Object[][] dataPedidosEntrada = new Object[100][5];
    private Object[][] dataCargasEntrada = new Object[100][5];
    private final int numColsPedidos = 5;
    private final int numColsCargas = 4;
    private DefaultTableModel modeloTabelaPedidosEntrada = new DefaultTableModel(colunasPedidos, numColsPedidos);
    private DefaultTableModel modeloTabelaCargasEntrada = new DefaultTableModel(colunasCargas, numColsCargas);
    private Integer idSelecionado = -1;


    JPanel tabVeiculosEntrada = gridBagLayoutConfig();
    JPanel tabCargasEntrada = gridBagLayoutConfig();
    JPanel tabPedidosEntrada = gridBagLayoutConfig();

    
    JPanel tabVeiculosSaida = gridBagLayoutConfig();
    JPanel tabCargasSaida = gridBagLayoutConfig();
    
    JButton botaoRetiraPedido;
    JButton botaoDesassociar;
    
    JTable tabelaPedidosEntrada;
    JTable tabelaCargasEntrada;

    public TelaFuncionario() {
        super("Funcionario");
         
        JTabbedPane painel = new JTabbedPane();
        
        GridBagConstraints gbc = gridBagConstraintsConfig();


        JTabbedPane tabEntrada = new JTabbedPane();
        JTabbedPane tabSaida = new JTabbedPane();
        
        
        
        painel.addTab("Chegada", tabEntrada);
        painel.addTab("Saída", tabSaida);

        tabEntrada.addTab("Pedidos", tabPedidosEntrada);
        tabelaPedidosEntrada = new JTable(modeloTabelaPedidosEntrada);
        tabelaPedidosEntrada.setRowSelectionAllowed(true);
        atualizaTabelaPedidosEntrada();
        JScrollPane containerTabelaItensEntrada = new JScrollPane(tabelaPedidosEntrada, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        containerTabelaItensEntrada.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        gbc.gridx = 0;
        gbc.gridy = 0;
        tabPedidosEntrada.add(containerTabelaItensEntrada, gbc);
        botaoRetiraPedido = new JButton("Retirar Pedido");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tabPedidosEntrada.add(botaoRetiraPedido, gbc);
        
        
        
        tabEntrada.addTab("Cargas", tabCargasEntrada);
        tabelaCargasEntrada = new JTable(modeloTabelaCargasEntrada);
        tabelaCargasEntrada.setRowSelectionAllowed(true);
        atualizaTabelaCargasEntrada();
        JScrollPane containerTabelaCargasEntrada = new JScrollPane(tabelaCargasEntrada, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        containerTabelaCargasEntrada.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        gbc.gridx = 0;
        gbc.gridy = 0;
        tabCargasEntrada.add(containerTabelaCargasEntrada, gbc);
        botaoDesassociar = new JButton("Desassociar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tabCargasEntrada.add(botaoDesassociar, gbc);
       
        tabEntrada.addTab("Veículos", tabVeiculosEntrada);

        
        tabSaida.addTab("Veículos", tabVeiculosSaida);
        tabSaida.addTab("Cargas", tabCargasSaida);
        
        
       
        this.add(painel);
        this.setVisible(true);

        tabelaPedidosEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tabelaPedidosEntrada.rowAtPoint(evt.getPoint());
                int col = tabelaPedidosEntrada.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    selecionaId(Integer.valueOf(tabelaPedidosEntrada.getValueAt(row, 0).toString()));
                }
            }
        });

        tabelaCargasEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tabelaCargasEntrada.rowAtPoint(evt.getPoint());
                int col = tabelaCargasEntrada.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    selecionaId(Integer.valueOf(tabelaCargasEntrada.getValueAt(row, 0).toString()));
                }
            }
        });

        botaoRetiraPedido.addActionListener((ActionEvent event) -> {
            FuncionarioController.retiraPedido(idSelecionado);
            atualizaTabelaPedidosEntrada();
        });
        
        botaoDesassociar.addActionListener((ActionEvent event) -> {
            FuncionarioController.desassociarCarga(idSelecionado);
            atualizaTabelaCargasEntrada();
            atualizaTabelaPedidosEntrada();
        });
    }
    
    public void selecionaId(Integer id){
        idSelecionado = id;
        System.out.println(id);
    }
    public void atualizaTabelaPedidosEntrada(){
        int numPedidosDisponiveis = FuncionarioController.getPedidosDisponiveisEntrada(dataPedidosEntrada);
        
        modeloTabelaPedidosEntrada.setDataVector(dataPedidosEntrada, colunasPedidos);
        modeloTabelaPedidosEntrada.setNumRows(numPedidosDisponiveis);
        modeloTabelaPedidosEntrada.fireTableDataChanged();
    }
    public void atualizaTabelaCargasEntrada(){
        int numCargasDisponiveis = FuncionarioController.getCargasDisponiveisEntrada(dataCargasEntrada);
        modeloTabelaCargasEntrada.setDataVector(dataCargasEntrada, colunasCargas);
        modeloTabelaCargasEntrada.setNumRows(numCargasDisponiveis);
        modeloTabelaCargasEntrada.fireTableDataChanged();
    }
}
