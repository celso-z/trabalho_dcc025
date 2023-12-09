/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mycompany.logsystem.LogSystem;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Item;
import model.Pedido;
import view.HomeUsuario;

/**
 *
 * @author celso-z
 */
public class PedidoController {
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
        new HomeUsuario();
    }
    
}
