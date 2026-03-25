package com.road2cs.services;

import com.road2cs.models.Semester;
import com.road2cs.semesters.*;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class SemesterService {
    private final CourseService courseService;
    private final Map<String, Semester> semesters;

    public SemesterService(CourseService courseService) {
        this.courseService = courseService;
        this.semesters = new HashMap<>();
        initializeSemesters();
    }

    private void initializeSemesters() {
        HeavySemesters.register(semesters, courseService);
        MediumSemesters.register(semesters, courseService);
        FourYearSummerSemesters.register(semesters, courseService);
        FourYearWinterSemesters.register(semesters, courseService);
        FourYearLightSemesters.register(semesters, courseService);
        FiveYearLightSemesters.register(semesters, courseService);
        PartTimeSemesters.register(semesters, courseService);
        PTSummerSemesters.register(semesters, courseService);
        PTWinterSemesters.register(semesters, courseService);
        PTHybridSemesters.register(semesters, courseService);
    }


    public Semester getSemester(String semesterKey) {
        return semesters.get(semesterKey);
    }

    public Collection<Semester> getAllSemesters() {
        return semesters.values();
    }

    public Map<String, Semester> getSemesterMap() {
        return semesters;
    }
}
