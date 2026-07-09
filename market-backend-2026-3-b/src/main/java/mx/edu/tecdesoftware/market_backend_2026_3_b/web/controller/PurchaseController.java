package mx.edu.tecdesoftware.market_backend_2026_3_b.web.controller;

import mx.edu.tecdesoftware.market_backend_2026_3_b.domain.Purchase;
import mx.edu.tecdesoftware.market_backend_2026_3_b.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;


    // Obtener todas las compras
    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll() {

        return ResponseEntity.ok(
                purchaseService.getAll()
        );
    }


    // Obtener compras por cliente
    @GetMapping("/client/{id}")
    public ResponseEntity<List<Purchase>> getByClient(
            @PathVariable("id") String clientId) {

        List<Purchase> purchases = purchaseService.getByClient(clientId);

        if (purchases.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(purchases);
    }


    // Guardar una compra
    @PostMapping("/save")
    public ResponseEntity<Purchase> save(
            @RequestBody Purchase purchase) {

        Purchase savedPurchase = purchaseService.save(purchase);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedPurchase);
    }
}