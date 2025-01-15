package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Produto;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class ExibirTipoDiscoController extends MenuController{
    @FXML
    private HBox hBox3, hBox4;

    @FXML
    private Label lbDiscoCadastrados, lbMsgErro;

    @FXML
    private ListView<Produto> listView;

    @FXML
    private void exibirDiscos(){
        ArrayList<Produto> encontrados = new ArrayList<>();

        encontrados = Operacoes.exibirProdutos("Disco");

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
