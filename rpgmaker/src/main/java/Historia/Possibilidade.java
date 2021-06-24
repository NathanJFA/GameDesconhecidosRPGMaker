package Historia;

import org.junit.jupiter.api.Test;

public class Possibilidade {
    private String apontador;
    private String id;
    private String descricao,msgOp1,msgOp2,msgOp3;
    private Possibilidade possibilidade1, possibilidade2, possibilidade3;

    public Possibilidade(){

    }
    public Possibilidade(String id, String descricao, String msgOp1, String msgOp2, String msgOp3){
        this.id = id;
        this.descricao = descricao;
        this.msgOp1 = msgOp1;
        this.msgOp2 = msgOp2;
        this.msgOp3 = msgOp3;
    }

    public Possibilidade(String id,String apontador){
        this.apontador = apontador;
        this.id = id;
    }
    public String getApontador(){
        return this.apontador;
    }
    public void setApontador(String apontador){
        this.apontador = apontador;
    }
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String msg){
        this.descricao = msg;
    } 
    public String getMsgOpcao1(){
        return this.msgOp1;
    }
    public String getMsgOpcao2(){
        return this.msgOp2;
    }
    public String getMsgOpcao3(){
        return this.msgOp3;
    }
    public void setMsgOp1(String msg){
        this.msgOp1 = msg;
    }
    public void setMsgOp2(String msg){
        this.msgOp2 = msg;
    }
    public void setMsgOp3(String msg){
        this.msgOp3 = msg;
    }
    public Possibilidade getPossibilidade1(){
        return this.possibilidade1;
    }
    public Possibilidade getPossibilidade2(){
        return this.possibilidade2;
    }
    public Possibilidade getPossibilidade3(){
        return this.possibilidade3;
    }
    public Possibilidade gerarPossi1(String msg){
        this.possibilidade1 = new Possibilidade(this.id+"1",msg);
        return this.possibilidade1;
    }
    public Possibilidade gerarPossi2(String msg){
        this.possibilidade2 = new Possibilidade(this.id+"2",msg);
        return this.possibilidade2;
    }
    public Possibilidade gerarPossi3(String msg){
        this.possibilidade3 = new Possibilidade(this.id+"3",msg);
        return this.possibilidade3;
    }  
    public void setAttr(String descricao, String op1, String op2, String op3){
        this.descricao = descricao;
        this.msgOp1 = op1;
        this.msgOp2 = op2;
        this.msgOp3 = op3;
    } 
}

