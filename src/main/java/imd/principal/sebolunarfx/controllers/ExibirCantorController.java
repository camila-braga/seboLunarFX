package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Produto;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;

/***
 * Classe controller da tela exibir disco por cantor.
 *
 * @author Camila Braga e Antonio Walter
 */
public class ExibirCantorController extends MenuController{
    @FXML
    private Label lbMsgErro;
    @FXML
    private TextField txtCantor;
    @FXML
    private Button btnBuscarCantor;
    @FXML
    private ListView <String> listViewCantor;
    private ObservableList<String> items;

    /**
     * Método para limpar os campos de preenchimento das telas.
     */
    @FXML
    public void limparCampos(){
        lbMsgErro.setText("");
    }

    /**
     * Método para checar se o campo de preenchimento está preenchido.
     * Retorna true em caso positivo e false, caso contrário.
     * @return !cantor.isBlank() - boolean do campo de preenchimento
     */
    public boolean validarDados(){
        String cantor = txtCantor.getText();

        return !cantor.isBlank();
    }

    /**
     * Método para realizar a busca por objetos que possuam o mesmo nome de cantor.
     * Faz a leitura do campo de preenchimento, cria um ArrayList do tipo Produto, chama
     * o método exibirPorCantor(String cantor) pertencente à classe Operacoes e armazena seu
     * retorno ao array list. Caso não haja produtos com essa especificação, retorna false.
     * Caso haja, adiciona os objetos armazenados previamente, convertidos em strings, no ObservableList
     * para serem exibidos na list view.
     * @return true caso tenha objetos armazenados e false, caso contrário.
     */
    public boolean atualizarDados() {
        String cantor;
        cantor = txtCantor.getText();

        ArrayList<Produto> encontrados = Operacoes.exibirPorCantor(cantor);

        items.clear();
        if (encontrados.isEmpty()) {
            return false;
        } else {
            for (Produto p : encontrados) {
                items.add(p.toString());
            }
            return true;
        }
    }

    /**
     * Método associado ao botão buscar.
     * Verifica se algum campo de preenchimento está vazio e exibe um alerta. Caso contrário,
     * chama o método atualizarDados() e, se for false, exibe uma mensagem de que não há produtos encontrados
     * com as características buscadas. Se for true, reseta a mensagem de erro.
     * Limpa o campo de preenchimento.
     */
    @FXML
    protected void btnBuscarCantorClick(){
        if(!validarDados()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha o campo!");
            alert.showAndWait();
        }else{
            if(!atualizarDados()){
                lbMsgErro.setText("Produto não encontrado!");
            } else {
                lbMsgErro.setText("");
            }
            //Reseta o campo
            txtCantor.setText("");
        }
    }

    /**
     * Método para inicializar a tela com algumas especificações.
     * Muda a cor do botão, exibe o menu à frente das imagens do layout e permite que a list view exiba os
     * resultados encontrados.
     */
    @FXML
    protected void initialize(){
        menu.toFront();
        btnBuscarCantor.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        items = FXCollections.observableArrayList();
        listViewCantor.setItems(items);
    }
}