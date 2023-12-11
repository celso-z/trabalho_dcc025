/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */

package model;

public abstract class Usuario {

    private String nome;
    private Integer matricula;
    private String username;
    private String senha;
    private static Integer numUsuarios = 0;

    public Usuario(String nome, String username, String senha) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.matricula = numUsuarios;
        numUsuarios++;
    }

    public String getNome() {
        return nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public static Integer getNumUsuarios() {
        return numUsuarios;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public static void setNumUsuarios(Integer numUsuarios) {
        Usuario.numUsuarios = numUsuarios;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
   
}
