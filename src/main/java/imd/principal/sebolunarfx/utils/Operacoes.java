package imd.principal.sebolunarfx.utils;

import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;

import imd.principal.sebolunarfx.DAO.BancoDAO;
import imd.principal.sebolunarfx.model.*;

/***
 * Classe contendo métodos auxiliares para as opções mostradas no menu da classe
 * Main.
 *
 * @author Camila Braga e Antonio Walter
 */

public class Operacoes {

    private static BancoDAO banco = BancoDAO.getInstance();

    //Usado no cadastro de produto
    public static Disco cadastrarDisco(String cantor_, String titulo_, String peso_, String estado_, int faixas_, int ano_, String formato_ ) {
        PesoProduto peso = PesoProduto.valueOf(peso_);
        EstadoConservacao estadoConservacao = EstadoConservacao.valueOf(estado_);
        FormatoDisco formato = FormatoDisco.valueOf(formato_);

        Disco novoDisco = new Disco(cantor_, titulo_, peso, estadoConservacao,
                faixas_, ano_, formato);

        banco.getArrayProduto().add(novoDisco);

        return novoDisco;
    }

    //Usado no cadastro de produto
    public static Livro cadastrarLivro(String autor_, String titulo_, String peso_, String estado_, int paginas_, int ano_, String editora_, String genero_ ) {
        PesoProduto peso = PesoProduto.valueOf(peso_);
        EstadoConservacao estadoConservacao = EstadoConservacao.valueOf(estado_);

        Livro novoLivro = new Livro(autor_, titulo_, peso, estadoConservacao,
                paginas_, editora_, ano_, genero_);

        banco.getArrayProduto().add(novoLivro);

        return novoLivro;
    }

