package Entities;

public class Possibilidades {
    private String mensagem;


    public Possibilidades(String mensagens){
        this.mensagem = mensagens;
    }
    public String getMensagem(){
        return mensagem;
    }
    public Possibilidades proximaPossib(){
        return null;
    }
    public Possibilidades anteriorPossib(){
        return null;
    }


}
