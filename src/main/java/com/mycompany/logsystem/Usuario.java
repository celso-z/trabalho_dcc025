/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logsystem;

/**
 *
 * @author celso-z
 */
public abstract class Usuario {

    String nome;
    Integer matricula;
    static Integer numUsuarios;
    
    public Usuario(String nome) {
        this.nome = nome;
        this.matricula = numUsuarios;
        numUsuarios++;
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public static Integer getNumUsuarios() {
        return numUsuarios;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public static void setNumUsuarios(Integer numUsuarios) {
        Usuario.numUsuarios = numUsuarios;
    }
}