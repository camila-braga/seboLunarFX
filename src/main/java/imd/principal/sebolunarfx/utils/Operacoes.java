package imd.principal.sebolunarfx.utils;

import java.util.ArrayList;
import imd.principal.sebolunarfx.DAO.BancoDAO;
import imd.principal.sebolunarfx.model.*;

/***
 * Classe contendo métodos auxiliares para as operações do menu
 * Main.
 *
 * @author Camila Braga e Antonio Walter
 */
public class Operacoes {

    private static final BancoDAO banco = BancoDAO.getInstance();

    /**
     * Método para cadastrar um disco.
     * Recebe como argumento o nome do cantor, o título do disco, o peso, o estado de conservacao,
     * o número de faixar, o ano de gravação e o formato do disco.
     * Realiza o armazenamento dos valores das enumerações PesoProduto, EstadoConservacao e FormatoDisco,
     * cria um novo objeto do tipo Disco e o insere no banco de dados.
     * @param cantor_ - nome do cantor
     * @param titulo_ - título do disco
     * @param peso_ - classificação do peso
     * @param estado_ - estado de conservacao
     * @param faixas_ - número de faixas
     * @param ano_ - ano de gravação
     * @param formato_ - formato do disco
     */
    public static void cadastrarDisco(String cantor_, String titulo_, String peso_, String estado_, int faixas_, int ano_, String formato_ ) {
        PesoProduto peso = PesoProduto.valueOf(peso_);
        EstadoConservacao estadoConservacao = EstadoConservacao.valueOf(estado_);
        FormatoDisco formato = FormatoDisco.valueOf(formato_);

        Disco novoDisco = new Disco(cantor_, titulo_, peso, estadoConservacao,
                faixas_, ano_, formato);

        banco.getArrayProduto().add(novoDisco);
    }

    /**
     * Método para cadastrar um livro.
     * Recebe como argumento o nome do autor, o título do livro, o peso, o estado de conservacao,
     * o número de páginas, o ano de publicação, o nome da editora e o gênero literário.
     * Realiza o armazenamento dos valores das enumerações PesoProduto e EstadoConservacao,
     * cria um novo objeto do tipo Livro e o insere no banco de dados.
     * @param autor_ - nome do cantor
     * @param titulo_ - título do disco
     * @param peso_ - classificação do peso
     * @param estado_ - estado de conservacao
     * @param paginas_ - número de faixas
     * @param ano_ - ano de publicação
     * @param editora_ - editora
     * @param genero_ - gênero literário
     */
    public static void cadastrarLivro(String autor_, String titulo_, String peso_, String estado_, int paginas_, int ano_, String editora_, String genero_ ) {

        PesoProduto peso = PesoProduto.valueOf(peso_);
        EstadoConservacao estadoConservacao = EstadoConservacao.valueOf(estado_);

        Livro novoLivro = new Livro(autor_, titulo_, peso, estadoConservacao,
                paginas_, editora_, ano_, genero_);

        banco.getArrayProduto().add(novoLivro);

    }

    /**
     * Método para exibir objetos do tipo Disco pelo nome do cantor.
     * Recebe como argumento o nome do cantor, cria um novo array list do tipo Produto,
     * faz uma busca no banco de dados e, se o objeto for do tipo Disco e que possua o
     * mesmo nome do cantor buscado, é gravado na array list nova.
     * Retorna a array list criada com os objetos do tipo Disco buscados ou vazia caso não possua objetos.
     * @param nome_ - nome do cantor
     * @return resultados - array list do tipo Produto com os discos buscados
     */
    public static ArrayList<Produto> exibirPorCantor(String nome_) {
        ArrayList<Produto> resultados = new ArrayList<>();
        for (Produto p : banco.getArrayProduto()) {
            if(p instanceof Disco){
                if (p.getAutorCantor().equals(nome_)) {
                    resultados.add(p);
                }
            }
        }
        return resultados;
    }

    /**
     * Método para exibir objetos do tipo Livro pelo nome do autor.
     * Recebe como argumento o nome do autor, cria um novo array list do tipo Produto,
     * faz uma busca no banco de dados e, se o objeto for do tipo Livro e que possua o
     * mesmo nome do autor buscado, é gravado na array list nova.
     * Retorna a array list criada com os objetos do tipo Livro buscados ou vazia caso não possua objetos.
     * @param nome_ - nome do autor
     * @return resultados - array list do tipo Produto com os livros buscados
     */
    public static ArrayList<Produto> exibirPorAutor(String nome_) {
        ArrayList<Produto> resultados = new ArrayList<>();
        for (Produto p : banco.getArrayProduto()) {
            if(p instanceof Livro){
                if (p.getAutorCantor().equals(nome_)) {
                    resultados.add(p);
                }
            }
        }
        return resultados;
    }

