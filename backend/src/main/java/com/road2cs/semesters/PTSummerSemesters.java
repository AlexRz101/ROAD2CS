package com.road2cs.semesters;

import com.road2cs.models.Semester;
import com.road2cs.services.CourseService;

import java.util.Map;

public class PTSummerSemesters {

    public static void register(Map<String, Semester> semesters, CourseService courseService) {

        // ─── Year 1 ───────────────────────────────────────────────────────────────

        //Semester 1 - Fall (9 units)
        semesters.put("ptSummerSem1", createSemester(courseService, 1, "Fall",
                "COMP110-L", "MATH150A"));

        //Semester 2 - Spring (8 units)
        semesters.put("ptSummerSem2", createSemester(courseService, 2, "Spring",
                "COMP182-L", "COMP122-L"));

        //Semester 3 - Summer (3 units)
        semesters.put("ptSummerSem3", createSemester(courseService, 3, "Summer",
                "GE_A2"));

        // ─── Year 2 ───────────────────────────────────────────────────────────────

        //Semester 4 - Fall (9 units)
        semesters.put("ptSummerSem4", createSemester(courseService, 4, "Fall",
                "PHIL230", "GE_C3", "COMP282"));

        //Semester 5 - Spring (8 units)
        semesters.put("ptSummerSem5", createSemester(courseService, 5, "Spring",
                "MATH150B", "GE_A1"));

        //Semester 6 - Summer (4 units)
        semesters.put("ptSummerSem6", createSemester(courseService, 6, "Summer",
                "GE_B2B3"));

        // ─── Year 3 ───────────────────────────────────────────────────────────────

        //Semester 7 - Fall (10 units)
        semesters.put("ptSummerSem7", createSemester(courseService, 7, "Fall",
                "COMP222", "COMP256-L", "GE_F"));

        //Semester 8 - Spring (9 units)
        semesters.put("ptSummerSem8", createSemester(courseService, 8, "Spring",
                "MATH262", "COMP324", "GE_C2"));

        //Semester 9 - Summer (4 units)
        semesters.put("ptSummerSem9", createSemester(courseService, 9, "Summer",
                "GE_B1B3"));

        // ─── Year 4 ───────────────────────────────────────────────────────────────

        //Semester 10 - Fall (10 units)
        semesters.put("ptSummerSem10", createSemester(courseService, 10, "Fall",
                "COMP310", "POLS155", "MATH340"));

        //Semester 11 - Spring (9 units)
        semesters.put("ptSummerSem11", createSemester(courseService, 11, "Spring",
                "GE_C1", "ANTH150", "COMP333"));

        // ─── Year 5 ───────────────────────────────────────────────────────────────

        //Semester 12 - Fall (10 units)
        semesters.put("ptSummerSem12", createSemester(courseService, 12, "Fall",
                "COMP322-L", "COMP482", "COMP380-L"));

        //Semester 13 - Spring (6 units)
        semesters.put("ptSummerSem13", createSemester(courseService, 13, "Spring",
                "GEOG321", "COMP440", "COMS356"));

        // ─── Senior Year ──────────────────────────────────────────────────────────

        //ML - Fall (9 units)
        semesters.put("ptSummerSemML14", createSemester(courseService, 14, "Fall",
                "COMP490-L", "COMP442", "COMP482"));

        //ML - Spring (9 units)
        semesters.put("ptSummerSemML15", createSemester(courseService, 15, "Spring",
                "COMP491-L", "COMP542", "COMP569"));

        //WD - Fall (9 units)
        semesters.put("ptSummerSemWD14", createSemester(courseService, 14, "Fall",
                "COMP490-L", "COMP484-L", "COMP429"));

        //WD - Spring (9 units)
        semesters.put("ptSummerSemWD15", createSemester(courseService, 15, "Spring",
                "COMP491-L", "COMP584", "COMP585"));

        //Game Dev - Fall (9 units)
        semesters.put("ptSummerSemGD14", createSemester(courseService, 14, "Fall",
                "COMP490-L", "COMP467", "COMP485"));

        //Game Dev - Spring (9 units)
        semesters.put("ptSummerSemGD15", createSemester(courseService, 15, "Spring",
                "COMP491-L", "COMP565", "COMP585"));

        //Data Science - Fall (9 units)
        semesters.put("ptSummerSemDS14", createSemester(courseService, 14, "Fall",
                "COMP490-L", "COMP541", "COMP502"));

        //Data Science - Spring (9 units)
        semesters.put("ptSummerSemDS15", createSemester(courseService, 15, "Spring",
                "COMP491-L", "COMP542", "COMP569"));

        //Cybersecurity - Fall (9 units)
        semesters.put("ptSummerSemCS14", createSemester(courseService, 14, "Fall",
                "COMP490-L", "COMP424", "COMP429"));

        //Cybersecurity - Spring (9 units)
        semesters.put("ptSummerSemCS15", createSemester(courseService, 15, "Spring",
                "COMP491-L", "COMP522", "COMP529", "COMP529L"));

        //Software Engineering - Fall (9 units)
        semesters.put("ptSummerSemSE14", createSemester(courseService, 14, "Fall",
                "COMP490-L", "COMP440", "COMP424"));

        //Software Engineering - Spring (9 units)
        semesters.put("ptSummerSemSE15", createSemester(courseService, 15, "Spring",
                "COMP491-L", "COMP586", "COMP583"));
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