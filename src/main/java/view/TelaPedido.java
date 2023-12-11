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
import controller.ControladorPedido;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import model.Item;
import model.Pedido;

public class TelaPedido extends Janela {

    private final String[] colunas = {"ID", "NOME", "PESO", "VALOR", "FRETE"};
    private Object data[][] = new Object[100][5];
    private final int numCols = 0;
    private DefaultTableModel modeloTabela = new DefaultTableModel(colunas, numCols) ;

    JLabel labelMeusItens;
    JTable textMeusItens;

    JLabel labelNomeItem;
    JTextField textNomeItem;

    JLabel labelValorItem;
    JTextField textValorItem;

    JLabel labelPesoItem;
    JTextField textPesoItem;

    JButton botaoAdicionarItem;
    JButton botaoFinalizar;

    public TelaPedido(Integer unidadeOrigem, Integer unidadeDestino, String cpfDestinatario, String nomeDestinatario) {  
        super("Pedido");
        Pedido possivelPedido = new Pedido((LogSystem.getClienteAtual()).getMatricula() ,unidadeOrigem, unidadeDestino, cpfDestinatario, nomeDestinatario);
        

        JPanel painel1 = gridBagLayoutConfig();
        JPanel painel2 = gridBagLayoutConfig();

        GridBagConstraints gbc = gridBagConstraintsConfig();

        labelNomeItem = new JLabel("Nome do item");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel2.add(labelNomeItem, gbc);

        textNomeItem = new JTextField();
        textNomeItem.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel2.add(textNomeItem, gbc);

        labelValorItem = new JLabel("Valor do item");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel2.add(labelValorItem, gbc);

        textValorItem = new JTextField();
        textValorItem.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel2.add(textValorItem, gbc);

        labelPesoItem = new JLabel("Peso do item");
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel2.add(labelPesoItem, gbc);

        textPesoItem = new JTextField();
        textPesoItem.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel2.add(textPesoItem, gbc);

        botaoAdicionarItem = new JButton("Adicionar item");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel2.add(botaoAdicionarItem, gbc);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        labelMeusItens = new JLabel("Meus itens");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel1.add(labelMeusItens, gbc);

        textMeusItens = new JTable(modeloTabela);
        textMeusItens.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        gbc.gridx = 0;
        gbc.gridy = 1;

        JScrollPane container_meus_itens = new JScrollPane(textMeusItens);
        container_meus_itens.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        painel1.add(container_meus_itens, gbc);
        
        botaoFinalizar = new JButton("Finalizar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel1.add(botaoFinalizar, gbc);

        JSplitPane painel = new JSplitPane(SwingConstants.VERTICAL, painel1, painel2);
        painel.setEnabled(false); //remove a opção de "resize" do painel
        painel.setVisible(true);

        this.add(painel);
        this.setVisible(true);
        
        botaoAdicionarItem.addActionListener((ActionEvent event) -> {
            ControladorPedido.addItem(possivelPedido, getNomeItem(), getValorItem(), getPesoItem());
            atualizaTabela(possivelPedido.getItensPedido());

        });
              
        botaoFinalizar.addActionListener((ActionEvent event) -> {
            if(possivelPedido.getItensPedido().size() > 0){
                ControladorPedido.registraPedido(this, possivelPedido);
            }

        });
        
    }
     public String getNomeItem() {
        return textNomeItem.getText();
    }
     
    public Float getValorItem() {
        return Float.valueOf(textValorItem.getText());
    }
    
    public Float getPesoItem() {
        return Float.valueOf(textPesoItem.getText());
    }
    
    public void atualizaTabela(ArrayList<Item> itens){

        for(int i = 0; i < itens.size(); i++){
            Item item = itens.get(i);
            data[i][0] = item.getIdItem();
            data[i][1] = item.getNome();
            data[i][2] = item.getPeso();
            data[i][3] = item.getValor();
            data[i][4] = item.getFrete();
        }
        modeloTabela.setDataVector(data, colunas);
        modeloTabela.setNumRows(itens.size());
        modeloTabela.fireTableDataChanged();
    }
    
    
}
