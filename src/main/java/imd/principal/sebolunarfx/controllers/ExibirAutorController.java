package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Produto;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;

public class ExibirAutorController extends MenuController{
    @FXML
    private Label lbMsgErro;

    @FXML
    private TextField txtAutor;

    @FXML
    private Button btnBuscarAutor;

    @FXML
    private ListView <String> listViewAutor;

    private ObservableList<String> items;

    public boolean validarDados(){
        String autor = txtAutor.getText();

        return !autor.isBlank();
    }

    public boolean atualizarDados() {
        String autor;
        autor = txtAutor.getText();

        ArrayList<Produto> encontrados = Operacoes.exibirPorAutor(autor);

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
    protected void btnBuscarAutorClick(){
        if(!validarDados()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha o campo!");
            alert.showAndWait();
        }else{
            if(!atualizarDados()){
                lbMsgErro.setText("Produto não encontrado!");
            } else {
                lbMsgErro.setText("");
            }
            //Reseta o campo
            txtAutor.setText("");
        }
    }

    @FXML
    protected void initialize(){
        menu.toFront();
        btnBuscarAutor.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        items = FXCollections.observableArrayList();
        listViewAutor.setItems(items);
    }

    @FXML
    public void limparCampos(){
        lbMsgErro.setText("");
    }
}
