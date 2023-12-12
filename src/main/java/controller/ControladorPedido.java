/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mycompany.logsystem.LogSystem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Item;
import model.Pedido;
import view.TelaUsuario;

public class ControladorPedido {
    public static boolean addItem(Pedido pedido, String nomeItem, Float valorItem, Float pesoItem){
        Item possivelItem;
        if((!"".equals(nomeItem)) && (valorItem > 0.0) && (pesoItem > 0.0)){
            possivelItem = new Item(nomeItem, valorItem, pesoItem);
            pedido.adicionaItem(possivelItem);
            return true;
        }
        return false;
    }
    
    public static void registraPedido(JFrame frame, Pedido pedido){
        List<Pedido> pedidos = LogSystem.getPedidos();
        if(pedidos == null){
            JOptionPane.showMessageDialog(null, "ERRO! PEDIDO NÃO CONCLUIDO, você será direcionado para a tela de inicial!");
        }else pedidos.add(pedido);
        frame.dispose();
        new TelaUsuario();
    }

    public static int atualizaTabela(Object data[][], ArrayList<Item> itens) {
        for(int i = 0; i < itens.size(); i++){
            Item item = itens.get(i);
            data[i][0] = item.getIdItem();
            data[i][1] = item.getNome();
            data[i][2] = item.getPeso();
            data[i][3] = item.getValor();
            data[i][4] = item.getFrete();
        }
        return itens.size();
    }
    
}
