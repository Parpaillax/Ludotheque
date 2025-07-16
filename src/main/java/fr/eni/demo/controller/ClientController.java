package fr.eni.demo.controller;

import fr.eni.demo.bll.ClientService;
import fr.eni.demo.bo.Adresse;
import fr.eni.demo.bo.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    // Ajouter un client
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody Client client) {
        clientService.add(client);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Client created successfully");
        response.put("status", 201);
        response.put("data", new HashMap<>());

        return ResponseEntity.ok(response);
    }

    // Chercher des clients par nom
    @GetMapping("/name/{name}")
    public ResponseEntity<Map<String, Object>> findByEmail(@PathVariable String name) {
        List<Client> result = clientService.findByName(name);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "List of Clients found");
        response.put("status", 200);
        response.put("data", result);

        return ResponseEntity.ok(response);
    }

    // Chercher des clients par nom
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findByEmail(@PathVariable Long id) {
        Client result = clientService.findById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Client found");
        response.put("status", true);
        response.put("data", result);

        return ResponseEntity.ok(response);
    }

    // Modifier un client
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> fullUpdate(@PathVariable Long id, @RequestBody Client client, @RequestBody Adresse adresse) {
        clientService.fullUpdate(id, client, adresse);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Client updated successfully");
        response.put("status", true);
        response.put("data", new HashMap<>());

        return ResponseEntity.ok(response);
    }

    // Modifier l'address d'un client
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateAddress(@PathVariable Long id, @RequestBody Adresse adresse) {
        clientService.updateLocation(id, adresse);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Client address updated successfully");
        response.put("status", true);
        response.put("data", new HashMap<>());

        return ResponseEntity.ok(response);
    }

}
