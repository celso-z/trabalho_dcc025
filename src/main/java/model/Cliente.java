/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Cliente extends Usuario {

    private String telefone;
    private Float creditos = 100.0F;

    public Cliente(String nome, String username, String senha) {
        super(nome, username, senha);
    }

    public Cliente(String nome, String username, String senha, String telefone) {
        super(nome, username, senha);
        this.telefone = telefone;
    }
    
    public void adicionaCreditos(Float creditos){
        if(creditos > 0.0F) this.creditos += creditos;
    }

    public Float getCreditos() {
        return creditos;
    }
    
    

    public String getTelefone() {
        return telefone;
    }
}
