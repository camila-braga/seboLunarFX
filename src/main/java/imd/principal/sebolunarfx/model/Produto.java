package imd.principal.sebolunarfx.model;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * Classe que representa o produto vendido no sebo.
 *
 * @author Camila Braga e Antonio Walter
 *
 **/
public abstract class Produto implements Serializable, Frete {

    private static final long serialVersionUID = 1L;

    private String autorCantor;
    private String titulo;
    private PesoProduto peso;
    private EstadoConservacao estadoConservacao;
    private Double precoBase;

    // Construtor parametrizado
    public Produto(String autorCantor, String titulo, PesoProduto peso, EstadoConservacao estadoConservacao,
                   Double precoBase) {
        this.autorCantor = autorCantor;
        this.titulo = titulo;
        this.peso = peso;
        this.estadoConservacao = estadoConservacao;
        this.precoBase = precoBase;
    }

    // Métodos get/set
    public String getAutorCantor() {
        return autorCantor;
    }

    public void setAutorCantor(String autorCantor) {
        this.autorCantor = autorCantor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public PesoProduto getPeso() {
        return peso;
    }

    public void setPeso(PesoProduto peso) {
        this.peso = peso;
    }

    public EstadoConservacao getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(EstadoConservacao estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    public Double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(Double preco) {
        this.precoBase = preco;
    }

    public Double calculaPreco() {
        return precoBase;
    }

    /***
     * Implementação do método para calcular o frete de um produto, herdado da
     * interface Frete.
     *
     */
    @Override
    public double calcularFrete(Zona zona) {
        double frete = getPrecoBase() * (1.0 + getPeso().getPercent()) + zona.getPercent();
        return frete;
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
        builder.append(", Peso = ");
        builder.append(getPeso());
        builder.append(", Estado de Conservação = R$");
        builder.append(getEstadoConservacao());
        builder.append(", Preço = R$");
        builder.append(df.format(getPrecoBase()));
        builder.append("]");
        return builder.toString();
    }

}
