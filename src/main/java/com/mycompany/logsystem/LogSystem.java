/*
 * Um Sistema de gestão logística
 */
package com.mycompany.logsystem;

import exceptions.DataException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import model.Cliente;
import storage.DataManager;
import model.Administrador;
import model.Funcionario;
//import view.Administrador;
//import view.Login;

/**
 *
 * @author Celso Zacarias da Silva Junior 202076003
 */
public class LogSystem {

    public static void main(String[] args) {
        List<Funcionario> f = new ArrayList<>();
        Funcionario func = new Funcionario("Funcionario", "adm", "1234", "32 12345-6789");
        f.add(func);
        
        try {
            DataManager.escreveRegistros(f);
        } catch (DataException ex) {
            Logger.getLogger(LogSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
