package Historias;

import java.util.HashMap;

import Entities.Entity;
import Entities.Item;

public class Aventura {
    private String nome;
    private HashMap<Entity, String> entidades = new HashMap<>();
    private HashMap<Item, String> itens = new HashMap<>();
    private Historia historia;

    public Aventura(String nome){
        this.nome = nome;
    }

    public HashMap<Entity, String> getEntity(){
        return entidades;
    }
    public void setEntity(){

    }
    public HashMap<Item, String> getItem(){
        return itens;
    }
    public void setItens(){

    }
    public Historia getHistoria(){
        return historia;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
}
