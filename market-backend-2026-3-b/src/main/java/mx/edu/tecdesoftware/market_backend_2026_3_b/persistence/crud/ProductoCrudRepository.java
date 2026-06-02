package mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.crud;

import java.util.List;
import java.util.Optional;

import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    /*
        SELECT *
        FROM productos
        WHERE id_categoria = ?
        ORDER BY nombre ASC;
     */
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    /*
        SELECT *
        FROM productos
        WHERE cantidad_stock < ?
        AND estado = ?;
     */
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(
            int cantidad,
            boolean estado
    );
}