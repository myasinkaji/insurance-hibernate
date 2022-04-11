package ir.dotin.insurance.hibernate.controller;

import ir.dotin.insurance.hibernate.service.StockManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stock")
@RequiredArgsConstructor
public class StockController {
    private final StockManager stockManager;

    @GetMapping
    public ResponseEntity<String> saveSampleStock() {
        stockManager.save();
        return ResponseEntity.ok("Saved Ok");
    }
}