    /**
     * Método para exibir objetos do tipo Produto pelo título da obra.
     * Recebe como argumento o título da obra, cria um novo array list do tipo Produto,
     * faz uma busca no banco de dados e, se o objeto possuir o
     * mesmo nome do título buscado, é gravado na array list nova.
     * Retorna a array list criada com os objetos do tipo Produto buscados ou vazia caso não possua objetos.
     * @param nome_ - título da obra
     * @return resultados - array list do tipo Produto com os objetos buscados
     */
    public static ArrayList<Produto> exibirPorTitulo(String nome_) {
        ArrayList<Produto> resultados = new ArrayList<>();
        for (Produto p : banco.getArrayProduto()) {
            if (p.getTitulo().equals(nome_)) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    /**
     * Método para exibir todos os objetos do tipo Livro.
     * Cria um novo array list do tipo Livro, faz uma busca no banco de dados e,
     * se o objeto  for do tipo Livro, é gravado na array list nova.
     * Retorna a array list criada com os objetos do tipo Livro ou vazia caso não possua objetos.
     * @return resultados - array list do tipo Livro com os objetos buscados
     */
    public static ArrayList<Livro> exibirProdutosLivro() {
        ArrayList<Livro> resultados = new ArrayList<>();

        for (Produto p : banco.getArrayProduto()) {
            if ((p instanceof Livro)) {
                resultados.add((Livro) p);
            }
        }
        return resultados;
    }

    /**
     * Método para exibir todos os objetos do tipo Disco.
     * Cria um novo array list do tipo Disco, faz uma busca no banco de dados e,
     * se o objeto  for do tipo Disco, é gravado na array list nova.
     * Retorna a array list criada com os objetos do tipo Disco ou vazia caso não possua objetos.
     * @return resultados - array list do tipo Disco com os objetos buscados
     */
    public static ArrayList<Disco> exibirProdutosDisco() {
        ArrayList<Disco> resultados = new ArrayList<>();

        for (Produto p : banco.getArrayProduto()) {
            if((p instanceof Disco) ){
                resultados.add((Disco) p);
            }
        }
        return resultados;
    }


    /**
     * Método para remover um objeto do tipo Disco.
     * Recebe como argumento o nome do cantor, o título do disco, o estado de conservacao,
     * o ano de gravação e o formato do disco.
     * Realiza o armazenamento dos valores das enumerações EstadoConservacao e FormatoDisco.
     * Busca no banco de dados por algum objeto que contenha os mesmos atributos e, se o achar,
     * o remove do banco.
     * Retorna true se a remoção for bem sucedida e false, caso contrário.
     * @param cantor - nome do cantor
     * @param titulo - título do disco
     * @param estado_ - estado de conservacao
     * @param ano - ano de gravação
     * @param formato_ - formato do disco
     * @return banco.getArrayProduto().remove(toRemove) - true em caso de sucesso ou false em caso de fracasso
     */
    public static boolean removeDisco(String cantor, String titulo, String estado_, int ano, String formato_) {
        Produto toRemove = null;
        EstadoConservacao estado = EstadoConservacao.valueOf(estado_);
        FormatoDisco formato = FormatoDisco.valueOf(formato_);
        for(Produto produto : banco.getArrayProduto()){
            if(produto instanceof Disco disco){
                boolean eqCantor = disco.getAutorCantor().equals(cantor);
                boolean eqTitulo = disco.getTitulo().equals(titulo);
                boolean eqEstado = disco.getEstadoConservacao() == estado;
                boolean eqAno = disco.getAnoGravacao() == ano;
                boolean eqFormato = disco.getFormato() == formato;
                if(eqCantor && eqTitulo && eqEstado && eqAno && eqFormato){
                    toRemove = produto;
                }
            }
        }
        return banco.getArrayProduto().remove(toRemove);
    }

    /**
     * Método para remover um objeto do tipo Livro.
     * Recebe como argumento o nome do autor, o título do livro, o estado de conservacao,
     * o ano de publicação e o nome da editora.
     * Realiza o armazenamento dos valores das enumerações EstadoConservacao.
     * Busca no banco de dados por algum objeto que contenha os mesmos atributos e, se o achar,
     * o remove do banco.
     * Retorna true se a remoção for bem sucedida e false, caso contrário.
     * @param autor - nome do cantor
     * @param titulo - título do disco
     * @param estado_ - estado de conservacao
     * @param ano - ano de gravação
     * @param editora - formato do disco
     * @return banco.getArrayProduto().remove(toRemove) - true em caso de sucesso ou false em caso de fracasso
     */
    public static boolean removeLivro(String autor, String titulo, String estado_, int ano, String editora) {
        Produto toRemove = null;
        EstadoConservacao estado = EstadoConservacao.valueOf(estado_);
        for(Produto produto : banco.getArrayProduto()){
            if(produto instanceof Livro livro){
                boolean eqCantor = livro.getAutorCantor().equals(autor);
                boolean eqTitulo = livro.getTitulo().equals(titulo);
                boolean eqEstado = livro.getEstadoConservacao() == estado;
                boolean eqAno = livro.getAnoPublicacao() == ano;
                boolean eqEditora = livro.getEditora().equals(editora);
                if(eqCantor && eqTitulo && eqEstado && eqAno && eqEditora){
                    toRemove = produto;
                }
            }
        }
        return banco.getArrayProduto().remove(toRemove);
    }
}
