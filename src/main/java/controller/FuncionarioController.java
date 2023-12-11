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
import java.util.Objects;
import javax.swing.JOptionPane;
import model.Carga;
import model.Pedido;
import model.Veiculo;

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
        if(Id == -1){
            JOptionPane.showMessageDialog(null, "Nenhuma carga Selecionada, selecione uma carga para desassociar seus pedidos.");
            return;
        }
        List<Carga> cargas = LogSystem.getCargas();
        for(Carga c : cargas){
            if (Objects.equals(c.getIdCarga(), Id)) {
                c.setDisponivel(false);
                List<Pedido> pedidosCarga = getPedidosCarga(c);
                for (Pedido p : pedidosCarga) {
                    p.setDisponivel(true);
                }
                c.setPedidosInclusos(null);
                break;
            }
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
    public static int getPedidosDisponiveisSaida(Object [][]dadosTabela){
        List<Pedido> pedidos = LogSystem.getPedidos();

        int numPedidosDisponiveis = 0;
        for(int i = 0; i < pedidos.size(); i++){
            Pedido p = pedidos.get(i);
            if(p.isDisponivel() && (Objects.equals(p.getUnidadeOrig(), (LogSystem.getFuncionarioAtual()).getUnidade())) && !(p.isEntregue() && p.isDisponivel() && Objects.equals(p.getUnidadeAtual(), (LogSystem.getFuncionarioAtual()).getUnidade()))){
                //dadosTabela[numPedidosDisponiveis][0] = false;
                dadosTabela[numPedidosDisponiveis][1] = p.getIdPedido();
                dadosTabela[numPedidosDisponiveis][2] = p.getUnidadeOrig();
                dadosTabela[numPedidosDisponiveis][3] = p.getUnidadeDest();
                numPedidosDisponiveis++;
            }
        }
        return numPedidosDisponiveis;
    }
    public static int getCargasDisponiveisEntrada(Object [][]dadosTabela){
        Integer numCargasDisponiveis = 0;
        List<Carga> cargas = LogSystem.getCargas();
        for (Carga c : cargas) {
            if (Objects.equals(c.getUnidadeDest(), LogSystem.getFuncionarioAtual().getUnidade()) && c.isDisponivel()) {
                dadosTabela[numCargasDisponiveis][0] = c.getIdCarga();
                dadosTabela[numCargasDisponiveis][1] = c.getPeso();
                dadosTabela[numCargasDisponiveis][2] = c.getValorMercadoria();
                dadosTabela[numCargasDisponiveis][3] = c.getValorFrete();
                numCargasDisponiveis++;
            }
        }
        return numCargasDisponiveis;
    }
    
    public static int getVeiculosDisponiveisEntrada(Object [][]dadosTabela){
        Integer numVeiculosDisponiveis = 0;
        List<Veiculo> veiculos = LogSystem.getVeiculos();
        for (Veiculo v : veiculos) {
            if (Objects.equals(v.getUnidadeDest(), LogSystem.getFuncionarioAtual().getUnidade()) && v.isDisponivel() && v.getCargaAtual() != -1) {
                dadosTabela[numVeiculosDisponiveis][0] = v.getIdVeiculo();
                dadosTabela[numVeiculosDisponiveis][1] = v.getCapacidadeVeiculo();
                dadosTabela[numVeiculosDisponiveis][2] = (v.getCargaAtual() != -1) ? "SIM" : "NÃO";
                numVeiculosDisponiveis++;
            }
        }
        return numVeiculosDisponiveis;
    }
    
    public static void descarregarVeiculo(Integer id){
        if(id == -1){
            JOptionPane.showMessageDialog(null, "Nenhum veículo Selecionado, selecione um veículo para descarregar.");
            return;
        }
        List<Veiculo> veiculos = LogSystem.getVeiculos();
        for(Veiculo v : veiculos){
            if(Objects.equals(v.getUnidadeDest(), LogSystem.getFuncionarioAtual().getUnidade()) && Objects.equals(v.getIdVeiculo(), id)){
                List<Carga> cargas = LogSystem.getCargas();
                for(Carga c : cargas){
                    if(Objects.equals(c.getIdCarga(), v.getCargaAtual())){
                        c.setDisponivel(true);
                        c.setUnidadeAtual(LogSystem.getFuncionarioAtual().getUnidade());
                        v.setDisponivel(true);
                        v.descarregar();
                        return;
                    }
                }
            }
        }
    }
    
    private static List<Pedido> getPedidosCarga(Carga c){
        List<Pedido> pedidos = new ArrayList<>();
        for(Integer id : c.getPedidosInclusos()){
            for(Pedido pedido : LogSystem.getPedidos()){
                if(Objects.equals(pedido.getIdPedido(), id)){
                    pedidos.add(pedido);
                    break;
                }
            }
        }
        
        return pedidos;
    } 

    public static int getCargasDisponiveisSaida(Object[][] dadosTabela) {
        Integer numCargasDisponiveis = 0;
        List<Carga> cargas = LogSystem.getCargas();
        for (Carga c : cargas) {
            if (Objects.equals(c.getUnidadeAtual(), LogSystem.getFuncionarioAtual().getUnidade()) && !Objects.equals(c.getUnidadeDest(), LogSystem.getFuncionarioAtual().getUnidade())  && c.isDisponivel()) {
                dadosTabela[numCargasDisponiveis][0] = c.getIdCarga();
                dadosTabela[numCargasDisponiveis][1] = c.getPeso();
                dadosTabela[numCargasDisponiveis][2] = c.getValorMercadoria();
                dadosTabela[numCargasDisponiveis][3] = c.getValorFrete();
                numCargasDisponiveis++;
            }
        }
        return numCargasDisponiveis;
    }
}
