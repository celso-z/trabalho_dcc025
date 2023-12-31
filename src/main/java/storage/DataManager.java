/**
 * @author Celso Zacarias da Silva Junior 202076003
 * @author Dhayana Nascimento Silva 201976040
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package storage;

import exceptions.DataException;
import model.Carga;
import model.Cliente;
import model.Unidade;
import model.Veiculo;
import model.Pedido;
import model.Item;
import model.Administrador;
import model.Funcionario;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import java.io.*;
import java.io.File;



/**
 *
 * @author celso-z
 */
public class DataManager {
    public static String DATA_DIR = "data";
    
    private static <T> void escreveRegistros(List<T> objectsToWrite) throws DataException{
        Gson gson = new Gson();
        String json = gson.toJson(objectsToWrite);
        File diretorio = new File(DATA_DIR);
        if(!diretorio.exists()){
            diretorio.mkdirs();
        }
        if(objectsToWrite.isEmpty() || objectsToWrite == null) return;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(classFilename(objectsToWrite.get(0).getClass().getSimpleName()), false))) {
            writer.write(json);
        } catch (IOException e) {
            throw new DataException("Erro ao escrever Json em arquivo", "DataManager", Thread.currentThread().getStackTrace()[1].getLineNumber(), e);
        }
    }
    
    private static <T> List<T> leRegistros(Type token,String objectName ) throws DataException{
        List<T> registros = new ArrayList<>();
        String filepathRegistro = classFilename(objectName);
        Gson gson = new Gson();
        File f = new File(filepathRegistro);
        if(f.exists() && f.isFile()){
            String json = jsonFileToString(filepathRegistro);
            registros = stringToRegistro(json, gson, token);
        }
        return registros;
    }
    
    private static String jsonFileToString(String filepath) throws DataException{
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new DataException("Erro ao ler arquivo Json", "BufferedReader", Thread.currentThread().getStackTrace()[1].getLineNumber(), e);
        }
        return content.toString();
    }
    
    private static <T> List<T> stringToRegistro(String str, Gson gson, Type token) throws DataException{
        List<T> objetos = new ArrayList<>();
        if(!str.trim().equals("")) {
            objetos = gson.fromJson(str, token);

            if (objetos == null)
                objetos = new ArrayList<>();
        }
        return objetos;
    }

    private static <T> String classFilename(String nomeClasse){
        String classFilename = "data" +  File.separator + nomeClasse + ".json";
        return classFilename;
    }
    
    //@objectName é o nome da classe a ser retornada
    public static <T> List<T> getFromDisk(String objectName) throws DataException{
        Type tipoLista;
        
        switch(objectName){
            case "Administrador" -> {
                tipoLista = new TypeToken<List<Administrador>>() {
                }.getType();
            }
            case "Funcionario" -> {
                tipoLista = new TypeToken<List<Funcionario>>() {
                }.getType();
            }
            case "Cliente" -> {
                tipoLista = new TypeToken<List<Cliente>>() {
                }.getType();
            }
            case "Carga" -> {
                tipoLista = new TypeToken<List<Carga>>() {
                }.getType();
            }
            case "Item" -> {
                tipoLista = new TypeToken<List<Item>>() {
                }.getType();
            }
            case "Pedido" -> {
                tipoLista = new TypeToken<List<Pedido>>() {
                }.getType();
            }
            case "Unidade" -> {
                tipoLista = new TypeToken<List<Unidade>>() {
                }.getType();
            }
            case "Veiculo" -> {
                tipoLista = new TypeToken<List<Veiculo>>() {
                }.getType();
            }
            
            default -> {
                throw new DataException("GetFromDisk não pode encontrar o tipo de arquivo especificado como parâmetro", "DataManager", Thread.currentThread().getStackTrace()[1].getLineNumber());
            }
        }
        return leRegistros(tipoLista,objectName);
    }
    
    public static void saveAllObjects(List cliente, List funcionario, List adm, List unidade, List carga, List pedido, List item, List veiculo) throws DataException{
        escreveRegistros(cliente);
        escreveRegistros(funcionario);
        escreveRegistros(adm);
        escreveRegistros(unidade);
        escreveRegistros(carga);
        escreveRegistros(pedido);
        escreveRegistros(item);
        escreveRegistros(veiculo);
    }    
}
