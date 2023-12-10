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
import view.TelaAdministrador;
import view.TelaLogin;


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
    
//           Veiculo a = new Veiculo(1500, 0);            
//           Veiculo b = new Veiculo(1000, 1);       
//      
//           veiculos.add(a);           
//           veiculos.add(b);

           
        new TelaLogin();
    }
    
    public static void startSession() throws DataException{
        clientes = DataManager.getFromDisk("Cliente");
        funcionarios = DataManager.getFromDisk("Funcionario");
        administradores = DataManager.getFromDisk("Administrador");
        unidades = DataManager.getFromDisk("Unidade");
        cargas = DataManager.getFromDisk("Carga");
        pedidos = DataManager.getFromDisk("Pedido");
        itens = DataManager.getFromDisk("Item");
        veiculos = DataManager.getFromDisk("Veiculo");
        
        Usuario.setNumUsuarios(clientes.size() + funcionarios.size() + administradores.size());        
        Unidade.setNumUnidades(unidades.size());
        Carga.setNumCargas(cargas.size());
        Pedido.setNumPedidos(pedidos.size());
        Item.setNumItens(itens.size());
        Veiculo.setNumVeiculos(veiculos.size());
        
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
