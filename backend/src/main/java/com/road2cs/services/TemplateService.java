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

    private Template createMediumTemplate(String track, String trackName) {
        Map<String, Semester> sems = getSemestersByPrefix("mediumSem", 6);
        sems.put("sem7", semesterService.getSemester("mediumSem" + track + "7"));
        sems.put("sem8", semesterService.getSemester("mediumSem" + track + "8"));

        return new Template(
                "CS-4YEAR-MEDIUM-" + track + "-2024",
                "4 Year Medium - " + trackName,
                4, "medium", false, false,
                sems.values()
        );
    }

    private Template createMediumSummerTemplate(String track, String trackName) {
        Map<String, Semester> sems = getSemestersByPrefix("medSummerSem", 8);
        sems.put("sem9", semesterService.getSemester("medSummerSem" + track + "9"));
        sems.put("sem10", semesterService.getSemester("medSummerSem" + track + "10"));

        return new Template(
                "CS-4YEAR-MEDIUM-SUMMER-" + track + "-2024",
                "4 Year Medium Summer - " + trackName,
                4, "medium", false, false,
                sems.values()
        );
    }

    private Template createMediumWinterTemplate(String track, String trackName) {
        Map<String, Semester> sems = getSemestersByPrefix("medWinterSem", 9);
        sems.put("sem10", semesterService.getSemester("medWinterSem" + track + "10"));
        sems.put("sem11", semesterService.getSemester("medWinterSem" + track + "11"));

        return new Template(
                "CS-4YEAR-MEDIUM-WINTER-" + track + "-2024",
                "4 Year Medium Summer - " + trackName,
                4, "medium", false, false,
                sems.values()
        );
    }

    private Template create4YearLightTemplate(String track, String trackName) {
        Map<String, Semester> sems = getSemestersByPrefix("4YearLightSem", 10);
        sems.put("sem11", semesterService.getSemester("4YearLightSem" + track + "11"));
        sems.put("sem12", semesterService.getSemester("4YearLightSem" + track + "12"));

        return new Template(
                "CS-4YEAR-LIGHT-" + track + "-2024",
                "4 Year Light - " + trackName,
                4, "light", true, true,
                sems.values()
        );
    }

    private Template create5YearLightTemplate(String track, String trackName) {
        Map<String, Semester> sems = getSemestersByPrefix("5YearLightSem", 8);
        sems.put("sem9", semesterService.getSemester("5YearLightSem" + track + "9"));
        sems.put("sem10", semesterService.getSemester("5YearLightSem" + track + "10"));

        return new Template(
                "CS-5YEAR-LIGHT-" + track + "-2024",
                "5 Year Light - " + trackName,
                5, "light", false, false,
                sems.values()
        );
    }

    private Template createPartTimeTemplate(String track, String trackName) {
        Map<String, Semester> sems = getSemestersByPrefix("ptSem", 10);
        sems.put("sem11", semesterService.getSemester("ptSem" + track + "11"));
        sems.put("sem12", semesterService.getSemester("ptSem" + track + "12"));

        return new Template(
                "CS-PART-TIME-" + track + "-2024",
                "Part-Time - " + trackName,
                6, "part-time", false, false,
                sems.values()
        );
    }

    private Template createPartTimeSummerTemplate(String track, String trackName) {
        Map<String, Semester> sems = getSemestersByPrefix("ptSummerSem", 13);
        sems.put("sem14", semesterService.getSemester("ptSummerSem" + track + "14"));
        sems.put("sem15", semesterService.getSemester("ptSummerSem" + track + "15"));

        return new Template(
                "CS-PART-TIME-SUMMER-" + track + "-2024",
                "Part-Time Summer - " + trackName,
                6, "part-time", false, false,
                sems.values()
        );
    }

    private Template createPartTimeWinterTemplate(String track, String trackName) {
        Map<String, Semester> sems = getSemestersByPrefix("ptWinterSem", 13);
        sems.put("sem14", semesterService.getSemester("ptWinterSem" + track + "14"));
        sems.put("sem15", semesterService.getSemester("ptWinterSem" + track + "15"));

        return new Template(
                "CS-PART-TIME-WINTER-" + track + "-2024",
                "Part-Time Winter - " + trackName,
                6, "part-time", false, false,
                sems.values()
        );
    }

    private Template createPartTimeHybridTemplate(String track, String trackName) {
        Map<String, Semester> sems = getSemestersByPrefix("ptHybridSem", 14);
        sems.put("sem15", semesterService.getSemester("ptHybridSem" + track + "15"));
        sems.put("sem16", semesterService.getSemester("ptHybridSem" + track + "16"));

        return new Template(
                "CS-PART-TIME-HYBRID-" + track + "-2024",
                "Part-Time Hybrid - " + trackName,
                6, "part-time", false, false,
                sems.values()
        );
    }

    /* Creating Templates */
    private void initializeTemplates() {
        // 4 Year Heavy - one per track
        templates.put("CS-4YEAR-HEAVY-ML-2024", createHeavyTemplate("ML", "Machine Learning"));
        templates.put("CS-4YEAR-HEAVY-WD-2024", createHeavyTemplate("WD", "Web Development"));
        templates.put("CS-4YEAR-HEAVY-GD-2024", createHeavyTemplate("GD", "Game Development"));
        templates.put("CS-4YEAR-HEAVY-DS-2024", createHeavyTemplate("DS", "Data Science"));
        templates.put("CS-4YEAR-HEAVY-CS-2024", createHeavyTemplate("CS", "Cybersecurity"));
        templates.put("CS-4YEAR-HEAVY-SE-2024", createHeavyTemplate("SE", "Software Engineering"));

        // 4 Year Medium - one per track
        templates.put("CS-4YEAR-MEDIUM-ML-2024", createMediumTemplate("ML", "Machine Learning"));
        templates.put("CS-4YEAR-MEDIUM-WD-2024", createMediumTemplate("WD", "Web Development"));
        templates.put("CS-4YEAR-MEDIUM-GD-2024", createMediumTemplate("GD", "Game Development"));
        templates.put("CS-4YEAR-MEDIUM-DS-2024", createMediumTemplate("DS", "Data Science"));
        templates.put("CS-4YEAR-MEDIUM-CS-2024", createMediumTemplate("CS", "Cybersecurity"));
        templates.put("CS-4YEAR-MEDIUM-SE-2024", createMediumTemplate("SE", "Software Engineering"));

        // 4 Year Medium Summer
        templates.put("CS-4YEAR-MEDIUM-SUMMER-ML-2024", createMediumSummerTemplate("ML", "Machine Learning"));
        templates.put("CS-4YEAR-MEDIUM-SUMMER-WD-2024", createMediumSummerTemplate("WD", "Web Development"));
        templates.put("CS-4YEAR-MEDIUM-SUMMER-GD-2024", createMediumSummerTemplate("GD", "Game Development"));
        templates.put("CS-4YEAR-MEDIUM-SUMMER-DS-2024", createMediumSummerTemplate("DS", "Data Science"));
        templates.put("CS-4YEAR-MEDIUM-SUMMER-CS-2024", createMediumSummerTemplate("CS", "Cybersecurity"));
        templates.put("CS-4YEAR-MEDIUM-SUMMER-SE-2024", createMediumSummerTemplate("SE", "Software Engineering"));

        // 4 Year Medium Winter
        templates.put("CS-4YEAR-MEDIUM-WINTER-ML-2024", createMediumWinterTemplate("ML", "Machine Learning"));
        templates.put("CS-4YEAR-MEDIUM-WINTER-WD-2024", createMediumWinterTemplate("WD", "Web Development"));
        templates.put("CS-4YEAR-MEDIUM-WINTER-GD-2024", createMediumWinterTemplate("GD", "Game Development"));
        templates.put("CS-4YEAR-MEDIUM-WINTER-DS-2024", createMediumWinterTemplate("DS", "Data Science"));
        templates.put("CS-4YEAR-MEDIUM-WINTER-CS-2024", createMediumWinterTemplate("CS", "Cybersecurity"));
        templates.put("CS-4YEAR-MEDIUM-WINTER-SE-2024", createMediumWinterTemplate("SE", "Software Engineering"));

        // 4 Year Light
        templates.put("CS-4YEAR-LIGHT-ML-2024", create4YearLightTemplate("ML", "Machine Learning"));
        templates.put("CS-4YEAR-LIGHT-WD-2024", create4YearLightTemplate("WD", "Web Development"));
        templates.put("CS-4YEAR-LIGHT-GD-2024", create4YearLightTemplate("GD", "Game Development"));
        templates.put("CS-4YEAR-LIGHT-DS-2024", create4YearLightTemplate("DS", "Data Science"));
        templates.put("CS-4YEAR-LIGHT-CS-2024", create4YearLightTemplate("CS", "Cybersecurity"));
        templates.put("CS-4YEAR-LIGHT-SE-2024", create4YearLightTemplate("SE", "Software Engineering"));

        // 5 Year Light
        templates.put("CS-5YEAR-LIGHT-ML-2024", create5YearLightTemplate("ML", "Machine Learning"));
        templates.put("CS-5YEAR-LIGHT-WD-2024", create5YearLightTemplate("WD", "Web Development"));
        templates.put("CS-5YEAR-LIGHT-GD-2024", create5YearLightTemplate("GD", "Game Development"));
        templates.put("CS-5YEAR-LIGHT-DS-2024", create5YearLightTemplate("DS", "Data Science"));
        templates.put("CS-5YEAR-LIGHT-CS-2024", create5YearLightTemplate("CS", "Cybersecurity"));
        templates.put("CS-5YEAR-LIGHT-SE-2024", create5YearLightTemplate("SE", "Software Engineering"));

        // 6 Year Part-Time
        templates.put("CS-PART-TIME-ML-2024", createPartTimeTemplate("ML", "Machine Learning"));
        templates.put("CS-PART-TIME-WD-2024", createPartTimeTemplate("WD", "Web Development"));
        templates.put("CS-PART-TIME-GD-2024", createPartTimeTemplate("GD", "Game Development"));
        templates.put("CS-PART-TIME-DS-2024", createPartTimeTemplate("DS", "Data Science"));
        templates.put("CS-PART-TIME-CS-2024", createPartTimeTemplate("CS", "Cybersecurity"));
        templates.put("CS-PART-TIME-SE-2024", createPartTimeTemplate("SE", "Software Engineering"));

        // Part-Time Summer
        templates.put("CS-PART-TIME-SUMMER-ML-2024", createPartTimeSummerTemplate("ML", "Machine Learning"));
        templates.put("CS-PART-TIME-SUMMER-WD-2024", createPartTimeSummerTemplate("WD", "Web Development"));
        templates.put("CS-PART-TIME-SUMMER-GD-2024", createPartTimeSummerTemplate("GD", "Game Development"));
        templates.put("CS-PART-TIME-SUMMER-DS-2024", createPartTimeSummerTemplate("DS", "Data Science"));
        templates.put("CS-PART-TIME-SUMMER-CS-2024", createPartTimeSummerTemplate("CS", "Cybersecurity"));
        templates.put("CS-PART-TIME-SUMMER-SE-2024", createPartTimeSummerTemplate("SE", "Software Engineering"));

        // Part-Time Winter
        templates.put("CS-PART-TIME-WINTER-ML-2024", createPartTimeWinterTemplate("ML", "Machine Learning"));
        templates.put("CS-PART-TIME-WINTER-WD-2024", createPartTimeWinterTemplate("WD", "Web Development"));
        templates.put("CS-PART-TIME-WINTER-GD-2024", createPartTimeWinterTemplate("GD", "Game Development"));
        templates.put("CS-PART-TIME-WINTER-DS-2024", createPartTimeWinterTemplate("DS", "Data Science"));
        templates.put("CS-PART-TIME-WINTER-CS-2024", createPartTimeWinterTemplate("CS", "Cybersecurity"));
        templates.put("CS-PART-TIME-WINTER-SE-2024", createPartTimeWinterTemplate("SE", "Software Engineering"));

        // Part-Time Hybrid
        templates.put("CS-PART-TIME-HYBRID-ML-2024", createPartTimeHybridTemplate("ML", "Machine Learning"));
        templates.put("CS-PART-TIME-HYBRID-WD-2024", createPartTimeHybridTemplate("WD", "Web Development"));
        templates.put("CS-PART-TIME-HYBRID-GD-2024", createPartTimeHybridTemplate("GD", "Game Development"));
        templates.put("CS-PART-TIME-HYBRID-DS-2024", createPartTimeHybridTemplate("DS", "Data Science"));
        templates.put("CS-PART-TIME-HYBRID-CS-2024", createPartTimeHybridTemplate("CS", "Cybersecurity"));
        templates.put("CS-PART-TIME-HYBRID-SE-2024", createPartTimeHybridTemplate("SE", "Software Engineering"));
    }

    //Getter methods
    public Template getTemplate(String templateId) {
        return templates.get(templateId);
    }

    public Map<String, Template> getAllTemplates() {
        return templates;
    }
}
