/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logsystem;
import java.io.File;



public abstract class Registro {
    final String DATA_DIR = "data";
    private final String dataPath;

    public Registro(String nomeArquivoSalvamento) {
        dataPath = DATA_DIR +  File.separator + nomeArquivoSalvamento;
    }

    public String getDataPath() {
        return dataPath;
    }
    
    
}
