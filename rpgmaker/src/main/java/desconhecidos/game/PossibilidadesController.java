
package desconhecidos.game;

import java.util.ArrayList;

import Historia.Aventura;
import Historia.Historia;
import Historia.Possibilidade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;

public class PossibilidadesController {

    Historia historia = new Historia();
    

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
                Possibilidade newP = new Possibilidade("0", textDescricao.getText());
                Historia.addPossibilidade(newP.getId(), newP);
            }else{
                //DEFINIR APONTADOR
                Possibilidade newP = new Possibilidade(null, textDescricao.getText());
                Historia.updateId(newP);
                newP.setMsgOp1(textOp1.getText());
                newP.setMsgOp2(textOp2.getText());
                newP.setMsgOp3(textOp3.getText());
                Historia.addPossibilidade(newP.getId(), newP);
            }
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

}


    

