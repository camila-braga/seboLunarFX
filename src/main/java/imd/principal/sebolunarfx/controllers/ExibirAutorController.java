package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Produto;
import imd.principal.sebolunarfx.utils.Operacoes;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;

public class ExibirAutorController extends MenuController{

    @FXML
    private Label lbMsgErro;

    @FXML
    private TextField txtAutor;

    @FXML
    private Button btnBuscarAutor;

    @FXML
    private ListView <Produto> listViewAutor;

    @FXML
    protected void btnBuscarAutorClick() throws IOException {
        String autor;

        autor = txtAutor.getText();

        if(!autor.isEmpty()){
            //Verifica se existe no banco de dados
            ArrayList<Produto> encontrados = new ArrayList<>();

            encontrados = Operacoes.exibirPorAutorCantorTitulo(autor, "tipoAutorCantor");

            if(encontrados.isEmpty()){
                lbMsgErro.setText("Produto não encontrado!");
            }else{
                listViewAutor = new ListView<>();

                for(Produto p : encontrados){
                    listViewAutor.getItems().add(p);
                }
            }
            //reseta os campos
            txtAutor.setText("");


        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha o campo!");
            alert.showAndWait();
        }
    }

    @FXML
    protected void initialize(){
        btnBuscarAutor.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
    }
}
