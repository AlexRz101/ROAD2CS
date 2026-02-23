package com.road2cs.semesters;

import com.road2cs.models.Semester;
import com.road2cs.services.CourseService;

import java.util.Map;

public class FiveYearLightSemesters {

    public static void register(Map<String, Semester> semesters, CourseService courseService) {

        /* Light semesters: 10 normal semesters */
        semesters.put("regLightSem1", createSemester(courseService, 1, "Fall",
                "COMP110-L", "MATH150A-L", "ENG115"));

        semesters.put("regLightSem2", createSemester(courseService, 2, "Spring",
                "COMP182-L", "COMP122-L", "MATH150B-L"));

        semesters.put("regLightSem3", createSemester(courseService, 3, "Fall",
                "PHIL230", "COMP222", "COMS151","GEOL101", "GEOL102"));

        semesters.put("regLightSem4", createSemester(courseService, 4, "Spring",
                "COMP256-L", "COMP282", "ECON101", "POLS155"));

        semesters.put("regLightSem5", createSemester(courseService, 5, "Fall",
                "COMP322-L", "COMP310", "MATH340", "MUS107"));

        semesters.put("regLightSem6", createSemester(courseService, 6, "Spring",
                "COMP333", "COMP380-L", "COMP324", "HIST271"));

        semesters.put("regLightSem7", createSemester(courseService, 7, "Fall",
                "MATH262", "BIOL106-L", "GEOG321", "AAS100"));

        semesters.put("regLightSem8", createSemester(courseService, 8, "Spring",
                "COMP440", "COMS356"));

        semesters.put("regLightSem9", createSemester(courseService, 9, "Fall",
                "COMP490-L", "MATH482"));

        semesters.put("regLightSem10", createSemester(courseService, 10, "Spring",
                "COMP491-L"));
    }

    private static Semester createSemester(CourseService courseService, int number,
                                           String term, String... courseCodes) {
        Semester semester = new Semester(number, term);
        for (String code : courseCodes) {
            semester.addCourse(courseService.getCourse(code));
        }
        return semester;
    }
}

