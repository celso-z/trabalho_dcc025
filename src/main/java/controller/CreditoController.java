/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mycompany.logsystem.LogSystem;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Cliente;
import view.HomeUsuario;

/**
 *
 * @author celso-z
 */
public class CreditoController {
    public static void addCredito(JFrame frame, Float valorCredito, boolean numeroPreenchido, boolean nomePreenchido, boolean cvvPreenchido, boolean dataPreenchida){
        Cliente clienteAtual = LogSystem.getClienteAtual();
        if(numeroPreenchido && nomePreenchido && cvvPreenchido && dataPreenchida) clienteAtual.adicionaCreditos(valorCredito);
        else JOptionPane.showMessageDialog(null, "ERRO! CRÉDITO NÃO ADICIONADO, VERIFIQUE SE TODOS OS DADOS FORAM PREENCHIDOS CORRETAMENTE, você será direcionado para a tela de inicial!");
        frame.dispose();
        new HomeUsuario();
    }
    
}
