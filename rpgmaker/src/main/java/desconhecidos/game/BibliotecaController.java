package desconhecidos.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BibliotecaController {

    private static MainGame mainGame;

    @FXML
    private Button btnPrevious;

    @FXML
    void previousAction(ActionEvent event) {
        changeScreen("main");
    }
    public void setMainGame(MainGame mainGame){
        this.mainGame = mainGame;
    }
    public void changeScreen(String scene){
        mainGame.changeScreen(scene);
    }

}
