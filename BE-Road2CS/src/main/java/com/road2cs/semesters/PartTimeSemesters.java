package com.road2cs.semesters;

import com.road2cs.models.Semester;
import com.road2cs.services.CourseService;

import java.util.Map;

public class PartTimeSemesters {

    public static void register(Map<String, Semester> semesters, CourseService courseService) {

        //Semester 1 - Fall (9 units)
        semesters.put("ptSem1", createSemester(courseService, 1, "Fall",
                "COMP110-L", "MATH150A-L"));

        //Semester 2 - Spring (11 units)
        semesters.put("ptSem2", createSemester(courseService, 2, "Spring",
                "COMP182-L", "COMP122-L", "PHIL230"));

        //Semester 3 - Fall (8 units)
        semesters.put("ptSem3", createSemester(courseService, 3, "Fall",
                "MATH150B-L", "ENG115"));

        //Semester 4 - Spring (10 units)
        semesters.put("ptSem4", createSemester(courseService, 4, "Spring",
                "COMP222", "GEOL101", "GEOL102", "MUS107"));

        //Semester 5 - Fall (10 units)
        semesters.put("ptSem5", createSemester(courseService, 5, "Fall",
                "COMS151", "COMP256-L", "HIST271"));

        //Semester 6 - Spring (9 units)
        semesters.put("ptSem6", createSemester(courseService, 6, "Spring",
                "COMP282", "ECON101", "POLS155"));

        //Semester 7 - Fall (10 units)
        semesters.put("ptSem7", createSemester(courseService, 7, "Fall",
                "MATH262", "BIOL106-L", "AAS100"));

        //Semester 8 - Spring (10 units)
        semesters.put("ptSem8", createSemester(courseService, 8, "Spring",
                "COMP322-L", "GEOG321", "COMS356"));

        //Semester 9 - Fall (10 units)
        semesters.put("ptSem9", createSemester(courseService, 9, "Fall",
                "COMP310", "MATH340", "COMP324"));

        //Semester 10 - Spring (9 units)
        semesters.put("ptSem10", createSemester(courseService, 10, "Spring",
                "COMP333", "COMP380-L", "COMP482"));

        //ML - Sem 11 - Fall (9 units)
        semesters.put("ptSemML11", createSemester(courseService, 11, "Fall",
                "COMP442", "COMP424", "COMP429"));

        //ML - Sem 12 - Spring (9 units)
        semesters.put("ptSemML12", createSemester(courseService, 12, "Spring",
                "COMP490-L", "COMP542", "COMP545"));

        //ML - Sem 13 - Fall (6 units)
        semesters.put("ptSemML13", createSemester(courseService, 13, "Fall",
                "COMP491-L", "COMP569"));

        //WD - Sem 11 - Fall (9 units)
        semesters.put("ptSemWD11", createSemester(courseService, 11, "Fall",
                "COMP484", "COMP484L", "COMP424", "COMP429"));

        //WD - Sem 12 - Spring (9 units)
        semesters.put("ptSemWD12", createSemester(courseService, 12, "Spring",
                "COMP490-L", "COMP584", "COMP585"));

        //WD - Sem 13 - Fall (6 units)
        semesters.put("ptSemWD13", createSemester(courseService, 13, "Fall",
                "COMP491-L", "COMP545"));

        //Game Dev - Sem 11 - Fall (9 units)
        semesters.put("ptSemGD11", createSemester(courseService, 11, "Fall",
                "COMP467", "COMP429", "COMP485"));

        //Game Dev - Sem 12 - Spring (9 units)
        semesters.put("ptSemGD12", createSemester(courseService, 12, "Spring",
                "COMP490-L", "COMP585", "COMP586"));

        //Game Dev - Sem 13 - Fall (6 units)
        semesters.put("ptSemGD13", createSemester(courseService, 13, "Fall",
                "COMP491-L", "COMP565"));

        //Data Science - Sem 11 - Fall (9 units)
        semesters.put("ptSemDS11", createSemester(courseService, 11, "Fall",
                "COMP440", "COMP502", "COMP429"));

        //Data Science - Sem 12 - Spring (9 units)
        semesters.put("ptSemDS12", createSemester(courseService, 12, "Spring",
                "COMP490-L", "COMP541", "COMP529", "COMP529L"));

        //Data Science - Sem 13 - Fall (6 units)
        semesters.put("ptSemDS13", createSemester(courseService, 13, "Fall",
                "COMP491-L", "COMP542"));

        //Cybersecurity - Sem 11 - Fall (9 units)
        semesters.put("ptSemCS11", createSemester(courseService, 11, "Fall",
                "COMP424", "COMP429", "COMP545"));

        //Cybersecurity - Sem 12 - Spring (9 units)
        semesters.put("ptSemCS12", createSemester(courseService, 12, "Spring",
                "COMP490-L", "COMP522", "COMP583"));

        //Cybersecurity - Sem 13 - Fall (9 units)
        semesters.put("ptSemCS13", createSemester(courseService, 13, "Fall",
                "COMP491-L", "COMP529", "COMP529L"));

        //Software Engineering - Sem 11 - Fall (9 units)
        semesters.put("ptSemSE11", createSemester(courseService, 11, "Fall",
                "COMP440", "COMP424", "COMP429"));

        //Software Engineering - Sem 12 - Spring (9 units)
        semesters.put("ptSemSE12", createSemester(courseService, 12, "Spring",
                "COMP490-L", "COMP589", "COMP583"));

        //Software Engineering - Sem 13 - Fall (9 units)
        semesters.put("ptSemSE13", createSemester(courseService, 13, "Fall",
                "COMP491-L", "COMP585", "COMP586"));
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