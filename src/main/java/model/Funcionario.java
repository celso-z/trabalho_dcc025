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

    private String telefone;
    
    public Funcionario(String nome, String username, String senha) {
        super(nome, username, senha);
    }
    
    public Funcionario(String nome, String username, String senha, String telefone) {
        super(nome, username, senha);
        this.telefone = telefone;
    }
    
    public String getTelefone() {
        return telefone;
    }

}
