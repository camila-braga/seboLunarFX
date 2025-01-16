package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Produto;
import imd.principal.sebolunarfx.utils.Operacoes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ExibirTipoLivroController extends MenuController{
    @FXML
    private HBox hBox3, hBox4;

    @FXML
    private VBox vBox1;

    @FXML
    private Label lbLivrosCadastrados, lbMsgErro;

    @FXML
    private ListView <Produto> listView;


    private void exibirLivros(){
        ArrayList<Produto> encontrados = new ArrayList<>();

        encontrados = Operacoes.exibirProdutos("Livro");

        if(encontrados.isEmpty()){
            lbMsgErro.setText("Produto não encontrado!");
        }else{
            listView = new ListView<>();

            for(Produto p : encontrados){
                listView.getItems().add(p);
            }
        }
    }
}
