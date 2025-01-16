package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;

/***
 * Classe controller da tela de introdução.
 *
 * @author Camila Braga e Antonio Walter
 */
public class IntroController {
    @FXML
    private VBox vBox1;
    @FXML
    private Button introButton;

    /**
     * Método associado ao botão Entrar.
     * Carrega a tela do menu, cria uma nova cena para ele e altera a janela atual para a cena do menu.
     */
    @FXML
    protected void onIntroButton() throws IOException  {
        //Carrega o tela do menu
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Menu.fxml"));

        //Cria uma nova cena com o menu
        Scene sceneMenu = new Scene(fxmlLoader.load(), 1024, 640);

        //Pega o a janela atual (stage) e altera para a cena do menu
        Stage stage = (Stage) introButton.getScene().getWindow();

        stage.setScene(sceneMenu);
        stage.centerOnScreen();
    }

    /**
     * Método para inicializar a tela com algumas especificações.
     * Muda a cor do botão, carrega uma imagem de fundo e cria um background com essa imagem.
     */
    @FXML
    public void initialize() {
        //Carrega uma imagem
        Image image = new Image("/luaIntro.jpg");

        // Cria um background com uma imagem
        BackgroundSize backgroundSize = new BackgroundSize(1, 1, true, true, false, false);
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);

        Background background = new Background(backgroundimage);

        vBox1.setBackground(background);
        introButton.setStyle("-fx-border-color: #c3603a; -fx-background-color: #ff9061;");
    }
}
