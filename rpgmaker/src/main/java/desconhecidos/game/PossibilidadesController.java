
package desconhecidos.game;

import java.util.ArrayList;

import Historia.Aventura;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;

public class PossibilidadesController {

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


    

