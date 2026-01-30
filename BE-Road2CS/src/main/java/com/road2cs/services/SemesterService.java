package com.road2cs.services;

import com.road2cs.storage.Course;
import com.road2cs.storage.Semester;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class SemesterService {
    private final CoursesService courseService;
    private final Map<String, Semester> semesters;

    public SemesterService(CoursesService courseService) {
        this.courseService = courseService;
        this.semesters = new HashMap<>();
        initializeSemesters();
    }

    /*
    Creating semesters
     */
    private void initializeSemesters() {
        semesters.put("HeavySem1", createSemester(1, "Fall",
                "COMP110-L", "MATH102", "GEO101", "COMS"));

        semesters.put("HeavySem2", createSemester(2, "Spring",
                "COMP182-L", "COMP122-L", "MATH150A-L", "PHIL230", "BIOL101"));

        semesters.put("HeavySem3", createSemester(3, "Fall",
                "COMP301", "MATH383", "STAT101"));

        semesters.put("HeavySem4", createSemester(4, "Fall",
                "COMP110", "MATH110", "ENGL101", "CHEM101"));

        semesters.put("HeavySem5", createSemester(5, "Spring",
                "COMP210", "MATH231", "PHYS101", "BIOL101"));

        semesters.put("HeavySem6", createSemester(6, "Fall",
                "COMP301", "MATH383", "STAT101"));

        semesters.put("HeavySem7", createSemester(7, "Fall",
                "COMP110", "MATH110", "ENGL101", "CHEM101"));

        semesters.put("HeavySem8", createSemester(8, "Spring",
                "COMP210", "MATH231", "PHYS101", "BIOL101"));

        /*
        Still gotta do:
        mediumSem
        mediumSemSummer
        mediumSemWinter
        lightSum&Win
        ^^^^^ all are 4 years

        mediumSem
        lightSem
        ^^^^^ 5 years

        parttimeSem
        ^^^^^ 6 years only

         */
    }

    private Semester createSemester(int number, String term, String... courseCodes) {
        Semester semester = new Semester(number, term);
        for (String code : courseCodes) {
            semester.addCourse(courseService.getCourse(code));
        }
        return semester;
    }
}