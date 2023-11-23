/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logsystem;

/**
 *
 * @author celso-z
 */
public class Veiculo {
    private static Integer numVeiculos;
    final private Integer idVeiculo;
    private Integer capacidadeVeiculo;
    private boolean disponivel;
    private Unidade unidadeOrig, unidadeDestino;
    private Carga cargaAtual;

    public Veiculo(Integer capacidadeVeiculo, Unidade unidadeOrig) {
        idVeiculo = numVeiculos;
        numVeiculos++;
        disponivel = true;    
        this.unidadeOrig = unidadeOrig;
        unidadeDestino = unidadeOrig;
    }

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public static Integer getNumVeiculos() {
        return numVeiculos;
    }

    public static void setNumVeiculos(Integer numVeiculos) {
        Veiculo.numVeiculos = numVeiculos;
    }

    public Integer getCapacidadeVeiculo() {
        return capacidadeVeiculo;
    }

    public void setCapacidadeVeiculo(Integer capacidadeVeiculo) {
        this.capacidadeVeiculo = capacidadeVeiculo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Unidade getUnidadeOrig() {
        return unidadeOrig;
    }

    public void setUnidadeOrig(Unidade unidadeOrig) {
        this.unidadeOrig = unidadeOrig;
    }

    public Unidade getUnidadeDestino() {
        return unidadeDestino;
    }

    public void setUnidadeDestino(Unidade unidadeDestino) {
        this.unidadeDestino = unidadeDestino;
    }

    public Carga getCargaAtual() {
        return cargaAtual;
    }

    public void setCargaAtual(Carga cargaAtual) {
        this.cargaAtual = cargaAtual;
    }
    
    
    
}
