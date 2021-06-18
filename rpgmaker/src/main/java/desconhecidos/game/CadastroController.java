package desconhecidos.game;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import Historia.Aventura;
import Historia.Historia;
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

    private Aventura newAventura;

    private HashMap<String, Aventura> aventuras = new HashMap<>();

    public CadastroController(){
        
        //TODO
    }
    
    @FXML
    private void initialize() throws IOException{  
        MainGame.addOnChangeScreenListener(new MainGame.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen, Object userData){
                if(newScreen.equals("cadastro")){
                    System.out.println("Entrando no Frame Cadastro...");
                    //AQUI DEVE SER IMPLEMENTADO A INTERAÇÃO COM A NOVA TELA
                }
            }
        });
    }      
        /*Inicializa a tablea de pessoa com duas colunas.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        */
    
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
        if(!(textNameAdventure.getText().isEmpty() || textCategorAdventure.getText().isEmpty() || textObjetive.getText().isEmpty() || textPersonMain.getText().isEmpty() || textAmbiente.getText().isEmpty() || textCLimax.getText().isEmpty() || textDescription.getText().isEmpty())){
            newAventura = new Aventura(textNameAdventure.getText(), textCategorAdventure.getText(), textObjetive.getText(), textPersonMain.getText(), textAmbiente.getText(), textDescription.getText());
            this.aventuras.put(newAventura.getNome(), newAventura);
            System.out.println(newAventura.toString());
            changeScreen("possibilidades", newAventura);
        }else{
            System.out.println("Algo precisa ser revisado...");
        }
    }
    private void changeScreen(String scene, Object userData){
        if(userData == null){
            mainGame.changeScreen(scene);
        }else{
            mainGame.changeScreen(scene, userData);
        }
        
    }
    private void changeScreen(String scene){
        mainGame.changeScreen(scene, null);
    }
}