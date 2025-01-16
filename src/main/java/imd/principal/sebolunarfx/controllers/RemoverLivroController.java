package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RemoverLivroController extends MenuController{

    @FXML
    private Label lbMsg;

    @FXML
    private TextField txtAutor, txtTitulo, txtEditora;

    @FXML
    private ChoiceBox<String> cboxEstado;

    @FXML
    private Spinner<Integer> anoPublicacao;

    @FXML
    private Button btnRemoverLivro;

    @FXML
    protected void onBtnRemoverLivro(){
        String autor, titulo, conservacao, editora;
        int ano;

        autor = txtAutor.getText();
        titulo = txtTitulo.getText();
        conservacao = cboxEstado.getSelectionModel().getSelectedItem();
        ano = anoPublicacao.getValue();
        editora = txtEditora.getText();

        if(autor.isEmpty() || titulo.isEmpty() || editora.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha todos os campos!");
            alert.showAndWait();
        } else {
            boolean result = Operacoes.removeLivro(autor, titulo, conservacao, ano, editora);
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
        txtAutor.setText("");
        txtTitulo.setText("");
        cboxEstado.setValue("");
        txtEditora.setText("");
        anoPublicacao.getValueFactory().setValue(2025);
    }

    @FXML
    protected void initialize(){
        btnRemoverLivro.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        cboxEstado.getItems().addAll("NOVO", "SEMINOVO", "USADO");
    }
}
