/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dhayana
 */
public class Funcionario extends Usuario {
    private final Integer unidade;

    public Funcionario(Integer unidade, String nome, String username, String senha) {
        super(nome, username, senha);
        this.unidade = unidade;
    }
    
    public Integer getUnidade() {
        return unidade;
    }
}
