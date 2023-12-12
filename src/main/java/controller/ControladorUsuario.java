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
import model.Pedido;
import view.TelaCredito;
import view.TelaPedido;

public class ControladorUsuario {

    public static void adicionarCredito(JFrame frame) {
        frame.dispose();
        new TelaCredito();
    }

    public static void realizarPedido(JFrame frame, Integer textUnidadeOrigem, Integer textUnidadeDestino, String textNomeDestinatario, String textCpfDestinatario) {
        frame.dispose();
        new TelaPedido(textUnidadeOrigem, textUnidadeDestino, textCpfDestinatario, textNomeDestinatario);
    }

    public static int getPedidosUsuario(Object[][] data) {
        List<Pedido> pedidos = LogSystem.getPedidos();
        List<Pedido> pedidosUsuario = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            if (pedido.getIdSoliciante() == LogSystem.getClienteAtual().getMatricula()) {
                pedidosUsuario.add(pedido);
            }
        }

        for (int i = 0; i < pedidosUsuario.size(); i++) {
            Pedido pedido = pedidosUsuario.get(i);
            data[i][0] = pedido.getIdPedido();
            data[i][1] = pedido.getItensPedido().size();
            data[i][2] = pedido.isEntregue() == true ? "SIM" : "NÃO";
        }
        return pedidosUsuario.size();
    }
}
