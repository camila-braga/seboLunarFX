package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Livro;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class ExibirTipoLivroController extends MenuController{
    @FXML
    private HBox hBox3, hBox4;

    @FXML
    private Label lbLivrosCadastrados;

    @FXML
    private ListView <Livro> listView;
}
