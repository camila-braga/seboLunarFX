package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Livro;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ExibirCantorController extends MenuController{

    @FXML
    private HBox hBox2, hBox3, hBox4;

    @FXML
    private VBox vBox4, vBox5;

    @FXML
    private Label lbExibirCantor, lbCantor, lbListaCantor, lbMsgSucesso;

    @FXML
    private TextField txtCantor;

    @FXML
    private Button btnBuscarCantor;

    @FXML
    private ListView <Livro> listViewCantor;

    @FXML
    protected void btnBuscarCantorClick() throws IOException {
        String autor;

        autor = txtCantor.getText();

        if(!autor.isEmpty()){
            //Verifica se existe no banco de dados

            //Se não existe, exibe mensagem de erro
            lbMsgSucesso.setText("Produto não encontrado!");

            //Reseta o campo
            txtCantor.setText("");


        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha o campo!");
            alert.showAndWait();
        }
    }

    @FXML
    protected void initialize(){
        btnBuscarCantor.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
    }

}