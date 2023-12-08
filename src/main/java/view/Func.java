/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author dhayana
 */
public class Func extends Janela {

    JButton botao_1;
    JButton botao_2;
    JButton botao_3;
    JButton botao_4;

    public Func() {
        super("Funcionario");
        
        JTabbedPane painel = new JTabbedPane();

        JPanel painel1 = gridBagLayoutConfig();
        JPanel painel2 = gridBagLayoutConfig();

        GridBagConstraints gbc = gridBagConstraintsConfig();

        painel.addTab("Chegada", painel1);
        painel.addTab("Saída", painel2);

        botao_1 = new JButton("Ação 1");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel1.add(botao_1, gbc);

        botao_2 = new JButton("Ação 2");
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel1.add(botao_2, gbc);

        botao_3 = new JButton("Ação 3");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel2.add(botao_3, gbc);

        botao_4 = new JButton("Ação 4");
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel2.add(botao_4, gbc);

        add(painel);
    }
}
