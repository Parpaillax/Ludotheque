package fr.eni.demo.controller;

import fr.eni.demo.bll.StockService;
import fr.eni.demo.bo.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    // Ajouter un stock
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody Stock stock) {
        stockService.add(stock);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Stock added");
        response.put("status", true);
        response.put("data", new HashMap<>());

        return ResponseEntity.ok(response);
    }

    // Chercher des clients par nom
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Optional<Stock> result = stockService.findById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "List of Clients found");
        response.put("status", true);
        response.put("data", result);

        return ResponseEntity.ok(response);
    }


}
