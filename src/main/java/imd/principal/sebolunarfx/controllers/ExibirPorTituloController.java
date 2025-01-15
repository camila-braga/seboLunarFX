package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Livro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ExibirPorTituloController extends MenuController{

    @FXML
    private HBox hBox2, hBox3, hBox4;

    @FXML
    private VBox vBox4, vBox5;

    @FXML
    private Label lbExibirPorTitulo, lbPorTitulo, lbListaPorTitulo, lbMsgSucesso;

    @FXML
    private TextField txtPorTitulo;

    @FXML
    private Button btnBuscarPorTitulo;

    @FXML
    private ListView <Livro> listViewPorTitulo;

    @FXML
    protected void btnBuscarPorTituloClick(){
        //Colocar um if
        lbMsgSucesso.setText("TESTE");
    }
}
