package com.road2cs.semesters;

import com.road2cs.models.Semester;
import com.road2cs.services.CourseService;

import java.util.Map;

public class PartTimeSemesters {

    public static void register(Map<String, Semester> semesters, CourseService courseService) {

        // ── Base Semesters 1–10 (shared across all fields) ──────────────────

        //Semester 1 - Fall (11 units)
        semesters.put("ptSem1", createSemester(courseService, 1, "Fall",
                "COMP110-L", "GE_B2B3", "GE_A2"));

        //Semester 2 - Spring (11 units)
        semesters.put("ptSem2", createSemester(courseService, 2, "Spring",
                "MATH150A", "POLS155", "PHIL230"));

        //Semester 3 - Fall (11 units)
        semesters.put("ptSem3", createSemester(courseService, 3, "Fall",
                "COMP182-L", "COMP122-L", "GE_A1"));

        //Semester 4 - Spring (11 units)
        semesters.put("ptSem4", createSemester(courseService, 4, "Spring",
                "COMP256-L", "GE_B1/B3", "GE_C3"));

        //Semester 5 - Fall (11 units)
        semesters.put("ptSem5", createSemester(courseService, 5, "Fall",
                "GE_F", "MATH150B", "COMP282"));

        //Semester 6 - Spring (10 units)
        semesters.put("ptSem6", createSemester(courseService, 6, "Spring",
                "MATH340", "GE_C1", "COMP222"));

        //Semester 7 - Fall (9 units)
        semesters.put("ptSem7", createSemester(courseService, 7, "Fall",
                "ANTH150", "COMP310", "GE_C2"));

        //Semester 8 - Spring (10 units)
        semesters.put("ptSem8", createSemester(courseService, 8, "Spring",
               "COMP322-L", "MATH262", "GEOG321"));

        //Semester 9 - Fall (9 units)
        semesters.put("ptSem9", createSemester(courseService, 9, "Fall",
                "COMP380-L", "COMP333", "COMS356"));

        //Semester 10 - Spring (9 units)
        semesters.put("ptSem10", createSemester(courseService, 10, "Spring",
                "COMP482", "COMP440", "COMP324"));

        // ── Machine Learning ─────────────────────────────────────────────────

        //ML - Sem 11 - Fall (COMP490-L + electives)
        semesters.put("ptSemML11", createSemester(courseService, 11, "Fall",
                "COMP490-L", "COMP442", "COMP429"));

        //ML - Sem 12 - Spring (COMP491-L + electives)
        semesters.put("ptSemML12", createSemester(courseService, 12, "Spring",
                "COMP491-L", "COMP542", "COMP569"));

        // ── Web Development ──────────────────────────────────────────────────

        //WD - Sem 11 - Fall (COMP490-L + electives)
        semesters.put("ptSemWD11", createSemester(courseService, 11, "Fall",
                "COMP490-L", "COMP484", "COMP484L", "COMP424"));

        //WD - Sem 12 - Spring (COMP491-L + electives)
        semesters.put("ptSemWD12", createSemester(courseService, 12, "Spring",
                "COMP491-L", "COMP584", "COMP545"));

        // ── Game Development ─────────────────────────────────────────────────

        //Game Dev - Sem 11 - Fall (COMP490-L + electives)
        semesters.put("ptSemGD11", createSemester(courseService, 11, "Fall",
                "COMP490-L", "COMP467", "COMP485"));

        //Game Dev - Sem 12 - Spring (COMP491-L + electives)
        semesters.put("ptSemGD12", createSemester(courseService, 12, "Spring",
                "COMP491-L", "COMP585", "COMP586"));

        // ── Data Science ─────────────────────────────────────────────────────

        //Data Science - Sem 11 - Fall (COMP490-L + electives)
        semesters.put("ptSemDS11", createSemester(courseService, 11, "Fall",
                "COMP490-L", "COMP424", "COMP429"));

        //Data Science - Sem 12 - Spring (COMP491-L + electives)
        semesters.put("ptSemDS12", createSemester(courseService, 12, "Spring",
                "COMP491-L", "COMP541", "COMP502"));

        // ── Cybersecurity ────────────────────────────────────────────────────

        //Cybersecurity - Sem 11 - Fall (COMP490-L + electives)
        semesters.put("ptSemCS11", createSemester(courseService, 11, "Fall",
                "COMP490-L", "COMP424", "COMP429"));

        //Cybersecurity - Sem 12 - Spring (COMP491-L + electives)
        semesters.put("ptSemCS12", createSemester(courseService, 12, "Spring",
                "COMP491-L", "COMP522", "COMP529", "COMP529L"));

        // ── Software Engineering ─────────────────────────────────────────────

        //Software Engineering - Sem 11 - Fall (COMP490-L + electives)
        semesters.put("ptSemSE11", createSemester(courseService, 11, "Fall",
                "COMP490-L", "COMP424", "COMP429"));

        //Software Engineering - Sem 12 - Spring (COMP491-L + electives)
        semesters.put("ptSemSE12", createSemester(courseService, 12, "Spring",
                "COMP491-L", "COMP589", "COMP586"));
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