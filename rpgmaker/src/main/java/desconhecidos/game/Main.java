package desconhecidos.game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage palco) throws Exception {
        final Effect r = new Reflection();
        final VBox raiz = new VBox(30);
        final HBox hbTopo = new HBox(5);
        final TextField txtNome = new TextField();
        final Button btnAcao = new Button("Enviar");
        final Label lblMensagem = new Label();
        raiz.setTranslateX(10);
        raiz.setTranslateY(10);
        lblMensagem.setText("Digite seu nome e clique no botão");
        hbTopo.getChildren().addAll(txtNome, btnAcao);
        raiz.getChildren().addAll(hbTopo, lblMensagem);
        lblMensagem.setEffect(r);
        Scene cena = new Scene(raiz, 250, 100);
        palco.setTitle("Aplicação usando código Java");
        palco.setScene(cena);
        palco.show();

        btnAcao.setOnAction(e -> lblMensagem.setText("Olá, " + txtNome.getText() + ", bem vindo!"));
    }
}