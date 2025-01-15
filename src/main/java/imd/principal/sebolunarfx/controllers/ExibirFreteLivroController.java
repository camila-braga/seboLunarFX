package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Livro;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ExibirFreteLivroController extends MenuController{

    @FXML
    private HBox hBox2, hBox3, hBox4, hBox5;

    @FXML
    private VBox vBox4, vBox5;

    @FXML
    private Label lbValorFrete, lbTituloFrete, lbZona, lbMsgErro;

    @FXML
    private TextField txtTituloFrete, txtZona;

    @FXML
    private Button btnCalcularFreteLivro;

    @FXML
    protected void btnCalcularFreteLivroClick() throws IOException {
        String titulo, zona;

        titulo = txtTituloFrete.getText();
        zona = txtZona.getText();

        if(!titulo.isEmpty() && !zona.isEmpty() ){
            //Verifica se existe no banco de dados

            //Se não existe, exibe mensagem de erro:
            lbMsgErro.setText("Produto não encontrado!");

            //reseta os campos
            txtTituloFrete.setText("");
            txtZona.setText("");

        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha todos os campos!");
            alert.showAndWait();
        }
    }

    @FXML
    protected void initialize(){
        btnCalcularFreteLivro.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
    }
}