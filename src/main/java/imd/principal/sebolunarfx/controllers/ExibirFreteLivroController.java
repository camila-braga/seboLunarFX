package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Livro;
import imd.principal.sebolunarfx.model.Zona;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;

/***
 * Classe controller da tela exibir o frete de livros com mesmo título.
 *
 * @author Camila Braga e Antonio Walter
 */
public class ExibirFreteLivroController extends MenuController{
    @FXML
    private Label lbMsgErro;
    @FXML
    private TextField txtTituloFrete;
    @FXML
    private ChoiceBox<String> cboxZona;
    @FXML
    private ListView <String> listFreteLivro;
    @FXML
    private Button btnCalcularFreteLivro;
    private ObservableList<String> items;

    /**
     * Método para limpar os campos de preenchimento das telas.
     */
    @FXML
    public void limparCampos(){
        txtTituloFrete.setText("");
        cboxZona.setValue("");
        lbMsgErro.setText("");
        items.clear();
    }

    /**
     * Método para checar se o campo de preenchimento está preenchido.
     * Retorna true em caso positivo e false, caso contrário.
     * @return valTitulo && valEnums - booleans dos campos de preenchimento
     */
    public boolean validarDados(){
        String titulo = txtTituloFrete.getText();
        String zona = cboxZona.getSelectionModel().getSelectedItem();

        boolean valTitulo = !titulo.isBlank();
        boolean valEnums = false;

        try {
            Zona.valueOf(zona);
            valEnums = true;
        } catch (IllegalArgumentException _){
        }

        return valTitulo && valEnums;
    }

    /**
     * Método para realizar a busca por objetos que possuam o mesmo título desejado.
     * Faz a leitura dos campos de preenchimentos, cria um ArrayList do tipo Livro, chama o método
     * exibirProdutosDisco() pertencente à classe Operacoes e armazena seu retorno ao array list.
     * Verifica se o campo zona foi preenchido corretamente e, caso contrário, retorna false.
     * Caso positivo, adiciona na ObservableList o valor do frete calculado junto com os detalhes de
     * seu objeto para serem exibidos na list view e retorna true se essa lista estiver preenchida ou false,
     * se estiver vazia.
     * @return boolean - false caso o campo zona não estiver preenchido ou true se a ObservableList contiver
     * informações ou false se estiver vazia.
     *
     */
    public boolean atualizarDados() {
        ArrayList<Livro> encontrados = Operacoes.exibirProdutosLivro();

        String titulo = txtTituloFrete.getText();
        String zona_str = cboxZona.getSelectionModel().getSelectedItem();

        if(zona_str == null || zona_str.isBlank() ){
            return false;
        }
        Zona zona = Zona.valueOf(zona_str);

        items.clear();
        lbMsgErro.setText(" ");
        for (Livro p : encontrados) {
            if(p.getTitulo().equals(titulo)){
                items.add("Frete: R$" + p.calcularFrete(zona) + "  |  " + p);
            }
        }

        return !items.isEmpty();
    }

    /**
     * Método associado ao botão calcular frete.
     * Verifica se algum campo de preenchimento está vazio e exibe um alerta. Caso contrário,
     * chama o método atualizarDados() e, se for false, exibe uma mensagem de que não há produtos encontrados
     * com as características buscadas. Se for true, reseta a mensagem de erro.
     * Limpa o campo de preenchimento.
     */
    @FXML
    protected void btnCalcularFreteLivroClick(){
        if(!validarDados()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha todos os campos!");
            alert.showAndWait();
        }else{

            if (!atualizarDados()){
                limparCampos();
                lbMsgErro.setText("Produto não encontrado!");
            }
        }
    }

    /**
     * Método para inicializar a tela com algumas especificações.
     * Muda a cor do botão, exibe o menu à frente das imagens do layout, define as opções
     * da choice box zona e permite que a list view exiba os resultados encontrados.
     */
    @FXML
    protected void initialize(){
        menu.toFront();
        btnCalcularFreteLivro.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        cboxZona.getItems().addAll("SUL", "NORTE");
        items = FXCollections.observableArrayList();
        listFreteLivro.setItems(items);
    }
}