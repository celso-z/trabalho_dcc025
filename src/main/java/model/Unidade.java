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
import java.util.Objects;

public class Unidade {
    private static Integer numUnidades = 0;
    private final Integer idUnidade;
    private Float capacidadeArmazenamento = 0F;
    private Float capacidadeAtual = 0F;
    private ArrayList<Integer> cargas = new ArrayList();

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

    public static void setNumUnidades(Integer numUnidades) {
        Unidade.numUnidades = numUnidades;
    }

    public Float getCapacidadeArmazenamento() {
        return capacidadeArmazenamento;
    }

    public Float getCapacidadeAtual() {
        return capacidadeAtual;
    }

    public ArrayList<Integer> getCargas() {
        return cargas;
    }
    
    public boolean adicionarCarga(Carga x){
        if(x.getPeso() < this.capacidadeAtual){
            cargas.add(x.getIdCarga());
            capacidadeAtual -= x.getPeso();
            return true;
        }
        return false;
    }
    
    public void retirarCarga(Carga x){
        for(Integer id : cargas){
            if(Objects.equals(id, x.getIdCarga())){
                cargas.remove(id);
                return;
            }
        }
    }
}
