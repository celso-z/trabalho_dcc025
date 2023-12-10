/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author celso-z
 */
public class Veiculo {
    private static Integer numVeiculos=0;
    final private Integer idVeiculo;
    private Integer capacidadeVeiculo;
    private boolean disponivel;
    private Integer unidadeOrig, unidadeDestino;
    private Carga cargaAtual;

    public Veiculo(Integer capacidadeVeiculo, Integer unidadeOrig) {
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

    public Integer getUnidadeOrig() {
        return unidadeOrig;
    }

    public void setUnidadeOrig(Integer unidadeOrig) {
        this.unidadeOrig = unidadeOrig;
    }

    public Integer getUnidadeDestino() {
        return unidadeDestino;
    }

    public void setUnidadeDestino(Integer unidadeDestino) {
        this.unidadeDestino = unidadeDestino;
    }

    public Carga getCargaAtual() {
        return cargaAtual;
    }

    public void setCargaAtual(Carga cargaAtual) {
        this.cargaAtual = cargaAtual;
    }
    
    
    
}
