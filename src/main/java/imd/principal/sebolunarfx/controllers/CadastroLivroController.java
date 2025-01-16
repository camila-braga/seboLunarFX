package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.model.EstadoConservacao;
import imd.principal.sebolunarfx.model.PesoProduto;
import imd.principal.sebolunarfx.utils.Operacoes;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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

    @FXML
    protected void initialize(){
        menu.toFront();
        btnCadastrarLivro.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        cboxPeso.getItems().addAll("A", "B", "C", "D", "E", "F");
        cboxEstado.getItems().addAll("NOVO", "SEMINOVO", "USADO");
    }

}
