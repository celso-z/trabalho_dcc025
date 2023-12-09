/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package storage;

/**
 *
 * @author dhayana
 */
public class ArmazenamentoTemporario {
    //Classe para registrar os dados durante a execução do programa
    
    private String nome;
    private Integer matricula;

    public ArmazenamentoTemporario(String nome, Integer matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public Integer getMatricula() {
        return matricula;
    } 
}
