package imd.principal.sebolunarfx;

import imd.principal.sebolunarfx.DAO.BancoDAO;
import imd.principal.sebolunarfx.controllers.ExibirAutorController;
import imd.principal.sebolunarfx.controllers.ExibirCantorController;
import imd.principal.sebolunarfx.controllers.ExibirTipoDiscoController;
import imd.principal.sebolunarfx.controllers.ExibirTipoLivroController;
import imd.principal.sebolunarfx.controllers.ExibirPorTituloController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.*;


public class MainApplication extends Application {

    private static final String NOME_ARQUIVO = "produtosSeboLunar.data";

    //Scenes
    private static Scene sceneCadLivro, sceneCadDisco;
    private static Scene sceneExibirTipoLivro, sceneExibirTipoDisco, sceneExibirAutor, sceneExibirCantor, sceneExibirTitulo;
    private static Scene sceneExibirFreteLivro, sceneExibirFreteDisco;
    private static Scene sceneRemoverLivro, sceneRemoverDisco;
    private static Stage primaryStage;

    public static void main(String[] args) {
        iniciar();
        launch(args);
        encerrar();
    }

    @Override
    public void start(Stage stage) throws IOException {

        primaryStage = stage;
        primaryStage.setTitle("Bem-Vindo ao Sebo Lunar!");

        //Carregamento das telas
        FXMLLoader intro = new FXMLLoader(getClass().getResource("Intro.fxml"));
        FXMLLoader cadLivro = new FXMLLoader(getClass().getResource("CadastroLivro.fxml"));
        FXMLLoader cadDisco = new FXMLLoader(getClass().getResource("CadastroDisco.fxml"));
        FXMLLoader exTipoLivro = new FXMLLoader(getClass().getResource("ExibirTipoLivro.fxml"));
        FXMLLoader exTipoDisco = new FXMLLoader(getClass().getResource("ExibirTipoDisco.fxml"));
        FXMLLoader exAutor = new FXMLLoader(getClass().getResource("ExibirAutor.fxml"));
        FXMLLoader exCantor = new FXMLLoader(getClass().getResource("ExibirCantor.fxml"));
        FXMLLoader exTitulo = new FXMLLoader(getClass().getResource("ExibirPorTitulo.fxml"));
        FXMLLoader exFreteLivro = new FXMLLoader(getClass().getResource("ExibirFreteLivro.fxml"));
        FXMLLoader exFreteDisco = new FXMLLoader(getClass().getResource("ExibirFreteDisco.fxml"));
        FXMLLoader removerLivro = new FXMLLoader(getClass().getResource("RemoverLivro.fxml"));
        FXMLLoader removerDisco = new FXMLLoader(getClass().getResource("RemoverDisco.fxml"));

        //Criação das cenas
        Parent parentIntro = intro.load();
        Parent parentCadLivro = cadLivro.load();
        Parent parentCadDisco = cadDisco.load();
        Parent parentExTipoLivro = exTipoLivro.load();
        parentExTipoLivro.setUserData(exTipoLivro);
        Parent parentExTipoDisco = exTipoDisco.load();
        parentExTipoDisco.setUserData(exTipoDisco);
        Parent parentExAutor = exAutor.load();
        parentExAutor.setUserData(exAutor);
        Parent parentExCantor = exCantor.load();
        parentExCantor.setUserData(exCantor);
        Parent parentExTitulo = exTitulo.load();
        parentExTitulo.setUserData(exTitulo);
        Parent parentExFreteLivro = exFreteLivro.load();
        Parent parentExFreteDisco = exFreteDisco.load();
        Parent parentRemoverLivro = removerLivro.load();
        Parent parentRemoverDisco = removerDisco.load();

        Scene sceneIntro = new Scene(parentIntro, 800, 600);
        sceneCadLivro = new Scene(parentCadLivro, 1024, 640);
        sceneCadDisco = new Scene(parentCadDisco, 1024, 640);
        sceneExibirTipoLivro = new Scene(parentExTipoLivro, 1024, 640);
        sceneExibirTipoDisco = new Scene(parentExTipoDisco, 1024, 640);
        sceneExibirAutor = new Scene(parentExAutor, 1024, 640);
        sceneExibirCantor = new Scene(parentExCantor, 1024, 640);
        sceneExibirTitulo = new Scene(parentExTitulo, 1024, 640);
        sceneExibirFreteLivro = new Scene(parentExFreteLivro, 1024, 640);
        sceneExibirFreteDisco = new Scene(parentExFreteDisco, 1024, 640);
        sceneRemoverLivro = new Scene(parentRemoverLivro, 1024, 640);
        sceneRemoverDisco = new Scene(parentRemoverDisco, 1024, 640);



        primaryStage.setScene(sceneIntro);
        primaryStage.centerOnScreen();
        primaryStage.show();

    }
    //Alternância das cenas pelo menu
    public static void mudarScene(int opcao) {

        FXMLLoader loader;
        switch (opcao){
            case 1:
                primaryStage.setScene(sceneCadLivro);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("Cadastro de livro");
                break;
            case 2:
                primaryStage.setScene(sceneCadDisco);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("Cadastro de disco");
                break;
            case 3:
                loader = (FXMLLoader) sceneExibirTipoLivro.getRoot().getUserData();
                ExibirTipoLivroController controllerLivro= loader.getController();
                controllerLivro.atualizarDados();
                primaryStage.setScene(sceneExibirTipoLivro);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("Exibir por tipo - livro");
                break;
            case 4:
                loader = (FXMLLoader) sceneExibirTipoDisco.getRoot().getUserData();
                ExibirTipoDiscoController controllerDisco = loader.getController();
                controllerDisco.atualizarDados();
                primaryStage.setScene(sceneExibirTipoDisco);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("Exibir por tipo - disco");
                break;
            case 5:
                loader = (FXMLLoader) sceneExibirAutor.getRoot().getUserData();
                ExibirAutorController controllerAutor = loader.getController();
                controllerAutor.atualizarDados();
                primaryStage.setScene(sceneExibirAutor);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("Exibir por autor");
                break;
            case 6:
                loader = (FXMLLoader) sceneExibirCantor.getRoot().getUserData();
                ExibirCantorController controllerCantor = loader.getController();
                controllerCantor.atualizarDados();
                primaryStage.setScene(sceneExibirCantor);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("Exibir por cantor");
                break;
            case 7:
                loader = (FXMLLoader) sceneExibirTitulo.getRoot().getUserData();
                ExibirPorTituloController controllerPorTitulo = loader.getController();
                controllerPorTitulo.atualizarDados();
                primaryStage.setScene(sceneExibirTitulo);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("Exibir por título");
                break;
            case 8:
                primaryStage.setScene(sceneExibirFreteLivro);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("Frete de livro");
                break;
            case 9:
                primaryStage.setScene(sceneExibirFreteDisco);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("Frete de disco");
                break;
            case 10:
                primaryStage.setScene(sceneRemoverLivro);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("Remover Livro");
                break;
            case 11:
                primaryStage.setScene(sceneRemoverDisco);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("Remover Disco");
                break;

        }
    }


