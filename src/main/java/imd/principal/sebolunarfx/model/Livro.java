package imd.principal.sebolunarfx.model;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Classe que representa um livro vendido no sebo.
 *
 * @author Camila Braga e Antonio Walter
 *
 **/
public class Livro extends Produto {

    private static final long serialVersionUID = 1L;

    private String numeroPaginas;
    private String editora;
    private String anoPublicacao;
    private String generoLiterario;

    public Livro(String autorCantor, String titulo, PesoProduto peso, EstadoConservacao estadoConservacao,
                 String numeroPaginas, String editora, String anoPublicacao, String generoLiterario) {
        super(autorCantor, titulo, peso, estadoConservacao, 10.0);
        this.numeroPaginas = numeroPaginas;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.generoLiterario = generoLiterario;
        setPrecoBase(calculaPreco());
    }

    public String getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(String numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getGeneroLiterario() {
        return generoLiterario;
    }

    public void setGeneroLiterario(String generoLiterario) {
        this.generoLiterario = generoLiterario;
    }

    /***
     * Implementação do método para calcular o preço final de um livro, herdado da
     * classe abstrata Produto.
     *
     * @return precoFinal - valor do preço final do livro.
     */
    @Override
    public Double calculaPreco() {
        Double precoFinal =  getPrecoBase() * (1.0 + getEstadoConservacao().getPercent());
        return precoFinal;
    }


    /***
     * Método para listar todos os atributos separados por "=" e vírgula.
     *
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.00");

        builder.append("Produto [autor/cantor = ");
        builder.append(getAutorCantor());
        builder.append(", Título = ");
        builder.append(getTitulo());
        builder.append(", Número de Páginas = ");
        builder.append(getNumeroPaginas());
        builder.append(", Editora = ");
        builder.append(getEditora());
        builder.append(", Ano de Publicação = ");
        builder.append(getAnoPublicacao());
        builder.append(", Gênero Literário = ");
        builder.append(getGeneroLiterario());
        builder.append(", Peso = ");
        builder.append(getPeso());
        builder.append(", Estado de Conservação = ");
        builder.append(getEstadoConservacao());
        builder.append(", Preço = R$");
        builder.append(df.format(getPrecoBase()));
        builder.append("]");
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(getNumeroPaginas(), livro.getNumeroPaginas()) && Objects.equals(getEditora(), livro.getEditora()) && Objects.equals(getAnoPublicacao(), livro.getAnoPublicacao()) && Objects.equals(getGeneroLiterario(), livro.getGeneroLiterario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumeroPaginas(), getEditora(), getAnoPublicacao(), getGeneroLiterario());
    }
}
