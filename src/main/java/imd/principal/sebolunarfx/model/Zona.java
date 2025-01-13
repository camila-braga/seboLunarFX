package imd.principal.sebolunarfx.model;

import java.io.Serializable;

/***
 * Representa a zona da cidade para o cálculo do frete.
 *
 * @author Camila Braga e Antonio Walter
 */
public enum Zona implements Serializable {

    SUL(5.0),
    NORTE(10.0);

    protected final Double percent;

    Zona(Double percent) {
        this.percent = percent;
    }

    public Double getPercent() {
        return percent;
    }
}