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
public class Unidade {
    private static Integer numUnidades = 0;
    private final Integer idUnidade;
    private Float capacidadeArmazenamento = 0F;
    private Float capacidadeAtual = 0F;
    private ArrayList<Carga> cargas;

    public Unidade(Float capacidadeArmazenamento) {
        idUnidade = numUnidades;
        numUnidades++;
        this.capacidadeArmazenamento = capacidadeArmazenamento;
        this.capacidadeAtual = capacidadeArmazenamento;
    }

    public Float getArmazenamentoAtual() {
        return capacidadeAtual;
    }

    public static Integer getNumUnidades() {
        return numUnidades;
    }

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public Float getCapacidadeArmazenamento() {
        return capacidadeArmazenamento;
    }

    public Float getCapacidadeAtual() {
        return capacidadeAtual;
    }

    public ArrayList<Carga> getCargas() {
        return cargas;
    }
    
    public boolean adicionarCarga(Carga x){
        if(x.getPeso() < this.capacidadeAtual){
            cargas.add(x);
            capacidadeAtual -= x.getPeso();
            return true;
        }
        return false;
    }
    
    public Carga retirarCarga(int idCarga){
        Carga cargaRemovida;
        try{
            cargaRemovida = cargas.get(idCarga);
        }catch(IndexOutOfBoundsException e){
            return null;
        }
        cargas.remove(idCarga);
        capacidadeAtual += cargaRemovida.getPeso();
        return cargaRemovida;
    }
}
