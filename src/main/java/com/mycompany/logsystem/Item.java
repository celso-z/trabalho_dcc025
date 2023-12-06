/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logsystem;


public class Item {
    static private Integer numItens = 0;
    private final Integer idItem; 
    private String nome;
    private Float valor;
    private Float peso;
    private Integer quantidade;
    private Float frete;
    
    

    public Item(String nome, Float valor, Float peso, Integer quantidade){ 
        idItem = numItens;
        numItens++;
        this.quantidade = quantidade;
        this.nome = nome;
        this.valor = valor;
        this.peso = peso;
        calculaFrete();
    }
    
    private Float calculaFrete(){
        Float multiplicadorValorAlto = 1 + (this.valor / 100);
        Float custoTransporte = (this.peso * 1.2F) * this.quantidade;
        return (custoTransporte * multiplicadorValorAlto);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public static Integer getNumItens() {
        return numItens;
    }

    public Integer getIdItem() {
        return idItem;
    }
    
    public Integer getQuantidade(){
        return quantidade;
    }
    
    public void setQuantidade(Integer quantidade){
        this.quantidade = quantidade;
    }

}
