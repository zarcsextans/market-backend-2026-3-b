package mx.edu.tecdesoftware.market_backend_2026_3_b.persistence;

import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.crud.ProductoCrudRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entity.Producto;

import  java.util.*;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;


    //SELECT * FORM productos
    public List<Producto> getAll() {
        //Se "castea" Iterable a lista
        return (List<Producto>) productoCrudRepository.findAll();
    }
    //Obtener productos por categoria
    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByCantidadOrderByNombreASC(idCategoria);
    }

    //Obtener productos escasos
    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
    //Obtener un producto dado el 10
    public Optional<Producto> getProductoById(int idProducto) {
        return productoCrudRepository.save(producto);
    }
    //Guardar un producto
    public Producto addProducto(Producto producto) {
        return productoCrudRepository.save(producto);
    }
    //Eliminar un producto
    public void deleteProductoById(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
