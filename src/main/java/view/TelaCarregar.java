/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.FuncionarioController;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author celso-z
 */
public class TelaCarregar extends Janela {
    private final String[] colunasVeiculos = {"ID", "CAPACIDADE"};
    private Object[][] dataVeiculos = new Object[100][2];
    private final int numColsVeiculos = 2;
    private DefaultTableModel modeloTabelaVeiculos = new DefaultTableModel(colunasVeiculos, numColsVeiculos);

    private JLabel labelVeiculos;
    private JButton botaoConfirmaVeiculo;
    
    private JTable tabelaVeiculos;

    public TelaCarregar(Integer idCarga) {
        super("Carregar Carga");
        JPanel painel = gridBagLayoutConfig();
        GridBagConstraints gbc = gridBagConstraintsConfig();
        labelVeiculos = new JLabel("Selecione um dos veículos Disponíveis:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(labelVeiculos, gbc);
        tabelaVeiculos = new JTable(modeloTabelaVeiculos);
        tabelaVeiculos.setRowSelectionAllowed(true);
        atualizaTabelaVeiculos();
        JScrollPane containerTabelaVeiculos = new JScrollPane(tabelaVeiculos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        containerTabelaVeiculos.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(containerTabelaVeiculos, gbc);
        botaoConfirmaVeiculo = new JButton("Confirmar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(botaoConfirmaVeiculo, gbc);
        this.add(painel);
        this.setVisible(true);
        
    }
    
    private void atualizaTabelaVeiculos(){
        int numVeiculosDisponiveis = FuncionarioController.getVeiculosDisponiveisSaida(dataVeiculos);
        
        modeloTabelaVeiculos.setDataVector(dataVeiculos, colunasVeiculos);
        modeloTabelaVeiculos.setNumRows(numVeiculosDisponiveis);
        modeloTabelaVeiculos.fireTableDataChanged();
    }
}
