/*
 * Sistema de gestão logística
 */
package com.mycompany.logsystem;

import exceptions.DataException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Administrador;
import model.Pedido;
import model.Funcionario;
import model.Carga;
import model.Unidade;
import model.Veiculo;
import model.Item;
import model.Usuario;
import storage.DataManager;
import view.TelaFuncionario;
import view.TelaPedido;
import view.TelaAdministrador;
import view.TelaLogin;
import view.TelaUsuario;


/**
 *
 * @author Celso Zacarias da Silva Junior 202076003
 */
public class LogSystem {
    private static Cliente clienteAtual = null; 
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
        new TelaLogin();
    }
    
    public static void startSession() throws DataException{
        clientes = DataManager.getFromDisk("Cliente");
        funcionarios = DataManager.getFromDisk("Funcionario");
        administradores = DataManager.getFromDisk("Administrador");
        unidades = DataManager.getFromDisk("Unidade");
        cargas = DataManager.getFromDisk("Carga");
        pedidos = DataManager.getFromDisk("Pedido");
        //itens = DataManager.getFromDisk("Itens");
        //veiculos = DataManager.getFromDisk("Veiculos");
        Usuario.setNumUsuarios(clientes.size() + funcionarios.size() + administradores.size());
        
    }
    
    public static void endSession(){
        try {
            DataManager.saveAllObjects(clientes, funcionarios, administradores, unidades, cargas, pedidos, itens, veiculos);
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
