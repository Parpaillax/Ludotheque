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

    // Creer un client
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody Client client) {
        clientService.add(client);
        return buildResponse("Client created", true, new HashMap<>());
    }

    // Chercher par nom
    @GetMapping("/name/{name}")
    public ResponseEntity<Map<String, Object>> findByName(@PathVariable String name) {
        List<Client> result = clientService.findByName(name);
        return buildResponse("Clients found", true, result);
    }

    // Chercher par id
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Client result = clientService.findById(id);
        return buildResponse("Client found", true, result);
    }

    // MAJ client complet
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> fullUpdate(@PathVariable Long id, @RequestBody Client client) {
        clientService.fullUpdate(id, client, client.getAdresse());
        return buildResponse("Client updated", true, new HashMap<>());
    }

    // MAJ adresse seule
    @PutMapping("/address/{id}")
    public ResponseEntity<Map<String, Object>> updateAddress(@PathVariable Long id, @RequestBody Adresse adresse) {
        clientService.updateLocation(id, adresse);
        return buildResponse("Address updated", true, new HashMap<>());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        clientService.delete(id);
        return buildResponse("Address deleted", true, new HashMap<>());
    }

    private ResponseEntity<Map<String, Object>> buildResponse(String message, boolean status, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("status", status);
        response.put("data", data);
        return ResponseEntity.ok(response);
    }

}
