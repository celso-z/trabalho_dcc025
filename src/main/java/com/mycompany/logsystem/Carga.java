/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logsystem;

/**
 *
 * @author celso-z
 */
public class Carga {
    private Float valorMercadoria;
    private Float peso;
    final private Integer idCarga;
    private Float valorFrete; 
    private static Integer num_Cargas = 0;

    public Carga() {
        idCarga = num_Cargas;
        num_Cargas++;
    }

    public Integer getIdCarga() {
        return idCarga;
    }
    
    public Carga(Float valorMercadoria, Float peso){
        idCarga = num_Cargas;
        num_Cargas++;
        this.valorMercadoria = valorMercadoria;
        this.peso = peso;
        valorFrete = valorMercadoria / 50;
    }
    
    public void transferenciaCarga(Carga x, Carga y){
        valorMercadoria = x.valorMercadoria + y.valorMercadoria;
        peso = x.peso + y.peso;
        valorFrete = x.valorFrete + y.valorFrete;
    };

    public Float getValorMercadoria() {
        return valorMercadoria;
    }

    public void setValorMercadoria(Float valorMercadoria) {
        this.valorMercadoria = valorMercadoria;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Float valorFrete) {
        this.valorFrete = valorFrete;
    }
    
    
}
