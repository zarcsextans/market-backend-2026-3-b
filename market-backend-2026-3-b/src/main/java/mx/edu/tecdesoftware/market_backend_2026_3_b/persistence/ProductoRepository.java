package mx.edu.tecdesoftware.market_backend_2026_3_b.persistence;

import mx.edu.tecdesoftware.market_backend_2026_3_b.domain.Product;
import mx.edu.tecdesoftware.market_backend_2026_3_b.domain.repository.ProductRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.crud.ProductoCrudRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entity.Producto;
import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper productMapper;

    //  SELECT * FROM productos
    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    //  Obtener productos por categoria
    @Override
    public Optional<List<Product>>  getByCategory(int categoryId) {

        List<Producto> productos =
                productoCrudRepository.findByCategoriaIdCategoria(categoryId);

        return Optional.of(productMapper.toProducts(productos));
    }

    // Obtener productos escasos
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {

        List<Producto> productos =
                productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);

        return Optional.of(productMapper.toProducts(productos));
    }

    // Obtener un producto por id
    @Override
    public Optional<Product> getProduct(int productId) {

        return productoCrudRepository.findById(productId)
                .map(productMapper::toProduct);
    }

    //  Guardar producto
    @Override
    public Product save(Product product) {

        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    //  Eliminar producto
    @Override
    public void delete(int productId) {

        productoCrudRepository.deleteById(productId);
    }
}