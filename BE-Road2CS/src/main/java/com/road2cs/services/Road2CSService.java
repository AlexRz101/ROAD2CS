package com.road2cs.services;

import com.road2cs.dtos.*;
import com.road2cs.models.*;
import org.springframework.stereotype.Service;

/*
Core logic of Road2CS
This Service class handles how our templates are used, how we use the courses
How we verify checkboxes, make sure valid templates are returned, etc.
 */
@Service
public class Road2CSService {

    private final TemplateService template;

    public Road2CSService(TemplateService template) {
        this.template = template;
    }

    /* Helper Methods */
    //Fetching the proper template
    public Template fetchTemplate(RoadmapRequestDTO request) {
        if (request.getYears() == 4 && request.getWorkload().equals("heavy")) {
            return template.getTemplate("CS-4YEAR-HEAVY-2024");

        } else if (request.getYears() == 4 && request.getWorkload().equals("medium")) {
            return template.getTemplate("CS-4YEAR-MEDIUM-2024");

        } else if (request.getYears() == 4 && request.getWorkload().equals("light")) {
            return template.getTemplate("CS-4YEAR-LIGHT-2024");

        } else if (request.getYears() == 5 && request.getWorkload().equals("light")) {
            return template.getTemplate("CS-5YEAR-LIGHT-2024");

        } else {
            throw new IllegalArgumentException("Invalid template parameters");
        }
    }

    //Return to controller
    public RoadmapResponseDTO generateResponse(RoadmapRequestDTO request) {

        Template userTemplate = fetchTemplate(request);

        //Simple Error Check
        if (userTemplate == null) {
            throw new IllegalArgumentException("Template not found");
        }

        //Build response
        RoadmapResponseDTO response = new RoadmapResponseDTO();
        response.setYears(request.getYears());
        response.setWorkload(request.getWorkload());
        response.setSummer(request.isSummer());
        response.setWinter(request.isWinter());
        response.setChosenField(request.getChosenField());
        response.setTemplate(userTemplate);
        response.setUnits(userTemplate.getTotalCredits());
        response.setRecommendedUnits(15);

        return response;
    }

    /* Error checks */

}