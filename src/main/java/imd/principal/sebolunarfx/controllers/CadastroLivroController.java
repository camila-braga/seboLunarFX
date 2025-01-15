package imd.principal.sebolunarfx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
    protected void onBtnCadastrarLivro(){
        //Colocar um if
        lbMensagemSucesso.setText("TESTE");
    }





}
