package com.road2cs.semesters;

import com.road2cs.models.Semester;
import com.road2cs.services.CourseService;

import java.util.Map;

public class PTHybridSemesters {

    public static void register(Map<String, Semester> semesters, CourseService courseService) {

        // ─── Year 1 ───────────────────────────────────────────────────────────────

        //Semester 1 - Fall (9 units)
        semesters.put("ptHybridSem1", createSemester(courseService, 1, "Fall",
                "COMP110-L", "MATH150A"));

        //Semester 2 - Spring (8 units)
        semesters.put("ptHybridSem2", createSemester(courseService, 2, "Spring",
                "COMP182-L", "COMP122-L"));

        //Semester 3 - Summer (3 units)
        semesters.put("ptHybridSem3", createSemester(courseService, 3, "Summer",
                "ENG115"));

        // ─── Year 2 ───────────────────────────────────────────────────────────────

        //Semester 4 - Fall (9 units)
        semesters.put("ptHybridSem4", createSemester(courseService, 4, "Fall",
                "PHIL230", "HIST271", "COMP282"));

        //Semester 5 - Spring (8 units)
        semesters.put("ptHybridSem5", createSemester(courseService, 5, "Spring",
                "MATH150B", "COMS151"));

        //Semester 6 - Summer (4 units)
        semesters.put("ptHybridSem6", createSemester(courseService, 6, "Summer",
                "BIOL106-L"));

        // ─── Year 3 ───────────────────────────────────────────────────────────────

        //Semester 7 - Fall (10 units)
        semesters.put("ptHybridSem7", createSemester(courseService, 7, "Fall",
                "COMP222", "COMP256-L", "AAS100"));

        //Semester 8 - Winter (4 units)
        semesters.put("ptHybridSem8", createSemester(courseService, 8, "Winter",
                "GEOL101", "GEOL102"));

        //Semester 8 - Spring (9 units)
        semesters.put("ptHybridSem9", createSemester(courseService, 9, "Spring",
                "MATH262", "COMP324", "ECON101"));


        // ─── Year 4 ───────────────────────────────────────────────────────────────

        //Semester 10 - Fall (10 units)
        semesters.put("ptHybridSem10", createSemester(courseService, 10, "Fall",
                "COMP310", "MATH340", "COMP380-L"));

        //Semester 11 - Winter (3 units)
        semesters.put("ptHybridSem11", createSemester(courseService, 11, "Winter",
                "POLS155"));

        //Semester 12 - Spring (9 units)
        semesters.put("ptHybridSem12", createSemester(courseService, 12, "Spring",
                "MUS107", "ANTH150", "COMP333"));

        // ─── Year 5 ───────────────────────────────────────────────────────────────

        //Semester 12 - Fall (7 units)
        semesters.put("ptHybridSem13", createSemester(courseService, 13, "Fall",
                "COMP322-L", "COMP482"));

        //Semester 13 - Spring (6 units)
        semesters.put("ptHybridSem14", createSemester(courseService, 14, "Spring",
                "GEOG321", "COMP440", "COMS356"));

        // ─── Senior Year ──────────────────────────────────────────────────────────

        //ML - Fall (9 units)
        semesters.put("ptHybridSemML15", createSemester(courseService, 15, "Fall",
                "COMP490-L", "COMP442", "COMP482"));

        //ML - Spring (9 units)
        semesters.put("ptHybridSemML16", createSemester(courseService, 16, "Spring",
                "COMP491-L", "COMP542", "COMP569"));

        //WD - Fall (9 units)
        semesters.put("ptHybridSemWD15", createSemester(courseService, 15, "Fall",
                "COMP490-L", "COMP484", "COMP484L", "COMP429"));

        //WD - Spring (9 units)
        semesters.put("ptHybridSemWD16", createSemester(courseService, 16, "Spring",
                "COMP491-L", "COMP584", "COMP585"));

        //Game Dev - Fall (9 units)
        semesters.put("ptHybridSemGD15", createSemester(courseService, 15, "Fall",
                "COMP490-L", "COMP467", "COMP485"));

        //Game Dev - Spring (9 units)
        semesters.put("ptHybridSemGD16", createSemester(courseService, 16, "Spring",
                "COMP491-L", "COMP565", "COMP585"));

        //Data Science - Fall (9 units)
        semesters.put("ptHybridSemDS15", createSemester(courseService, 15, "Fall",
                "COMP490-L", "COMP541", "COMP502"));

        //Data Science - Spring (9 units)
        semesters.put("ptHybridSemDS16", createSemester(courseService, 16, "Spring",
                "COMP491-L", "COMP542", "COMP569"));

        //Cybersecurity - Fall (9 units)
        semesters.put("ptHybridSemCS15", createSemester(courseService, 15, "Fall",
                "COMP490-L", "COMP424", "COMP429"));

        //Cybersecurity - Spring (9 units)
        semesters.put("ptHybridSemCS16", createSemester(courseService, 16, "Spring",
                "COMP491-L", "COMP522", "COMP529", "COMP529L"));

        //Software Engineering - Fall (9 units)
        semesters.put("ptHybridSemSE15", createSemester(courseService, 15, "Fall",
                "COMP490-L", "COMP440", "COMP424"));

        //Software Engineering - Spring (9 units)
        semesters.put("ptHybridSemSE16", createSemester(courseService, 16, "Spring",
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