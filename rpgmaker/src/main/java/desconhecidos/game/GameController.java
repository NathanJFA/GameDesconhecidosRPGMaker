package desconhecidos.game;

import Historia.Aventura;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class GameController {
    protected Aventura newAventura;
    @FXML
    private TextArea telaDescricao;

    @FXML
    private Button opcao3;

    @FXML
    private Button opcao2;

    @FXML
    private Button opcao1;

    @FXML
    private Button btMenu;

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
    void menuFrame(ActionEvent event) {
        MainGame.changeScreen("main");
    }


}
