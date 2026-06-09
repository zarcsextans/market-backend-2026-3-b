package mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.crud;

import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    // ✔ Productos por categoría (CORRECTO)
    List<Producto> findByCategoriaIdCategoriaOrderByNombreAsc(int idCategoria);

    // ✔ Productos escasos
    List<Producto> findByCantidadStockLessThanAndEstado(int cantidad, boolean estado);

    List<Producto> findByCategoriaIdCategoria(int categoryId);
}