/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logsystem;
import java.util.ArrayList;

/**
 *
 * @author celso-z
 */
public class Pedido {
    private static Integer numPedidos;
    private Integer idPedido;
    private Unidade unidadeOrig;
    private Unidade UnidadeDest;
    private String cpfDestinatario;
    private String nomeDestinatario;
    private ArrayList<Item> itensPedido;
    private Float frete;

    public Pedido(Unidade unidadeOrig, Unidade UnidadeDest, String cpfDestinatario, String nomeDestinatario) {
        this.unidadeOrig = unidadeOrig;
        this.UnidadeDest = UnidadeDest;
        this.cpfDestinatario = cpfDestinatario;
        this.nomeDestinatario = nomeDestinatario;
        
        this.idPedido = numPedidos;
        numPedidos++;
    }

    public void adicionaPedido(Item item){
        itensPedido.add(item);
        //TODO: this.frete += item.getFrete();
    }
    

    public Unidade getUnidadeOrig() {
        return unidadeOrig;
    }

    public void setUnidadeOrig(Unidade unidadeOrig) {
        this.unidadeOrig = unidadeOrig;
    }

    public Unidade getUnidadeDest() {
        return UnidadeDest;
    }

    public void setUnidadeDest(Unidade UnidadeDest) {
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

    public Item getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(Item itensPedido) {
        this.itensPedido = itensPedido;
    }

    public Float getFrete() {
        return frete;
    }

    public void setFrete(Float frete) {
        this.frete = frete;
    }
    
}
