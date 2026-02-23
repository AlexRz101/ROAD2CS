package com.road2cs.semesters;

import com.road2cs.models.Semester;
import com.road2cs.services.CourseService;

import java.util.Map;

public class PartTimeSemesters {

    public static void register(Map<String, Semester> semesters, CourseService courseService) {
        semesters.put("ptSem1", createSemester(courseService, 1, "Fall",
                "COMP110-L", "MATH150A-L"));

        semesters.put("ptSem2", createSemester(courseService, 2, "Spring",
                "ENG115", "COMP182-L", "COMP122-L"));

        semesters.put("ptSem3", createSemester(courseService, 3, "Fall",
                "MATH150B-L", "PHIL230"));

        semesters.put("ptSem4", createSemester(courseService, 4, "Spring",
                "COMS151", "GEOL101", "GEOL102"));

        semesters.put("ptSem5", createSemester(courseService, 5, "Fall",
                "COMP222", "COMP256-L"));

        semesters.put("ptSem6", createSemester(courseService, 6, "Spring",
                "COMP282", "ECON101", "POLS155"));

        semesters.put("ptSem7", createSemester(courseService, 7, "Fall",
                "MATH262", "BIOL106-L", "AAS100"));

        semesters.put("ptSem8", createSemester(courseService, 8, "Spring",
                "GEOG321", "COMP322-L","COMS356"));

        semesters.put("ptSem9", createSemester(courseService, 9, "Fall",
                "COMP310", "MATH340", "MUS107"));

        semesters.put("ptSem10", createSemester(courseService, 10, "Spring",
                "HIST271", "COMP333", "COMP380-L"));

        semesters.put("ptSem11", createSemester(courseService, 11, "Fall",
                "COMP324", "COMP440", "COMP490-L"));

        semesters.put("ptSem12", createSemester(courseService, 12, "Spring",
                "COMP491-L", "MATH482"));
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
