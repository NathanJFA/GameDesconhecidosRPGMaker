
package desconhecidos.game;

import java.util.ArrayList;
import java.util.Map;

import Historia.Aventura;
import Historia.Possibilidade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;

public class PossibilidadesController {

    private ArrayList<PrePossibilidade> possibilidadesPreDefinidas = new ArrayList<>();

    private Possibilidade newNodeP;

    
    private static MainGame mainGame;
    Aventura newAventura;

    @FXML
    private Button btnPrevious;

    @FXML 
    private TextArea textDescricao;

    @FXML
    private TextArea textOp1;

    @FXML
    private TextArea textOp2;

    @FXML
    private TextArea textOp3;
 
    @FXML
    private Label labelApontador;

    @FXML
    private TextField tfPesquisaId;

    @FXML 
    protected void initialize(){
        MainGame.addOnChangeScreenListener(new MainGame.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen, Object userData){
                if(newScreen.equals("possibilidades")){
                    tfPesquisaId.setText("");
                    System.out.println("Entrando no Frame Possibilidades...");
                    //AQUI DEVE SER IMPLEMENTADO A INTERAÇÃO COM A NOVA TELA 
                    newAventura = (Aventura) userData; 
                }
            }
        });
    }
    @FXML
    void concluirPossibilidade(ActionEvent event){
        if(!(textDescricao.getText().isEmpty() || textOp1.getText().isEmpty() || textOp2.getText().isEmpty() || textOp3.getText().isEmpty())){
            
            if(Aventura.possibilidades.size() == 0){
                newNodeP = new Possibilidade(textDescricao.getText());
                newNodeP.setApontador(null);
                newNodeP.setMsgOp1(textOp1.getText());
                newNodeP.setMsgOp2(textOp2.getText());
                newNodeP.setMsgOp3(textOp3.getText());
                newNodeP.setId("0");
                Aventura.addPossibilidade(newNodeP.getId(), newNodeP);
                possibilidadesPreDefinidas.add(new PrePossibilidade(newNodeP.getId() + "1", newNodeP.getMsgOpcao1()));
                possibilidadesPreDefinidas.add(new PrePossibilidade(newNodeP.getId() + "2", newNodeP.getMsgOpcao2())); 
                possibilidadesPreDefinidas.add(new PrePossibilidade(newNodeP.getId() + "3", newNodeP.getMsgOpcao3()));
            }else{
                if(!tfPesquisaId.getText().isEmpty()){
                    for(PrePossibilidade pp : possibilidadesPreDefinidas){
                        if(pp.getId().equals(tfPesquisaId.getText())){
                            Possibilidade newP = new Possibilidade(textDescricao.getText());
                            newP.setApontador(pp.getAPontador());
                            newP.setMsgOp1(textOp1.getText());
                            newP.setMsgOp2(textOp2.getText());
                            newP.setMsgOp3(textOp3.getText());
                            Aventura.addPossibilidade(newP.getId(), newP);
                            possibilidadesPreDefinidas.remove(pp);
                        }
                    }
                possibilidadesPreDefinidas.add(new PrePossibilidade (newNodeP.getId() + "1", newNodeP.getMsgOpcao1()));
                possibilidadesPreDefinidas.add(new PrePossibilidade (newNodeP.getId() + "2", newNodeP.getMsgOpcao2())); 
                possibilidadesPreDefinidas.add(new PrePossibilidade (newNodeP.getId() + "3", newNodeP.getMsgOpcao3()));
                }
            }
        }else{
            System.out.println("Preencher campos para continuar..");
        }
    }



    @FXML
    void previousFrame(ActionEvent event) {
        changeScreen("cadastro");
    }
    public void setMain(MainGame mainGame){
        this.mainGame = mainGame;
    }
    private void changeScreen(String scene){
        mainGame.changeScreen(scene);
    }
    public void updateTable(){
        //ADICIONAR NOVAS POSSIBILIDADES
    }

    

}


    

