package imd.principal.sebolunarfx.model;

import java.io.Serializable;

/**
 * Interface que representa o frete do produto.
 *
 * @author Camila Braga e Antonio Walter
 *
 **/
public interface Frete extends Serializable {
    /**
     * Método para calcular o frete.
     *
     * @param zona A zona da cidade onde será feita a entrega (sul ou norte).
     * @return O valor total do frete.
     */
    double calcularFrete(Zona zona);
}
