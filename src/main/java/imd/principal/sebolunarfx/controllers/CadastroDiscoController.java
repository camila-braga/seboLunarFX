package imd.principal.sebolunarfx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.*;

public class CadastroDiscoController extends MenuController{

    @FXML
    private VBox vBox4, vBox5, vBox6, vBox7, vBox8, vBox9, vBox10;

    @FXML
    private HBox hBox2, hBox3, hBox4, hBox5, hBox6, hBox7, hBox8, hBox9, hBox10;

    @FXML
    private Label lbCadDisco, lbCantor, lbTitulo, lbPeso, lbConservacao, lbFaixas, lbAnoGravacao, lbFormato, lbMensagemSucesso;

    @FXML
    private TextField txtCantor, txtTitulo, txtPeso, txtConservacao, txtFaixas, txtAnoGravacao, txtFormato;

    @FXML
    private Button btnCadastrarDisco;

    @FXML
    protected void onBtnCadastrarDisco(){
        //Colocar um if
        lbMensagemSucesso.setText("TESTE");

    };


}
