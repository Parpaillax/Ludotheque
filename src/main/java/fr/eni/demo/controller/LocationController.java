package fr.eni.demo.controller;

import fr.eni.demo.bll.LocationService;
import fr.eni.demo.bo.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    // Ajouter une location
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody Location location) {
        locationService.add(location);
        return buildResponse("Location added", true, new HashMap<>());
    }

    // Chercher location depuis code barre
    @GetMapping("/codeBarre/{codeBarre}")
    public ResponseEntity<Map<String, Object>> findByCodeBarre(@PathVariable String codeBarre) {
        try {
            Location location = locationService.findByCodeBarre(codeBarre);
            return buildResponse("Location trouvée", true, location);
        } catch (NoSuchElementException e) {
            return buildResponse(e.getMessage(), false, new HashMap<>());
        }
    }

    private ResponseEntity<Map<String, Object>> buildResponse(String message, boolean status, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("status", status);
        response.put("data", data);
        return ResponseEntity.ok(response);
    }
}
