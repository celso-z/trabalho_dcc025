/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ControladorFuncionario;
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
    private final String[] colunasVeiculos = {"ID", "CAPACIDADE", "CARREGADO"};
    private Object[][] dataPedidosEntrada = new Object[100][5];
    private Object[][] dataCargasEntrada = new Object[100][4];
    private Object[][] dataCargasSaida = new Object[100][4];
    private Object[][] dataVeiculosEntrada = new Object[100][3];
    private final int numColsPedidos = 5;
    private final int numColsCargas = 4;
    private final int numColsVeiculos = 3;
    private DefaultTableModel modeloTabelaPedidosEntrada = new DefaultTableModel(colunasPedidos, numColsPedidos);
    private DefaultTableModel modeloTabelaCargasEntrada = new DefaultTableModel(colunasCargas, numColsCargas);
    private DefaultTableModel modeloTabelaCargasSaida = new DefaultTableModel(colunasCargas, numColsCargas);
    private DefaultTableModel modeloTabelaVeiculosEntrada = new DefaultTableModel(colunasVeiculos, numColsVeiculos);
    private Integer idSelecionado = -1;


    private JPanel tabVeiculosEntrada = gridBagLayoutConfig();
    private JPanel tabCargasEntrada = gridBagLayoutConfig();
    private JPanel tabPedidosEntrada = gridBagLayoutConfig();

    
    private JPanel tabVeiculosSaida = gridBagLayoutConfig();
    private JPanel tabCargasSaida = gridBagLayoutConfig();
    
    private JButton botaoRetiraPedido;
    private JButton botaoDesassociar;
    private JButton botaoDescarregar;
    private JButton botaoNovaCarga;
    private JButton botaoCarregar;
    
    private JTable tabelaPedidosEntrada;
    private JTable tabelaCargasEntrada;
    private JTable tabelaCargasSaida;
    private JTable tabelaVeiculosEntrada;

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
        tabelaVeiculosEntrada = new JTable(modeloTabelaVeiculosEntrada);
        tabelaVeiculosEntrada.setRowSelectionAllowed(true);
        atualizaTabelaVeiculosEntrada();
        JScrollPane containerTabelaVeiculosEntrada = new JScrollPane(tabelaVeiculosEntrada, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        containerTabelaVeiculosEntrada.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        gbc.gridx = 0;
        gbc.gridy = 0;
        tabVeiculosEntrada.add(containerTabelaVeiculosEntrada, gbc);
        botaoDescarregar = new JButton("Descarregar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tabVeiculosEntrada.add(botaoDescarregar, gbc);
        
        tabSaida.addTab("Cargas", tabCargasSaida);
        tabelaCargasSaida = new JTable(modeloTabelaCargasSaida);
        tabelaCargasSaida.setRowSelectionAllowed(true);
        atualizaTabelaCargasSaida();
        JScrollPane containerTabelaCargasSaida = new JScrollPane(tabelaCargasSaida, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        containerTabelaCargasSaida.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        gbc.gridx = 0;
        gbc.gridy = 0;
        tabCargasSaida.add(containerTabelaCargasSaida, gbc);
        botaoNovaCarga = new JButton("Nova Carga");
        gbc.gridx = 0;
        gbc.gridy = 2;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        tabCargasSaida.add(botaoNovaCarga, gbc);
        botaoCarregar = new JButton("Carregar");
        gbc.gridx = 1;
        gbc.gridy = 2;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        tabCargasSaida.add(botaoCarregar, gbc);
        
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
        
        tabelaVeiculosEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tabelaVeiculosEntrada.rowAtPoint(evt.getPoint());
                int col = tabelaVeiculosEntrada.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    selecionaId(Integer.valueOf(tabelaVeiculosEntrada.getValueAt(row, 0).toString()));
                }
            }
        });
        
        tabelaCargasSaida.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tabelaCargasEntrada.rowAtPoint(evt.getPoint());
                int col = tabelaCargasEntrada.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    selecionaId(Integer.valueOf(tabelaVeiculosEntrada.getValueAt(row, 0).toString()));
                }
            }
        });
        
        

        botaoRetiraPedido.addActionListener((ActionEvent event) -> {
            ControladorFuncionario.retiraPedido(idSelecionado);
            atualizaTabelaPedidosEntrada();
        });
        
        botaoDesassociar.addActionListener((ActionEvent event) -> {
            ControladorFuncionario.desassociarCarga(idSelecionado);
            atualizaTabelaCargasEntrada();
            atualizaTabelaPedidosEntrada();
        });
        
        botaoDescarregar.addActionListener((ActionEvent event) -> {
            ControladorFuncionario.descarregarVeiculo(idSelecionado);
            atualizaTabelaVeiculosEntrada();
            atualizaTabelaCargasEntrada();
        });
        
        botaoNovaCarga.addActionListener((ActionEvent event) -> {
            new TelaNovaCarga();
            atualizaTabelaCargasSaida();
        });
        
        botaoNovaCarga.addActionListener((ActionEvent event) -> {
            new TelaCarregar(idSelecionado);
            atualizaTabelaCargasSaida();
        });
    }
    
    private void selecionaId(Integer id){
        idSelecionado = id;
    }
    private void atualizaTabelaPedidosEntrada(){
        int numPedidosDisponiveis = ControladorFuncionario.getPedidosDisponiveisEntrada(dataPedidosEntrada);
        
        modeloTabelaPedidosEntrada.setDataVector(dataPedidosEntrada, colunasPedidos);
        modeloTabelaPedidosEntrada.setNumRows(numPedidosDisponiveis);
        modeloTabelaPedidosEntrada.fireTableDataChanged();
    }
    private void atualizaTabelaCargasEntrada(){
        int numCargasDisponiveis = ControladorFuncionario.getCargasDisponiveisEntrada(dataCargasEntrada);
        modeloTabelaCargasEntrada.setDataVector(dataCargasEntrada, colunasCargas);
        modeloTabelaCargasEntrada.setNumRows(numCargasDisponiveis);
        modeloTabelaCargasEntrada.fireTableDataChanged();
    }
    private void atualizaTabelaVeiculosEntrada(){
        int numVeiculosDisponiveis = ControladorFuncionario.getVeiculosDisponiveisEntrada(dataVeiculosEntrada);
        modeloTabelaVeiculosEntrada.setDataVector(dataVeiculosEntrada, colunasVeiculos);
        modeloTabelaVeiculosEntrada.setNumRows(numVeiculosDisponiveis);
        modeloTabelaVeiculosEntrada.fireTableDataChanged();
    }
    private void atualizaTabelaCargasSaida(){
        int numCargasDisponiveis = ControladorFuncionario.getCargasDisponiveisSaida(dataCargasSaida);
        modeloTabelaCargasSaida.setDataVector(dataCargasSaida, colunasCargas);
        modeloTabelaCargasSaida.setNumRows(numCargasDisponiveis);
        modeloTabelaCargasSaida.fireTableDataChanged();
    }
}
