package mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "compras_productos")
public class CompraProducto {

    @EmbeddedId
    private CompraProductoPK id;

    private Integer cantidad;
    private double total;
    private Boolean estado;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra_producto")
    private Integer idCompraProducto;

}
