package com.road2cs.semesters;

import com.road2cs.models.Course;
import com.road2cs.models.Semester;
import com.road2cs.services.CourseService;

import java.util.Map;

public class FourYearWinterSemesters {
    public static void register(Map<String, Semester> semesters, CourseService courseService) {

        // ─── Year 1 ───────────────────────────────────────────────────────────────

        //Semester 1 - Fall (15 units)
        semesters.put("medWinterSem1", createSemester(courseService, 1, "Fall",
                "COMP110-L", "MATH150A", "GE_A2", "GE_F"));

        //Semester 2 - Winter (3 units)
        semesters.put("medWinterSem2", createSemester(courseService, 2, "Winter",
                "GE_C2"));

        //Semester 3 - Spring (13 units)
        semesters.put("medWinterSem3", createSemester(courseService, 3, "Spring",
                "COMP182-L", "COMP122-L", "MATH150B"));

        // ─── Year 2 ───────────────────────────────────────────────────────────────

        //Semester 4 - Fall (16 units)
        semesters.put("medWinterSem4", createSemester(courseService, 4, "Fall",
                "COMP282", "COMP222", "GE_B2B3", "PHIL230", "GE_C3"));

        //Semester 5 - Winter (3 units)
        semesters.put("medWinterSem5", createSemester(courseService, 5, "Winter",
                "GE_D1"));

        //Semester 6 - Spring (14 units)
        semesters.put("medWinterSem6", createSemester(courseService, 6, "Spring",
                "MATH262", "COMP256-L", "GE_A1", "GE_B1B3"));

        // ─── Year 3 ───────────────────────────────────────────────────────────────

        //Semester 7 - Fall (14 units)
        semesters.put("medWinterSem7", createSemester(courseService, 7, "Fall",
                "COMP322-L", "COMP310", "MATH340", "GE_C1"));

        //Semester 8 - Winter (3 units)
        semesters.put("medWinterSem8", createSemester(courseService, 8, "Winter",
                "GE_D3"));

        //Semester 9 - Spring (15 units)
        semesters.put("medWinterSem9", createSemester(courseService, 9, "Spring",
                "COMP333", "COMP380-L", "COMP324", "GEOG321", "COMS356"));

        // ─── Senior Year ──────────────────────────────────────────────────────────

        //ML Sem1 - Fall
        semesters.put("medWinterSemML10", createSemester(courseService, 10, "Fall",
                "COMP490-L", "COMP442", "COMP429", "COMP482"));

        //ML Sem2 - Spring
        semesters.put("medWinterSemML11", createSemester(courseService, 11, "Spring",
                "COMP491-L", "COMP542", "COMP545", "COMP569"));

        //WD Sem1 - Fall
        semesters.put("medWinterSemWD10", createSemester(courseService, 10, "Fall",
                "COMP490-L", "COMP484-L", "COMP482", "COMP440"));

        //WD Sem2 - Spring
        semesters.put("medWinterSemWD11", createSemester(courseService, 11, "Spring",
                "COMP491-L", "COMP584", "COMP585", "COMP545"));

        //Game Dev Sem1 - Fall
        semesters.put("medWinterSemGD10", createSemester(courseService, 10, "Fall",
                "COMP490-L", "COMP467", "COMP485", "COMP482"));

        //Game Dev Sem2 - Spring
        semesters.put("medWinterSemGD11", createSemester(courseService, 11, "Spring",
                "COMP491-L", "COMP585", "COMP586", "COMP565"));

        //Data Science Sem1 - Fall
        semesters.put("medWinterSemDS10", createSemester(courseService, 10, "Fall",
                "COMP490-L", "COMP541", "COMP502", "COMP482"));

        //Data Science Sem2 - Spring
        semesters.put("medWinterSemDS11", createSemester(courseService, 11, "Spring",
                "COMP491-L", "COMP542", "COMP545", "COMP569"));

        //Cybersecurity Sem1 - Fall
        semesters.put("medWinterSemCS10", createSemester(courseService, 10, "Fall",
                "COMP490-L", "COMP482", "COMP545", "COMP440"));

        //Cybersecurity Sem2 - Spring
        semesters.put("medWinterSemCS11", createSemester(courseService, 11, "Spring",
                "COMP491-L", "COMP522", "COMP583", "COMP529", "COMP529L"));

        //Software Engineering Sem1 - Fall
        semesters.put("medWinterSemSE10", createSemester(courseService, 10, "Fall",
                "COMP490-L", "COMP440", "COMP424", "COMP429", "COMP482"));

        //Software Engineering Sem2 - Spring
        semesters.put("medWinterSemSE11", createSemester(courseService, 11, "Spring",
                "COMP491-L", "COMP586", "COMP585", "COMP583"));
    }

    private static Semester createSemester(CourseService courseService, int number,
                                           String term, String... courseCodes) {
        Semester semester = new Semester(number, term);
        for (String code : courseCodes) {
            Course course;
            if (code.startsWith("GE_")) {
                course = courseService.getRandomCourseByType(code);
            } else {
                course = courseService.getCourse(code);
            }
            semester.addCourse(course);
        }
        return semester;
    }
}