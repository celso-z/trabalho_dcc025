/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logsystem;

/**
 *
 * @author celso-z
 */
public class DataException extends Exception{
    String classeErro;
    public int lineNumber;
    
    public DataException(String message, String classeErro, int lineNumber){
        super(message);
        this.classeErro = classeErro;
        this.lineNumber = lineNumber;
    }
    
}
