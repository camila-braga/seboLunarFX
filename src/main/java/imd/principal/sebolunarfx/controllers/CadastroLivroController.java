package imd.principal.sebolunarfx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CadastroLivroController extends MenuController {

    @FXML
    private VBox vBox4, vBox5, vBox6, vBox7, vBox8, vBox9, vBox10, vBox11;

    @FXML
    private HBox hBox2, hBox3, hBox4, hBox5, hBox6, hBox7, hBox8, hBox9, hBox10, hBox11;

    @FXML
    private Label lbCadLivro, lbAutor, lbTitulo, lbPeso, lbConservacao, lbEditora, lbPaginas, lbAnoPublicacao, lbGeneroLiterario, lbMensagemSucesso;

    @FXML
    private TextField txtAutor, txtTitulo, txtPeso, txtConservacao, txtEditora, txtPaginas, txtAnoPublicacao, txtGeneroLiterario;

    @FXML
    private Button btnCadastrarLivro;

    @FXML
    protected void onBtnCadastrarLivro() throws IOException {
        String autor, titulo, editora, genero;
        String conservacao;
        String paginas, anoPublicacao;
        String peso;

        autor = txtAutor.getText();
        titulo = txtTitulo.getText();
        peso = txtPeso.getText();
        conservacao = txtConservacao.getText();
        editora = txtEditora.getText();
        paginas = txtPaginas.getText();
        anoPublicacao = txtAnoPublicacao.getText();
        genero = txtGeneroLiterario.getText();

        if(!autor.isEmpty() && !titulo.isEmpty() &&!peso.isEmpty() && !conservacao.isEmpty() && !editora.isEmpty() && !paginas.isEmpty() &&!anoPublicacao.isEmpty() &&!genero.isEmpty()){
            //Faz o cadastro

            //Limpando os campos de preenchimento:
            limparCampos();

            //Mensagem de sucesso
            lbMensagemSucesso.setText("Livro cadastrado!");

        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha todos os campos!");
            alert.showAndWait();
        }
    }

    @FXML
    protected void limparCampos(){
        txtAutor.setText("");
        txtTitulo.setText("");
        txtPeso.setText("");
        txtConservacao.setText("");
        txtEditora.setText("");
        txtPaginas.setText("");
        txtAnoPublicacao.setText("");
        txtGeneroLiterario.setText("");
    }

    @FXML
    protected void initialize(){
        btnCadastrarLivro.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
    }





}
