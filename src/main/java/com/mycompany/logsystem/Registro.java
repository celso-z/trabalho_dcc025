/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logsystem;
import java.io.*;
import java.util.List;



public abstract class Registro {
    final String DATA_DIR;
    public abstract void EscreveRegistro(List<Registro> itens);
    public abstract Registro LeRegistro();

    public Registro(String diretorioSalvamento) {
        this.DATA_DIR = "data" + diretorioSalvamento;
    }
            
    
}
