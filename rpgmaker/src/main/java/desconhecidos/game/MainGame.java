package desconhecidos.game;

import java.io.IOException;

import Entities.Entity;
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

    private Stage stage;
    
    private ObservableList<Entity> entidades = FXCollections.observableArrayList();
    
    

    public MainGame(){
        entidades.add(new Entity("Super Homem", 1,1,1));
    }

    public ObservableList<Entity> getEntidades(){
        return entidades;
    }
    

    
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stageIn) throws Exception {
        this.stage = stageIn;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../Telas/BaseFramePrincipal.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);

        stage.setTitle("Game RPG Maker v1.0");

        stage.setScene(tela);
        stage.show();
    }

    @FXML
    private Button btnCreateAdventure;

    @FXML
    private Button btnLibrarieGames;

    @FXML
    private Button btnExit;

    @FXML
    void createAdventure(ActionEvent event) throws IOException{
        //System.out.println("Criar");
        CadastroController cadastroGame = new CadastroController(this.stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../Telas/FrameCadastro.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        
        //this.stage.setScene(tela);
        
    }

    @FXML
    void exit(ActionEvent event) {
        System.out.println("Sair");
    }
    

    @FXML
    void librarieGames(ActionEvent event) {
        System.out.println("Biblioteca");

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

