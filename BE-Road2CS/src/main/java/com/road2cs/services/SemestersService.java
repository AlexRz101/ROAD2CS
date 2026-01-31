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

        //Semester 3 - Fall (18 units)
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

        /*
        Still gotta do:
        mediumSem
        mediumSemSummer
        mediumSemWinter
        lightSum&Win
        ^^^^^ all are 4 years

        mediumSem
        lightSem
        ^^^^^ 5 years

        parttimeSem
        ^^^^^ 6 years only

         */
    }

    private Semester createSemester(int number, String term, String... courseCodes) {
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