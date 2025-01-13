package imd.principal.sebolunarfx.model;

import java.io.Serializable;

/***
 * Representa o formato do disco.
 *
 * @author Camila Braga e Antonio Walter
 */
public enum FormatoDisco implements Serializable {

    LP(0.5), // Diâmetro de 30cm
    EP(0.25), // Diâmetro de 17,5cm com lado A e B
    SINGLE(0.3); // Diâmetro de 17,5cm

    private final Double percent;

    FormatoDisco(Double percent) {
        this.percent = percent;
    }

    public Double getPercent() {
        return percent;
    }
}