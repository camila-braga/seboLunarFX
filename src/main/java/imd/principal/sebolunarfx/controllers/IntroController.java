package imd.principal.sebolunarfx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class IntroController {

    @FXML
    private VBox vBox1;

    @FXML
    private HBox hBox1;

    @FXML
    private HBox hBox2;

    @FXML
    private HBox hBox3;

    @FXML
    private Label introText;

    @FXML
    private Button introButton;

    @FXML
    private Button introExitButton;

    @FXML
    protected void onIntroButton() {
        introText.setText("Funcionou!");
    }

    //Fazer o programa encerrar!
    @FXML
    protected void onIntroExitButton() {
        introText.setText("Teste para sair!");
    }

    @FXML
    public void initialize() {

        Image image = new Image("/luaIntro.jpg");

        // create a background image
        BackgroundSize backgroundSize = new BackgroundSize(1, 1, true, true, false, false);
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);

        // create Background
        Background background = new Background(backgroundimage);

        vBox1.setBackground(background);


        introButton.setStyle("-fx-border-color: #c3603a; -fx-background-color: #ff9061;");
        introExitButton.setStyle("-fx-border-color: #c3603a; -fx-background-color: #ff9061;");
    }



}
