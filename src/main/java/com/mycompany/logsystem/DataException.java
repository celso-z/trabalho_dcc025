/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logsystem;
import java.io.*;

/**
 *
 * @author celso-z
 */
public class DataException extends IOException{
    private final String classeErro;
    private final int lineNumber;
    
    public DataException(String message, String classeErro, int lineNumber){
        super(message);
        this.classeErro = classeErro;
        this.lineNumber = lineNumber;
    }
    
    public DataException(String message, String classeErro, int lineNumber, Throwable cause){
        super(message, cause);
        this.classeErro = classeErro;
        this.lineNumber = lineNumber;
    }

    public String getClasseErro() {
        return classeErro;
    }

    public int getLineNumber() {
        return lineNumber;
    }
    
    
    
}
