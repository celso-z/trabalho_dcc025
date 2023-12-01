/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logsystem;

/**
 *
 * @author celso-z
 */
public class Item {
    private Integer numItens;
    private Integer idItem; 
    private String nome;
    private Float valor;
    private Float peso;
    private Float frete;
    
    

    public Item(String nome, Float valor, Float peso) {
        this.nome = nome;
        this.valor = valor;
        this.peso = peso;
        this.frete = calculaFrete();
    }
    
    private int calculaFrete(){
        
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

    public void setFrete(Float frete) {
        this.frete = frete;
    }
    
}
