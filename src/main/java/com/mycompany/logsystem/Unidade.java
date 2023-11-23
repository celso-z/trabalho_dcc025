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
public class Unidade {
    private static Integer numUnidades = 0;
    final private Integer idUnidade;
    private Integer capacidadeArmazenamento;
    private Integer capacidadeAtual;
    private ArrayList<Carga> cargas;

    public Unidade(Integer capacidadeArmazenamento) {
        this.capacidadeArmazenamento = capacidadeArmazenamento;
    }

    public Integer getArmazenamentoAtual() {
        return capacidadeAtual;
    }

    public void setArmazenamentoAtual(Integer armazenamentoAtual) {
        this.capacidadeAtual = armazenamentoAtual;
    }
    
    public void adicionarCarga(Carga x){
        if(x.getPeso() < this.capacidadeAtual){
            cargas.add(x);
        }
        return;
    }
    
    public void retirarCarga(Integer idCarga){
        
    }
}
