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
        if (request.getYears() == 4) {
            if (request.getWorkload().equals("heavy")) {
                return switch (request.getChosenField()) {
                    case "Machine Learning" -> template.getTemplate("CS-4YEAR-HEAVY-ML-2024");
                    case "Web Development" -> template.getTemplate("CS-4YEAR-HEAVY-WD-2024");
                    case "Game Development" -> template.getTemplate("CS-4YEAR-HEAVY-GD-2024");
                    case "Data Science" -> template.getTemplate("CS-4YEAR-HEAVY-DS-2024");
                    case "Cybersecurity" -> template.getTemplate("CS-4YEAR-HEAVY-CS-2024");

                    //Default heavy template (Software Engineering)
                    default -> template.getTemplate("CS-4YEAR-HEAVY-SE-2024");
                };

            } else if (request.getWorkload().equals("medium")) {
                return template.getTemplate("CS-4YEAR-MEDIUM-2024");

            } else if (request.getWorkload().equals("light")) {
                return template.getTemplate("CS-4YEAR-LIGHT-2024");
            }

        } else if (request.getYears() == 5) {
            if (request.getWorkload().equals("light")) {
                return template.getTemplate("CS-5YEAR-LIGHT-2024");
            }

        } else if (request.getYears() == 6) {
            return template.getTemplate("CS-6Year-PT-2024");
        }

        //Default to error
        throw new IllegalArgumentException("Invalid template parameters");
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