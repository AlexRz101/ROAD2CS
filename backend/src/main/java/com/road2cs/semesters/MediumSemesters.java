package com.road2cs.semesters;

import com.road2cs.models.Course;
import com.road2cs.models.Semester;
import com.road2cs.services.CourseService;

import java.util.Map;

public class MediumSemesters {
    public static void register(Map<String, Semester> semesters, CourseService courseService) {
        /* mediumSem */
        //Semester 1 - Fall (15 units)
        semesters.put("mediumSem1", createSemester(courseService, 1, "Fall",
                "COMP110-L", "MATH150A", "GE_A1", "GE_A2"));

        //Semester 2 - Spring (16 units)
        semesters.put("mediumSem2", createSemester(courseService, 2, "Spring",
                "COMP182-L", "COMP122-L", "MATH150B", "PHIL230"));

        //Semester 3 - Fall (14 units)
        semesters.put("mediumSem3", createSemester(courseService, 3, "Fall",
                "COMP282", "COMP222", "COMP256-L", "GE_B1B3"));

        //Semester 4 - Spring (16 units)
        semesters.put("mediumSem4", createSemester(courseService, 4, "Spring",
                "MATH262", "GE_B2B3", "GE_C2", "GE_D3", "GE_F"));

        //Semester 5 - Fall (14 units)
        semesters.put("mediumSem5", createSemester(courseService, 5, "Fall",
                "COMP322-L", "COMP310", "MATH340", "GE_C1"));

        //Semester 6 - Spring (15 units)
        semesters.put("mediumSem6", createSemester(courseService, 6, "Spring",
                "COMP333", "COMP380-L", "COMP324", "GE_C3", "GE_D1"));

        //ML Sem1 - Fall (15 units)
        semesters.put("mediumSemML7", createSemester(courseService, 7, "Fall",
                "COMP490-L", "COMP442", "COMP429", "GEOG321", "COMP482"));

        //ML Sem2 - Spring (15 units)
        semesters.put("mediumSemML8", createSemester(courseService, 8, "Spring",
                "COMP491-L", "COMP542", "COMP545", "COMP569", "COMS356"));

        //WD Sem1 - Fall (15 units)
        semesters.put("mediumSemWD7", createSemester(courseService, 7, "Fall",
                "COMP490-L", "COMP484-L", "COMP424", "GEOG321", "COMP482"));

        //WD Sem2 - Spring (15 units)
        semesters.put("mediumSemWD8", createSemester(courseService, 8, "Spring",
                "COMP491-L", "COMP584", "COMP585", "COMP545", "COMS356"));

        //Game Dev Sem1 - Fall (15 units)
        semesters.put("mediumSemGD7", createSemester(courseService, 7, "Fall",
                "COMP490-L", "COMP467", "GEOG321", "COMP485", "COMP482"));

        //Game Dev Sem2 - Spring (15 units)
        semesters.put("mediumSemGD8", createSemester(courseService, 8, "Spring",
                "COMP491-L", "COMP585", "COMP586", "COMP565", "COMS356"));

        //Data Science Sem1 - Fall (15 units)
        semesters.put("mediumSemDS7", createSemester(courseService, 7, "Fall",
                "COMP490-L", "COMP440", "COMP502", "GEOG321", "COMP482"));

        //Data Science Sem2 - Spring (15 units)
        semesters.put("mediumSemDS8", createSemester(courseService, 8, "Spring",
                "COMP491-L", "COMP541", "COMP542", "COMP569", "COMS356"));

        //Cybersecurity Sem1 - Fall (15 units)
        semesters.put("mediumSemCS7", createSemester(courseService, 7, "Fall",
                "COMP490-L", "COMP429", "COMP424", "GEOG321", "COMP482"));

        //Cybersecurity Sem2 - Spring (15 units)
        semesters.put("mediumSemCS8", createSemester(courseService, 8, "Spring",
                "COMP491-L", "COMP522", "COMP545", "COMP529", "COMP529L", "COMS356"));

        //Software Engineering Sem1 - Fall (15 units)
        semesters.put("mediumSemSE7", createSemester(courseService, 7, "Fall",
                "COMP490-L", "COMP430", "COMP440", "GEOG321", "COMP482"));

        //Software Engineering Sem2 - Spring (15 units)
        semesters.put("mediumSemSE8", createSemester(courseService, 8, "Spring",
                "COMP491-L", "COMP583", "COMP585", "COMP586", "COMS356"));
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
