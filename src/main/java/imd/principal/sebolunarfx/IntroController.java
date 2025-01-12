package imd.principal.sebolunarfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class IntroController {

    @FXML
    private SplitPane introScene;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label BemVindo;

    @FXML
    private Button acessar;

    @FXML
    private Button sair;

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

        introScene.setBackground(background);


        acessar.setStyle("-fx-border-color: #f2e175; -fx-background-color: #c9bb5c;");
    }

    @FXML
    protected void ButtonIntroController() {
        BemVindo.setText("FUNCIONOU!");
    }
}

