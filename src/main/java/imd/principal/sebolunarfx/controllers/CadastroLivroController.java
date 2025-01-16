package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.utils.Operacoes;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CadastroLivroController extends MenuController {

    @FXML
    private VBox vBox4, vBox5, vBox6, vBox7, vBox8, vBox9;

    @FXML
    private HBox hBox2, hBox3, hBox4, hBox5, hBox6, hBox7, hBox8, hBox9, hBox10, hBox11;

    @FXML
    private Label lbCadLivro, lbAutor, lbTitulo, lbPeso, lbConservacao, lbEditora, lbPaginas, lbAnoPublicacao, lbGeneroLiterario, lbMensagemSucesso;

    @FXML
    private TextField txtAutor, txtTitulo, txtEditora, txtPaginas, txtAnoPublicacao, txtGeneroLiterario;

    @FXML
    private ChoiceBox<String> cboxPeso, cboxEstado;

    @FXML
    private Button btnCadastrarLivro;

    @FXML
    protected void onBtnCadastrarLivro() throws IOException {
        String autor, titulo, editora, genero, conservacao, paginas, anoPublicacao, peso;

        autor = txtAutor.getText();
        titulo = txtTitulo.getText();
        peso = cboxPeso.getSelectionModel().getSelectedItem();
        conservacao = cboxEstado.getSelectionModel().getSelectedItem();
        editora = txtEditora.getText();
        paginas = txtPaginas.getText();
        anoPublicacao = txtAnoPublicacao.getText();
        genero = txtGeneroLiterario.getText();

        boolean check = checagem(autor, titulo, peso, conservacao, editora, paginas, anoPublicacao, genero);

        if(check){
            //Faz o cadastro
            Operacoes.cadastrarLivro(autor, titulo, peso, conservacao, editora, paginas, anoPublicacao, genero);

            //Limpa os campos de preenchimento:
            limparCampos();

            //Mensagem de sucesso
            lbMensagemSucesso.setText("Livro cadastrado!");

        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Preencha todos os campos!");
            alert.showAndWait();
        }

    }

    @FXML
    protected boolean checagem( String autor, String titulo, String peso, String conservacao, String editora, String paginas, String anoPublicacao, String genero){
        boolean resultado = false;
        if(!autor.isEmpty()){
            if(!titulo.isEmpty()){
                if(!peso.isEmpty()){
                    if(!conservacao.isEmpty()){
                        if(!editora.isEmpty()){
                            if(!paginas.isEmpty()){
                                if(!anoPublicacao.isEmpty()){
                                    if(!genero.isEmpty()){
                                        resultado = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return resultado;
    }

    @FXML
    protected void limparCampos(){
        txtAutor.setText("");
        txtTitulo.setText("");
       // cboxPeso.setText("");
        //cboxEstado.setText("");
        txtEditora.setText("");
        txtPaginas.setText("");
        txtAnoPublicacao.setText("");
        txtGeneroLiterario.setText("");
    }

    @FXML
    protected void initialize(){
        btnCadastrarLivro.setStyle("-fx-border-color: #40a1da; -fx-background-color: #6cb0da;");
        cboxPeso.getItems().addAll("A", "B", "C", "D", "E", "F");
        cboxEstado.getItems().addAll("NOVO", "SEMINOVO", "USADO");
    }

}
