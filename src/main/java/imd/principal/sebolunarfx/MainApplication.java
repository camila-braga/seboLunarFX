package imd.principal.sebolunarfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class MainApplication extends Application {

    //Scenes e stages
    private static Scene sceneIntro, sceneMenu, sceneCadLivro, sceneCadDisco;
    private static Scene sceneExibirTipoLivro, sceneExibirTipoDisco, sceneExibirAutor, sceneExibirCantor, sceneExibirTitulo, sceneExibirFreteLivro, sceneExibirFreteDisco;
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
        FXMLLoader cadDisco = new FXMLLoader(getClass().getResource("CadastroDisco.fxml"));
        FXMLLoader exTipoLivro = new FXMLLoader(getClass().getResource("ExibirTipoLivro.fxml"));
        FXMLLoader exTipoDisco = new FXMLLoader(getClass().getResource("ExibirTipoDisco.fxml"));
        FXMLLoader exAutor = new FXMLLoader(getClass().getResource("ExibirAutor.fxml"));
        FXMLLoader exCantor = new FXMLLoader(getClass().getResource("ExibirCantor.fxml"));
        FXMLLoader exTitulo = new FXMLLoader(getClass().getResource("ExibirPorTitulo.fxml"));
        FXMLLoader exFreteLivro = new FXMLLoader(getClass().getResource("ExibirFreteLivro.fxml"));
        FXMLLoader exFreteDisco = new FXMLLoader(getClass().getResource("ExibirFreteDisco.fxml"));


        Parent parentIntro = intro.load();
        Parent parentMenu = menu.load();
        Parent parentCadLivro = cadLivro.load();
        Parent parentCadDisco = cadDisco.load();
        Parent parentExTipoLivro = exTipoLivro.load();
        Parent parentExTipoDisco = exTipoDisco.load();
        Parent parentExAutor = exAutor.load();
        Parent parentExCantor = exCantor.load();
        Parent parentExTitulo = exTitulo.load();
        Parent parentExFreteLivro = exFreteLivro.load();
        Parent parentExFreteDisco = exFreteDisco.load();

        sceneIntro = new Scene(parentIntro, 800, 600);
        sceneMenu = new Scene(parentMenu, 1024, 640);
        sceneCadLivro = new Scene(parentCadLivro, 1024, 640);
        sceneCadDisco = new Scene(parentCadDisco, 1024, 640);
        sceneExibirTipoLivro = new Scene(parentExTipoLivro, 1024, 640);
        sceneExibirTipoDisco = new Scene(parentExTipoDisco, 1024, 640);
        sceneExibirAutor = new Scene(parentExAutor, 1024, 640);
        sceneExibirCantor = new Scene(parentExCantor, 1024, 640);
        sceneExibirTitulo = new Scene(parentExTitulo, 1024, 640);
        sceneExibirFreteLivro = new Scene(parentExFreteLivro, 1024, 640);
        sceneExibirFreteDisco = new Scene(parentExFreteDisco, 1024, 640);

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
                primaryStage.setScene(sceneCadDisco);
                break;
            case 3:
                primaryStage.setScene(sceneExibirTipoLivro);
                break;
            case 4:
                primaryStage.setScene(sceneExibirTipoDisco);
                break;
            case 5:
                primaryStage.setScene(sceneExibirAutor);
                break;
            case 6:
                primaryStage.setScene(sceneExibirCantor);
                break;
            case 7:
                primaryStage.setScene(sceneExibirTitulo);
                break;
            case 8:
                primaryStage.setScene(sceneExibirFreteLivro);
                break;
            case 9:
                primaryStage.setScene(sceneExibirFreteDisco);
                break;

            case 20:
                //teste
                primaryStage.setScene(sceneIntro);
                break;

        }
    }


}