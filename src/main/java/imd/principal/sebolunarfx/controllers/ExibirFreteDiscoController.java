package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Disco;
import imd.principal.sebolunarfx.model.Zona;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class ExibirFreteDiscoController extends MenuController{

    @FXML
    private Label lbMsgErro;

    @FXML
    private TextField txtTituloFrete;

    @FXML
    private ChoiceBox<String> cboxZona;

    @FXML
    private ListView <String> listFreteDisco;

    private ObservableList<String> items;

    @FXML
    private Button btnCalcularFreteDisco;

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
        ArrayList<Disco> encontrados = Operacoes.exibirProdutosDisco();

        String titulo = txtTituloFrete.getText();
        String zona_str = cboxZona.getSelectionModel().getSelectedItem();

        if(zona_str == null || zona_str.isBlank() ){
            return false;
        }
        Zona zona = Zona.valueOf(zona_str);

        items.clear();
        lbMsgErro.setText(" ");
        for (Disco p : encontrados) {
            if(p.getTitulo().equals(titulo)){
                items.add("Frete: R$" + p.calcularFrete(zona) + "  |  " + p);
            }
        }

        return !items.isEmpty();
    }

    @FXML
    protected void btnCalcularFreteDiscoClick(){
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
    }

    @FXML
    protected void initialize(){
        menu.toFront();
        btnCalcularFreteDisco.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        cboxZona.getItems().addAll("SUL", "NORTE");
        items = FXCollections.observableArrayList();
        listFreteDisco.setItems(items);
    }
}