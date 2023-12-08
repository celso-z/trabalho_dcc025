/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;

public class Pedido {
    private static Integer numPedidos = 0;
    private final Integer idPedido;
    private Integer idSoliciante;
    private Integer unidadeOrig;
    private Integer UnidadeDest;
    private String cpfDestinatario;
    private String nomeDestinatario;
    private ArrayList<Item> itensPedido;
    private Float frete;
    private Float pesoTotal;
    private Float precoTotal;
    
    public Pedido(Integer idSolicitante, Integer unidadeOrig, Integer UnidadeDest, String cpfDestinatario, String nomeDestinatario) {
        this.unidadeOrig = unidadeOrig;
        this.UnidadeDest = UnidadeDest;
        this.cpfDestinatario = cpfDestinatario;
        this.nomeDestinatario = nomeDestinatario;
        this.pesoTotal = 0F;
        this.precoTotal = 0F;
        this.frete = 0F;
        this.itensPedido = new ArrayList();
        this.idSoliciante = idSolicitante;
        
        this.idPedido = numPedidos;
        numPedidos++;
    }
    
    public void adicionaItem(Item item){
        if(!itensPedido.add(item)) return;
        pesoTotal += item.getPeso();
        precoTotal += item.getValor();
        this.frete += item.getFrete();
    }
    
    public void removeItem(Integer index){
        Item itemRemovido = itensPedido.get(index);
        if(!itensPedido.remove(itemRemovido)) return;
        pesoTotal -= itemRemovido.getPeso();
        precoTotal -= itemRemovido.getValor();
        frete -= itemRemovido.getFrete();
    }
    
    public Integer getUnidadeOrig() {
        return unidadeOrig;
    }

    public void setUnidadeOrig(Integer unidadeOrig) {
        this.unidadeOrig = unidadeOrig;
    }

    public Integer getUnidadeDest() {
        return UnidadeDest;
    }

    public void setUnidadeDest(Integer UnidadeDest) {
        this.UnidadeDest = UnidadeDest;
    }

    public String getCpfDestinatario() {
        return cpfDestinatario;
    }

    public void setCpfDestinatario(String cpfDestinatario) {
        this.cpfDestinatario = cpfDestinatario;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public Float getFrete() {
        return frete;
    }

    public void setFrete(Float frete) {
        this.frete = frete;
    }

    public static Integer getNumPedidos() {
        return numPedidos;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public ArrayList<Item> getItensPedido() {
        return itensPedido;
    }

    public Float getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(Float pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public Float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Float precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Integer getIdSoliciante() {
        return idSoliciante;
    }
    
    
}
