package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Disco;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;

import java.util.ArrayList;

public class ExibirTipoDiscoController extends MenuController{

    @FXML
    private Label lbMsgErro;

    @FXML
    private ListView<String> listView;

    private ObservableList<String> items;


    public void initialize() {
        menu.toFront();
        items = FXCollections.observableArrayList();
        listView.setItems(items);
    }

    public void atualizarDados() {
        ArrayList<Disco> encontrados = Operacoes.exibirProdutosDisco();

        if (encontrados.isEmpty()) {
            lbMsgErro.setText("Não existem discos cadastrados!");
        } else {
            items.clear();
            for (Disco p : encontrados) {
                items.add(p.toString());
            }
        }
    }

    @FXML
    public void limparCampos(){
        if (Operacoes.exibirProdutosDisco().isEmpty()) {
            lbMsgErro.setText("Não existem discos cadastrados!");
        } else {
            lbMsgErro.setText("");
        }
        items.clear();
    }

}
