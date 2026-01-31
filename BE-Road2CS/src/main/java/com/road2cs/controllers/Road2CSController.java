package com.road2cs.controllers;

import com.road2cs.services.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
Controller that communicates with the frontend via endpoints
Follow: Fat service, Skinny controller
Put logic into service, keep controller minimal as possible
 */
@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/roadmaps")
public class Road2CSController {

    public Road2CSController(Road2CSService road2CSService) {}


}
