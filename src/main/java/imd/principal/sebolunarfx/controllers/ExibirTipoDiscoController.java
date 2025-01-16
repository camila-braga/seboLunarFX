package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.DAO.BancoDAO;
import imd.principal.sebolunarfx.model.Produto;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class ExibirTipoDiscoController extends MenuController{
    @FXML
    private HBox hBox3, hBox4;

    @FXML
    private Label lbDiscoCadastrados, lbMsgErro;

    @FXML
    private ListView<String> listView;

    private ObservableList<String> items;

    public void initialize() {
        items = FXCollections.observableArrayList();

        listView.setItems(items);

    }

    public void atualizarDados() {
        ArrayList<Produto> encontrados = Operacoes.exibirProdutos("Disco");

        if (encontrados.isEmpty()) {
            lbMsgErro.setText("Produto não encontrado!");
        } else {
            items.clear();
            for (Produto p : encontrados) {
                System.out.println(p);
                items.add(p.toString());
            }
        }
    }

}
