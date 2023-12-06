/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author celso-z
 */
public class Carga {
    private Float valorMercadoria = 0F;
    private Float peso;
    final private Integer idCarga;
    private Float valorFrete = 0F; 
    private static Integer num_Cargas = 0;
    private ArrayList<Pedido> pedidosInclusos;

    public Carga() {
        idCarga = num_Cargas;
        num_Cargas++;
    }
    
    public void addPedido(Pedido p){
        if(!pedidosInclusos.add(p)) return;
        peso += p.getPesoTotal();
        valorMercadoria += p.getPrecoTotal();
        valorFrete += p.getFrete();
    }

    public Float getPeso() {
        return peso;
    }

    public Float getValorMercadoria() {
        return valorMercadoria;
    }

    public Integer getIdCarga() {
        return idCarga;
    }

    public static Integer getNum_Cargas() {
        return num_Cargas;
    }

    

    public Float getValorFrete() {
        return valorFrete;
    }

    public ArrayList<Pedido> getPedidosInclusos() {
        return pedidosInclusos;
    }

    public void setPedidosInclusos(ArrayList<Pedido> pedidosInclusos) {
        this.pedidosInclusos = pedidosInclusos;
    }
    
    
}
