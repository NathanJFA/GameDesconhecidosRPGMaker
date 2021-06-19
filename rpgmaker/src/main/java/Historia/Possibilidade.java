public class Possibilidade {
    private String Id;
    private String mensagem,msgOp1,msgOp2,msgOp3;
    private Possibilidade possibilidade1, possibilidade2, possibilidade3;


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
        return possibilidade1;
    }
    public Possibilidade getPossibilidade2(){
        return possibilidade2;
    }
    public Possibilidade getPossibilidade3(){
        return possibilidade3;
    }
    public void setPossibilidade1(Possibilidade possibilidade){
        this.possibilidade1 = possibilidade;
    }
    public void setPossibilidade2(Possibilidade possibilidade){
        this.possibilidade2 = possibilidade;
    }
    public void setPossibilidade3(Possibilidade possibilidade){
        this.possibilidade3 = possibilidade;
    }
}