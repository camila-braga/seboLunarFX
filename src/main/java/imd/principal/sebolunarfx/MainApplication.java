package imd.principal.sebolunarfx;

import imd.principal.sebolunarfx.DAO.BancoDAO;
import imd.principal.sebolunarfx.controllers.ExibirTipoDiscoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    private static FXMLLoader exTipoDisco;

    @Override
    public void start(Stage stage) throws IOException {

        primaryStage = stage;
        primaryStage.setTitle("Bem-Vindo ao Sebo Lunar!");

        //Carregamento das telas
        FXMLLoader intro = new FXMLLoader(getClass().getResource("Intro.fxml"));
        FXMLLoader cadLivro = new FXMLLoader(getClass().getResource("CadastroLivro.fxml"));
        FXMLLoader cadDisco = new FXMLLoader(getClass().getResource("CadastroDisco.fxml"));
        FXMLLoader exTipoLivro = new FXMLLoader(getClass().getResource("ExibirTipoLivro.fxml"));
        exTipoDisco = new FXMLLoader(getClass().getResource("ExibirTipoDisco.fxml"));
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
        Parent parentExTipoDisco = exTipoDisco.load();
        parentExTipoDisco.setUserData(exTipoDisco);


        Parent parentExAutor = exAutor.load();
        Parent parentExCantor = exCantor.load();
        Parent parentExTitulo = exTitulo.load();
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
                primaryStage.setScene(sceneExibirTipoLivro);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("Exibir por tipo - livro");
                break;
            case 4:
                FXMLLoader loader = (FXMLLoader) sceneExibirTipoDisco.getRoot().getUserData();
                ExibirTipoDiscoController controller = loader.getController();
                controller.atualizarDados();


                primaryStage.setScene(sceneExibirTipoDisco);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("Exibir por tipo - disco");
                break;
            case 5:
                primaryStage.setScene(sceneExibirAutor);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("Exibir por autor");
                break;
            case 6:
                primaryStage.setScene(sceneExibirCantor);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("Exibir por cantor");
                break;
            case 7:
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
     *
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
                e.printStackTrace();
            } finally {
                fluxoDados.close();
            }

        } catch (FileNotFoundException e) {
            // cria um banco de dados vazio
        } catch (IOException e) {
            e.printStackTrace();
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
                e.printStackTrace();
            } finally {
                fluxoDados.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}