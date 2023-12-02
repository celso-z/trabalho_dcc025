/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logsystem;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import java.io.*;


/**
 *
 * @author celso-z
 */
public class DataManager {
    private Gson gson;
    private String json;
    
    public void escreveRegistros(List<Registro> objectsToWrite) throws DataException{
        String filepathRegistro = objectsToWrite.get(0).getDataPath();
        String filepathRegistroDir = objectsToWrite.get(0).DATA_DIR;
        //Gson gson = new Gson();
        gson = new Gson();
        //String json = gson.toJson(objectsToWrite);
        json = gson.toJson(objectsToWrite);
        File diretorio = new File(filepathRegistroDir);
        if(!diretorio.exists()){
            diretorio.mkdirs();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepathRegistro, false))) {
            writer.write(json);
        } catch (IOException e) {
            throw new DataException("Erro ao escrever Json em arquivo", "DataManager", Thread.currentThread().getStackTrace()[1].getLineNumber());
        }
    }
    public List<Registro> leRegistros(String filepathRegistro) throws DataException{
        //Gson gson = new Gson();
        gson = new Gson();
        //String json = jsonFileToString(filepathRegistro);
        json = jsonFileToString(filepathRegistro);
        return stringToRegistro(json);
    }
    private String jsonFileToString(String filepath) throws DataException{
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new DataException("Erro ao ler arquivo Json", "DataManager", Thread.currentThread().getStackTrace()[1].getLineNumber());
        }
        return content.toString();
    }
    private List<Registro> stringToRegistro(String str){
        List<Registro> registros = new ArrayList<>();
        if(!str.trim().equals("")) {

            Type tipoLista = new TypeToken<List<Registro>>() {
            }.getType();
        registros = gson.fromJson(str, tipoLista);

            if (registros == null)
                registros = new ArrayList<>();
        }

        return registros;
    }
}
