/*
 * Um Sistema de gestão logística
 */
package com.mycompany.logsystem;

import exceptions.DataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.Cliente;
import model.Administrador;
import model.Pedido;
import model.Funcionario;
import model.Carga;
import model.Unidade;
import model.Veiculo;
import model.Item;
import storage.DataManager;
import view.Credito;
//import view.Administrador;
import view.Login;
import view.TelaFuncionario;
import view.TelaPedido;

/**
 *
 * @author Celso Zacarias da Silva Junior 202076003
 */
public class LogSystem {
    private static model.Cliente clienteAtual = null; 
    private static Funcionario funcionarioAtual = null; 
    private static Administrador administradorAtual = null; 
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Administrador> administradores = new ArrayList<>();
    private static List<Unidade> unidades = new ArrayList<>();
    private static List<Carga> cargas = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static List<Item> itens = new ArrayList<>();
    private static List<Veiculo> veiculos = new ArrayList<>();

    public static void main(String[] args) throws DataException {
        startSession();
        //Pedido p = new Pedido(555,2,0,"777", "Jose");
        //pedidos.add(p);
        //pedidos.add(p);
        //Unidade u = new Unidade(15000F);
        //unidades.add(u);
        //Carga c = new Carga(0);
        //Carga c1 = new Carga(0);
        //Carga c2 = new Carga(0);
        //Carga c3 = new Carga(0);
        //cargas.add(c3);
        //c3.addPedido(p);
        //u.adicionarCarga(c3);
        //Unidade u = unidades.get(0);
        //u.adicionarCarga(cargas.get(0));
        funcionarioAtual = funcionarios.get(0);
        //funcionarios.add(funcionarioAtual);
        new TelaFuncionario();
    }
    
    public static void startSession() throws DataException{
        //clientes = DataManager.getFromDisk("Cliente");
        funcionarios = DataManager.getFromDisk("Funcionario");
        //administradores = DataManager.getFromDisk(administradores.getClass().getSimpleName());
        unidades = DataManager.getFromDisk("Unidade");
        cargas = DataManager.getFromDisk("Carga");
        pedidos = DataManager.getFromDisk("Pedido");
        //itens = DataManager.getFromDisk(itens.getClass().getSimpleName());
        //veiculos = DataManager.getFromDisk(veiculos.getClass().getSimpleName());
        
    }
    
    public static void endSession(){
        try {
            DataManager.saveAllObjects(clientes, funcionarios, cargas, unidades, cargas, pedidos, itens, veiculos);
        } catch (DataException ex) {
            System.exit(1);
        }
        System.exit(0);
    }

    public static Cliente getClienteAtual() {
        return clienteAtual;
    }

    public static void setClienteAtual(Cliente clienteAtual) {
        LogSystem.clienteAtual = clienteAtual;
    }

    public static Funcionario getFuncionarioAtual() {
        return funcionarioAtual;
    }

    public static void setFuncionarioAtual(Funcionario funcionarioAtual) {
        LogSystem.funcionarioAtual = funcionarioAtual;
    }

    public static Administrador getAdministradorAtual() {
        return administradorAtual;
    }

    public static void setAdministradorAtual(Administrador administradorAtual) {
        LogSystem.administradorAtual = administradorAtual;
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }

    public static List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public static List<Administrador> getAdministradores() {
        return administradores;
    }

    public static List<Unidade> getUnidades() {
        return unidades;
    }

    public static List<Carga> getCargas() {
        return cargas;
    }

    public static List<Pedido> getPedidos() {
        return pedidos;
    }

    public static List<Item> getItens() {
        return itens;
    }

    public static List<Veiculo> getVeiculos() {
        return veiculos;
    }
    
    
}
