/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Veiculo {
    private static Integer numVeiculos=0;
    final private Integer idVeiculo;
    private Integer capacidadeVeiculo;
    private boolean disponivel = true;
    private Integer unidadeOrig, unidadeDest;
    private Integer cargaAtual = -1;

    public Veiculo(Integer capacidadeVeiculo, Integer unidadeOrig) {
        idVeiculo = numVeiculos;
        numVeiculos++;
        this.capacidadeVeiculo = capacidadeVeiculo;
        disponivel = true;    
        this.unidadeOrig = unidadeOrig;
        unidadeDest = -1;
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

    public Integer getUnidadeDest() {
        return unidadeDest;
    }

    public Integer getCargaAtual() {
        return cargaAtual;
    }

    public boolean carregar(Carga c) {
        boolean carregamentoRealizado = false;
        if(c.getPeso() < capacidadeVeiculo){
            this.cargaAtual = c.getIdCarga();
            this.unidadeDest = c.getUnidadeDest();
            carregamentoRealizado = true;
        }
        return carregamentoRealizado;
    }
    
    public void descarregar(){
        cargaAtual = -1;
    }
    
}
