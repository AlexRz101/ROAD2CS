package com.road2cs.services;

import com.road2cs.models.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TemplateService {

    private final CourseService courseService;
    private final SemesterService semesterService;
    private final Map<String, Template> templates;

    public TemplateService(CourseService courseService,
                            SemesterService semesterService) {
        this.courseService = courseService;
        this.semesterService = semesterService;
        this.templates = new HashMap<>();
        initializeTemplates();
    }

    //Helper method to extract semesters by prefix
    private Map<String, Semester> getSemestersByPrefix(String prefix, int count) {
        Map<String, Semester> allSemesters = semesterService.getSemesterMap();
        Map<String, Semester> result = new HashMap<>();

        for (int i = 1; i <= count; i++) {
            String key = prefix + i;
            result.put(key, allSemesters.get(key));
        }

        return result;
    }

    private Template createHeavyTemplate(String track, String trackName) {
        Map<String, Semester> sems = getSemestersByPrefix("heavySem", 6);
        sems.put("sem7", semesterService.getSemester("heavySem" + track + "7"));
        sems.put("sem8", semesterService.getSemester("heavySem" + track + "8"));

        return new Template(
                "CS-4YEAR-HEAVY-" + track + "-2024",
                "4 Year Heavy - " + trackName,
                4, "heavy", false, false,
                sems.values()
        );
    }

    /* Creating Templates */
    private void initializeTemplates() {
        // Heavy - one per track
        templates.put("CS-4YEAR-HEAVY-ML-2024", createHeavyTemplate("ML", "Machine Learning"));
        templates.put("CS-4YEAR-HEAVY-WD-2024", createHeavyTemplate("WD", "Web Development"));
        templates.put("CS-4YEAR-HEAVY-GD-2024", createHeavyTemplate("GD", "Game Development"));
        templates.put("CS-4YEAR-HEAVY-DS-2024", createHeavyTemplate("DS", "Data Science"));
        templates.put("CS-4YEAR-HEAVY-CS-2024", createHeavyTemplate("CS", "Cybersecurity"));
        templates.put("CS-4YEAR-HEAVY-SE-2024", createHeavyTemplate("SE", "Software Engineering"));

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

        Template partTimeTemplate = new Template(
                "CS-6YEAR-PT-2024",
                "light 6 year plan",
                6,
                "light",
                false,
                false,
                getSemestersByPrefix("ptSem", 12).values()  //Get Map, then convert to Collection
        );

        templates.put("CS-4YEAR-MEDIUM-2024", mediumTemplate);
        templates.put("CS-4YEAR-LIGHT-2024", lightTemplateSW);
        templates.put("CS-5YEAR-LIGHT-2024", regLightTemplate);
        templates.put("CS-6YEAR-LIGHT-2024", partTimeTemplate);
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
