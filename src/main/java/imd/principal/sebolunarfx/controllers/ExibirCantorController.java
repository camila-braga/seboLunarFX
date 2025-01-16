package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Produto;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;

public class ExibirCantorController extends MenuController{
    @FXML
    private Label lbMsgErro;

    @FXML
    private TextField txtCantor;

    @FXML
    private Button btnBuscarCantor;

    @FXML
    private ListView <String> listViewCantor;

    private ObservableList<String> items;

    public boolean validarDados(){
        String cantor = txtCantor.getText();

        return !cantor.isBlank();
    }

    @FXML
    protected void initialize(){
        menu.toFront();
        btnBuscarCantor.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        items = FXCollections.observableArrayList();
        listViewCantor.setItems(items);
    }

    public boolean atualizarDados() {
        String cantor;
        cantor = txtCantor.getText();

        ArrayList<Produto> encontrados = Operacoes.exibirPorCantor(cantor);

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
    protected void btnBuscarCantorClick(){
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
            txtCantor.setText("");
        }
    }

    @FXML
    public void limparCampos(){
        lbMsgErro.setText("");
    }
}