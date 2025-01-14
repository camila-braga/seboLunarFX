package imd.principal.sebolunarfx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.*;

public class CadastroDiscoController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu cadastrar, exibir, remover, frete;

    @FXML
    private MenuItem livro, disco;

    @FXML
    private MenuItem porTitulo, porAutor, porCantor, porTipo;

    @FXML
    private MenuItem freteLivro, freteDisco;

    @FXML
    private VBox vBoxEsquerda, vBoxCentral, vBoxCentral2, vBoxBarra, vBoxDireita;

    @FXML
    private HBox hBoxCentral, hBoxCentral2, hBoxCentral3, hBoxCentral4, hBoxInferior;

    @FXML
    private Label labelCadastro, labelNome, labelTitulo, labelClassificacao, labelConservacao, labelFaixas, labelAnoGravacao, labelFormato, labelMensagem;

    @FXML
    private TextField texto1, texto2, texto3, texto4, texto5, texto6, texto7;

    @FXML
    private Button ButtonCadastrar;

    @FXML
    private ScrollPane scrollPane;



}
