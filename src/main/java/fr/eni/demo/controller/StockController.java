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

  // Ajouter un stock
  @PostMapping
  public ResponseEntity<Map<String, Object>> create(@RequestBody Stock stock) {
    stockService.add(stock);
    return buildResponse("Stock added", true, new HashMap<>());
  }

  // Chercher des stocks par id
  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
    Optional<Stock> result = stockService.findById(id);
    return buildResponse("Stock fetched", true, result);
  }

  // Trouver les jeux par nom et compter le result par nom
  // ACCESS PUBLIC
  @GetMapping("/search/{name}")
  public ResponseEntity<Map<String, Object>> findByName(@PathVariable String name) {
    List<StockCount> result = stockService.findAllByName(name);
    return buildResponse("List stock fetched", true, result);
  }

  @GetMapping("/{ref}")
  public ResponseEntity<Map<String, Object>> findByRef(@PathVariable String ref) {
    Stock result = stockService.findByRef(ref);
    return buildResponse("Stock fetched", true, result);
  }

  private ResponseEntity<Map<String, Object>> buildResponse(String message, boolean status, Object data) {
    Map<String, Object> response = new HashMap<>();
    response.put("message", message);
    response.put("status", status);
    response.put("data", data);
    return ResponseEntity.ok(response);
  }
}
