package com.road2cs.semesters;

import com.road2cs.models.Semester;
import com.road2cs.services.CourseService;

import java.util.Map;

public class HeavySemesters {

    public static void register(Map<String, Semester> semesters, CourseService courseService) {

        /* Heavy Load Path - 4 Years (17-18 units per semester) */
        //Semester 1 - Fall (18 units)
        semesters.put("heavySem1", createSemester(courseService, 1, "Fall",
                "COMP110-L", "MATH150A", "GE_A1", "GE_A2", "GE_C1"));

        //Semester 2 - Spring (16 units)
        semesters.put("heavySem2", createSemester(courseService, 2, "Spring",
                "COMP182-L", "COMP122-L", "MATH150B", "PHIL230"));

        //Semester 3 - Fall (17 units)
        semesters.put("heavySem3", createSemester(courseService, 3, "Fall",
                "COMP282", "COMP222", "COMP256-L", "MATH262", "GE_B1/B3"));

        //Semester 4 - Spring (16 units)
        semesters.put("heavySem4", createSemester(courseService, 4, "Spring",
                "GE_B2B3", "GE_C3", "GE_C2", "POLS155", "GE_F"));

        //Semester 5 - Fall (17 units)
        semesters.put("heavySem5", createSemester(courseService, 5, "Fall",
                "COMP322-L", "COMP310", "MATH340", "GEOG321", "ANTH150"));

        //Semester 6 - Spring (15 units)
        semesters.put("heavySem6", createSemester(courseService, 6, "Spring",
                "COMP333", "COMP380-L", "COMP324", "COMP482", "COMS356"));

        /* HeavySemester Senior Field Semesters */

        //ML Sem1 - Fall (15 units)
        semesters.put("heavySemML7", createSemester(courseService, 7, "Fall",
                "COMP490-L", "COMP442", "COMP424", "COMP429"));

        //ML Sem2 - Spring (12 units)
        semesters.put("heavySemML8", createSemester(courseService, 8, "Spring",
                "COMP491-L", "COMP542", "COMP545", "COMP569"));

        //WD Sem1 - Fall (12 units)
        semesters.put("heavySemWD7", createSemester(courseService, 7, "Fall",
                "COMP490-L", "COMP484", "COMP484L", "COMP424", "COMP429"));

        //WD Sem2 - Spring (12 units)
        semesters.put("heavySemWD8", createSemester(courseService, 8, "Spring",
                "COMP491-L", "COMP584", "COMP585", "COMP545"));

        //Game Dev Sem1 - Fall
        semesters.put("heavySemGD7", createSemester(courseService, 7, "Fall",
                "COMP490-L", "COMP467", "COMP565", "COMP485"));

        //Game Dev Sem2 - Spring
        semesters.put("heavySemGD8", createSemester(courseService, 8, "Spring",
                "COMP491-L", "COMP585", "COMP586"));

        //Data Science Sem1 - Fall
        semesters.put("heavySemDS7", createSemester(courseService, 7, "Fall",
                "COMP490-L", "COMP541", "COMP502", "COMP440"));

        //Data Science Sem2 - Spring
        semesters.put("heavySemDS8", createSemester(courseService, 8, "Spring",
                "COMP491-L", "COMP542", "COMP569"));

        //Cybersecurity Sem1 - Fall
        semesters.put("heavySemCS7", createSemester(courseService, 7, "Fall",
                "COMP490-L", "COMP424", "COMP429", "COMP545"));

        //Cybersecurity Sem2 - Spring
        semesters.put("heavySemCS8", createSemester(courseService, 8, "Spring",
                "COMP491-L", "COMP522", "COMP583"));

        //Software Engineering Sem1 - Fall
        semesters.put("heavySemSE7", createSemester(courseService, 7, "Fall",
                "COMP490-L", "COMP583", "COMP586", "COMP430"));

        //Software Engineering Sem2 - Spring
        semesters.put("heavySemSE8", createSemester(courseService, 8, "Spring",
                "COMP491-L", "COMP589", "COMP585", "COMP502"));
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