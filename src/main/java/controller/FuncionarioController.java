/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mycompany.logsystem.LogSystem;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import model.Carga;
import model.Pedido;
import model.Unidade;

/**
 *
 * @author celso-z
 */
public class FuncionarioController {
    public static void retiraPedido(Integer Id){
        if(Id == -1){
            JOptionPane.showMessageDialog(null, "Nenhum pedido Selecionado, selecione um pedido para entregar.");
        }
        List<Pedido> pedidos = LogSystem.getPedidos();
        for(Pedido pedido : pedidos){
            if(Objects.equals(pedido.getIdPedido(), Id)){
                pedido.setEntregue(true);
                break;
            }
        }
    }
    public static void desassociarCarga(Integer Id){
        List<Unidade> unidades = LogSystem.getUnidades();
        for(Unidade u : unidades){
            if(Objects.equals(u.getIdUnidade(), LogSystem.getFuncionarioAtual().getUnidade())){
                List<Carga> cargas = u.getCargas();
                for(Carga c : cargas){
                    if(Objects.equals(c.getIdCarga(), Id)){
                        c.setDisponivel(false);
                        /*List<Pedido> pedidosCarga = c.getPedidosInclusos();
                        for(Pedido p : pedidosCarga){
                            p.setDisponivel(true);
                        }
                        c.setPedidosInclusos(null);
                        ArrayList<Carga> cargasUnidade = u.getCargas();
                        cargasUnidade.remove(c);*/
                        break;
                    }
                }
            }
        }

        if(Id == -1){
            JOptionPane.showMessageDialog(null, "Nenhuma carga Selecionada, selecione uma carga para desassociar seus pedidos.");
        }
    }
    public static int getPedidosDisponiveisEntrada(Object [][]dadosTabela){
        List<Pedido> pedidos = LogSystem.getPedidos();

        int numPedidosDisponiveis = 0;
        for(int i = 0; i < pedidos.size(); i++){
            Pedido p = pedidos.get(i);
            if(p.isDisponivel() && (Objects.equals(p.getUnidadeDest(), (LogSystem.getFuncionarioAtual()).getUnidade())) && !(p.isEntregue())){
                dadosTabela[numPedidosDisponiveis][0] = p.getIdPedido();
                dadosTabela[numPedidosDisponiveis][1] = p.getNomeDestinatario();
                dadosTabela[numPedidosDisponiveis][2] = p.getPesoTotal();
                dadosTabela[numPedidosDisponiveis][3] = p.getPrecoTotal();
                dadosTabela[numPedidosDisponiveis][4] = p.getFrete();
                numPedidosDisponiveis++;
            }
        }
        return numPedidosDisponiveis;
    }
    public static int getCargasDisponiveisEntrada(Object [][]dadosTabela){
        int numCargasDisponiveis = 0;
        List<Unidade> unidades = LogSystem.getUnidades();
        for(Unidade u : unidades){
            if(Objects.equals(u.getIdUnidade(), LogSystem.getFuncionarioAtual().getUnidade())){
                List<Carga> cargas = u.getCargas();
                for(Carga c : cargas){
                    if(Objects.equals(c.getUnidadeDest(), u.getIdUnidade()) && c.isDisponivel()){
                        System.out.println(c.isDisponivel());
                        dadosTabela[numCargasDisponiveis][0] = c.getIdCarga();
                        dadosTabela[numCargasDisponiveis][1] = c.getPeso();
                        dadosTabela[numCargasDisponiveis][2] = c.getValorMercadoria();
                        dadosTabela[numCargasDisponiveis][3] = c.getValorFrete();
                        numCargasDisponiveis++;
                    }
                }
                break;
            }
        }

        return numCargasDisponiveis;
    }
}
