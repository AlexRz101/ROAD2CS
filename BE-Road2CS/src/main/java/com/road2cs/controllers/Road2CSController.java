package com.road2cs.controllers;

import com.road2cs.dtos.*;
import com.road2cs.services.*;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
Controller that communicates with the frontend via endpoints
Follow: Fat service, Skinny controller
Put logic into service, keep controller minimal as possible
 */
@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/roadmap")
public class Road2CSController {

    private final Road2CSService road2CSService;

    public Road2CSController(Road2CSService road2CSService) {
        this.road2CSService = road2CSService;
    }

    @PostMapping
    public ResponseEntity<RoadmapResponseDTO> returnTemplate(
            @Valid @RequestBody RoadmapRequestDTO request) {

        try {
            RoadmapResponseDTO response = road2CSService.generateResponse(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
