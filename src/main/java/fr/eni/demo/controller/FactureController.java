package fr.eni.demo.controller;

import fr.eni.demo.bll.FactureService;
import fr.eni.demo.bo.Facture;
import fr.eni.demo.bo.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/facture")
@RequiredArgsConstructor
public class FactureController {

  private final FactureService factureService;

  @GetMapping()
  public ResponseEntity<Map<String, Object>> getAllFactures() {
    List<Facture> result = factureService.getAll();
    Map<String, Object> response = new HashMap<>();
    response.put("data", result);
    response.put("status", 200);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/client/{id}")
  public ResponseEntity<Map<String, Object>> getFactureByClient(@PathVariable Long clientId) {
    Map<String, Object> response = new HashMap<>();
    response.put("data", factureService.getByClient(clientId));
    response.put("status", 200);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/unpayed")
  public ResponseEntity<Map<String, Object>> getUnpayedFactures() {
    List<Facture> result = factureService.getUnpayed();
    Map<String, Object> response = new HashMap<>();
    response.put("data", result);
    response.put("status", 200);
    return ResponseEntity.ok(response);
  }
}
