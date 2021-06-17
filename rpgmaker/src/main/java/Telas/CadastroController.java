package Telas;

import desconhecidos.game.MainGame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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

    private MainGame mainGame;

    public CadastroController(){
        //TODO
    }
    
    @FXML
    private void inicialize(){
        /*Inicializa a tablea de pessoa com duas colunas.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        */
    }
    public void setMainGame(MainGame mainGame){
        this.mainGame = mainGame;

        /*Adiciona os dados da observable list na tabela
        #tabela.setItems(#classe.get#ObservableArrayList());
        */
    }

}
