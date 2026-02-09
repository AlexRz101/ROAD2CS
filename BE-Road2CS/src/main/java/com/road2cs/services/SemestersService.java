package com.road2cs.services;

import com.road2cs.models.Semester;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class SemestersService {
    private final CoursesService courseService;
    private final Map<String, Semester> semesters;

    public SemestersService(CoursesService courseService) {
        this.courseService = courseService;
        this.semesters = new HashMap<>();
        initializeSemesters();
    }

    /* Creating semesters */
    private void initializeSemesters() {

        /* Heavy Load Path - 4 Years (17-18 units per semester) */
        //Semester 1 - Fall (18 units)
        semesters.put("heavySem1", createSemester(1, "Fall",
                "COMP110-L", "MATH150A-L", "COMS151", "ENG115", "MUS107"));

        //Semester 2 - Spring (16 units)
        semesters.put("heavySem2", createSemester(2, "Spring",
                "COMP182-L", "COMP122-L", "MATH150B-L", "PHIL230"));

        //Semester 3 - Fall (7 units)
        semesters.put("heavySem3", createSemester(3, "Fall",
                "COMP282", "COMP222", "COMP256-L", "MATH262", "GEOL101", "GEOL102"));

        //Semester 4 - Spring (16 units)
        semesters.put("heavySem4", createSemester(4, "Spring",
                "BIOL106-L", "HIST271", "ECON101", "POLS155", "AAS100"));

        //Semester 5 - Fall (17 units)
        semesters.put("heavySem5", createSemester(5, "Fall",
                "COMP322-L", "COMP310", "MATH340", "GEOG321", "COMS356"));

        //Semester 6 - Spring (15 units)
        semesters.put("heavySem6", createSemester(6, "Spring",
                "COMP333", "COMP380-L", "COMP324", "MATH482", "COMP440"));

        //Semester 7 - Fall (3 units)
        semesters.put("heavySem7", createSemester(7, "Fall",
                "COMP490-L"));

        //Semester 8 - Spring (3 units)
        semesters.put("heavySem8", createSemester(8, "Spring",
                "COMP491-L"));

        /* Finish the last 2 sems, just random senior cs electives */
        /* mediumSem */
        //Semester 1 - Fall (15 units)
        semesters.put("mediumSem1", createSemester(1, "Fall",
                "COMP110-L", "MATH150A-L", "COMS151", "ENG115"));

        //Semester 2 - Spring (16 units)
        semesters.put("mediumSem2", createSemester(2, "Spring",
                "COMP182-L", "COMP122-L", "MATH150B-L", "PHIL230"));

        //Semester 3 - Fall (14 units)
        semesters.put("mediumSem3", createSemester(3, "Fall",
                "COMP282", "COMP222", "COMP256-L", "GEOL101", "GEOL102"));

        //Semester 4 - Spring (16 units)
        semesters.put("mediumSem4", createSemester(4, "Spring",
                "MATH262", "BIOL106-L", "ECON101", "POLS155", "AAS100"));

        //Semester 5 - Fall (14 units)
        semesters.put("mediumSem5", createSemester(5, "Fall",
                "COMP322-L", "COMP310", "MATH340", "MUS107"));

        //Semester 6 - Spring (15 units)
        semesters.put("mediumSem6", createSemester(6, "Spring",
                "COMP333", "COMP380-L", "COMP324", "HIST271", "GEOG321"));

        //Semester 7 - Fall (12 units)
        semesters.put("mediumSem7", createSemester(7, "Fall",
                "COMP490-L", "MATH482", "COMP440", "COMS356"));

        //Semester 8 - Spring (3 units)
        semesters.put("mediumSem8", createSemester(8, "Spring",
                "COMP491-L"));

        /* -------------------------------------------------- */
        /* lightSum&Win semester: 8 normal semesters, 3 summer, 3 winter */

        semesters.put("lightSem1", createSemester(1, "Fall",
                "COMP110-L", "MATH150A-L", "ENG115"));

        //Semester 2 - Winter (3 units)
        semesters.put("lightSem2", createSemester(2, "Winter", "COMS151"));

        //Semester 3 - Spring
        semesters.put("lightSem3", createSemester(3, "Spring",
                "COMP182-L", "COMP122-L", "MATH150B-L"));
        //Semester 4 - Summer
        semesters.put("lightSem4", createSemester(4, "Summer", "PHIL230"));

        semesters.put("lightSem5", createSemester(5, "Fall",
                "COMP282", "COMP222", "COMP256-L", "GEOL101", "GEOL102"));

        semesters.put("lightSem6", createSemester(6,"winter","GEOG321"));

        semesters.put("lightSem7", createSemester(7, "Spring",
                "MATH262", "BIOL106-L", "ECON101", "POLS155"));

        semesters.put("lightSem8", createSemester(8, "Summer","AAS100"));


        semesters.put("lightSem9", createSemester(9, "Fall",
                "COMP322-L", "COMP310", "MATH340"));

        semesters.put("lightSem10", createSemester(10, "winter",
                "MUS107"));

        semesters.put("lightSem11", createSemester(11, "Spring",
                "COMP333", "COMP380-L", "COMP324" ));

        semesters.put("lightSem12", createSemester(12, "Summer",
                "HIST271"));

        semesters.put("lightSem13", createSemester(13, "Fall",
                "COMP490-L", "MATH482", "COMP440"));

        semesters.put("lightSem14", createSemester(14, "Winter",
                "COMS356"));

        semesters.put("lightSem15", createSemester(15, "Spring",
                "COMP491-L"));

        /* -------------------------------------------------- */
        /* Light semesters: 10 normal semesters */
        semesters.put("regLightSem1", createSemester(1, "Fall",
                "COMP110-L", "MATH150A-L", "ENG115"));

        semesters.put("regLightSem2", createSemester(2, "Spring",
                "COMP182-L", "COMP122-L", "MATH150B-L"));

        semesters.put("regLightSem3", createSemester(3, "Fall",
                "PHIL230", "COMP222", "COMS151","GEOL101", "GEOL102"));

        semesters.put("regLightSem4", createSemester(4, "Spring",
                "COMP256-L", "COMP282", "ECON101", "POLS155"));

        semesters.put("regLightSem5", createSemester(5, "Fall",
                "COMP322-L", "COMP310", "MATH340", "MUS107"));

        semesters.put("regLightSem6", createSemester(6, "Spring",
                "COMP333", "COMP380-L", "COMP324", "HIST271"));

        semesters.put("regLightSem7", createSemester(7, "Fall",
                "MATH262", "BIOL106-L", "GEOG321", "AAS100"));

        semesters.put("regLightSem8", createSemester(8, "Spring",
                "COMP440", "COMS356"));

        semesters.put("regLightSem9", createSemester(9, "Fall",
                "COMP490-L", "MATH482"));

        semesters.put("regLightSem10", createSemester(10, "Spring",
                "COMP491-L"));

        /* -------------------------------------------------- */
        /* Part-time semesters: 12 semester, around 10 units per sem */

        /*
        Still gotta do:
        mediumSemSummer
        mediumSemWinter
        ^^^^^ all are 4 years

        mediumSem
        ^^^^^ 5 years
         */
    }

    private Semester createSemester(double number, String term, String... courseCodes) {
        Semester semester = new Semester(number, term);
        for (String code : courseCodes) {
            semester.addCourse(courseService.getCourse(code));
        }
        return semester;
    }

    public Semester getSemester(String semesterKey) {
        return semesters.get(semesterKey);
    }

    public Collection<Semester> getAllSemesters() {
        return semesters.values();
    }

    public Map<String, Semester> getSemesterMap() {
        return semesters;
    }
}
