package com.road2cs.semesters;

import com.road2cs.models.Semester;
import com.road2cs.services.CourseService;

import java.util.Map;

public class FourYearLightSemesters {

    public static void register(Map<String, Semester> semesters, CourseService courseService) {

        semesters.put("lightSem1", createSemester(courseService, 1, "Fall",
                "COMP110-L", "MATH150A-L", "ENG115"));

        //Semester 2 - Winter (3 units)
        semesters.put("lightSem2", createSemester(courseService, 2, "Winter", "COMS151"));

        //Semester 3 - Spring
        semesters.put("lightSem3", createSemester(courseService, 3, "Spring",
                "COMP182-L", "COMP122-L", "MATH150B-L"));
        //Semester 4 - Summer
        semesters.put("lightSem4", createSemester(courseService, 4, "Summer", "PHIL230"));

        semesters.put("lightSem5", createSemester(courseService, 5, "Fall",
                "COMP282", "COMP222", "COMP256-L", "GEOL101", "GEOL102"));

        semesters.put("lightSem6", createSemester(courseService, 6,"winter","GEOG321"));

        semesters.put("lightSem7", createSemester(courseService, 7, "Spring",
                "MATH262", "BIOL106-L", "ECON101", "POLS155"));

        semesters.put("lightSem8", createSemester(courseService, 8, "Summer","AAS100"));


        semesters.put("lightSem9", createSemester(courseService, 9, "Fall",
                "COMP322-L", "COMP310", "MATH340"));

        semesters.put("lightSem10", createSemester(courseService, 10, "winter",
                "MUS107"));

        semesters.put("lightSem11", createSemester(courseService, 11, "Spring",
                "COMP333", "COMP380-L", "COMP324" ));

        semesters.put("lightSem12", createSemester(courseService, 12, "Summer",
                "HIST271"));

        semesters.put("lightSem13", createSemester(courseService, 13, "Fall",
                "COMP490-L", "MATH482", "COMP440"));

        semesters.put("lightSem14", createSemester(courseService, 14, "Winter",
                "COMS356"));

        semesters.put("lightSem15", createSemester(courseService, 15, "Spring",
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

