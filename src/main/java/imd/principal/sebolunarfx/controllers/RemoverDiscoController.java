package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class RemoverDiscoController extends MenuController{

    @FXML
    private Label lbRemoverDisco, lbCantor, lbTitulo, lbConservacao, lbAnoGravacao, lbFormato, lbMsgErro;

    @FXML
    private HBox hBox2, hBox3, hBox4, hBox5, hBox6, hBox7, hBox8;

    @FXML
    private VBox vBox4, vBox5, vBox6;

    @FXML
    private TextField txtCantor, txtTitulo, txtAnoGravacao;

    @FXML
    private ChoiceBox<String> cboxEstado, cboxFormato;

    @FXML
    private Button btnRemoverDisco;

    @FXML
    protected void onBtnRemoverDisco() throws IOException {
        String cantor, titulo, editora, ano, conservacao, formato;

        cantor = txtCantor.getText();
        titulo = txtTitulo.getText();
        conservacao = cboxEstado.getSelectionModel().getSelectedItem();
        ano = txtAnoGravacao.getText();
        formato = cboxFormato.getSelectionModel().getSelectedItem();

        /*if(){
            //Faz o cadastro

            //Limpa os campos de preenchimento:
            limparCampos();

            //Mensagem de erro
            lbMsgErro.setText("Produto não encontrado!");

        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha todos os campos!");
            alert.showAndWait();
        }*/
    }

    @FXML
    protected void limparCampos(){
        txtCantor.setText("");
        txtTitulo.setText("");
        //cboxEstado.setText("");
        txtAnoGravacao.setText("");
        //cboxFormato.setText("");
    }

    @FXML
    protected void initialize(){
        btnRemoverDisco.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        cboxEstado.getItems().addAll("NOVO", "SEMINOVO", "USADO");
        cboxFormato.getItems().addAll("LP", "EP", "SINGLE");
    }

}
