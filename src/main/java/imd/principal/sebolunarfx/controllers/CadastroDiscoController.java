package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.MainApplication;
import imd.principal.sebolunarfx.model.EstadoConservacao;
import imd.principal.sebolunarfx.model.FormatoDisco;
import imd.principal.sebolunarfx.model.PesoProduto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.*;

import java.io.IOException;

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
    protected void onBtnCadastrarDisco() throws IOException{
        String cantor, titulo;
        String conservacao;
        String faixas, anoGravacao;
        String formato;
        String peso;

        cantor = txtCantor.getText();
        titulo = txtTitulo.getText();
        peso = txtPeso.getText();
        conservacao = txtConservacao.getText();
        faixas = txtFaixas.getText();
        anoGravacao = txtAnoGravacao.getText();
        formato = txtFormato.getText();

        if(!cantor.isEmpty() && !titulo.isEmpty() &&!peso.isEmpty() && !conservacao.isEmpty() && !faixas.isEmpty() && !anoGravacao.isEmpty() &&!formato.isEmpty()){
            //Faz o cadastro

            //Limpando os campos de preenchimento:
            limparCampos();

            //Mensagem de sucesso
            lbMensagemSucesso.setText("Disco cadastrado!");

        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha todos os campos!");
            alert.showAndWait();
        }
    }

    @FXML
    protected void limparCampos(){
        txtCantor.setText("");
        txtTitulo.setText("");
        txtPeso.setText("");
        txtConservacao.setText("");
        txtFaixas.setText("");
        txtAnoGravacao.setText("");
        txtFormato.setText("");
    }

    @FXML
    protected void initialize(){
        btnCadastrarDisco.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
    }


}
