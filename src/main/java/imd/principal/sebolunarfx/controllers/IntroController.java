package imd.principal.sebolunarfx.controllers;

import imd.principal.sebolunarfx.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class IntroController {

    @FXML
    private VBox vBox1;


    @FXML
    private HBox hBox2;

    @FXML
    private HBox hBox3;

    @FXML
    private Label introText;

    @FXML
    private Button introButton;


    @FXML
    protected void onIntroButton(ActionEvent event) throws IOException  {

        //Carrega o tela do menu
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Menu.fxml"));

        //Cria uma nova cena com o menu
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        //Pega o a janela atual (stage) e altera para a cena do menu
        Stage stage = (Stage) introButton.getScene().getWindow();
        stage.setScene(scene);
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

    }



}
