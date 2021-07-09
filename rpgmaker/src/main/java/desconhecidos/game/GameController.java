package desconhecidos.game;

import Historia.Aventura;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class GameController {
    protected Aventura newAventura;

    @FXML
    private TextArea telaDescricao;

    @FXML
    private TableView<?> tableAtributos;

    @FXML
    private GridPane gridInventario;

    @FXML
    private GridPane gridHabilidades;

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
    @FXML
    void mutar(MouseEvent event) {
        if(Sound.Clips.som){
            Sound.Clips.music.stop();
            System.out.println("stop");
            //imageViewSom.setImage(new Image("/home/nathanjfa/Documentos/ProjetosGitHub/GameDesconhecidosRPGMaker/rpgmaker/src/main/java/img/semSom.png"));
        }else if(!Sound.Clips.som){
            Sound.Clips.music.play();
            System.out.println("play");
            //imageViewSom.setImage(new Image("/home/nathanjfa/Documentos/ProjetosGitHub/GameDesconhecidosRPGMaker/rpgmaker/src/main/java/img/ComSom.png"));
        }    
    }

    


}
