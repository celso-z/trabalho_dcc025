/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */
package view;

import controller.ControladorCadastro;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaCadastro extends Janela {

    private final JLabel labelNome;
    private final JTextField textNome;

    private final JLabel labelUsuario;
    private final JTextField textUsuario;

    private final JLabel labelTelefone;
    private final JTextField textTelefone;

    private final JLabel labelSenha;
    private final JPasswordField textSenha;

    private final JButton botaoCadastrar;

    public TelaCadastro() {
        super("Cadastro");

        JPanel painel = gridBagLayoutConfig();
        GridBagConstraints gbc = gridBagConstraintsConfig();

        labelNome = new JLabel("Nome");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(labelNome, gbc);

        textNome = new JTextField();
        textNome.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel.add(textNome, gbc);

        labelUsuario = new JLabel("Usuário");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(labelUsuario, gbc);

        textUsuario = new JTextField();
        textUsuario.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel.add(textUsuario, gbc);

        labelTelefone = new JLabel("Telefone");
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(labelTelefone, gbc);

        textTelefone = new JTextField();
        textTelefone.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel.add(textTelefone, gbc);

        labelSenha = new JLabel("Senha");
        gbc.gridx = 0;
        gbc.gridy = 3;
        painel.add(labelSenha, gbc);

        textSenha = new JPasswordField();
        textSenha.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        gbc.gridx = 1;
        gbc.gridy = 3;
        painel.add(textSenha, gbc);

        botaoCadastrar = new JButton("Cadastrar");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(botaoCadastrar, gbc);

        botaoCadastrar.addActionListener((ActionEvent event) -> {
            ControladorCadastro.cadastrar(this, getTextNome(), getTextUsuario(), getTextSenha(), getTextTelefone());
        });

        this.add(painel);
        this.setVisible(true);
    }

    private String getTextNome() {
        return textNome.getText();
    }

    private String getTextUsuario() {
        return textUsuario.getText();
    }

    private String getTextTelefone() {
        return textTelefone.getText();
    }

    private String getTextSenha() {
        return new String(textSenha.getPassword());
    }

}
