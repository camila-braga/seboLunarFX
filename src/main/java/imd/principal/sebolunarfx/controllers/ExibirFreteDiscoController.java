package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Produto;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ExibirFreteDiscoController extends MenuController{

    @FXML
    private HBox hBox2, hBox3, hBox4;

    @FXML
    private VBox vBox4;

    @FXML
    private Label lbValorFrete, lbTituloFrete, lbZona, lbMsgErro;

    @FXML
    private TextField txtTituloFrete;

    @FXML
    private ChoiceBox<String> cboxZona;

    @FXML
    private ListView <Produto> listFreteDisco;

    @FXML
    private Button btnCalcularFreteDisco;

    @FXML
    protected void btnCalcularFreteDiscoClick() throws IOException {
        String titulo, zona;

        titulo = txtTituloFrete.getText();
        zona = cboxZona.getSelectionModel().getSelectedItem();

        if(!titulo.isEmpty() && !zona.isEmpty() ){
            //Verifica se existe no banco de dados

            //Se não existe, exibe mensagem de erro:
            lbMsgErro.setText("Produto não encontrado!");

            //reseta os campos
            txtTituloFrete.setText("");
            //cboxZona.setText("");

        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha todos os campos!");
            alert.showAndWait();
        }
    }

    @FXML
    protected void initialize(){
        btnCalcularFreteDisco.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        cboxZona.getItems().addAll("SUL", "NORTE");
    }
}