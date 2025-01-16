package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.EstadoConservacao;
import imd.principal.sebolunarfx.model.FormatoDisco;
import imd.principal.sebolunarfx.model.PesoProduto;
import imd.principal.sebolunarfx.utils.Operacoes;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

import static imd.principal.sebolunarfx.model.PesoProduto.*;


public class CadastroDiscoController extends MenuController{

    @FXML
    private VBox vBox4, vBox5, vBox6, vBox7;

    @FXML
    private HBox hBox2, hBox3, hBox4, hBox5, hBox6, hBox7, hBox8, hBox9, hBox10;

    @FXML
    private Label lbCadDisco, lbCantor, lbTitulo, lbPeso, lbConservacao, lbFaixas, lbAnoGravacao, lbFormato, lbMensagemSucesso;

    @FXML
    private TextField txtCantor, txtTitulo, txtFaixas, txtAnoGravacao;

    @FXML
    private ChoiceBox<String> cboxPeso, cboxEstado, cboxFormato ;

    @FXML
    private Button btnCadastrarDisco;

    @FXML
    protected void limparCampos(){
        txtCantor.setText("");
        txtTitulo.setText("");
        //cboxPeso.
        //cboxEstado.;
        txtFaixas.setText("");
        txtAnoGravacao.setText("");
        //cboxFormato.;
    }

    @FXML
    protected void onBtnCadastrarDisco() throws IOException{
        String cantor, titulo, conservacao, faixas, anoGravacao, formato, peso;

        cantor = txtCantor.getText();
        titulo = txtTitulo.getText();
        peso = cboxPeso.getSelectionModel().getSelectedItem();
        conservacao = cboxEstado.getSelectionModel().getSelectedItem();
        faixas = txtFaixas.getText();
        anoGravacao = txtAnoGravacao.getText();
        formato = cboxFormato.getSelectionModel().getSelectedItem();

        boolean check = checagem(cantor, titulo, peso, conservacao, faixas, anoGravacao, formato);

        if(check){
            //Faz o cadastro
            Operacoes.cadastrarDisco(cantor, titulo, peso, conservacao, faixas, anoGravacao, formato);

            //Limpa os campos de preenchimento:
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
    protected boolean checagem( String cantor, String titulo, String peso, String conservacao, String faixas, String anoGravacao, String formato){
        boolean resultado = false;
        if(!cantor.isEmpty()){
            if(!titulo.isEmpty()){
                if(!peso.isEmpty()){
                    if(!conservacao.isEmpty()){
                        if(!faixas.isEmpty()){
                            if(!anoGravacao.isEmpty()){
                                if(!formato.isEmpty()){
                                    resultado = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return resultado;
    }

    @FXML
    protected void initialize(){
        btnCadastrarDisco.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        cboxPeso.getItems().addAll("A", "B", "C", "D", "E", "F");
        cboxEstado.getItems().addAll("NOVO", "SEMINOVO", "USADO");
        cboxFormato.getItems().addAll("LP", "EP", "SINGLE");
    }

}
