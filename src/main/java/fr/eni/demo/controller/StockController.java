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
        return buildResponse("Stock added", true, new HashMap<>());
    }

    // Chercher un stock par id
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Optional<Stock> result = stockService.findById(id);
        return buildResponse("Stock found", true, result);
    }

    // Reponse formatée
    private ResponseEntity<Map<String, Object>> buildResponse(String message, boolean status, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("status", status);
        response.put("data", data);
        return ResponseEntity.ok(response);
    }
}