    //Usado para exibir autor/cantor
    public static ArrayList<Produto> exibirPorAutorCantor(String nome_) {
        ArrayList<Produto> resultados = new ArrayList<>();
        for (Produto p : banco.getArrayProduto()) {
            if (p.getAutorCantor().equals(nome_)) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    //Usado para exibir titulo
    public static ArrayList<Produto> exibirPorTitulo(String nome_) {
        ArrayList<Produto> resultados = new ArrayList<>();
        for (Produto p : banco.getArrayProduto()) {
            if (p.getTitulo().equals(nome_)) {
                resultados.add(p);
            }
        }
        return resultados;
    }



    //Usado para exibir produtos
    public static ArrayList<Produto> exibirProdutos(String tipo) {
        ArrayList<Produto> resultados = new ArrayList<>();

        for (Produto p : banco.getArrayProduto()) {
            if ((p instanceof Livro) && tipo.equals("Livro")) {
                resultados.add(p);
            }else if((p instanceof Disco) && tipo.equals("Disco")){
                resultados.add(p);
            }
        }
        return resultados;
    }

    public static ArrayList<Produto> exibirProdutosLivro() {
        ArrayList<Produto> resultados = new ArrayList<>();

        for (Produto p : banco.getArrayProduto()) {
            if ((p instanceof Livro)) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    public static ArrayList<Produto> exibirProdutosDisco() {
        ArrayList<Produto> resultados = new ArrayList<>();

        for (Produto p : banco.getArrayProduto()) {
            if((p instanceof Disco) ){
                resultados.add(p);
            }
        }
        return resultados;
    }

    public static boolean existeDisco(String cantor, String titulo, EstadoConservacao estado, int ano, FormatoDisco formato) {
        for(Produto produto : banco.getArrayProduto()){
            if(produto instanceof Disco disco){
                boolean eqCantor = disco.getAutorCantor().equals(cantor);
                boolean eqTitulo = disco.getTitulo().equals(titulo);
                boolean eqEstado = disco.getEstadoConservacao() == estado;
                boolean eqAno = disco.getAnoGravacao() == ano;
                boolean eqFormato = disco.getFormato() == formato;
                if(eqCantor && eqTitulo && eqEstado && eqAno && eqFormato){
                    return true;
                }
            }
        }
        return false;
    }

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


    /*//Usado para verificar se um livro existe
    public static boolean existeLivro(String autor_, String titulo_, String estado_, String ano_, String editora_ ) {
        boolean encontrado = false;
        EstadoConservacao estadoConservacao = tratamentoConservacao(estado_);

        for(Produto p : banco.getArrayProduto()){
            if(p.getAutorCantor().equals(autor_)){
                if(p.getTitulo().equals(titulo_)){
                    if(p.getEstadoConservacao().equals(estadoConservacao)){
                        if(p.getTitulo().equals(titulo_)){
                            if(p.getAutorCantor().equals(titulo_)){
                                encontrado = true;

                            }
                        }
                    }
                }
            }
        }
    }*/







    /***
     * Método para ler os dados de um produto e chamar a função de calcular frete.
     * Verifica se o produto existe e imprime na tela o valor do frete referente a ele.
     * Caso não exista, imprime uma mensagem de produto inexistente.
     *
     */
    /*public static void lerFrete() {
        Scanner scan = new Scanner(System.in);
        System.out.println("============================ Frete ============================");
        System.out.print("Qual o tipo do produto (Livro/Disco)?");
        String tipo = scan.nextLine();

        while (!(tipo.equals( "Livro") || tipo.equals( "Disco"))) {
            System.out.println();
            System.out.print("Tipo \"" + tipo + "\" inexistente. Só pode ser 'Livro' ou 'Disco'. Digite novamente:");
            tipo = scan.nextLine();
        }

        boolean existe = false;
        String titulo = "";

        while (!existe) {
            System.out.print("Qual o título? ");
            titulo = scan.nextLine();
            existe = buscarPorTitulo(titulo);
            if(!existe) {
                System.out.print("Título inexistente. Digite de novo: ");
            }
        }
        System.out.print("Qual o estado de conservação? ");
        EstadoConservacao estado = lerEstadoConservacao(scan);
        boolean encontrado = false;

        switch (tipo) {
            case "Livro":
                for (Produto p : banco.getArrayProduto()) {
                    if(p.getTitulo().equals(titulo) && p.getEstadoConservacao().equals(estado)) {
                        encontrado = true;
                        Zona zona;
                        double frete;
                        DecimalFormat df = new DecimalFormat("#.00");

                        System.out.println("Digite a zona a ser entregue (SUL ou NORTE): ");
                        zona = lerZona(scan);

                        frete = p.calcularFrete(zona);
                        System.out.println("O frete é R$" + df.format(frete) + ".");
                    }
                }
                break;

            case "Disco":
                System.out.print("Qual o formato do disco? ");
                FormatoDisco formato = lerFormadoDisco(scan);

                for (Produto p : banco.getArrayProduto()) {
                    if(p.getTitulo().equals(titulo) && p.getEstadoConservacao().equals(estado) && ((Disco) p).getFormato().equals(formato)) {
                        encontrado = true;
                        Zona zona;
                        double frete;
                        DecimalFormat df = new DecimalFormat("#.00");

                        System.out.println("Digite a zona a ser entregue (SUL ou NORTE): ");
                        zona = lerZona(scan);

                        frete = p.calcularFrete(zona);
                        System.out.println("O frete é R$" + df.format(frete) + ".");
                    }
                }
                break;
        }
        if(!encontrado) {
            System.out.println("Produto inexistente.");
        }

        System.out.println("===============================================================");
        System.out.println();
    }*/


    /***
     * Método buscar um produto pelo título.
     * Busca no banco de dados se existe um objeto do tipo Produto com o título
     * desejado.
     *
     * @param titulo - titulo do produto
     * @return boolean - "true" caso exista um produto com o título buscado, "false" caso contrário.
     */
    /*private static boolean buscarPorTitulo(String titulo) {
        for (Produto p : banco.getArrayProduto()) {
            if (p.getTitulo().equals(titulo)) {
                return true;
            }
        }
        return false;
    }*/


    /***
     * Método para ler a classificação do peso de um produto.
     * Realiza a leitura da classificação do peso de um produto, sendo válidas
     * apenas as formas
     * A, B, C, D, E, F. Qualquer leitura diferente dessas, faz
     * tratamento de erro exibindo uma mensagem com as opções válidas.
     *
     * @param scan - variável para leitura
     * @return PesoProduto - classificação do peso de um produto
     */
   /* private static PesoProduto lerPeso(Scanner scan) {
        PesoProduto peso = PesoProduto.A;
        boolean obtendoDados = true;
        while (obtendoDados) {
            String line = scan.nextLine();
            try {
                peso = PesoProduto.valueOf(line);
                obtendoDados = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Essa classificação não existe. Só pode uma das seguintes opções: "
                        + Arrays.toString(PesoProduto.values()));
                System.out.print("Qual a classificacão do peso do livro (A a F)? ");
            }
        }
        return peso;
    }*/

    /***
     * Método para ler o estado de conservação do produto.
     * Realiza a leitura do estado de conservação de um produto, sendo válidas
     * apenas as formas NOVO, SEMINOVO, USADO. Qualquer leitura diferente dessas,
     * faz
     * tratamento de erro exibindo uma mensagem com as opções válidas.
     *
     * @param scan - variável para leitura
     * @return EstadoConservacao- estado de conservação de um produto
     */
    /*private static EstadoConservacao lerEstadoConservacao(Scanner scan) {
        EstadoConservacao estado = EstadoConservacao.NOVO;
        boolean obtendoDados = true;
        while (obtendoDados) {
            String line = scan.nextLine();
            try {
                estado = EstadoConservacao.valueOf(line);
                obtendoDados = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Esse estado não existe. Só pode uma das seguintes opções: "
                        + Arrays.toString(EstadoConservacao.values()));
                System.out.print("Qual o estado de conservação (NOVO, SEMINOVO, USADO)? ");
            }
        }
        return estado;
    }*/

    /***
     * Método para ler o formato de um disco.
     * Realiza a leitura do formato de um disco, sendo válidas
     * apenas as formas LP, EP, SINGLE. Qualquer leitura diferente dessas,
     * faz
     * tratamento de erro exibindo uma mensagem com as opções válidas.
     *
     * @param scan - variável para leitura
     * @return FormatoDisco- formato de um disco
     */
    /*private static FormatoDisco lerFormadoDisco(Scanner scan) {
        FormatoDisco formato = FormatoDisco.LP;
        boolean obtendoDados = true;
        while (obtendoDados) {
            String line = scan.nextLine();
            try {
                formato = FormatoDisco.valueOf(line);
                obtendoDados = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Esse formato não existe. Só pode uma das seguintes opções: "
                        + Arrays.toString(FormatoDisco.values()));
                System.out.print("Qual o formato do disco (LP, EP, SINGLE)? ");
            }
        }
        return formato;
    }*/

    /***
     * Método para ler a zona da cidade.
     * Realiza a leitura da zona da cidade, sendo válidas
     * apenas as formas SUL e NORTE. Qualquer leitura diferente dessas,
     * faz
     * tratamento de erro exibindo uma mensagem com as opções válidas.
     *
     * @param scan - variável para leitura
     * @return Zona- zona da cidade
     */
    private static Zona lerZona(Scanner scan) {
        Zona zona = Zona.SUL;
        boolean obtendoDados = true;
        while (obtendoDados) {
            String line = scan.nextLine();
            try {
                zona = Zona.valueOf(line);
                obtendoDados = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Esse formato não existe. Só pode uma das seguintes opções: "
                        + Arrays.toString(Zona.values()));
                System.out.print("Digite a zona a ser entregue (SUL ou NORTE): ");
            }
        }
        return zona;
    }

    /***
     * Método para ler dados de um livro.
     * Realiza a leitura dos dados de um livro.
     *
     * @param scan - variável para leitura
     * @return Livro - objeto do tipo livro
     */
    /*public static Livro lerLivro(Scanner scan) {
        String autor;
        String titulo;
        PesoProduto peso;
        EstadoConservacao estadoConservacao;
        String editora;
        Integer numeroPaginas;
        Integer anoPublicacao;
        String generoLiterario;

        System.out.print("Qual o nome do autor? ");
        autor = scan.nextLine();

        System.out.print("Qual o título? ");
        titulo = scan.nextLine();

        System.out.print("Qual a classificacão do peso do livro (A a F)? ");
        peso = lerPeso(scan);

        System.out.print("Qual o estado de conservação (NOVO, SEMINOVO, USADO)? ");
        estadoConservacao = lerEstadoConservacao(scan);

        System.out.print("Qual a editora? ");
        editora = scan.nextLine();

        System.out.print("Qual o número de páginas? ");
        numeroPaginas = scan.nextInt();

        System.out.print("Qual o ano de publicação? ");
        anoPublicacao = scan.nextInt();

        // para não dar problema na leitura da nova string
        scan.nextLine();

        System.out.print("Qual o gênero literário? ");
        generoLiterario = scan.nextLine();

        Livro novoLivro = new Livro(autor, titulo, peso, estadoConservacao,
                numeroPaginas, editora, anoPublicacao, generoLiterario);
        return novoLivro;

    }*/

    /***
     * Método para ler dados de um disco.
     * Realiza a leitura dos dados de um disco.
     *
     * @param scan - variável para leitura
     * @return Disco - Objeto do tipo disco
     */
    /*public static Disco lerDisco(Scanner scan) {
        String Cantor;
        String titulo;
        PesoProduto peso;
        EstadoConservacao estadoConservacao;
        Integer numeroFaixas;
        Integer anoGravacao;
        FormatoDisco formato;

        System.out.print("Qual o nome do cantor? ");
        Cantor = scan.nextLine();

        System.out.print("Qual o título? ");
        titulo = scan.nextLine();

        System.out.print("Qual a classificacão do peso do disco (A a F)? ");
        peso = lerPeso(scan);

        System.out.print("Qual o estado de conservação (NOVO, SEMINOVO, USADO)? ");
        estadoConservacao = lerEstadoConservacao(scan);

        System.out.print("Qual o número de faixas? ");
        numeroFaixas = scan.nextInt();

        System.out.print("Qual o ano de gravação? ");
        anoGravacao = scan.nextInt();

        // para não dar problema na leitura da nova string
        scan.nextLine();

        System.out.print("Qual o formato do disco? ");
        formato = lerFormadoDisco(scan);

        Disco novoDisco = new Disco(Cantor, titulo, peso, estadoConservacao,
                numeroFaixas, anoGravacao, formato);

        return novoDisco;


    }*/

    /***
     * Método para cadastrar um produto.
     * Realiza a leitura dos dados de um livro ou de um disco, cadastra um produto e
     * armazena o objeto cadastrado no banco de dados.
     */
    /*public static void cadastrarProduto() {
        Scanner scan = new Scanner(System.in);

        System.out.println("================= Cadastrando um Produto ======================");
        System.out.print("Qual o tipo do produto (Livro/Disco)? ");
        String tipo = scan.nextLine();

        while (!(tipo.equals("Livro") || tipo.equals("Disco"))) {
            System.out.println();
            System.out.print("Tipo inexistente. Só pode ser 'Livro' ou 'Disco'. Digite novamente: ");
            tipo = scan.nextLine();
        }

        switch (tipo) {
            case "Livro":
                Livro novoLivro = lerLivro(scan);

                banco.getArrayProduto().add(novoLivro);

                System.out.println();
                System.out.println("Livro cadastrado!");
                System.out.println();

                break;

            case "Disco":
                Disco novoDisco = lerDisco(scan);

                banco.getArrayProduto().add(novoDisco);

                System.out.println();
                System.out.println("Disco cadastrado!");
                System.out.println();

                break;
        }
        System.out.println("===============================================================");
        System.out.println();

    }*/

    /***
     * Método para exibir livros.
     * Imprime na tela todos os produtos que sejam um livro ou um aviso de que não existem
     * livros cadastrados.
     */
    /*public static void exibirLivros() {
        boolean existeAlgumProduto = false;
        for (Produto p : banco.getArrayProduto()) {
            if (p instanceof Livro) {
                existeAlgumProduto = true;
                System.out.println(p);
            }
        }
        if(!existeAlgumProduto) {
            System.out.println("Não existem livros cadastrados!");
        }
    }*/


    /***
     * Método para exibir discos.
     *
     * Imprime na tela todos os produtos que sejam um disco ou um aviso de que não existem
     * discos cadastrados.
     */
    public static void exibirDiscos() {
        boolean existeAlgumProduto = false;
        for (Produto p : banco.getArrayProduto()) {
            if (p instanceof Disco) {
                existeAlgumProduto = true;
                System.out.println(p);
            }
        }
        if(!existeAlgumProduto) {
            System.out.println("Não existem discos cadastrados!");
        }
        //return encontrado;
    }

    /***
     * Método para exibir um produto pelo título.
     * Realiza a leitura do título do produto, verifica se existe no banco de dados e
     * imprime todos os produtos que tenham o mesmo título ou um aviso de que não existe
     * um produto com o título desejado.
     */
    /*public static void exibirPorTitulo(Scanner scan) {
        boolean existe = false;
        String tituloProduto = "";
        scan.nextLine();

        while (!existe) {
            System.out.print("Qual o título? ");
            tituloProduto = scan.nextLine();
            existe = buscarPorTitulo(tituloProduto);
            if(!existe) {
                System.out.print("Título inexistente. Digite de novo: ");
            }
        }

        System.out.println();
        System.out.println("================ Exibindo produtos por título =================");
        for (Produto p : banco.getArrayProduto()) {
            if (p.getTitulo().equals(tituloProduto)) {
                System.out.println(p);
            }
        }
        System.out.println("===============================================================");
        System.out.println();
    }*/

    /***
     * Método para exibir produtos por autor ou cantor.
     * Realiza a leitura do nome do autor/cantor. Verifica se existe no banco de dados e
     * imprime todos os produtos que tenham o nome digitado ou um aviso de que não existe
     * um produto com o autor/cantor desejado.
     * fornecido.
     */
    /*public static void exibirPorAutorCantor() {
        Scanner scan = new Scanner(System.in);
        boolean encontrado = false;

        while(!encontrado) {
            System.out.print("Digite o nome do autor ou cantor: ");
            String nome = scan.nextLine();
            System.out.println("=================== Exibir Por Autor ou Cantor ===================");
            for (Produto p : banco.getArrayProduto()) {
                if (p.getAutorCantor().equalsIgnoreCase(nome)) {
                    System.out.println(p);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("Nenhum produto encontrado para o autor/cantor: " + nome);
            }
            System.out.println("===============================================================");
            System.out.println();
        }
    }*/

    /***
     * Método para exibir todos os produtos de acordo com o tipo escolhido.
     * Realiza a leitura do título do produto, verifica se existe no banco de dados e
     * imprime todos os produtos que tenham o mesmo título ou um aviso de que não existe
     * um produto com o título desejado.
     */
   /* public static void exibirPorTipo(Scanner scan) {
        scan.nextLine();
        System.out.println();
        System.out.print("Qual o tipo do produto (Livro/Disco)?");
        String tipo = scan.nextLine();

        while (!(tipo.equals( "Livro") || tipo.equals( "Disco"))) {
            System.out.println();
            System.out.print("Tipo \"" + tipo + "\" inexistente. Só pode ser 'Livro' ou 'Disco'. Digite novamente:");
            tipo = scan.nextLine();
        }
        switch(tipo) {
            case "Livro":
                System.out.println("=================== Exibir Por Tipo - LIVRO ===================");
                exibirLivros();
                System.out.println("===============================================================");
                System.out.println();
                break;
            case "Disco":
                System.out.println("=================== Exibir Por Tipo - DISCO ===================");
                exibirDiscos();
                System.out.println("===============================================================");
                System.out.println();
                break;
        }
    }*/

    /***
     * Método para remover um produto do banco de dados.
     * Realiza a leitura do título do produto, verifica se existe no banco de dados e
     * o remove de lá.
     */
   /* public static void removerProduto(Scanner scan) {
        System.out.println("==================== Removendo um Produto =====================");

        scan.nextLine();
        String titulo = "";
        boolean existe = false;

        System.out.print("Digite o título do produto: ");

        while(!existe) {
            titulo = scan.nextLine();
            existe = buscarPorTitulo(titulo);
            if(!existe) {
                System.out.print("Produto \"" + titulo + "\" não existe! Digite novamente: ");
            }
        }

        Produto remover = null;
        for (Produto p : banco.getArrayProduto()) {
            if (p instanceof Livro) {
                if (p.getTitulo().equals(titulo)) {
                    remover = p;
                }
            }
            if (p instanceof Disco) {
                if (p.getTitulo().equals(titulo)) {
                    remover = p;
                }
            }
        }

        if(remover != null) {
            banco.getArrayProduto().remove(remover);
            System.out.println("Produto \"" + titulo + "\" foi removido!");
        }
        System.out.println("===============================================================");
        System.out.println();
    }*/



}
