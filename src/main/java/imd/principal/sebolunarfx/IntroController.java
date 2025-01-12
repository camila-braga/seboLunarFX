package imd.principal.sebolunarfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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

    @FXML
    protected void onIntroExitButton() {
        introText.setText("Teste para sair!");
    }



}
