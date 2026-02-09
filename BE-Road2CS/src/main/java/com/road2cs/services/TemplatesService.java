package com.road2cs.services;

import com.road2cs.models.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TemplatesService {

    private final CoursesService courseService;
    private final SemestersService semestersService;
    private final Map<String, Template> templates;

    public TemplatesService(CoursesService courseService,
                            SemestersService semestersService) {
        this.courseService = courseService;
        this.semestersService = semestersService;
        this.templates = new HashMap<>();
        initializeTemplates();
    }

    //Helper method to extract semesters by prefix
    private Map<String, Semester> getSemestersByPrefix(String prefix, int count) {
        Map<String, Semester> allSemesters = semestersService.getSemesterMap();
        Map<String, Semester> result = new HashMap<>();

        for (int i = 1; i <= count; i++) {
            String key = prefix + i;
            result.put(key, allSemesters.get(key));
        }

        return result;
    }

    /* Creating Templates */
    private void initializeTemplates() {
        //Create 4-Year Heavy Template
        Template heavyTemplate = new Template(
                "CS-4YEAR-HEAVY-2024",
                "4 Year Heavy Workload Plan",
                4,
                "heavy",
                false,
                false,
                getSemestersByPrefix("heavySem", 8).values()  //Get Map, then convert to Collection
        );

        //Create 4-Year Medium Template
        Template mediumTemplate = new Template(
                "CS-4YEAR-MEDIUM-2024",
                "4 Year Medium Workload Plan",
                4,
                "medium",
                false,
                false,
                getSemestersByPrefix("mediumSem", 8).values()  //Get Map, then convert to Collection
        );
        Template lightTemplateSW = new Template(
                "CS-4YEAR-light-SW-2024",
                "4 Year light Workload Plan with summer and winter",
                4,
                "light",
                true,
                true,
                getSemestersByPrefix("lightSem", 15).values()  //Get Map, then convert to Collection
        );
        Template regLightTemplate = new Template(
                "CS-5YEAR-light-2024",
                "light 5 year plan",
                4,
                "light",
                false,
                false,
                getSemestersByPrefix("regLightSem", 10).values()  //Get Map, then convert to Collection
        );


        templates.put("CS-4YEAR-HEAVY-2024", heavyTemplate);
        templates.put("CS-4YEAR-MEDIUM-2024", mediumTemplate);
        templates.put("CS-4YEAR-LIGHT-2024", lightTemplateSW);
        templates.put("CS-5YEAR-LIGHT-2024", regLightTemplate);

        /*
        Create more templates like
         */
    }

    //Getter methods
    public Template getTemplate(String templateId) {
        return templates.get(templateId);
    }

    public Map<String, Template> getAllTemplates() {
        return templates;
    }
}
