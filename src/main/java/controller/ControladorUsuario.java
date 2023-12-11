/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JFrame;
import view.TelaCredito;
import view.TelaPedido;

public class ControladorUsuario {

    public static void adicionarCredito(JFrame frame) {
        frame.dispose();
        new TelaCredito();
    }

    public static void realizarPedido(JFrame frame, Integer textUnidadeOrigem, Integer textUnidadeDestino, String textNomeDestinatario, String textCpfDestinatario) {
        frame.dispose();
        new TelaPedido(textUnidadeOrigem, textUnidadeDestino, textCpfDestinatario, textNomeDestinatario);
    }
}