package desconhecidos.game;

import Historia.Aventura;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    
    @FXML
    void buscaAventura(ActionEvent event) {
        ObservableList<Aventura> aventuraTemporaria = FXCollections.observableArrayList();
        if(!tfTitulo.getText().isEmpty()){
            for(Aventura a: aventuras){
                if(a.getNome().equals(tfTitulo.getText())){
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
                    tableAventuras.setItems(aventuras);
                    inicializeComponentes();
                    
                }
            }
        });
    }
    public void setMainGame(MainGame mainGame){
        this.mainGame = mainGame;
    }
    public void changeScreen(String scene){
        mainGame.changeScreen(scene);
    }    
    void inicializeComponentes(){
        String textoPadrao = "Digite o titulo na caixa de pesquisa para carregar a descriçao da aventura";
        tfExibeDescricao.setText(textoPadrao);
        tfExibeDescricao.setEditable(false);
        btnConfirmarAventura.setDisable(true);
    }
    @FXML
    void confirmar(ActionEvent event){
        //PASSAR PRA OUTRA TELA (GAME)
    }
    @FXML
    void acionaTfTitulo(MouseEvent event) {
        tfTitulo.setText("");
    }



}
