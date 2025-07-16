package fr.eni.demo.controller;

import fr.eni.demo.bll.ClientService;
import fr.eni.demo.bll.LocationService;
import fr.eni.demo.bo.Client;
import fr.eni.demo.bo.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    // Ajouter une location
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody Location location) {
        locationService.add(location);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Location added");
        response.put("status", true);
        response.put("data", new HashMap<>());

        return ResponseEntity.ok(response);
    }

}
