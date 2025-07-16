package fr.eni.demo.controller;

import fr.eni.demo.bll.GameTypeService;
import fr.eni.demo.bo.GameType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/gametype")
@RequiredArgsConstructor
public class GameTypeController {

    private final GameTypeService gameTypeService;

    // Creer un type de jeu
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody GameType gameType) {
        gameTypeService.add(gameType);
        return buildResponse("Game type created", true, new HashMap<>());
    }

    private ResponseEntity<Map<String, Object>> buildResponse(String message, boolean status, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("status", status);
        response.put("data", data);
        return ResponseEntity.ok(response);
    }
}
