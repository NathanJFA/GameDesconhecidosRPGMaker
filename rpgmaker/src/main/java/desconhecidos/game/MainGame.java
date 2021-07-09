package desconhecidos.game;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entities.Entity;
import bd.WriteAndRead;
import bd.connMysql;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainGame extends Application{

    static WriteAndRead dados = new WriteAndRead();
    @FXML
    private Button btnCreateAdventure;
    @FXML
    private Button btnBiblioteca;
    @FXML
    private Button btnSair;

    private static Stage stage; //PALCO

    /**
     *  JANELAS QUE SERÃO REFERENCIADAS NO STAGE (PALCO) DENTRO DO SWITCH
     */
    public static Scene cadastroScene;
    public static Scene mainScene; 
    public static Scene bibliotecaScene; 
    public static Scene possibilidadeScene;
    public static Scene gameScene;

    CadastroController cadastroC = new CadastroController();
    BibliotecaController bibliotecaC = new BibliotecaController();
    
    private ObservableList<Entity> entidades = FXCollections.observableArrayList();
    
    public MainGame(){
    }

    public static void main(String[] args) {
        try {
            inicializaComponentes();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        launch(args);
    }
    static void inicializaComponentes() throws IOException{
        Sound.Clips.music.play();
        dados.recuperarDados();
    }

    /**
     * TODAS AS CENAS SÃO INICIADAS AQUI, SEGUE A MESMA LÓGICA DO changeScreen()
     */
    @Override
    public void start(Stage stageIn) throws IOException {
        stage = stageIn;
        Parent fxmlMain = FXMLLoader.load(getClass().getResource("../../Telas/BaseFramePrincipal.fxml"));
        mainScene = new Scene(fxmlMain); 
        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("../../Telas/FrameCadastro.fxml"));
        cadastroScene = new Scene(fxmlCadastro);
        Parent fxmlPossibilidades = FXMLLoader.load(getClass().getResource("../../Telas/frameCadastroAv_Possibilidades.fxml"));
        possibilidadeScene = new Scene(fxmlPossibilidades);
        Parent fxmlBiblioteca = FXMLLoader.load(getClass().getResource("../../Telas/FrameSelecioneAventura.fxml"));
        bibliotecaScene = new Scene(fxmlBiblioteca);
        Parent fxmlGame = FXMLLoader.load(getClass().getResource("../../Telas/FrameGame.fxml"));
        gameScene = new Scene(fxmlGame);

        stage.setTitle("Game RPG Maker v1.0");
        stage.setScene(mainScene);
        stage.show();
    }

    public ObservableList<Entity> getEntidades(){
        return entidades;
    }
    
    /**
     * FAZ A TRANSIÇÃO DE TODAS AS TELAS
     * TODOS OS CONTROLADORES CHAMAM ESSE METODO QUANDO FOR NECESSÁRIO TROCAR DE CENA
     * CASO SEJA ADICIONADA ALGUMA TELA, É PRECISO IMPLANTAR AQUI TAMBÉM
     * PODE SER PASSADO UM OBJETO
     * @param src
     * @param userData
     */
    public static void changeScreen(String src, Object userData){
        switch(src){
            case "main":
                stage.setScene(mainScene);
                notifyAllListeners("main", userData);
                break;
            case "cadastro":
                stage.setScene(cadastroScene);
                notifyAllListeners("cadastro", userData);
                break;
            case "biblioteca":
                stage.setScene(bibliotecaScene);
                notifyAllListeners("biblioteca", userData);
                break;
            case "possibilidades":
                stage.setScene(possibilidadeScene);
                notifyAllListeners("possibilidades", userData);
                break;
            case "game":
                stage.setScene(gameScene);
                notifyAllListeners("game", userData);
        }
    }
    //CASO NÃO QUEIRA PASSAR OBJETO
    public static void changeScreen(String src){
        changeScreen(src, null);
    }
    //RETORNA O PALCO
    public Stage getStage(){
        return this.stage;
    }

    /**
     * METODOS OBRIGATORIOS DO SCENENUILDER/FXML
     * @param event
     */
    @FXML 
    void createAdventure(ActionEvent event) {
        cadastroC.setMainGame(this);
        changeScreen("cadastro");  
    }
    @FXML
    void bibliotecaGames(ActionEvent event) {
        bibliotecaC.setMainGame(this);
        changeScreen("biblioteca");
    }
    @FXML
    void exit(ActionEvent event) throws IOException {
        dados.gravarDados();
        stage.close();
    }

    //------------------------------------------------------------------------
    /**
     * ESSE SCRIPS AVISA A TODAS OS CONTROLLERS QUANDO SEU FRAME FOR ACESSADO
     * TEM UM MÉTODO NO CONSTRUTOR DOS CONTROLERS QUE FAZ ISSO
     */
    private static ArrayList<OnChangeScreen> listeners = new ArrayList<OnChangeScreen>();

    public static interface OnChangeScreen{
        public void onScreenChanged(String newScreen, Object userData);
    }

    public static void addOnChangeScreenListener(OnChangeScreen newListener){
        listeners.add(newListener);
    }
    public static void notifyAllListeners(String newScreen, Object userData){
        for(OnChangeScreen l : listeners){
            l.onScreenChanged(newScreen, userData);
        }
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

