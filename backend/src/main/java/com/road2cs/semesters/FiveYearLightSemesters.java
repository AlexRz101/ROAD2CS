package com.road2cs.semesters;

import com.road2cs.models.Semester;
import com.road2cs.services.CourseService;

import java.util.Map;

public class FiveYearLightSemesters {

    public static void register(Map<String, Semester> semesters, CourseService courseService) {

        //Semester 1 - Fall (12 units)
        semesters.put("5YearLightSem1", createSemester(courseService, 1, "Fall",
                "COMP110-L", "MATH150A", "GE_A2"));

        //Semester 2 - Spring (13 units)
        semesters.put("5YearLightSem2", createSemester(courseService, 2, "Spring",
                "COMP182-L", "COMP122-L", "MATH150B"));

        //Semester 3 - Fall (13 units)
        semesters.put("5YearLightSem3", createSemester(courseService, 3, "Fall",
                "COMP282", "COMP222", "GE_B1B3", "GE_A1"));

        //Semester 4 - Spring (12 units)
        semesters.put("5YearLightSem4", createSemester(courseService, 4, "Spring",
                "GE_C2", "MATH262", "PHIL230", "POLS155"));

        //Semester 5 - Fall (12 units)
        semesters.put("5YearLightSem5", createSemester(courseService, 5, "Fall",
                "MATH340", "GE_B2B3", "COMP256-L"));

        //Semester 6 - Spring (13 units)
        semesters.put("5YearLightSem6", createSemester(courseService, 6, "Spring",
                "COMP322-L", "ANTH150", "COMP333", "GE_F"));

        //Semester 7 - Fall (13 units)
        semesters.put("5YearLightSem7", createSemester(courseService, 7, "Fall",
                "COMP380-L", "GE_C3","COMP310", "GE_C1"));

        //Semester 8 - Spring (12 units)
        semesters.put("5YearLightSem8", createSemester(courseService, 8, "Spring",
                "COMP324", "COMP482", "GEOG321", "COMS356"));

        //ML - Fall (12 units)
        semesters.put("5YearLightSemML9", createSemester(courseService, 9, "Fall",
                "COMP490-L", "COMP442", "COMP424", "COMP429"));

        //ML - Spring (12 units)
        semesters.put("5YearLightSemML10", createSemester(courseService, 10, "Spring",
                "COMP491-L", "COMP542", "COMP545", "COMP569"));

        //WD - Fall (12 units)
        semesters.put("5YearLightSemWD9", createSemester(courseService, 9, "Fall",
                "COMP490-L", "COMP484-L", "COMP424", "COMP429"));

        //WD - Spring (12 units)
        semesters.put("5YearLightSemWD10", createSemester(courseService, 10, "Spring",
                "COMP491-L", "COMP584", "COMP585", "COMP545"));

        //Game Dev - Fall (12 units)
        semesters.put("5YearLightSemGD9", createSemester(courseService, 9, "Fall",
                "COMP490-L", "COMP467", "COMP429", "COMP485"));

        //Game Dev - Spring (12 units)
        semesters.put("5YearLightSemGD10", createSemester(courseService, 10, "Spring",
                "COMP491-L", "COMP585", "COMP586", "COMP565"));

        //Data Science - Fall (12 units)
        semesters.put("5YearLightSemDS9", createSemester(courseService, 9, "Fall",
                "COMP490-L", "COMP440", "COMP424", "COMP429"));

        //Data Science - Spring (12 units)
        semesters.put("5YearLightSemDS10", createSemester(courseService, 10, "Spring",
                "COMP491-L", "COMP541", "COMP529", "COMP529L", "COMP502"));

        //Cybersecurity - Fall (12 units)
        semesters.put("5YearLightSemCS9", createSemester(courseService, 9, "Fall",
                "COMP490-L", "COMP424", "COMP429", "COMP545"));

        //Cybersecurity - Spring (13 units)
        semesters.put("5YearLightSemCS10", createSemester(courseService, 10, "Spring",
                "COMP491-L", "COMP522", "COMP583", "COMP529", "COMP529L"));

        //Software Engineering - Fall (12 units)
        semesters.put("5YearLightSemSE9", createSemester(courseService, 9, "Fall",
                "COMP490-L", "COMP440", "COMP424", "COMP429"));

        //Software Engineering - Spring (12 units)
        semesters.put("5YearLightSemSE10", createSemester(courseService, 10, "Spring",
                "COMP491-L", "COMP589", "COMP583", "COMP586"));
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