package Historia;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import Entities.Entity;
import Entities.Item;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Aventura {
    private String nome;
    private String categoriaAventura;
    private String objetivo;
    private String personagemPrincipal;
    private String ambiente;
    private String descricao;
    private HashMap<String, Entity> entidades = new HashMap<>();
    private HashMap<String, Item> itens = new HashMap<>();
    private HashMap<String, Possibilidade> possibilidades = new HashMap<>();


    public Aventura(String nome, String categoriaAventura, String objetivo, String personagemPrincipal, String ambiente, String descricao, HashMap<String, Entity> entidadesList, HashMap<String, Item> itensList, HashMap<String, Possibilidade> possibilidadesList){
        this.nome = nome;
        this.categoriaAventura = categoriaAventura;
        this.objetivo = objetivo;
        this.personagemPrincipal = personagemPrincipal;
        this.ambiente = ambiente;
        this.descricao = descricao;
        this.entidades = entidadesList;
        this.itens = itensList;
        possibilidades = possibilidadesList;
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
    public StringProperty getNomeProperty(){
        return new SimpleStringProperty(nome);
    }
    public String getCategoriaAventura(){
        return this.categoriaAventura;
    }
    public String getObjetivo(){
        return this.objetivo;
    }
    public void setPossibilidades(HashMap<String, Possibilidade> possibilidadesHash){
        this.possibilidades = possibilidadesHash;
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

    public HashMap<String, Entity> getEntity(){
        return entidades;
    }
    public void setEntity(){

    }
    public HashMap<String, Item> getItens(){
        return itens;
    }
    public void setItens(){

    }
    @Override //APENAS P DEBUG
    public String toString(){
        return nome+"#"+categoriaAventura+"#"+objetivo+"#"+personagemPrincipal+"#"+ambiente+"#"+descricao;
    }
    public void updateId(Possibilidade possibilidade){
        for(Map.Entry<String , Possibilidade> p: this.possibilidades.entrySet()) {
            if(p.getValue().getMsgOpcao1().equals(possibilidade.getApontador())) {
                possibilidade.setId(nomeiaId(p.getValue().getId(), "1"));
            }else if(p.getValue().getMsgOpcao2().equals(possibilidade.getApontador())){
                possibilidade.setId(nomeiaId(p.getValue().getId(), "2"));
            }else if(p.getValue().getMsgOpcao3().equals(possibilidade.getApontador())){
                possibilidade.setId(nomeiaId(p.getValue().getId(), "3"));
            }
        }
    }
    public static String nomeiaId(String idPai, String op){ 
        String newIdFilho = idPai + op;
        return newIdFilho;
    }
    public void addPossibilidade(String id, Possibilidade p){
        this.possibilidades.put(id,p);
    }
    public void removerPossibilidade(Possibilidade p){
        this.possibilidades.remove(p);
    }
    public HashMap<String, Possibilidade> getPossibilidades(){
        return possibilidades;
    }
    public boolean validarPossiblidade(Possibilidade possibilidade){
        for(Map.Entry<String , Possibilidade> p: possibilidades.entrySet()) {
            if(p.getValue().equals(possibilidade)){
                if(p.getValue().getDescricao()!= null){
                    return true;
                }
            }
        }return false;
    }
}
