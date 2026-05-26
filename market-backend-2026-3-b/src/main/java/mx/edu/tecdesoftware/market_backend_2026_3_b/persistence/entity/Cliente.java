package mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "clientes")

public class Cliente {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Integer id;

        private String nombre;
        private String apellidos;
        private String celular;
        private String dirección;
        @Column (name = "correo_electronico")
        private String correoElectronico;


}
