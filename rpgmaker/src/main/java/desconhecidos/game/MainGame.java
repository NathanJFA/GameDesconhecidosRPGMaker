package desconhecidos.game;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entities.Entity;
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
import javafx.stage.Stage;

public class MainGame extends Application{


    @FXML
    private Button btnCreateAdventure;

    @FXML
    private Button btnBiblioteca;

    @FXML
    private Button btnSair;
    private static Stage stage; //PALCO

    /**
     * ESTUDANDO A PLATAFORMA P INTRODUZIR BANCO DE DADOS connMysql
     * connMysql bd = new connMysql();
     * /

    /**
     *  JANELAS QUE SERÃO REFERENCIADAS NO STAGE (PALCO) DENTRO DO SWITCH
     */
    public static Scene cadastroScene;
    public static Scene mainScene; 
    public static Scene bibliotecaScene; 
    public static Scene possibilidadeScene;

    CadastroController cadastroC = new CadastroController();
    BibliotecaController bibliotecaC = new BibliotecaController();
    
    private ObservableList<Entity> entidades = FXCollections.observableArrayList();
    
    public MainGame(){
        
        /**
         * TESTE DE CONEXÃO CASO FOR UTILIZAR A CLASSE  connMysql
         * connMysql.getConnection();
         * JOptionPane.showMessageDialog(null, connMysql.statusConection());
        */  
    }

    public ObservableList<Entity> getEntidades(){
        return entidades;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
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

        stage.setTitle("Game RPG Maker v1.0");
        stage.setScene(mainScene);
        stage.show();
    }

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
        }

    }
    public static void changeScreen(String src){
        changeScreen(src, null);
    }
    public Stage getStage(){
        return this.stage;
    }

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
    void exit(ActionEvent event) {
        stage.close();
    }

    //------------------------------------------------------------------------

    private static ArrayList<OnChangeScreen> listeners = new ArrayList<OnChangeScreen>();


    public static interface OnChangeScreen{
        public void onScreenChanged(String newScreen, Object userData);
    }

    public static void addOnChangeScreenListener(OnChangeScreen newListener){
        listeners.add(newListener);
        System.out.println("chegou até aqui");
    }
    public static void notifyAllListeners(String newScreen, Object userData){
        //System.out.println(listeners.size());
        for(OnChangeScreen l : listeners){
            l.onScreenChanged(newScreen, userData);


        }
    }
            /*
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../Telas/FrameCadastro.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);

        stage.setScene(tela);
        stage.show();
        */


    /*
        private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");
@../img/ceu.jpe@../img/ceu.jpe'
        initRootLayout();

        showPersonOverview();
    }
    
    /**
     * Inicializa o root layout (layout base).
     *
    public void initRootLayout() {
        try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Mostra a scene (cena) contendo o root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */


}

