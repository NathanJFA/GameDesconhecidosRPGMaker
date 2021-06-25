package Historia;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
    public static LinkedHashMap<String, Possibilidade> possibilidades = new LinkedHashMap<>();


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
    @Override //APENAS P DEBUG
    public String toString(){
        return nome+"#"+categoriaAventura+"#"+objetivo+"#"+personagemPrincipal+"#"+ambiente+"#"+descricao;
    }
    public static void updateId(Possibilidade possibilidade){
        for(Map.Entry<String , Possibilidade> p: possibilidades.entrySet()) {
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
    public static void addPossibilidade(String id, Possibilidade possiblidade){
        possibilidades.put(id,possiblidade);
    }
    public void removerPossibilidade(Possibilidade possibilidade){
        possibilidades.remove(possibilidade);
    }
    public LinkedHashMap<String, Possibilidade> getPossibilidades(){
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
