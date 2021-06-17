
package desconhecidos.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PossibilidadesController {

    private static MainGame mainGame;

    @FXML
    private Button btnPrevious;

    @FXML 
    protected void inictialize(){
        MainGame.addOnChangeScreenListener(new MainGame.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen, Object userData){
                if(newScreen.equals("possibilidades")){
                    //TRATANDO O AVISO
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


    

