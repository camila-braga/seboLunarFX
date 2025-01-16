package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.MainApplication;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

/***
 * Classe controller do menu principal
 *
 * @author Camila Braga e Antonio Walter
 */
public class MenuController {
    @FXML
    protected MenuBar menu;

    /**
     * Método para inicializar a tela com algumas especificações.
     * Coloca o menu à frente das imagens de fundo
     */
    @FXML
    protected void initialize() {
        menu.toFront();
    }

    /**
     * Métodos para fazer as trocas de telas de acordo com o parâmetro int opção.
     */
    @FXML
    protected void onCadLivroClick(){ MainApplication.mudarScene(1); }
    @FXML
    protected void onCadDiscoClick(){ MainApplication.mudarScene(2); }
    @FXML
    protected void onExTipoLivroClick(){ MainApplication.mudarScene(3); }
    @FXML
    protected void onExTipoDiscoClick(){ MainApplication.mudarScene(4);}
    @FXML
    protected void onExAutorClick(){ MainApplication.mudarScene(5); }
    @FXML
    protected void onExCantorClick(){ MainApplication.mudarScene(6); }
    @FXML
    protected void onExTituloClick(){ MainApplication.mudarScene(7); }
    @FXML
    protected void onRemoverLivroClick(){ MainApplication.mudarScene(10); }
    @FXML
    protected void onRemoverDiscoClick(){ MainApplication.mudarScene(11); }
    @FXML
    protected void onFreteLivroClick(){ MainApplication.mudarScene(8); }
    @FXML
    protected void onFreteDiscoClick(){ MainApplication.mudarScene(9); }
}