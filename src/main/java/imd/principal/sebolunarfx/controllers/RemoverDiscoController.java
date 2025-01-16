package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RemoverDiscoController extends MenuController{
    @FXML
    private TextField txtCantor, txtTitulo;

    @FXML
    private Spinner<Integer> anoGravacao;

    @FXML
    private ChoiceBox<String> cboxEstado, cboxFormato;

    @FXML
    private Button btnRemoverDisco;

    @FXML
    private Label lbMsg;

    @FXML
    protected void onBtnRemoverDisco() {
        String cantor, titulo, conservacao, formato;
        int ano;

        cantor = txtCantor.getText();
        titulo = txtTitulo.getText();
        conservacao = cboxEstado.getSelectionModel().getSelectedItem();
        ano = anoGravacao.getValue();
        formato = cboxFormato.getSelectionModel().getSelectedItem();

        if(cantor.isEmpty() || titulo.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha todos os campos!");
            alert.showAndWait();
        } else {
            boolean result = Operacoes.removeDisco(cantor, titulo, conservacao, ano, formato);
            limparCampos();
            if(result){
                lbMsg.setText("Produto removido!");

            }else{
                lbMsg.setText("Produto inexistente!");
            }
        }
    }

    @FXML
    protected void limparCampos(){
        txtCantor.setText("");
        txtTitulo.setText("");
        cboxEstado.setValue("");
        anoGravacao.getValueFactory().setValue(2025);
        cboxFormato.setValue("");
    }

    @FXML
    protected void initialize(){
        btnRemoverDisco.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        cboxEstado.getItems().addAll("NOVO", "SEMINOVO", "USADO");
        cboxFormato.getItems().addAll("LP", "EP", "SINGLE");
    }
}
