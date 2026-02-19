package com.road2cs.controllers;

import com.road2cs.dtos.*;
import com.road2cs.services.*;
import com.road2cs.services.RateLimitService;
import io.github.bucket4j.Bucket;
import jakarta.servlet.http.HttpServletRequest;
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
    private final RateLimitService rateLimitService;

    public Road2CSController(Road2CSService road2CSService,
                             RateLimitService rateLimitService) {
        this.road2CSService = road2CSService;
        this.rateLimitService = rateLimitService;
    }

    @PostMapping
    public ResponseEntity<RoadmapResponseDTO> returnTemplate(
            @Valid @RequestBody RoadmapRequestDTO request,
            HttpServletRequest httpRequest) {

        //Rate limiting by IP
        String clientIp = httpRequest.getRemoteAddr();
        Bucket bucket = rateLimitService.resolveBucket(clientIp);

        if (!bucket.tryConsume(1)) {
            return ResponseEntity
                    .status(HttpStatus.TOO_MANY_REQUESTS)
                    .body(null);
        }

        try {
            RoadmapResponseDTO response = road2CSService.generateResponse(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}