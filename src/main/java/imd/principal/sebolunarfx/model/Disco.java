package imd.principal.sebolunarfx.model;

import java.text.DecimalFormat;

/**
 * Classe que representa um disco vendido no sebo.
 *
 * @author Camila Braga e Antonio Walter
 *
 **/
public class Disco extends Produto {

    private static final long serialVersionUID = 1L;

    private Integer numeroFaixas;
    private Integer anoGravacao;
    private FormatoDisco formato;

    // Construtor parametrizado
    public Disco(String autorCantor, String titulo, PesoProduto peso, EstadoConservacao estadoConservacao,
                 Integer numeroFaixas, Integer anoGravacao, FormatoDisco formato) {
        super(autorCantor, titulo, peso, estadoConservacao, 10.0);
        this.numeroFaixas = numeroFaixas;
        this.anoGravacao = anoGravacao;
        this.formato = formato;
        setPrecoBase(calculaPreco());
    }

    // Métodos get/set
    public Integer getNumeroFaixas() {
        return numeroFaixas;
    }

    public void setNumeroFaixas(Integer numeroFaixas) {
        this.numeroFaixas = numeroFaixas;
    }

    public Integer getAnoGravacao() {
        return anoGravacao;
    }

    public void setAnoGravacao(Integer anoGravacao) {
        this.anoGravacao = anoGravacao;
    }

    public FormatoDisco getFormato() {
        return formato;
    }

    public void setFormato(FormatoDisco formato) {
        this.formato = formato;
    }

    /***
     * Implementação do método para calcular o preço final de um disco, herdado da
     * classe abstrata Produto.
     *
     * @return precoFinal - valor do preço final do disco.
     */
    @Override
    public Double calculaPreco() {
        Double precoFinal = getPrecoBase() * (1 + getEstadoConservacao().getPercent() + formato.getPercent());
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
        builder.append(", Número de Faixas = ");
        builder.append(getNumeroFaixas());
        builder.append(", Ano da Gravação = ");
        builder.append(getAnoGravacao());
        builder.append(", Formato do disco = ");
        builder.append(getFormato());
        builder.append(", Peso = ");
        builder.append(getPeso());
        builder.append(", Estado de Conservação = ");
        builder.append(getEstadoConservacao());
        builder.append(", Preço = R$");
        builder.append(df.format(getPrecoBase()));
        builder.append("]");
        return builder.toString();
    }


}
