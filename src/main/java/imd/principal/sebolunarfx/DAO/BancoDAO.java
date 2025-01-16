package imd.principal.sebolunarfx.DAO;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

import imd.principal.sebolunarfx.model.Produto;

/***
 * Classe que representa o banco de dados do sebo Lunar.
 * Implementado usando singleton, ou seja, o construtor deve ser privado para
 * evitar a instanciação de novos objetos. Dessa forma, existirá apenas um único
 * banco de dados.
 *
 * @author Camila Braga e Antonio Walter
 */
public class BancoDAO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final ArrayList<Produto> produtos;
    public static BancoDAO banco;

    private BancoDAO() {
        produtos = new ArrayList<>();
    }

    public static BancoDAO getInstance() {
        if (banco == null) {
            banco = new BancoDAO();
        }
        return banco;
    }

    public ArrayList<Produto> getArrayProduto() {
        return this.produtos;
    }
}
