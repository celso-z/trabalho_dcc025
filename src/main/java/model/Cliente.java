/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author celso-z
 */
public class Cliente extends Usuario {

    private String telefone;

    public Cliente(String nome, String username, String senha) {
        super(nome, username, senha);
    }

    public Cliente(String nome, String username, String senha, String telefone) {
        super(nome, username, senha);
        this.telefone = telefone;
    }

    /*public solicitarFrete(Integer Valor, Unidade orig, Unidade dest){
    
     */
    public String getTelefone() {
        return telefone;
    }
}
