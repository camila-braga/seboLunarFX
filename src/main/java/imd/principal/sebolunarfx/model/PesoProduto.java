package imd.principal.sebolunarfx.model;

import java.io.Serializable;

/***
 * Representa o peso do produto. Cada nível tem um acréscimo de 5% sobre o preço
 * total do livro, no cálculo do frete.
 *
 * @author Camila Braga e Antonio Walter
 */
public enum PesoProduto implements Serializable {
    A(0.05), // até 200g
    B(0.1), // 201g a 400g
    C(0.15), // 401g a 600g
    D(0.20), // 601g a 800g
    E(0.25), // 801g a 1000g
    F(0.30); // acima de 1000g

    private final Double percent;

    PesoProduto(Double percent) {
        this.percent = percent;
    }

    public Double getPercent() {
        return percent;
    }
}