package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Produto;
import imd.principal.sebolunarfx.utils.Operacoes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class ExibirPorTituloController extends MenuController{

    @FXML
    private HBox hBox2, hBox3, hBox4;

    @FXML
    private VBox vBox4, vBox5;

    @FXML
    private Label lbExibirPorTitulo, lbPorTitulo, lbListaPorTitulo, lbMsgErro;

    @FXML
    private TextField txtPorTitulo;

    @FXML
    private Button btnBuscarPorTitulo;

    @FXML
    private ListView <String> listViewPorTitulo;

    private ObservableList<String> items;

    @FXML
    protected void initialize(){
        btnBuscarPorTitulo.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        items = FXCollections.observableArrayList();
        listViewPorTitulo.setItems(items);
    }

    public boolean atualizarDados() {
        String titulo;
        titulo = txtPorTitulo.getText();

        ArrayList<Produto> encontrados = Operacoes.exibirPorTitulo(titulo);

        items.clear();
        if (encontrados.isEmpty()) {
            return false;
        } else {
            for (Produto p : encontrados) {
                items.add(p.toString());
            }
            return true;
        }
    }

    @FXML
    protected void btnBuscarPorTituloClick(){
        String titulo;

        titulo = txtPorTitulo.getText();

        if(!titulo.isEmpty()){
            if(!atualizarDados()){
                lbMsgErro.setText("Produto não encontrado!");
            } else{
                lbMsgErro.setText("");
            }
            //Reseta o campo
            txtPorTitulo.setText("");

        } else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha o campo!");
            alert.showAndWait();
        }
    }
}