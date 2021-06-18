package Historia;

public class Possibilidade {
    private String mensagem;
    private Possibilidade opcao1,opcao2,opcao3;


    public Possibilidade(String mensagens){
        this.mensagem = mensagens;
    }
    public Possibilidade(){

    }
    public String getMensagem(){
        return mensagem;
    }
    public void setMesagem(String msg){
        this.mensagem = msg;
    }
    public Possibilidade getOpcao1(){
        return this.opcao1;
    }
    public Possibilidade getOpcao2(){
        return this.opcao2;
    }
    public Possibilidade getOpcao3(){
        return this.opcao3;
    }


}
