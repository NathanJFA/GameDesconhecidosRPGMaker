package desconhecidos.game;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroController {

    @FXML
    private TextField textNameAdventure;

    @FXML
    private TextField textCategorAdventure;

    @FXML
    private TextField textObjetive;

    @FXML
    private TextField textPersonMain;

    @FXML
    private TextField textAmbiente;

    @FXML
    private TextField textCLimax;

    @FXML
    private TextArea textDescription;

    @FXML
    private Button btnNext;

    @FXML
    private Button btnVoltar;

    private static MainGame mainGame;

    private static Stage stage;

    //CENAS BASE - REFATORAR
    Scene previousScene;
    Scene nextScene;


    public CadastroController(){
        //TODO
    }
    
    @FXML
    private void inicialize() throws IOException{        
        /*Inicializa a tablea de pessoa com duas colunas.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        */
    }
    public void setMainGame(MainGame mainGame){
        this.mainGame = mainGame;
        stage = mainGame.getStage();

        /*Adiciona os dados da observable list na tabela
        #tabela.setItems(#classe.get#ObservableArrayList());
        */
    }

    @FXML
    void previousFrame(ActionEvent event){
        changeScreen("main");
    }
    @FXML
    void nextFrame(ActionEvent event){
        changeScreen("possibilidades");
    }
    private void changeScreen(String scene){
        mainGame.changeScreen(scene);
    }

}