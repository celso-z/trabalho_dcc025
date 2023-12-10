/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

public class Carga {
    private Float valorMercadoria = 0F;
    private Float peso = 0F;
    final private Integer idCarga;
    private Float valorFrete = 0F; 
    private static Integer numCargas = 0;
    private ArrayList<Integer> pedidosInclusos = new ArrayList<>();
    private final Integer unidadeDest;
    private final Integer unidadeAtual;
    private boolean disponivel = true;

    public Carga(Integer unidadeAtual, Integer unidadeDest) {
        idCarga = numCargas;
        numCargas++;
        this.unidadeDest = unidadeDest;
        this.unidadeAtual = unidadeAtual;
    }
    
    public void addPedido(Pedido p){
        if(!pedidosInclusos.add(p.getIdPedido())) return;
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

    public static Integer getNumCargas() {
        return numCargas;
    }

    public static void setNumCargas(Integer numCargas) {
        Carga.numCargas = numCargas;
    }   

    public Float getValorFrete() {
        return valorFrete;
    }

    public ArrayList<Integer> getPedidosInclusos() {
        return pedidosInclusos;
    }

    public Integer getUnidadeDest() {
        return unidadeDest;
    }
    
    public boolean isDisponivel(){
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Integer getUnidadeAtual() {
        return unidadeAtual;
    }
}
