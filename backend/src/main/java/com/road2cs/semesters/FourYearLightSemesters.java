package com.road2cs.semesters;

import com.road2cs.models.Semester;
import com.road2cs.services.CourseService;

import java.util.Map;

public class FourYearLightSemesters {

    public static void register(Map<String, Semester> semesters, CourseService courseService) {

        //Semester 1 - Fall (12 units)
        semesters.put("4YearLightSem1", createSemester(courseService, 1, "Fall",
                "COMP110-L", "MATH150A", "COMS151"));

        //Semester 2 - Winter (3 units)
        semesters.put("4YearLightSem2", createSemester(courseService, 2, "Winter",
                "ENG115"));

        //Semester 3 - Spring (13 units)
        semesters.put("4YearLightSem3", createSemester(courseService, 3, "Spring",
                "COMP182-L", "COMP122-L", "MATH150B"));

        //Semester 4 - Summer (7 units)
        semesters.put("4YearLightSem4", createSemester(courseService, 4, "Summer",
                "PHIL230", "GEOL101", "GEOL102"));

        //Semester 5 - Fall (13 units)
        semesters.put("4YearLightSem5", createSemester(courseService, 5, "Fall",
                "COMP282", "COMP222", "COMP256-L", "POLS155"));

        //Semester 6 - Winter (3 units)
        semesters.put("4YearLightSem6", createSemester(courseService, 6, "Winter",
                "ECON101"));

        //Semester 7 - Spring (13 units)
        semesters.put("4YearLightSem7", createSemester(courseService, 7, "Spring",
                "MATH262", "BIOL106-L", "AAS100", "HIST271"));

        //Semester 8 - Summer (6 units)
        semesters.put("4YearLightSem8", createSemester(courseService, 8, "Summer",
                "ANTH150", "MUS107"));

        //Semester 9 - Fall (13 units)
        semesters.put("4YearLightSem9", createSemester(courseService, 9, "Fall",
                "COMP310", "MATH340", "COMS356", "GEOG321"));

        //Semester 10 - Spring (13 units)
        semesters.put("4YearLightSem10", createSemester(courseService, 10, "Spring",
                "COMP322-L", "COMP380-L", "COMP333", "COMP324"));

        //ML - Fall (12 units)
        semesters.put("4YearLightSemML11", createSemester(courseService, 11, "Fall",
                "COMP490-L", "COMP442", "COMP482", "COMP429"));

        //ML - Spring (12 units)
        semesters.put("4YearLightSemML12", createSemester(courseService, 12, "Spring",
                "COMP491-L", "COMP542", "COMP545", "COMP569"));

        //WD - Fall (12 units)
        semesters.put("4YearLightSemWD11", createSemester(courseService, 11, "Fall",
                "COMP490-L", "COMP484", "COMP484L", "COMP482", "COMP429"));

        //WD - Spring (12 units)
        semesters.put("4YearLightSemWD12", createSemester(courseService, 12, "Spring",
                "COMP491-L", "COMP584", "COMP585", "COMP545"));

        //Game Dev - Fall (12 units)
        semesters.put("4YearLightSemGD11", createSemester(courseService, 11, "Fall",
                "COMP490-L", "COMP467", "COMP482", "COMP485"));

        //Game Dev - Spring (12 units)
        semesters.put("4YearLightSemGD12", createSemester(courseService, 12, "Spring",
                "COMP491-L", "COMP585", "COMP586", "COMP565"));

        //Data Science - Fall (12 units)
        semesters.put("4YearLightSemDS11", createSemester(courseService, 11, "Fall",
                "COMP490-L", "COMP440", "COMP482", "COMP429"));

        //Data Science - Spring (12 units)
        semesters.put("4YearLightSemDS12", createSemester(courseService, 12, "Spring",
                "COMP491-L", "COMP541", "COMP529", "COMP529L", "COMP502"));

        //Cybersecurity - Fall (12 units)
        semesters.put("4YearLightSemCS11", createSemester(courseService, 11, "Fall",
                "COMP490-L", "COMP482", "COMP429", "COMP545"));

        //Cybersecurity - Spring (13 units)
        semesters.put("4YearLightSemCS12", createSemester(courseService, 12, "Spring",
                "COMP491-L", "COMP522", "COMP583", "COMP529", "COMP529L"));

        //Software Engineering - Fall (12 units)
        semesters.put("4YearLightSemSE11", createSemester(courseService, 11, "Fall",
                "COMP490-L", "COMP440", "COMP482", "COMP429"));

        //Software Engineering - Spring (12 units)
        semesters.put("4YearLightSemSE12", createSemester(courseService, 12, "Spring",
                "COMP491-L", "COMP589", "COMP583", "COMP586"));
    }

    private static Semester createSemester(CourseService courseService, int number, String term, String... courseCodes) {
        Semester semester = new Semester(number, term);
        for (String code : courseCodes) {
            semester.addCourse(courseService.getCourse(code));
        }
        return semester;
    }
}