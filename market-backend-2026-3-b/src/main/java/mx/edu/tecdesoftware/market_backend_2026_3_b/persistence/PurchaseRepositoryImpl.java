package mx.edu.tecdesoftware.market_backend_2026_3_b.persistence;

import mx.edu.tecdesoftware.market_backend_2026_3_b.domain.Purchase;
import mx.edu.tecdesoftware.market_backend_2026_3_b.domain.repository.PurchaseRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.crud.CompraCrudRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entity.Compra;
import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entity.CompraProducto;
import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository {


    @Autowired
    private CompraCrudRepository compraCrudRepository;


    @Autowired
    private PurchaseMapper purchaseMapper;



    @Override
    public List<Purchase> getAll() {

        List<Compra> compras = (List<Compra>) compraCrudRepository.findAll();

        return purchaseMapper.toPurchases(compras);
    }



    @Override
    public List<Purchase> getByClient(String clientId) {

        List<Compra> compras = compraCrudRepository.findByIdCliente(clientId);

        return purchaseMapper.toPurchases(compras);
    }



    @Override
    public Purchase save(Purchase purchase) {

        Compra compra = purchaseMapper.toCompra(purchase);


        // Asigna la compra principal a cada detalle
        if (compra.getProductos() != null) {

            for (CompraProducto producto : compra.getProductos()) {

                producto.setCompra(compra);
            }
        }


        Compra compraGuardada = compraCrudRepository.save(compra);


        return purchaseMapper.toPurchase(compraGuardada);
    }
}