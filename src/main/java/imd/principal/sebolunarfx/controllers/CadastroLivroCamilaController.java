package imd.principal.sebolunarfx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CadastroLivroCamilaController {
    //Interface do Menu
    @FXML
    private VBox vBox1, vBox2, vBox3;

    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox hBox1;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu menuCadastrar, menuExibir, menuTipo, menuRemover, menuFrete;

    @FXML
    private MenuItem menuItemCadLivro, menuItemCadDisco, menuItemExAutor, menuItemExCantor, menuItemExTitulo, menuItemExTipoLivro, menuItemExTipoDisco, menuItemFreteLivro, menuItemFreteDisco;

    @FXML
    private ImageView luaLeftPic, luaRightPic, luaBottomPic;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Label msgInicial;


    //Novos para cadastro de livros
    @FXML
    private VBox vBox4, vBox5, vBox6, vBox7, vBox8, vBox9, vBox10, vBox11;

    @FXML
    private HBox hBox2, hBox3, hBox4, hBox5, hBox6, hBox7, hBox8, hBox9, hBox10, hBox11;

    @FXML
    private Label lbCadLivro, lbaAutor, lbTitulo, lbPeso, lbConservacao, lbEditora, lbPaginas, lbAnoPublicacao, lbGeneroLiterario, lbMensagemSucesso;

    @FXML
    private TextField txtAutor, txtTitulo, txtPeso, txtConservacao, txtEditora, txtPaginas, txtAnoPublicacao, txtGeneroLiterario;

    @FXML
    private Button btnCadastrarLivro;

}
