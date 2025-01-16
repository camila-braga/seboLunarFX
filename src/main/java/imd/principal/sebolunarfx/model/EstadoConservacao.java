package imd.principal.sebolunarfx.model;

import java.io.Serializable;

/***
 * Representa o nível do estado de conservação do produto.
 *
 * @author Camila Braga e Antonio Walter
 */
public enum EstadoConservacao implements Serializable {

    NOVO(0.6),
    SEMINOVO(0.4),
    USADO(0.2);

    private final Double percent;

    EstadoConservacao(Double percent) {
        this.percent = percent;
    }

    public Double getPercent() {
        return percent;
    }
}