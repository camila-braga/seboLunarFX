package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Produto;
import imd.principal.sebolunarfx.utils.Operacoes;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class ExibirCantorController extends MenuController{

    @FXML
    private HBox hBox2, hBox3, hBox4;

    @FXML
    private VBox vBox4, vBox5;

    @FXML
    private Label lbExibirCantor, lbCantor, lbListaCantor, lbMsgErro;

    @FXML
    private TextField txtCantor;

    @FXML
    private Button btnBuscarCantor;

    @FXML
    private ListView <Produto> listViewCantor;

    @FXML
    protected void btnBuscarCantorClick() throws IOException {
        String cantor;

        cantor = txtCantor.getText();

        if(!cantor.isEmpty()){
            //Verifica se existe no banco de dados
            ArrayList<Produto> encontrados = new ArrayList<>();

            encontrados = Operacoes.exibirPorAutorCantorTitulo(cantor, "tipoAutorCantor");

            if(encontrados.isEmpty()){
                lbMsgErro.setText("Produto não encontrado!");
            }else{
                listViewCantor = new ListView<>();

                for(Produto p : encontrados){
                    listViewCantor.getItems().add(p);
                }
            }
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