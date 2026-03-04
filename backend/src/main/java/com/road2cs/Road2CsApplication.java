package com.road2cs;

import com.road2cs.models.Semester;
import com.road2cs.models.Template;
import com.road2cs.services.*;

import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
This is how our app will run, don't touch for now
 */
@SpringBootApplication
public class Road2CsApplication implements CommandLineRunner {

    private final CourseService courseService;
    private final SemesterService semesterService;
    private final TemplateService templateService;

    public Road2CsApplication(CourseService courseService,
                              SemesterService semesterService,
                              TemplateService templateService) {
        this.courseService = courseService;
        this.semesterService = semesterService;
        this.templateService = templateService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Road2CsApplication.class, args);
    }

    @Override
    public void run(String @NonNull ... args) throws Exception {

    }
}
