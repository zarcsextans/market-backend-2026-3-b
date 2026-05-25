package mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "fecha_compra")
    private LocalDateTime fechaCompra;

    @Column(name = "total")
    private Double total;

    @Column(name = "metodo_pago")
    private String metodoPago;

    @Column(name = "estatus")
    private String estatus;
}