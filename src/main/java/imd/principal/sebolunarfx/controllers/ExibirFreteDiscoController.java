package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.Disco;
import imd.principal.sebolunarfx.model.Zona;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;

/***
 * Classe controller da tela exibir o frete de discos com mesmo título.
 *
 * @author Camila Braga e Antonio Walter
 */
public class ExibirFreteDiscoController extends MenuController{
    @FXML
    private Label lbMsgErro;
    @FXML
    private TextField txtTituloFrete;
    @FXML
    private ChoiceBox<String> cboxZona;
    @FXML
    private ListView <String> listFreteDisco;
    @FXML
    private Button btnCalcularFreteDisco;
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
     * Método para realizar a busca por objetos que possuam o mesmo nome de cantor.
     * Faz a leitura do campo de preenchimento, cria um ArrayList do tipo Produto, chama
     * o método Operacoes.exibirPorCantor(String cantor) pertencente à classe Operacoes e armazena seu
     * retorno ao array list. Caso não haja produtos com essa especificação, retorna false.
     * Caso haja, adiciona os objetos armazenados, convertidos em strings, no ObservableList
     * para serem exibidos na list view.
     * @return true caso tenha objetos armazenados e false, caso contrário.
     */
    public boolean atualizarDados() {
        ArrayList<Disco> encontrados = Operacoes.exibirProdutosDisco();

        String titulo = txtTituloFrete.getText();
        String zona_str = cboxZona.getSelectionModel().getSelectedItem();

        if(zona_str == null || zona_str.isBlank() ){
            return false;
        }
        Zona zona = Zona.valueOf(zona_str);

        items.clear();
        lbMsgErro.setText(" ");
        for (Disco p : encontrados) {
            if(p.getTitulo().equals(titulo)){
                items.add("Frete: R$" + p.calcularFrete(zona) + "  |  " + p);
            }
        }

        return !items.isEmpty();
    }

    @FXML
    protected void btnCalcularFreteDiscoClick(){
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



    @FXML
    protected void initialize(){
        menu.toFront();
        btnCalcularFreteDisco.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        cboxZona.getItems().addAll("SUL", "NORTE");
        items = FXCollections.observableArrayList();
        listFreteDisco.setItems(items);
    }
}