package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.EstadoConservacao;
import imd.principal.sebolunarfx.model.FormatoDisco;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.fxml.FXML;
import javafx.scene.control.*;


/***
 * Classe controller da tela de remover um disco do banco de dados.
 *
 * @author Camila Braga e Antonio Walter
 */
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

    /**
     * Método para limpar os campos de preenchimento das telas.
     */
    @FXML
    public void limparCampos(){
        txtCantor.setText("");
        txtTitulo.setText("");
        cboxEstado.setValue("");
        anoGravacao.getValueFactory().setValue(2025);
        cboxFormato.setValue("");
        lbMsg.setText("");
    }

    /**
     * Método para checar se os campos de preenchimento estão preenchidos.
     * Retorna true em caso positivo e false, caso contrário.
     * @return valCantor && valTitulo && valEnums - booleans dos campos de preenchimento
     */
    public boolean validarDados(){
        String cantor = txtCantor.getText();
        String titulo = txtTitulo.getText();
        String conservacao = cboxEstado.getSelectionModel().getSelectedItem();
        String formato = cboxFormato.getSelectionModel().getSelectedItem();

        boolean valCantor = !cantor.isBlank();
        boolean valTitulo = !titulo.isBlank();
        boolean valEnums = false;

        try {
            EstadoConservacao.valueOf(conservacao);
            FormatoDisco.valueOf(formato);
            valEnums = true;
        } catch (IllegalArgumentException _){
        }

        return valCantor && valTitulo && valEnums;
    }

    /**
     * Método associado ao botão remover.
     * Realiza as leituras dos campos, checa se todos foram preenchidos. Caso contrário, exibe um
     * alerta de campo vazio. Caso positivo, chama o método
     * removeDisco(String cantor, String titulo, String conservacao, int ano, String formato) da classe
     * Operacoes e, caso seu retorno seja true, exibe mensagem de sucesso ou então, de fracasso em caso contrário.
     */
    @FXML
    protected void onBtnRemoverDisco() {
        String cantor, titulo, conservacao, formato;
        int ano;

        cantor = txtCantor.getText();
        titulo = txtTitulo.getText();
        conservacao = cboxEstado.getSelectionModel().getSelectedItem();
        ano = anoGravacao.getValue();
        formato = cboxFormato.getSelectionModel().getSelectedItem();

        if(!validarDados()){
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

    /**
     * Método para inicializar a tela com algumas especificações.
     * Muda a cor do botão, exibe o menu à frente das imagens do layout e define as opções das choice boxs
     * referentes ao estado de conservação e ao formato do disco.
     */
    @FXML
    protected void initialize(){
        menu.toFront();
        btnRemoverDisco.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        cboxEstado.getItems().addAll("NOVO", "SEMINOVO", "USADO");
        cboxFormato.getItems().addAll("LP", "EP", "SINGLE");
    }
}
