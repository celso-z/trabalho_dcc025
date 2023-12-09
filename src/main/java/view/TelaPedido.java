/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.mycompany.logsystem.LogSystem;
import controller.PedidoController;
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

/**
 *
 * @author dhayana
 */
public class TelaPedido extends Janela {
    private final String[] colunas = {"ID", "NOME", "PESO", "VALOR", "FRETE"};
    private Object data[][] = new Object[100][5];
    private final int numCols = 0;
    private DefaultTableModel modeloTabela = new DefaultTableModel(colunas, numCols) ;
    //modeloTabela.setColumnIdentifiers(colunas);
    //modeloTabela.setColumnIdentifiers(colunas);

    JLabel label_meus_itens;
    JTable text_meus_itens;

    JLabel label_nome_item;
    JTextField text_nome_item;

    JLabel label_valor_item;
    JTextField text_valor_item;

    JLabel label_peso_item;
    JTextField text_peso_item;

    JButton botao_adicionar_item;
    JButton botao_finalizar;

    public TelaPedido(Integer unidadeOrigem, Integer unidadeDestino, String cpfDestinatario, String nomeDestinatario) {  
        super("Pedido");
        Pedido possivelPedido = new Pedido((LogSystem.getClienteAtual()).getMatricula() ,unidadeOrigem, unidadeDestino, cpfDestinatario, nomeDestinatario);
        
        JPanel painel1 = gridBagLayoutConfig();
        JPanel painel2 = gridBagLayoutConfig();

        GridBagConstraints gbc = gridBagConstraintsConfig();

        label_nome_item = new JLabel("Nome do item");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel2.add(label_nome_item, gbc);

        text_nome_item = new JTextField();
        text_nome_item.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel2.add(text_nome_item, gbc);

        label_valor_item = new JLabel("Valor do item");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel2.add(label_valor_item, gbc);

        text_valor_item = new JTextField();
        text_valor_item.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel2.add(text_valor_item, gbc);

        label_peso_item = new JLabel("Peso do item");
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel2.add(label_peso_item, gbc);

        text_peso_item = new JTextField();
        text_peso_item.setPreferredSize(new Dimension(INPUT_SMALL_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel2.add(text_peso_item, gbc);

        botao_adicionar_item = new JButton("Adicionar item");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel2.add(botao_adicionar_item, gbc);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        label_meus_itens = new JLabel("Meus itens");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel1.add(label_meus_itens, gbc);

        text_meus_itens = new JTable(modeloTabela);
        text_meus_itens.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        gbc.gridx = 0;
        gbc.gridy = 1;
        JScrollPane container_meus_itens = new JScrollPane(text_meus_itens);
        container_meus_itens.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
        painel1.add(container_meus_itens, gbc);
        
        botao_finalizar = new JButton("Finalizar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel1.add(botao_finalizar, gbc);

        JSplitPane painel = new JSplitPane(SwingConstants.VERTICAL, painel1, painel2);
        painel.setEnabled( false ); //remove a opção de "resize" do painel
        painel.setVisible(true);

        this.add(painel);
        this.setVisible(true);
        
        botao_adicionar_item.addActionListener((ActionEvent event) -> {
            PedidoController.addItem(possivelPedido, getNomeItem(), getValorItem(), getPesoItem());
            atualizaTabela(possivelPedido.getItensPedido());

        });
              
        botao_finalizar.addActionListener((ActionEvent event) -> {
            if(possivelPedido.getItensPedido().size() > 0){
                PedidoController.registraPedido(this, possivelPedido);
            }

        });
        
    }
     public String getNomeItem() {
        return text_nome_item.getText();
    }
     
    public Float getValorItem() {
        return Float.valueOf(text_valor_item.getText());
    }
    
    public Float getPesoItem() {
        return Float.valueOf(text_peso_item.getText());
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
