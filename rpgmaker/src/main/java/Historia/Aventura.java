package Historia;

import java.util.HashMap;

import Entities.Entity;
import Entities.Item;

public class Aventura {
    private String nome;
    private String categoriaAventura;
    private String objetivo;
    private String personagemPrincipal;
    private String ambiente;
    private String descricao;
    private HashMap<Entity, String> entidades = new HashMap<>();
    private HashMap<Item, String> itens = new HashMap<>();
    private Historia historia;

    public Aventura(){

    }
    public Aventura(String nome, String categoriaAventura, String objetivo, String personagemPrincipal, String ambiente, String descricao){
        this.nome = nome;
        this.categoriaAventura = categoriaAventura;
        this.objetivo = objetivo;
        this.personagemPrincipal = personagemPrincipal;
        this.ambiente = ambiente;
        this.descricao = descricao;
    }
    public String getNome(){
        return this.nome;
    }
    public String getCategoriaAventura(){
        return this.categoriaAventura;
    }
    public String getObjetivo(){
        return this.objetivo;
    }
    public String getPersonagemPrincipal(){
        return this.personagemPrincipal;
    }
    public String getAmbiente(){
        return this.ambiente;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCategoriaAventura(String categoriaAventura){
        this.categoriaAventura = categoriaAventura;
    }
    public void setObjetivo(String objetivo){
        this.objetivo = objetivo;
    }
    public void setPersonagemPrincipal(String personagemPrincipal){
        this.personagemPrincipal = personagemPrincipal;
    }
    public void setAmbiente(String ambiente){
        this.ambiente = ambiente;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
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
    @Override //APENAS P DEBUG
    public String toString(){
        return nome+"#"+categoriaAventura+"#"+objetivo+"#"+personagemPrincipal+"#"+ambiente+"#"+descricao;

    }
}
