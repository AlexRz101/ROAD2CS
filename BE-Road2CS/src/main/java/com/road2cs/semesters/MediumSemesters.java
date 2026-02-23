package com.road2cs.semesters;

import com.road2cs.models.Semester;
import com.road2cs.services.CourseService;

import java.util.Map;

public class MediumSemesters {

    public static void register(Map<String, Semester> semesters, CourseService courseService) {
        /* mediumSem */
        //Semester 1 - Fall (15 units)
        semesters.put("mediumSem1", createSemester(courseService, 1, "Fall",
                "COMP110-L", "MATH150A-L", "COMS151", "ENG115"));

        //Semester 2 - Spring (16 units)
        semesters.put("mediumSem2", createSemester(courseService, 2, "Spring",
                "COMP182-L", "COMP122-L", "MATH150B-L", "PHIL230"));

        //Semester 3 - Fall (14 units)
        semesters.put("mediumSem3", createSemester(courseService, 3, "Fall",
                "COMP282", "COMP222", "COMP256-L", "GEOL101", "GEOL102"));

        //Semester 4 - Spring (16 units)
        semesters.put("mediumSem4", createSemester(courseService, 4, "Spring",
                "MATH262", "BIOL106-L", "ECON101", "POLS155", "AAS100"));

        //Semester 5 - Fall (14 units)
        semesters.put("mediumSem5", createSemester(courseService, 5, "Fall",
                "COMP322-L", "COMP310", "MATH340", "MUS107"));

        //Semester 6 - Spring (15 units)
        semesters.put("mediumSem6", createSemester(courseService, 6, "Spring",
                "COMP333", "COMP380-L", "COMP324", "HIST271", "GEOG321"));

        //Semester 7 - Fall (12 units)
        semesters.put("mediumSem7", createSemester(courseService, 7, "Fall",
                "COMP490-L", "MATH482", "COMP440", "COMS356"));

        //Semester 8 - Spring (3 units)
        semesters.put("mediumSem8", createSemester(courseService, 8, "Spring",
                "COMP491-L"));
    }

    private static Semester createSemester(CourseService courseService, int number, String term, String... courseCodes) {
        Semester semester = new Semester(number, term);
        for (String code : courseCodes) {
            semester.addCourse(courseService.getCourse(code));
        }
        return semester;
    }
}
