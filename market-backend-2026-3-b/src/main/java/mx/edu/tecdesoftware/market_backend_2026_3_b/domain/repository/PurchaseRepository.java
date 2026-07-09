package mx.edu.tecdesoftware.market_backend_2026_3_b.domain.repository;

import mx.edu.tecdesoftware.market_backend_2026_3_b.domain.Purchase;

import java.util.List;

public interface PurchaseRepository {

    List<Purchase> getAll();

    List<Purchase> getByClient(String clientId);

    Purchase save(Purchase purchase);
}