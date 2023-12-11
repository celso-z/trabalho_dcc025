/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */
package view;

import controller.ControladorFuncionario;
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

public class TelaNovaCarga extends Janela{
    private List<Integer> pedidosSelecionados = new ArrayList<>();
    private final String[] colunasPedidos = {"ADD", "ID", "ORIGEM", "DESTINO"};
    private Object[][] dataPedidos = new Object[100][4];
    private final int numColsPedidos = 5;
    private DefaultTableModel modeloTabelaPedidos = new DefaultTableModel(colunasPedidos, numColsPedidos){
        public Class<?> getColumnClass(int column){
            switch(column){
                case 0: return Boolean.class;
                default: return Integer.class;
            }
        }
    };
    

    private Integer destinoCarga = -1;
    private JLabel labelPedidos;
    private JButton botaoConfirmaCarga;
    
    private JTable tabelaPedidos;
    

    public TelaNovaCarga() {
        super("Nova Carga");
        JPanel painel = gridBagLayoutConfig();
        GridBagConstraints gbc = gridBagConstraintsConfig();
        labelPedidos = new JLabel("Selecione um ou mais entre os pedidos disponíveis:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(labelPedidos, gbc);
        tabelaPedidos = new JTable(modeloTabelaPedidos);
        tabelaPedidos.setRowSelectionAllowed(true);
        atualizaTabelaPedidos();
        JScrollPane containerTabelaPedidos = new JScrollPane(tabelaPedidos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        containerTabelaPedidos.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(containerTabelaPedidos, gbc);
        botaoConfirmaCarga = new JButton("Confirmar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(botaoConfirmaCarga, gbc);
        this.add(painel);
        this.setVisible(true);
        
        tabelaPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tabelaPedidos.rowAtPoint(evt.getPoint());
                int col = tabelaPedidos.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    Boolean valorAtual = Boolean.valueOf(tabelaPedidos.getValueAt(row, 0).toString());
                    if(!valorAtual){
                        for(Integer id : pedidosSelecionados){
                            if(Objects.equals(id, Integer.valueOf(tabelaPedidos.getValueAt(row, 1).toString()))){
                                pedidosSelecionados.remove(id);
                                if(pedidosSelecionados.isEmpty()) destinoCarga = -1;
                                break;
                            }
                        }
                    }else{
                        if(destinoCarga == -1){
                            destinoCarga = Integer.valueOf(tabelaPedidos.getValueAt(row, 3).toString());
                        }else{
                            if(!Objects.equals(destinoCarga, Integer.valueOf(tabelaPedidos.getValueAt(row, 3).toString()))){
                                JOptionPane.showMessageDialog(null, "Todos pedidos de uma carga devem ter o mesmo destino.");
                                return;
                            }
                        }
                        pedidosSelecionados.add(Integer.valueOf(tabelaPedidos.getValueAt(row, 1).toString()));
                    }
                }
                modeloTabelaPedidos.fireTableDataChanged();
            }
        });
        
        botaoConfirmaCarga.addActionListener((ActionEvent event) -> {
            ControladorFuncionario.novaCarga(this, destinoCarga, pedidosSelecionados);
        });
    }
    private void atualizaTabelaPedidos(){
        int numPedidosDisponiveis = ControladorFuncionario.getPedidosDisponiveisSaida(dataPedidos);
        
        modeloTabelaPedidos.setDataVector(dataPedidos, colunasPedidos);
        modeloTabelaPedidos.setNumRows(numPedidosDisponiveis);
        modeloTabelaPedidos.fireTableDataChanged();
    }
}
