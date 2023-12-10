/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.mycompany.logsystem.LogSystem;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame {

    final int WINDOW_WIDTH = 800;
    final int WINDOW_HEIGHT = 500;

    final int INPUT_WIDTH = 250;
    final int INPUT_SMALL_WIDTH = 100;
    final int INPUT_HEIGHT = 30;

    final int LIST_WIDTH = 400;
    final int LIST_HEIGHT = 300;

    final int INSET_TOP = 0;
    final int INSET_BOTTOM = 15;
    final int INSET_LEFT = 10;
    final int INSET_RIGHT = 10;

    final int PADDING = 10;

    public Janela(String titulo) {
        setTitle("LogSystem - " + titulo);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null); //abre a janela centralizado na tela
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
        setVisible(true);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent event){
                LogSystem.endSession();
            }
        });
    }

    public JPanel gridBagLayoutConfig() {
        JPanel painel = new JPanel();
        painel.setVisible(true);
        painel.setLayout(new GridBagLayout()); //utiliza o layout Grid Bag

        return painel;
    }

    public GridBagConstraints gridBagConstraintsConfig() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST; //alinha texto a direita
        gbc.insets = new Insets(INSET_TOP, INSET_LEFT, INSET_BOTTOM, INSET_RIGHT); //define espaçamento externo        
        gbc.ipadx = PADDING; //define espaçamento interno na horizontal
        gbc.ipady = PADDING; //define espaçamento interno na vertical

        return gbc;
    }
}
