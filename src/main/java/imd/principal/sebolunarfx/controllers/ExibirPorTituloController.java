package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Produto;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;

public class ExibirPorTituloController extends MenuController{

    @FXML
    private Label lbMsgErro;

    @FXML
    private TextField txtPorTitulo;

    @FXML
    private Button btnBuscarPorTitulo;

    @FXML
    private ListView <String> listViewPorTitulo;

    private ObservableList<String> items;

    public boolean validarDados(){
        String cantor = txtPorTitulo.getText();

        return !cantor.isBlank();
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
            txtPorTitulo.setText("");
        }
    }

    @FXML
    protected void initialize(){
        menu.toFront();
        btnBuscarPorTitulo.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        items = FXCollections.observableArrayList();
        listViewPorTitulo.setItems(items);
    }

    @FXML
    public void limparCampos(){
        lbMsgErro.setText("");
    }
}
