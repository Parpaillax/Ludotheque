package fr.eni.demo.controller;

import fr.eni.demo.bll.FactureService;
import fr.eni.demo.bo.Facture;
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

  // Toutes les factures
  @GetMapping
  public ResponseEntity<Map<String, Object>> getAllFactures() {
    List<Facture> result = factureService.getAll();
    return buildResponse(result);
  }

  // Factures par client
  @GetMapping("/client/{clientId}")
  public ResponseEntity<Map<String, Object>> getFactureByClient(@PathVariable Long clientId) {
    return buildResponse(factureService.getByClient(clientId));
  }

  // Factures impayees
  @GetMapping("/unpayed")
  public ResponseEntity<Map<String, Object>> getUnpayedFactures() {
    List<Facture> result = factureService.getUnpayed();
    return buildResponse(result);
  }

  private ResponseEntity<Map<String, Object>> buildResponse(Object data) {
    Map<String, Object> response = new HashMap<>();
    response.put("data", data);
    response.put("status", 200);
    return ResponseEntity.ok(response);
  }
}
