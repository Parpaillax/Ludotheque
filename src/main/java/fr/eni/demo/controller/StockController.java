package fr.eni.demo.controller;

import fr.eni.demo.bll.StockService;
import fr.eni.demo.bo.Stock;
import fr.eni.demo.bo.StockCount;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class StockController {

  private final StockService stockService;

<<<<<<< HEAD
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

  // Chercher des stocks par id
  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
    Optional<Stock> result = stockService.findById(id);
    Map<String, Object> response = new HashMap<>();
    response.put("message", "List of Clients found");
    response.put("status", 200);
    response.put("data", result);

    return ResponseEntity.ok(response);
  }

  // Trouver les jeux par nom et compter le result par nom
  // ACCESS PUBLIC
  @GetMapping("/{name}")
  public ResponseEntity<Map<String, Object>> findByName(@PathVariable String name) {
    List<StockCount> result = stockService.findAllByName(name);
    Map<String, Object> response = new HashMap<>();
    response.put("message", "List of Clients found");
    response.put("status", 200);
    response.put("data", result);
    return ResponseEntity.ok(response);
  }
=======
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
>>>>>>> c09dfc497575d616cee9f47afcc62667dbb08b0c
}
