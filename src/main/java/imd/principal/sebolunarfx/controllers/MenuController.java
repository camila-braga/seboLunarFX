package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import imd.principal.sebolunarfx.utils.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

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

   /* @FXML
    protected void menuCadLivro(ActionEvent event) throws IOException {

        //Carrega o tela do menu
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("CadastroLivroCamila.fxml"));

        //Cria uma nova cena para cadastrar livro
        Scene cadLivro = new Scene(fxmlLoader.load(), 1024, 640);

        //Pega o a janela atual (stage) e altera para a cena do menu
        Stage stage = (Stage) menuItemCadLivro.getWindow();
        stage.setScene(cadLivro);
    }*/

}