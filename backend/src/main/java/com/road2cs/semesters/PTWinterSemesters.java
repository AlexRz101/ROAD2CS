package com.road2cs.semesters;

import com.road2cs.models.Semester;
import com.road2cs.services.CourseService;

import java.util.Map;

public class PTWinterSemesters {

    public static void register(Map<String, Semester> semesters, CourseService courseService) {

        // ─── Year 1 ───────────────────────────────────────────────────────────────

        //Semester 1 - Fall (9 units)
        semesters.put("ptWinterSem1", createSemester(courseService, 1, "Fall",
                "COMP110-L", "MATH150A"));

        //Semester 2 - Winter (8 units)
        semesters.put("ptWinterSem2", createSemester(courseService, 2, "Winter",
                "COMP182-L", "COMP122-L"));

        //Semester 3 - Spring (3 units)
        semesters.put("ptWinterSemS1", createSemester(courseService, 3, "Spring",
                "ENG115"));

        // ─── Year 2 ───────────────────────────────────────────────────────────────

        //Semester 4 - Fall (9 units)
        semesters.put("ptWinterSem4", createSemester(courseService, 4, "Fall",
                "PHIL230", "HIST271", "COMP282"));

        //Semester 5 - Winter (8 units)
        semesters.put("ptWinterSem5", createSemester(courseService, 5, "Winter",
                "MATH150B", "COMS151"));

        //Semester 6 - Spring (4 units)
        semesters.put("ptWinterSemS2", createSemester(courseService, 6, "Spring",
                "BIOL106-L"));

        // ─── Year 3 ───────────────────────────────────────────────────────────────

        //Semester 7 - Fall (10 units)
        semesters.put("ptWinterSem7", createSemester(courseService, 7, "Fall",
                "COMP222", "COMP256-L", "AAS100"));

        //Semester 8 - Winter (9 units)
        semesters.put("ptWinterSem8", createSemester(courseService, 8, "Winter",
                "MATH262", "COMP324", "ECON101"));

        //Semester 9 - Spring (4 units)
        semesters.put("ptWinterSemS3", createSemester(courseService, 9, "Spring",
                "GEOL101", "GEOL102"));

        // ─── Year 4 ───────────────────────────────────────────────────────────────

        //Semester 10 - Fall (10 units)
        semesters.put("ptWinterSem10", createSemester(courseService, 10, "Fall",
                "COMP310", "POLS155", "MATH340"));

        //Semester 11 - Winter (9 units)
        semesters.put("ptWinterSem11", createSemester(courseService, 11, "Winter",
                "MUS107", "ANTH150", "COMP333"));

        // ─── Year 5 ───────────────────────────────────────────────────────────────

        //Semester 12 - Fall (10 units)
        semesters.put("ptWinterSem12", createSemester(courseService, 12, "Fall",
                "COMP322-L", "COMP482", "COMP380-L"));

        //Semester 13 - Winter (6 units)
        semesters.put("ptWinterSem13", createSemester(courseService, 13, "Winter",
                "GEOG321", "COMP440", "COMS356"));

        // ─── Senior Year ──────────────────────────────────────────────────────────

        //ML - Fall
        semesters.put("ptWinterSemML14", createSemester(courseService, 14, "Fall",
                "COMP490-L", "COMP442", "COMP482"));

        //ML - Winter
        semesters.put("ptWinterSemML15", createSemester(courseService, 15, "Winter",
                "COMP491-L", "COMP542", "COMP569"));


        //WD - Fall
        semesters.put("ptWinterSemWD14", createSemester(courseService, 14, "Fall",
                "COMP490-L", "COMP484", "COMP484L", "COMP429"));

        //WD - Winter
        semesters.put("ptWinterSemWD15", createSemester(courseService, 15, "Winter",
                "COMP491-L", "COMP584", "COMP585"));


        //Game Dev - Fall
        semesters.put("ptWinterSemGD14", createSemester(courseService, 14, "Fall",
                "COMP490-L", "COMP467", "COMP485"));

        //Game Dev - Winter
        semesters.put("ptWinterSemGD15", createSemester(courseService, 15, "Winter",
                "COMP491-L", "COMP565", "COMP585"));


        //Data Science - Fall
        semesters.put("ptWinterSemDS14", createSemester(courseService, 14, "Fall",
                "COMP490-L", "COMP541", "COMP502"));

        //Data Science - Winter
        semesters.put("ptWinterSemDS15", createSemester(courseService, 15, "Winter",
                "COMP491-L", "COMP542", "COMP569"));


        //Cybersecurity - Fall
        semesters.put("ptWinterSemCS14", createSemester(courseService, 14, "Fall",
                "COMP490-L", "COMP424", "COMP429"));

        //Cybersecurity - Winter
        semesters.put("ptWinterSemCS15", createSemester(courseService, 15, "Winter",
                "COMP491-L", "COMP522", "COMP529", "COMP529L"));


        //Software Engineering - Fall
        semesters.put("ptWinterSemSE14", createSemester(courseService, 14, "Fall",
                "COMP490-L", "COMP440", "COMP424"));

        //Software Engineering - Winter
        semesters.put("ptWinterSemSE15", createSemester(courseService, 15, "Winter",
                "COMP491-L", "COMP586", "COMP583", "COMP585"));
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