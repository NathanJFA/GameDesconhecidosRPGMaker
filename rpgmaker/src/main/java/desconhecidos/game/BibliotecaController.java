package desconhecidos.game;

import java.util.ArrayList;

import Historia.Aventura;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
    
public class BibliotecaController {

    CadastroController sistemaCadastro = new CadastroController();

    Aventura workAventura;

    private static MainGame mainGame;
    
    @FXML
    private Button btnPrevious;
    
    @FXML
    private TableView<Aventura> tableAventuras;

    @FXML
    private TableColumn<Aventura, String> colunaTitulo;
    
    @FXML
    private Button btnPesquisar;
    
    @FXML
    private Button btnConfirmarAventura;
    
    @FXML
    private TextArea tfExibeDescricao;

    @FXML
    private TextField tfTitulo;

    ObservableList<Aventura> aventuras = FXCollections.observableArrayList();
    ArrayList<Aventura> aventuras2 = new ArrayList<>();
    
    @FXML
    void buscaAventura(ActionEvent event) {
        ObservableList<Aventura> aventuraTemporaria = FXCollections.observableArrayList();
        if(!tfTitulo.getText().isEmpty()){
            for(Aventura a: aventuras){
                if(a.getNome().equals(tfTitulo.getText())){
                    workAventura = a;
                    aventuraTemporaria.add(a);
                }
            }
        }if(!aventuraTemporaria.isEmpty()){
            tfExibeDescricao.setText(aventuraTemporaria.get(0).getDescricao());
            btnConfirmarAventura.setDisable(false);
        }
    }
    @FXML
    void previousAction(ActionEvent event) {
        changeScreen("main");
    }
    public void changeScreen(String scene){
        mainGame.changeScreen(scene);
    } 
    @FXML 
    protected void initialize(){
        for(Aventura a: sistemaCadastro.aventuras.values()){
            aventuras.add(a);
        }
        colunaTitulo.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
        MainGame.addOnChangeScreenListener(new MainGame.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen, Object userData){
                if(newScreen.equals("biblioteca")){
                    System.out.println("Entrando no Frame biblioteca...");
                    ArrayList<Aventura> temp = new ArrayList<>();
                    for(Aventura a: temp){
                        aventuras.add(a);
                    }
                   
                    tableAventuras.setItems(aventuras);
                    inicializeComponentes();
                    
                }
            }
        });
    }
    public void setMainGame(MainGame mainGame){
        this.mainGame = mainGame;
    }
    public void changeScreen(String scene, Object obj){
        mainGame.changeScreen(scene, workAventura);
    }    
    void inicializeComponentes(){
        String textoPadrao = "Digite o titulo na caixa de pesquisa para carregar a descriçao da aventura";
        tfExibeDescricao.setText(textoPadrao);
        tfExibeDescricao.setEditable(false);
        btnConfirmarAventura.setDisable(true);
    }
    @FXML
    void confirmar(ActionEvent event){
        if(!tfTitulo.getText().isEmpty()){
            changeScreen("game", workAventura);
        }
    }
    @FXML
    void acionaTfTitulo(MouseEvent event) {
        tfTitulo.setText("");
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
