package mx.edu.tecdesoftware.market_backend_2026_3_b.domain.service;

import mx.edu.tecdesoftware.market_backend_2026_3_b.domain.Purchase;
import mx.edu.tecdesoftware.market_backend_2026_3_b.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {


    @Autowired
    private PurchaseRepository purchaseRepository;


    // Obtener todas las compras
    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }


    // Obtener compras por cliente
    public List<Purchase> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }


    // Guardar compra
    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

}