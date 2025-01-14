package imd.principal.sebolunarfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class MainApplication extends Application {

    //Scenes e stages
    private static Scene sceneIntro, sceneMenu, sceneCadLivro;
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        primaryStage = stage;
        primaryStage.setTitle("Bem-Vindo ao Sebo Lunar!");

        FXMLLoader intro = new FXMLLoader(getClass().getResource("Intro.fxml"));
        FXMLLoader menu = new FXMLLoader(getClass().getResource("Menu.fxml"));
        FXMLLoader cadLivro = new FXMLLoader(getClass().getResource("CadastroLivro.fxml"));

        Parent parentIntro = intro.load();
        Parent parentMenu = menu.load();
        Parent parentCadLivro = cadLivro.load();

        sceneIntro = new Scene(parentIntro, 800, 600);
        sceneMenu = new Scene(parentMenu, 1024, 640);
        sceneCadLivro = new Scene(parentCadLivro, 1024, 640);

        primaryStage.setScene(sceneIntro);
        primaryStage.show();

        /*FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Intro.fxml"));
        Scene sceneIntro = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Bem-Vindo ao Sebo Lunar!");

        stage.setScene(sceneIntro);
        stage.show();*/
    }

    public static void mudarScene(int opcao){
        switch (opcao){
            case 1:
                primaryStage.setScene(sceneCadLivro);
                break;
            case 2:
                //teste
                primaryStage.setScene(sceneIntro);
                break;
        }
    }


}