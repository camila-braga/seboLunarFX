package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.EstadoConservacao;
import imd.principal.sebolunarfx.model.PesoProduto;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/***
 * Classe controller da tela de cadastro de livro no banco de dados.
 *
 * @author Camila Braga e Antonio Walter
 */
public class CadastroLivroController extends MenuController {
    @FXML
    private Label  lbMensagemSucesso;
    @FXML
    private TextField txtAutor, txtTitulo, txtEditora, txtGeneroLiterario;
    @FXML
    private ChoiceBox<String> cboxPeso, cboxEstado;
    @FXML
    private Spinner<Integer> numPaginas, anoPublicacao;
    @FXML
    private Button btnCadastrarLivro;

    /**
     * Método para limpar os campos de preenchimento das telas.
     */
    @FXML
    public void limparCampos(){
        txtAutor.setText("");
        txtTitulo.setText("");
        cboxPeso.setValue("");
        cboxEstado.setValue("");
        txtEditora.setText("");
        numPaginas.getValueFactory().setValue(1);
        anoPublicacao.getValueFactory().setValue(2025);
        txtGeneroLiterario.setText("");
        lbMensagemSucesso.setText("");
    }

    /**
     * Método para checar se todos os campos de preenchimento estão preenchidos.
     * Retorna true em caso positivo e false, caso contrário.
     * @return valCantor && valTitulo && valEditora && valGenero && valEnums - booleans dos campos de preenchimento
     */
    public boolean validarDados(){
        String autor = txtAutor.getText();
        String titulo = txtTitulo.getText();
        String peso = cboxPeso.getSelectionModel().getSelectedItem();
        String conservacao = cboxEstado.getSelectionModel().getSelectedItem();
        String editora = txtEditora.getText();
        String genero = txtGeneroLiterario.getText();

        boolean valCantor = !autor.isBlank();
        boolean valTitulo = !titulo.isBlank();
        boolean valEditora = !editora.isBlank();
        boolean valGenero = !genero.isBlank();
        boolean valEnums = false;

        try {
            PesoProduto.valueOf(peso);
            EstadoConservacao.valueOf(conservacao);
            valEnums = true;
        } catch (IllegalArgumentException _){
        }

        return valCantor && valTitulo && valEditora && valGenero && valEnums;
    }

    /**
     * Método para realizar o cadastro de um livro no banco de dados.
     * Realiza a leitura dos campos e verifica se todos foram preenchidos. Caso contrário, exibe um alerta
     * para o usuário preencher os campos que faltam. Caso positivo, chama o método de cadastrar livro pertencente
     * à classe Operações, limpa os campos de preenchimento e exibe uma mensagem de sucesso.
     */
    @FXML
    protected void onBtnCadastrarLivro() {
        String autor, titulo, editora, genero, conservacao, peso;

        autor = txtAutor.getText();
        titulo = txtTitulo.getText();
        peso = cboxPeso.getSelectionModel().getSelectedItem();
        conservacao = cboxEstado.getSelectionModel().getSelectedItem();
        editora = txtEditora.getText();
        genero = txtGeneroLiterario.getText();
        Integer paginas = numPaginas.getValue();
        int ano =  anoPublicacao.getValue();

        if(!validarDados()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha todos os campos!");
            alert.showAndWait();
        }else{
            //Faz o cadastro
            Operacoes.cadastrarLivro(autor, titulo, peso, conservacao, paginas, ano, editora, genero);

            //Limpa os campos de preenchimento:
            limparCampos();

            //Mensagem de sucesso
            lbMensagemSucesso.setText("Livro cadastrado!");
        }
    }

    /**
     * Método para inicializar a tela com algumas especificações.
     * Muda a cor do botão, exibe o menu à frente das imagens do layout, e insere as opções dos
     * choice box referentes à classificação do peso e ao estado de conservação do livro.
     */
    @FXML
    protected void initialize(){
        menu.toFront();
        btnCadastrarLivro.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        cboxPeso.getItems().addAll("A", "B", "C", "D", "E", "F");
        cboxEstado.getItems().addAll("NOVO", "SEMINOVO", "USADO");
    }
}
