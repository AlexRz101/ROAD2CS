package com.road2cs.semesters;

import com.road2cs.models.Semester;
import com.road2cs.services.CourseService;

import java.util.Map;

public class FourYearSummerSemesters {
    public static void register(Map<String, Semester> semesters, CourseService courseService) {

        // ─── Year 1 ───────────────────────────────────────────────────────────────

        //Semester 1 - Fall (15 units)
        semesters.put("medSummerSem1", createSemester(courseService, 1, "Fall",
                "COMP110-L", "MATH150A", "ENG115", "AAS100"));

        //Semester 2 - Spring (13 units)
        semesters.put("medSummerSem2", createSemester(courseService, 2, "Spring",
                "COMP182-L", "COMP122-L", "MATH150B"));

        //Semester 3 - Summer (6 units)
        semesters.put("medSummerSem3", createSemester(courseService, 3, "Summer",
                "ECON101", "POLS155"));

        // ─── Year 2 ───────────────────────────────────────────────────────────────

        //Semester 4 - Fall (16 units)
        semesters.put("medSummerSem4", createSemester(courseService, 4, "Fall",
                "COMP282", "COMP222", "BIOL106-L", "PHIL230", "MUS107"));

        //Semester 5 - Spring (14 units)
        semesters.put("medSummerSem5", createSemester(courseService, 5, "Spring",
                "MATH262", "COMP256-L", "COMS151", "GEOL101", "GEOL102"));

        //Semester 6 - Summer (6 units)
        semesters.put("medSummerSem6", createSemester(courseService, 6, "Summer",
                "HIST271", "ANTH150"));

        // ─── Year 3 ───────────────────────────────────────────────────────────────

        //Semester 7 - Fall (14 units)
        semesters.put("medSummerSem7", createSemester(courseService, 7, "Fall",
                "COMP322-L", "COMP310", "MATH340", "COMS356"));

        //Semester 8 - Spring (12 units)
        semesters.put("medSummerSem8", createSemester(courseService, 8, "Spring",
                "COMP333", "COMP380-L", "COMP324", "GEOG321"));

        // ─── Senior Year ──────────────────────────────────────────────────────────

        //ML Sem 9 - Fall
        semesters.put("medSummerSemML9", createSemester(courseService, 9, "Fall",
                "COMP490-L", "COMP442", "COMP429", "COMP482"));

        //ML Sem 10 - Spring
        semesters.put("medSummerSemML10", createSemester(courseService, 10, "Spring",
                "COMP491-L", "COMP542", "COMP545", "COMP569"));

        //WD Sem 9 - Fall
        semesters.put("medSummerSemWD9", createSemester(courseService, 9, "Fall",
                "COMP490-L", "COMP484", "COMP484L", "COMP482", "COMP440"));

        //WD Sem 10 - Spring
        semesters.put("medSummerSemWD10", createSemester(courseService, 10, "Spring",
                "COMP491-L", "COMP584", "COMP585", "COMP545"));

        //Game Dev Sem 9 - Fall
        semesters.put("medSummerSemGD9", createSemester(courseService, 9, "Fall",
                "COMP490-L", "COMP467", "COMP485", "COMP482"));

        //Game Dev Sem 10 - Spring
        semesters.put("medSummerSemGD10", createSemester(courseService, 10, "Spring",
                "COMP491-L", "COMP585", "COMP586", "COMP565"));

        //Data Science Sem 9 - Fall
        semesters.put("medSummerSemDS9", createSemester(courseService, 9, "Fall",
                "COMP490-L", "COMP541", "COMP502", "COMP482"));

        //Data Science Sem 10 - Spring
        semesters.put("medSummerSemDS10", createSemester(courseService, 10, "Spring",
                "COMP491-L", "COMP542", "COMP545", "COMP569"));

        //Cybersecurity Sem 9 - Fall
        semesters.put("medSummerSemCS9", createSemester(courseService, 9, "Fall",
                "COMP490-L", "COMP482", "COMP545", "COMP440"));

        //Cybersecurity Sem 10 - Spring
        semesters.put("medSummerSemCS10", createSemester(courseService, 10, "Spring",
                "COMP491-L", "COMP522", "COMP583", "COMP529", "COMP529L"));

        //Software Engineering Sem 9 - Fall
        semesters.put("medSummerSemSE9", createSemester(courseService, 9, "Fall",
                "COMP490-L", "COMP440", "COMP424", "COMP429", "COMP482"));

        //Software Engineering Sem 10 - Spring
        semesters.put("medSummerSemSE10", createSemester(courseService, 10, "Spring",
                "COMP491-L", "COMP586", "COMP585", "COMP583"));
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