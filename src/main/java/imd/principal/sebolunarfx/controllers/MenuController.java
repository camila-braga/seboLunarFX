package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

public class MenuController {

    @FXML
    protected MenuBar menu;

    @FXML
    protected void initialize() {
        menu.toFront();
    }

    @FXML
    protected void onCadLivroClick(ActionEvent e){ MainApplication.mudarScene(1); }

    @FXML
    protected void onCadDiscoClick(ActionEvent e){ MainApplication.mudarScene(2); }

    @FXML
    protected void onExTipoLivroClick(ActionEvent e){ MainApplication.mudarScene(3); }

    @FXML
    protected void onExTipoDiscoClick(ActionEvent e){ MainApplication.mudarScene(4);}

    @FXML
    protected void onExAutorClick(ActionEvent e){ MainApplication.mudarScene(5); }

    @FXML
    protected void onExCantorClick(ActionEvent e){ MainApplication.mudarScene(6); }

    @FXML
    protected void onExTituloClick(ActionEvent e){
        MainApplication.mudarScene(7);
    }

    @FXML
    protected void onRemoverLivroClick(ActionEvent e){
        MainApplication.mudarScene(10);
    }

    @FXML
    protected void onRemoverDiscoClick(ActionEvent e){
        MainApplication.mudarScene(11);
    }

    @FXML
    protected void onFreteLivroClick(ActionEvent e){
        MainApplication.mudarScene(8);
    }

    @FXML
    protected void onFreteDiscoClick(ActionEvent e){
        MainApplication.mudarScene(9);
    }
}