/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logsystem;

/**
 *
 * @author celso-z
 */
public class Cliente extends Usuario {
    private final String username;
    private final String senha;
    private String telefone;
    
    
    public Cliente(String nome, String username, String senha) {
        super(nome);
        this.username = username;
        this.senha = senha;
    }
    
    public Cliente(String nome, String username, String senha, String telefone) {
        super(nome);
        this.username = username;
        this.senha = senha;
        this.telefone = telefone;
    }
    
    
    /*public solicitarFrete(Integer Valor, Unidade orig, Unidade dest){
    
    */

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }
}
