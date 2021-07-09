
package desconhecidos.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map.Entry;

import Historia.Aventura;
import Historia.Possibilidade;
import bd.WriteAndRead;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PossibilidadesController {

    private Possibilidade newNodeP;

    

    private static MainGame mainGame;

    private Aventura newAventura;

    @FXML   
    private TableView possibilidadesView;
    @FXML
    private Button btnPrevious;
    @FXML 
    private TextArea textDescricao;
    @FXML
    private TextArea textOp1;
    @FXML
    private TextArea textOp2;
    @FXML
    private TextArea textOp3;

    @FXML
    private Label labelApontador;
    @FXML
    private TextField tfPesquisaId;
    @FXML
    private Button btnFinalizar;

    @FXML
    private Button btnConcluirPossibilidade;

    @FXML
    private ImageView imageViewSom;

    @FXML
    private Button btnSom;
    @FXML
    private TableView<Possibilidade> tableViewComple;
    private ObservableList<Possibilidade> possibiliDataComple = FXCollections.observableArrayList();
    @FXML
    private TableView<Possibilidade> tableViewIncom;
    private ObservableList<Possibilidade> possibiliDataIncomple = FXCollections.observableArrayList();

    /*
    @FXML
    private TableView<?> tableViewIncom;
    @FXML
    private TableColumn<?, ?> possibiliIncompleta;
    */

    @FXML
    private TableColumn<Possibilidade, String> possibiliCompleta;
    @FXML
    private TableColumn<Possibilidade, String> possibiliIncompleta;

    @FXML
    private Button editarPossibilidade;

    private String workId;

    /**
     * ESSE MÉTODO É PADRÃO DO JAVAFX
     * É CHAMADO TODA VEZ QUE SE CRIA UM LOADER COM O FXML
     * ESTÁ SENDO CRIADO O LOADER NA CLASSE MAINGAME
     * O METODO É NOTIFICADO E TODA VEZ QUE ENTRA CENA RODA ALGUM SCRIPT
     */
    @FXML 
    protected void initialize(){
        possibiliCompleta.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
        possibiliIncompleta.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
        MainGame.addOnChangeScreenListener(new MainGame.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen, Object userData){
                if(newScreen.equals("possibilidades")){
                    tfPesquisaId.setText("");
                    System.out.println("Entrando no Frame Possibilidades...");
                    //AQUI DEVE SER IMPLEMENTADO A INTERAÇÃO COM A NOVA TELA 
                    newAventura = (Aventura) userData; 
                }
            }
        });
    }
    /**
     * AO CLICAR EM FINALIZAR VAI VERIFICAR SE A LISTA É VAZIA, CASO FOR VAI CADASTRAR DIRETO
     * CASO NÃO FOR, SÓ SERÁ CADASTRADO SE TIVER ALGO NA CAIXA DE PESQUISA
     * CADA POSSIBILIDADE CRIADA, IMPLICA EM ADICIONAR 3 PRÉ-POSSIBILIDADES EM UMA LISTA AUXILIAR
     * CONTENDO O ROVAVEL ID E A OPÇÃO QUE DÁ O SURGIMENTO DELE
     * 
     * É PRECISO CRIAR UM CHECKBOX PARA SABER QUANDO AQUELA POSSIBILIDADE É O FIM
     * @param event
     */
    @FXML
    void concluirPossibilidade(ActionEvent event){
        /**
         * apagar tudo que estiver dentro dos textField
         * apagar a frase apontadora (label de id: labelApontador)
         */
        btnConcluirPossibilidade.setDisable(true);
        btnFinalizar.setDisable(false);

        if(!(textDescricao.getText().isEmpty() || textOp1.getText().isEmpty() || textOp2.getText().isEmpty() || textOp3.getText().isEmpty())){
            if(Aventura.possibilidades.size() == 0){
                //PRIMEIRA POSSIBILIDADE
                newNodeP = new Possibilidade("0", textDescricao.getText(), textOp1.getText(), textOp2.getText(), textOp3.getText());
                newNodeP.setApontador(null);

                Aventura.addPossibilidade(newNodeP.getId(), newNodeP);
                Aventura.addPossibilidade(newNodeP.getId() + "1", new Possibilidade(newNodeP.getId() + "1", newNodeP.getMsgOpcao1()));
                Aventura.addPossibilidade(newNodeP.getId() + "2", new Possibilidade(newNodeP.getId() + "2", newNodeP.getMsgOpcao2()));
                Aventura.addPossibilidade(newNodeP.getId() + "3", new Possibilidade(newNodeP.getId() + "3", newNodeP.getMsgOpcao3()));

                textDescricao.setText("");
                labelApontador.setText("");
                textOp1.setText("");
                textOp2.setText("");
                textOp3.setText("");

                textDescricao.setEditable(false);
                labelApontador.setDisable(false);
                textOp1.setEditable(false);
                textOp2.setEditable(false);
                textOp3.setEditable(false);

                //A LISTA EH ATUALIZADA ANTES DE SER CHAMADA PELAS TABELAS
                atualizarTable();
                tableViewComple.setItems(getPossibiliDataComple());
                tableViewIncom.setItems(getPossibiliDataIncomple());

                btnConcluirPossibilidade.setDisable(true);
                btnFinalizar.setDisable(true);
            }else if(!workId.isEmpty()){
                for(Possibilidade p : Aventura.possibilidades.values()){
                    if(p.getId().equals(workId)){
                        if(p.getDescricao().isEmpty()){
                            p.setAttr(textDescricao.getText(), textOp1.getText(), textOp2.getText(), textOp3.getText());
                            //Aventura.addPossibilidade(p.getId(), p);

                            Aventura.addPossibilidade(p.getId() + "1", new Possibilidade(p.getId() + "1", p.getMsgOpcao1()));
                            Aventura.addPossibilidade(p.getId() + "2", new Possibilidade(p.getId() + "2", p.getMsgOpcao2()));
                            Aventura.addPossibilidade(p.getId() + "3", new Possibilidade(p.getId() + "3", p.getMsgOpcao3()));   
                            
                            textDescricao.setEditable(false);
                            labelApontador.setDisable(false);
                            textOp1.setEditable(false);
                            textOp2.setEditable(false);
                            textOp3.setEditable(false);
    
                            textDescricao.setText("");
                            labelApontador.setText("");
                            textOp1.setText("");
                            textOp2.setText("");
                            textOp3.setText("");
    
                            atualizarTable();
                            tableViewComple.setItems(getPossibiliDataComple());   
                            tableViewIncom.setItems(getPossibiliDataIncomple());  
                            
                           
                            
                        }else{
                            System.out.println("DescricaoPreenchida");
                        }
                    }else{
                        System.out.println("ID DIGITADO NÃO EXISTE");
                    }
                }
            }
        }else{
            System.out.println("Preencher campos para continuar..");
        }
    }
    void nextFrame(){
        changeScreen("possibilidades");
    }
    @FXML //ACAO DO BOTAO RETORNAR PRA TELA CADASTRO
    void previousFrame(ActionEvent event) {
        changeScreen("cadastro");
    }
    @FXML
    void buscarPossibilidade(ActionEvent event) {
        if(!tfPesquisaId.getText().isEmpty()){
            btnFinalizar.setDisable(false);
            btnConcluirPossibilidade.setDisable(false);
            labelApontador.setText(Aventura.possibilidades.get(tfPesquisaId.getText()).getApontador());
            workId = tfPesquisaId.getText();

            textDescricao.setText("");
            textOp1.setText("");
            textOp2.setText("");
            textOp3.setText("");

            textDescricao.setEditable(true);
            labelApontador.setDisable(true);
            textOp1.setEditable(true);
            textOp2.setEditable(true);
            textOp3.setEditable(true);

            //CASO JA EXISTA
            if(!Aventura.possibilidades.get(tfPesquisaId.getText()).getDescricao().isEmpty()){
                textDescricao.setEditable(false);
                labelApontador.setDisable(false);
                textOp1.setEditable(false);
                textOp2.setEditable(false);
                textOp3.setEditable(false);
                btnConcluirPossibilidade.setDisable(true);
                btnFinalizar.setDisable(true);
                textDescricao.setText(Aventura.possibilidades.get(workId).getDescricao());
                labelApontador.setText(Aventura.possibilidades.get(workId).getApontador()); 
                textOp1.setText(Aventura.possibilidades.get(workId).getMsgOpcao1());
                textOp2.setText(Aventura.possibilidades.get(workId).getMsgOpcao2());
                textOp3.setText(Aventura.possibilidades.get(workId).getMsgOpcao3());
            }
            tfPesquisaId.setText("");
        }else{
            System.out.println("Algo de errado não está certo");
        }
    }
    //CASO DESEJE PUXAR A INSTANCIA DE MAINGAME
    public void setMain(MainGame mainGame){
        this.mainGame = mainGame;
    }
    //METODO PRA MUDAR A CENA
    private void changeScreen(String scene){
        mainGame.changeScreen(scene);
    }
    //AQUI É A EXIBIÇÃO DAS POSSIBILIDADES NA TABELA
    public void atualizarTable(){
        for(Entry<String, Possibilidade> p: Aventura.possibilidades.entrySet()) {
            if(p.getValue().getDescricao() != "" && !encontrarPossibilidade(p.getValue(),"possibiliDataComple")){
                possibiliDataComple.add(p.getValue());
                //possibiliDataComple.sort();
                System.out.println(possibiliDataComple.size());
            }
            else if(p.getValue().getDescricao() == "" && !encontrarPossibilidade(p.getValue(),"possibiliDataIncomple")){
                possibiliDataIncomple.add(p.getValue());
                //possibiliDataIncomple.sorted();
                System.out.println(possibiliDataIncomple.size());
            }
        //VERIFICA SE NÃO TEM ID DUPLICADO NAS DUAS TABELAS
        }for(Possibilidade p: possibiliDataComple){
            for(Possibilidade r: possibiliDataIncomple){
                if(p.getId().equals(r.getId())){
                    possibiliDataIncomple.remove(r);
                }
            }
        }
    }
    private boolean encontrarPossibilidade(Possibilidade p, String nomeDaLista){
        ObservableList<Possibilidade> list = null;
        if(nomeDaLista.equals("possibiliDataComple")){
            list = possibiliDataComple;
        }else if(nomeDaLista.equals("possibiliDataIncomple")){
            list = possibiliDataIncomple;
        }
        for(Possibilidade q: list){
            if(q.equals(p)){
                return true;
            }
        }return false;
    } 
    /*private ObservableList<Possibilidade> selectionSort(ObservableList<Possibilidade> list){
        for(int i = 0; i < list.size(); i++){
            int menorId = i;

            for(int j = menorId + 1; j < list.size(); j++){
                if(Integer.parseInt(list.get(j).getId()) < Integer.parseInt(list.get(menorId).getId())){
                    menorId = j;
                }
            }
            if(menorId != i){
                Possibilidade var = list.get(i);
                list.set(i) = list.get(menorId);
            }
        }
        return null;
    }*/

    public ObservableList<Possibilidade> getPossibiliDataComple() {
		return this.possibiliDataComple;
	}

    public ObservableList<Possibilidade> getPossibiliDataIncomple(){
        return this.possibiliDataIncomple;
    }
    @FXML
    void editarPossibilidade(ActionEvent event) {

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
    }@FXML
    void finalizarAventura(ActionEvent event) throws IOException{
        WriteAndRead.gravarDados();
        changeScreen("biblioteca");

    }
}


    

