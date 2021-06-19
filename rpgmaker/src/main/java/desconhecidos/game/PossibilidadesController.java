
package desconhecidos.game;

import java.util.ArrayList;
import java.util.Map;

import Historia.Aventura;
import Historia.Historia;
import Historia.Possibilidade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;

public class PossibilidadesController {

    Historia historia = new Historia();
    private ArrayList<Possibilidade> possibilidadesPreDefinidas = new ArrayList<>();

    private Possibilidade newNodeP;

    @FXML
    private SplitMenuButton MenuButtonId;
    
    private static MainGame mainGame;
    Aventura newAventura;

    @FXML
    private Button btnPrevious;

    @FXML 
    private TextField textDescricao;

    @FXML
    private TextField textOp1;

    @FXML
    private TextField textOp2;

    @FXML
    private TextField textOp3;
    @FXML
    private Label labelApontador;

    @FXML 
    protected void initialize(){
        MainGame.addOnChangeScreenListener(new MainGame.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen, Object userData){
                if(newScreen.equals("possibilidades")){
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
            System.out.println("Preencher campos para continuar..");
            if(Historia.possibilidades.size() == 0){
                newNodeP = new Possibilidade(textDescricao.getText());
                newNodeP.setApontador(null);
                newNodeP.setMsgOp1(textOp1.getText());
                newNodeP.setMsgOp2(textOp2.getText());
                newNodeP.setMsgOp3(textOp3.getText());
                newNodeP.setId("0");
                Historia.addPossibilidade(newNodeP.getId(), newNodeP);
            }else{
                //DEFINIR APONTADOR
                newNodeP.setPossibilidade1();
                Possibilidade newNode = newNodeP.getPossibilidade1();
                newNodeP.setDescricao(textDescricao.getText());
                newNodeP.setMsgOp1(textOp1.getText());
                newNodeP.setMsgOp2(textOp2.getText());
                newNodeP.setMsgOp3(textOp3.getText());
                Historia.addPossibilidade(newNodeP.getId()+"1", newNode);



                Possibilidade newP = new Possibilidade(textDescricao.getText());
                Historia.updateId(newP);
                newP.setMsgOp1(textOp1.getText());
                newP.setMsgOp2(textOp2.getText());
                newP.setMsgOp3(textOp3.getText());
                Historia.addPossibilidade(newP.getId(), newP);

                newP.setPossibilidade1();
                newP.setPossibilidade2();
                newP.setPossibilidade3();
            }
        }
    }
    public void tratandoNode(String node){
        


    }
    @FXML
    void selecionandoNode(ActionEvent event){
        //PODE SER CHAMADO PELO FRONT ENT NA CAIXINHA DE SELEÇÃO, DAÍ ELE PASSA QUAL É O ID DA POSSIBILIDADE
        //precisa enviar pra 
        tratandoNode("nome do menuItem");
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

    

}


    

