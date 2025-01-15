package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.MainApplication;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import imd.principal.sebolunarfx.utils.*;
import javafx.stage.Stage;

import javax.swing.*;
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
    private MenuItem menuItemCadLivro, menuItemCadDisco, menuItemExAutor, menuItemExCantor, menuItemExTitulo, menuItemExTipoLivro, menuItemExTipoDisco, menuItemRemover, menuItemFreteLivro, menuItemFreteDisco;

    @FXML
    private ImageView luaLeftPic, luaRightPic, luaBottomPic;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Label msgInicial;

    @FXML
    protected void onCadLivroClick(ActionEvent e){
        MainApplication.mudarScene(1);
    }

    //teste. É pra ir pra pag intro
    @FXML
    protected void onCadDiscoClick(ActionEvent e){
        MainApplication.mudarScene(2);
    }

    @FXML
    protected void onExTipoLivroClick(ActionEvent e){
        MainApplication.mudarScene(3);
    }

    @FXML
    protected void onExTipoDiscoClick(ActionEvent e){
        MainApplication.mudarScene(20);
    }

    @FXML
    protected void onExAutorClick(ActionEvent e){
        MainApplication.mudarScene(20);
    }

    @FXML
    protected void onExCantorClick(ActionEvent e){
        MainApplication.mudarScene(20);
    }

    @FXML
    protected void onExTituloClick(ActionEvent e){
        MainApplication.mudarScene(20);
    }
    @FXML
    protected void onRemoverClick(ActionEvent e){
        MainApplication.mudarScene(20);
    }

    @FXML
    protected void onFreteLivroClick(ActionEvent e){
        MainApplication.mudarScene(20);
    }

    @FXML
    protected void onFreteDiscoClick(ActionEvent e){
        MainApplication.mudarScene(20);
    }






}