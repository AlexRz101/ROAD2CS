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

        if (request == null
                || request.getWorkload() == null || request.getWorkload().isBlank()
                || request.getChosenField() == null || request.getChosenField().isBlank()
                || request.getYears() <= 0) {
            throw new IllegalArgumentException("Please fill in all necessary options.");
        }

        String workload = request.getWorkload().trim().toLowerCase();
        String field = request.getChosenField().trim().toLowerCase();

        if (request.getYears() == 4) {
            if (workload.equals("heavy")) {
                return switch (field) {
                    case "machine learning" -> template.getTemplate("CS-4YEAR-HEAVY-ML-2024");
                    case "web development" -> template.getTemplate("CS-4YEAR-HEAVY-WD-2024");
                    case "game development" -> template.getTemplate("CS-4YEAR-HEAVY-GD-2024");
                    case "data science" -> template.getTemplate("CS-4YEAR-HEAVY-DS-2024");
                    case "cybersecurity" -> template.getTemplate("CS-4YEAR-HEAVY-CS-2024");

                    //Default heavy template (Software Engineering)
                    default -> template.getTemplate("CS-4YEAR-HEAVY-SE-2024");
                };

            } else if (workload.equals("medium")) {
                return switch (field) {
                    case "machine learning" -> template.getTemplate("CS-4YEAR-MEDIUM-ML-2024");
                    case "web development" -> template.getTemplate("CS-4YEAR-MEDIUM-WD-2024");
                    case "game development" -> template.getTemplate("CS-4YEAR-MEDIUM-GD-2024");
                    case "data science" -> template.getTemplate("CS-4YEAR-MEDIUM-DS-2024");
                    case "cybersecurity" -> template.getTemplate("CS-4YEAR-MEDIUM-CS-2024");

                    //Default medium template (Software Engineering)
                    default -> template.getTemplate("CS-4YEAR-MEDIUM-SE-2024");
                };

            } else if (workload.equals("light")) {
                return switch (field) {
                    case "machine learning" -> template.getTemplate("CS-4YEAR-LIGHT-ML-2024");
                    case "web development" -> template.getTemplate("CS-4YEAR-LIGHT-WD-2024");
                    case "game development" -> template.getTemplate("CS-4YEAR-LIGHT-GD-2024");
                    case "data science" -> template.getTemplate("CS-4YEAR-LIGHT-DS-2024");
                    case "cybersecurity" -> template.getTemplate("CS-4YEAR-LIGHT-CS-2024");

                    //Default light template (Software Engineering)
                    default -> template.getTemplate("CS-4YEAR-LIGHT-SE-2024");
                };
            }

        } else if (request.getYears() == 5) {
            if (workload.equals("light")) {
                return switch (field) {
                    case "machine learning" -> template.getTemplate("CS-5YEAR-LIGHT-ML-2024");
                    case "web development" -> template.getTemplate("CS-5YEAR-LIGHT-WD-2024");
                    case "game development" -> template.getTemplate("CS-5YEAR-LIGHT-GD-2024");
                    case "data science" -> template.getTemplate("CS-5YEAR-LIGHT-DS-2024");
                    case "cybersecurity" -> template.getTemplate("CS-5YEAR-LIGHT-CS-2024");

                    //Default light template (Software Engineering)
                    default -> template.getTemplate("CS-5YEAR-LIGHT-SE-2024");
                };
            };

        } else if (request.getYears() == 6) {
                if (workload.equals("light")) {
                    return switch (field) {
                    case "machine learning" -> template.getTemplate("CS-PART-TIME-ML-2024");
                    case "web development" -> template.getTemplate("CS-PART-TIME-WD-2024");
                    case "game development" -> template.getTemplate("CS-PART-TIME-GD-2024");
                    case "data science" -> template.getTemplate("CS-PART-TIME-DS-2024");
                    case "cybersecurity" -> template.getTemplate("CS-PART-TIME-CS-2024");

                    //Default light template (Software Engineering)
                    default -> template.getTemplate("CS-PART-TIME-SE-2024");
                };
            };
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