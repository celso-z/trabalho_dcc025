/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logsystem;

/**
 *
 * @author celso-z
 */
public class ClientePersist extends Registro {
    private final Cliente ref;

    public ClientePersist(String nomeArquivoSalvamento, Cliente ref) {
        super(nomeArquivoSalvamento);
        this.ref = ref;
    }
    
   @Override
    public String toString() {
        return "Usuário{" + "Matricula=" + ref.getMatricula() + ", Nome=" + ref.getNome() 
                + ", Username=" + ref.getUsername() + ", Senha=" + ref.getSenha() + '}';
    }

}
