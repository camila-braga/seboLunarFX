package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Livro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ExibirFreteLivroController extends MenuController{

    @FXML
    private HBox hBox2, hBox3, hBox4, hBox5;

    @FXML
    private VBox vBox4, vBox5;

    @FXML
    private Label lbValorFrete, lbTituloFrete, lbZona, lbMsgSucesso;

    @FXML
    private TextField txtTituloFrete, txtZona;

    @FXML
    private Button btnCalcularFreteLivro;

    @FXML
    protected void btnCalcularFreteLivroClick(){
        //Colocar um if
        lbMsgSucesso.setText("TESTE");
    }
}