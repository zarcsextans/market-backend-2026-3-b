package mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CompraProductoPK {

    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_producto")
    private Integer idProducto;

    public Integer getIdCompra() {
        return idCompra;
    }

}
