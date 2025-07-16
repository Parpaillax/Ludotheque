package fr.eni.demo.controller;

import fr.eni.demo.bll.AdresseService;
import fr.eni.demo.bo.Adresse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final AdresseService adresseService;

    // Creer nouvelle adresse
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody Adresse adresse) {
        Adresse saved = adresseService.add(adresse);
        return buildResponse("Adresse added", true, saved);
    }

    // Recuperer adresse par id
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable String id) {
        Adresse result = adresseService.findById(Long.valueOf(id));
        return buildResponse("Adresse found", true, result);
    }

    // Recuperer toutes les adresses
    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll() {
        List<Adresse> result = adresseService.findAll();
        return buildResponse("All adresses fetched", true, result);
    }

    // Maj adresse par id
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable String id, @RequestBody Adresse adresse) {
        Adresse updated = adresseService.update(Long.valueOf(id), adresse);
        return buildResponse("Adresse updated", true, updated);
    }

    // Supprimer adresse par id
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable String id) {
        adresseService.delete(Long.valueOf(id));
        return buildResponse("Adresse deleted", true, null);
    }

    // Recuperer adresse associee à un client via son id
    @GetMapping("/client/{clientId}")
    public ResponseEntity<Map<String, Object>> findByClientId(@PathVariable String clientId) {
        Adresse result = adresseService.findAdresseByClientId(Long.valueOf(clientId));
        return buildResponse("Adresse found for client", true, result);
    }

    private ResponseEntity<Map<String, Object>> buildResponse(String message, boolean status, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("status", status);
        response.put("data", data);
        return ResponseEntity.ok(response);
    }
}
