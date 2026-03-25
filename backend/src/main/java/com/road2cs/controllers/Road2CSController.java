package com.road2cs.controllers;

import com.road2cs.dtos.*;
import com.road2cs.services.*;
import com.road2cs.services.RateLimitService;
import io.github.bucket4j.Bucket;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Roadmap endpoints", description = "Only controller used for Road2CS thus far")
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

    @Operation(summary = "Generate a roadmap template",
            description = "An in house template is fetched and returned to the user"
    )
    @PostMapping
    public ResponseEntity<RoadmapResponseDTO> returnTemplate(
            @Valid @RequestBody RoadmapRequestDTO request,
            HttpServletRequest httpRequest) {

        //API/Rate limit buckets reliant on IPs
        String clientIp = httpRequest.getRemoteAddr();
        Bucket bucket = rateLimitService.resolveBucket(clientIp);

        if (!bucket.tryConsume(1)) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(null); //Error 429
        }

        try {
            RoadmapResponseDTO response = road2CSService.generateResponse(request);

            //Invalid params (roadmap type not found/recognized)
            if (response == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); //Error 400
            }

            return ResponseEntity.ok(response); //Success 200

        } catch (IllegalArgumentException e) {
            //Invalid params (bad input that passed @Valid)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); //Error 400

        } catch (Exception e) {
            //General response error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); //Error 500
        }
    }
}