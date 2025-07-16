package fr.eni.demo.controller;

import fr.eni.demo.bll.AdresseService;
import fr.eni.demo.bll.StockService;
import fr.eni.demo.bo.Adresse;
import fr.eni.demo.bo.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final AdresseService adresseService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody Adresse adresse) {
        adresseService.add(adresse);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Adresse added");
        response.put("status", true);
        response.put("data", new HashMap<>());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Adresse result = adresseService.findById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Adresse find");
        response.put("status", true);
        response.put("data", result);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Map<String, Object>> findByIdClient(@PathVariable Long id) {
        Adresse result = adresseService.findAdresseByClientId(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Adresse find");
        response.put("status", true);
        response.put("data", result);

        return ResponseEntity.ok(response);
    }

}
