package Historia;

import org.junit.jupiter.api.Test;

public class Possibilidade {
    private String Id;
    private String mensagem,msgOpcao1,msgOpcao2,msgOpcao3;
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
    
    public String getMsgOpcao1(){
        return this.msgOpcao1;
    }
    public String getMsgOpcao2(){
        return this.msgOpcao2;
    }
    public String getMsgOpcao3(){
        return this.msgOpcao3;
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
    public void setOpcao1(String msg){
        opcao1 = new Possibilidade(msg);
    }
    public void setOpcao2(String msg){
        opcao2 = new Possibilidade(msg);
    }
    public void setOpcao3(String msg){
        opcao3 = new Possibilidade(msg);
    }

    

}
