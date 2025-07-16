package fr.eni.demo.controller;

import fr.eni.demo.bll.GameTypeService;
import fr.eni.demo.bo.GameType;
import fr.eni.demo.bo.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/gametype")
@RequiredArgsConstructor
public class GameTypeController {

    private final GameTypeService gameTypeService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody GameType gameType) {
        gameTypeService.add(gameType);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Game type create");
        response.put("status", true);
        response.put("data", new HashMap<>());

        return ResponseEntity.ok(response);
    }

}
