package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.EstadoConservacao;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/***
 * Classe controller da tela de remover um livro do banco de dados.
 *
 * @author Camila Braga e Antonio Walter
 */
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

    /**
     * Método para limpar os campos de preenchimento das telas.
     */
    @FXML
    public void limparCampos(){
        txtAutor.setText("");
        txtTitulo.setText("");
        cboxEstado.setValue("");
        txtEditora.setText("");
        anoPublicacao.getValueFactory().setValue(2025);
        lbMsg.setText("");
    }

    /**
     * Método para checar se os campos de preenchimento estão preenchidos.
     * Retorna true em caso positivo e false, caso contrário.
     * @return valAutor && valTitulo && valEditora && valEnums - booleans dos campos de preenchimento
     */
    public boolean validarDados(){
        String autor = txtAutor.getText();
        String titulo = txtTitulo.getText();
        String editora = txtEditora.getText();
        String conservacao = cboxEstado.getSelectionModel().getSelectedItem();

        boolean valAutor = !autor.isBlank();
        boolean valTitulo = !titulo.isBlank();
        boolean valEditora = !editora.isBlank();
        boolean valEnums = false;

        try {
            EstadoConservacao.valueOf(conservacao);
            valEnums = true;
        } catch (IllegalArgumentException _){
        }

        return valAutor && valTitulo && valEditora && valEnums;
    }

    /**
     * Método associado ao botão remover.
     * Realiza as leituras dos campos, checa se todos foram preenchidos. Caso contrário, exibe um
     * alerta de campo vazio. Caso positivo, chama o método
     * removeLivro(String autor, String titulo, String conservacao, int ano, String editora) da classe
     * Operacoes e, caso seu retorno seja true, exibe mensagem de sucesso ou então, de fracasso em caso contrário.
     */
    @FXML
    protected void onBtnRemoverLivro(){
        String autor, titulo, conservacao, editora;
        int ano;

        autor = txtAutor.getText();
        titulo = txtTitulo.getText();
        conservacao = cboxEstado.getSelectionModel().getSelectedItem();
        ano = anoPublicacao.getValue();
        editora = txtEditora.getText();

        if(!validarDados()){
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

    /**
     * Método para inicializar a tela com algumas especificações.
     * Muda a cor do botão, exibe o menu à frente das imagens do layout e define as opções das choice boxs
     * referentes ao estado de conservação.
     */
    @FXML
    protected void initialize(){
        menu.toFront();
        btnRemoverLivro.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        cboxEstado.getItems().addAll("NOVO", "SEMINOVO", "USADO");
    }
}
