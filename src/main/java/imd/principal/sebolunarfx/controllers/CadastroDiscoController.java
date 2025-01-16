package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CadastroDiscoController extends MenuController{
    @FXML
    private Label lbMensagemSucesso;

    @FXML
    private Spinner<Integer> numFaixas, anoGravacao;

    @FXML
    private TextField txtCantor, txtTitulo;

    @FXML
    private ChoiceBox<String> cboxPeso, cboxEstado, cboxFormato ;

    @FXML
    private Button btnCadastrarDisco;

    @FXML
    protected void limparCampos(){
        txtCantor.setText("");
        txtTitulo.setText("");
        cboxPeso.setValue("");
        cboxEstado.setValue("");
        cboxFormato.setValue("");
        numFaixas.getValueFactory().setValue(1);
        anoGravacao.getValueFactory().setValue(2025);
    }

    @FXML
    protected void onBtnCadastrarDisco() {
        String cantor, titulo, conservacao, formato, peso;

        cantor = txtCantor.getText();
        titulo = txtTitulo.getText();
        peso = cboxPeso.getSelectionModel().getSelectedItem();
        conservacao = cboxEstado.getSelectionModel().getSelectedItem();
        formato = cboxFormato.getSelectionModel().getSelectedItem();

        Integer faixas = numFaixas.getValue();
        int ano =  anoGravacao.getValue();

        if(!cantor.isEmpty() && !titulo.isEmpty()){
            //Faz o cadastro
            Operacoes.cadastrarDisco(cantor, titulo, peso, conservacao, faixas, ano, formato);

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
    protected void initialize(){
        btnCadastrarDisco.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        cboxPeso.getItems().addAll("A", "B", "C", "D", "E", "F");
        cboxEstado.getItems().addAll("NOVO", "SEMINOVO", "USADO");
        cboxFormato.getItems().addAll("LP", "EP", "SINGLE");
    }
}
