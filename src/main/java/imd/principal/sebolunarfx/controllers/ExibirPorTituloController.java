package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Livro;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ExibirPorTituloController extends MenuController{

    @FXML
    private HBox hBox2, hBox3, hBox4;

    @FXML
    private VBox vBox4, vBox5;

    @FXML
    private Label lbExibirPorTitulo, lbPorTitulo, lbListaPorTitulo, lbMsgSucesso;

    @FXML
    private TextField txtPorTitulo;

    @FXML
    private Button btnBuscarPorTitulo;

    @FXML
    private ListView <Livro> listViewPorTitulo;

    @FXML
    protected void btnBuscarPorTituloClick() throws IOException {
        String titulo;

        titulo = txtPorTitulo.getText();

        if(!titulo.isEmpty()){
            //Verifica se existe no banco de dados

            //Se não existe, exibe mensagem de erro
            lbMsgSucesso.setText("Produto não encontrado!");

            //Reseta o campo
            txtPorTitulo.setText("");


        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha o campo!");
            alert.showAndWait();
        }
    }

    @FXML
    protected void initialize(){
        btnBuscarPorTitulo.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
    }
}
