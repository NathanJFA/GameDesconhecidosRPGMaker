package desconhecidos.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GameController {

    @FXML
    private Button btMenu;

    @FXML
    void menuFrame(ActionEvent event) {
        MainGame.changeScreen("main");
    }

}
