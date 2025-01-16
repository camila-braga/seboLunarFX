package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Livro;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.util.ArrayList;

/***
 * Classe controller da tela exibir todos os livros do banco de dados.
 *
 * @author Camila Braga e Antonio Walter
 */
public class ExibirTipoLivroController extends MenuController{
    @FXML
    private Label lbMsgErro;
    @FXML
    private ListView <String> listView;
    private ObservableList<String> items;

    /**
     * Método para limpar os campos de preenchimento e mensagens de erro das telas.
     */
    @FXML
    public void limparCampos(){
        if (Operacoes.exibirProdutosDisco().isEmpty()) {
            lbMsgErro.setText("Não existem livros cadastrados!");
        } else {
            lbMsgErro.setText("");
        }
    }


    /**
     * Método para realizar a busca por todos os objetos tipo Livro no banco de dados.
     * Cria um ArrayList do tipo Disco, chama o método exibirProdutosLivro() pertencente à classe
     * Operacoes e armazena seu retorno ao array list.
     * Caso não haja produtos com essa especificação, exibe mensagem de que não existem livros cadastrados.
     * Caso haja, adiciona os objetos armazenados previamente, convertidos em strings, no ObservableList para
     * serem exibidos na list view.
     */
    public void atualizarDados() {
        ArrayList<Livro> encontrados = Operacoes.exibirProdutosLivro();

        items.clear();
        if (encontrados.isEmpty()) {
            lbMsgErro.setText("Não existem livros cadastrados!");
        } else {

            for (Livro p : encontrados) {
                items.add(p.toString());
            }
        }
    }
    /**
     * Método para inicializar a tela com algumas especificações.
     * Exibe o menu à frente das imagens do layout e permite que a list view exiba os
     * resultados encontrados.
     */
    public void initialize() {
        menu.toFront();
        items = FXCollections.observableArrayList();
        listView.setItems(items);
    }
}
