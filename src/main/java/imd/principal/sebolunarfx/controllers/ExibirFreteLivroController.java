package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Livro;
import imd.principal.sebolunarfx.model.Zona;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;

public class ExibirFreteLivroController extends MenuController{

    @FXML
    private Label lbMsgErro;

    @FXML
    private TextField txtTituloFrete;

    @FXML
    private ChoiceBox<String> cboxZona;

    @FXML
    private ListView <String> listFreteLivro;

    private ObservableList<String> items;

    @FXML
    private Button btnCalcularFreteLivro;

    public boolean validarDados(){
        String titulo = txtTituloFrete.getText();
        String zona = cboxZona.getSelectionModel().getSelectedItem();

        boolean valTitulo = !titulo.isBlank();
        boolean valEnums = false;

        try {
            Zona.valueOf(zona);
            valEnums = true;
        } catch (IllegalArgumentException _){
        }

        return valTitulo && valEnums;
    }

    public boolean atualizarDados() {
        ArrayList<Livro> encontrados = Operacoes.exibirProdutosLivro();

        String titulo = txtTituloFrete.getText();
        String zona_str = cboxZona.getSelectionModel().getSelectedItem();

        if(zona_str == null || zona_str.isBlank() ){
            return false;
        }
        Zona zona = Zona.valueOf(zona_str);

        items.clear();
        lbMsgErro.setText(" ");
        for (Livro p : encontrados) {
            if(p.getTitulo().equals(titulo)){
                items.add("Frete: R$" + p.calcularFrete(zona) + "  |  " + p);
            }
        }

        return !items.isEmpty();
    }

    @FXML
    protected void btnCalcularFreteLivroClick(){
        if(!validarDados()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha todos os campos!");
            alert.showAndWait();
        }else{

            if (!atualizarDados()){
                limparCampos();
                lbMsgErro.setText("Produto não encontrado!");
            }
        }
    }

    @FXML
    public void limparCampos(){
        txtTituloFrete.setText("");
        cboxZona.setValue("");
        lbMsgErro.setText("");
        items.clear();
    }

    @FXML
    protected void initialize(){
        menu.toFront();
        btnCalcularFreteLivro.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        cboxZona.getItems().addAll("SUL", "NORTE");
        items = FXCollections.observableArrayList();
        listFreteLivro.setItems(items);
    }
}