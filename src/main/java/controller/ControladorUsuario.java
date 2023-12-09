/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JFrame;
import view.TelaCredito;
import view.TelaPedido;

/**
 *
 * @author dhayana
 */
public class ControladorUsuario {

    public static void adicionarCredito(JFrame frame) {
        frame.dispose();
        new TelaCredito();
    }

    public static void realizarPedido(JFrame frame, String textUnidadeOrigem, String textUnidadeDestino, String textNomeDestinatario, String textCpfDestinatario) {
        frame.dispose();
        new TelaPedido(textUnidadeOrigem, textUnidadeDestino, textNomeDestinatario, textCpfDestinatario);
    }
}