    /***
     * Método para carregar o banco de dados a partir de um arquivo binário de nome
     * NOME_ARQUIVO.
     * Restaura o estado do banco de dados a partir das informações presentes no
     * arquivo, porém, se acontecer algum erro de entrada e saída, o banco de dados
     * não será alterado (continuará vazio).
     */
    public static void iniciar() {
        File arquivo = new File(NOME_ARQUIVO);

        FileInputStream fluxoDados;
        try {
            fluxoDados = new FileInputStream(arquivo);

            ObjectInputStream input;
            try {
                input = new ObjectInputStream(fluxoDados);
                BancoDAO.banco = (BancoDAO) input.readObject();

            } catch (IOException | ClassNotFoundException e) {
                //e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Atenção!");
                alert.setHeaderText("Banco de dados não pôde ser carregado.");
                alert.showAndWait();
            } finally {
                fluxoDados.close();
            }

        } catch (FileNotFoundException e) {
            // cria um banco de dados vazio
        } catch (IOException e) {
            //e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Banco de dados não pôde ser carregado.");
            alert.showAndWait();
        }
    }

    /***
     * Método para gravar os dados do banco de dados no arquivo de nome NOME_ARQUIVO
     * e fechá-lo.
     *
     */
    public static void encerrar() {
        File arquivo = new File(NOME_ARQUIVO);

        FileOutputStream fluxoDados;
        try {
            fluxoDados = new FileOutputStream(arquivo);

            ObjectOutputStream output;
            try {
                output = new ObjectOutputStream(fluxoDados);
                output.writeObject(BancoDAO.banco);
            } catch (IOException e) {
                //e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Atenção!");
                alert.setHeaderText("Banco de dados não pôde ser gravado.");
                alert.showAndWait();
            } finally {
                fluxoDados.close();
            }

        } catch (IOException e) {
            //e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Banco de dados não pôde ser fechado.");
            alert.showAndWait();
        }

    }
}