package fr.eni.demo.controller;

import fr.eni.demo.bll.FactureService;
import fr.eni.demo.bll.LocationService;
import fr.eni.demo.bo.Facture;
import fr.eni.demo.bo.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/facture")
@RequiredArgsConstructor
public class FactureController {

  private final FactureService factureService;
  private final LocationService locationService;

  // Toutes les factures
  @GetMapping
  public ResponseEntity<Map<String, Object>> getAllFactures() {
    List<Facture> result = factureService.getAll();
    return buildResponse("List all order", true, result);
  }

  // Factures par client
  @GetMapping("/client/{clientId}")
  public ResponseEntity<Map<String, Object>> getFactureByClient(@PathVariable Long clientId) {
    List<Facture> result = factureService.getByClient(clientId);
    return buildResponse("List order customer", true, result);
  }

  // Factures impayees
  @GetMapping("/unpayed")
  public ResponseEntity<Map<String, Object>> getUnpayedFactures() {
    List<Facture> result = factureService.getUnpayed();
    return buildResponse("List unpayed older", true, result);
  }

  // Génère une facture
  @PostMapping
  public ResponseEntity<Map<String, Object>> setFacture(@RequestBody List<Location> locations) {
    double price = 0;
    for(Location location : locations){
      price += location.getStock().getDailyPrice();
      locationService.updateDateEnd(location.getId(), location);
    }
    Facture facture = new Facture();
    facture.setClient(locations.get(0).getClient());
    facture.setDatePay(new Date());
    facture.setPrice(price);
    factureService.add(facture);
    return buildResponse("Older created", true, new HashMap<>());
  }

  private ResponseEntity<Map<String, Object>> buildResponse(String message, boolean status, Object data) {
    Map<String, Object> response = new HashMap<>();
    response.put("message", message);
    response.put("status", status);
    response.put("data", data);
    return ResponseEntity.ok(response);
  }

}
