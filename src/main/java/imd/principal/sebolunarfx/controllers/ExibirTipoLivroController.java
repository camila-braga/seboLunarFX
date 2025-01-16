package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Produto;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.util.ArrayList;

public class ExibirTipoLivroController extends MenuController{
    @FXML
    private Label lbMsgErro;

    @FXML
    private ListView <String> listView;

    private ObservableList<String> items;

    public void initialize() {
        items = FXCollections.observableArrayList();
        listView.setItems(items);
    }

    public void atualizarDados() {
        ArrayList<Produto> encontrados = Operacoes.exibirProdutosLivro();

        if (encontrados.isEmpty()) {
            lbMsgErro.setText("Não existem livros cadastrados!");
        } else {
            items.clear();
            for (Produto p : encontrados) {
                items.add(p.toString());
            }
        }
    }
}
