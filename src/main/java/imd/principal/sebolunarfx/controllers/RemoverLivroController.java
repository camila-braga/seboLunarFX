package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class RemoverLivroController extends MenuController{

    @FXML
    private Label lbRemoverLivro, lbAutor, lbTitulo, lbConservacao, lbEditora, lbAnoPublicacao, lbMsgErro;

    @FXML
    private HBox hBox2, hBox3, hBox4, hBox5, hBox6, hBox7, hBox8;

    @FXML
    private VBox vBox4, vBox5, vBox6, vBox7;

    @FXML
    private TextField txtAutor, txtTitulo, txtEditora, txtAnoPublicacao;

    @FXML
    private ChoiceBox<String> cboxEstado;

    @FXML
    private Button btnRemoverLivro;

    @FXML
    protected void onBtnRemoverLivro() throws IOException {
        String autor, titulo, editora, ano, conservacao;

        autor = txtAutor.getText();
        titulo = txtTitulo.getText();
        conservacao = cboxEstado.getSelectionModel().getSelectedItem();
        editora = txtEditora.getText();
        ano = txtAnoPublicacao.getText();

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
        txtAutor.setText("");
        txtTitulo.setText("");
        //cboxEstado.setText("");
        txtEditora.setText("");
        txtAnoPublicacao.setText("");
    }

    @FXML
    protected void initialize(){
        btnRemoverLivro.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        cboxEstado.getItems().addAll("NOVO", "SEMINOVO", "USADO");
    }

}
