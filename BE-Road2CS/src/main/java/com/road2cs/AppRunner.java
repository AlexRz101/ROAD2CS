package com.road2cs;

import com.road2cs.models.Semester;
import com.road2cs.models.Template;
import com.road2cs.services.CourseService;
import com.road2cs.services.SemesterService;
import com.road2cs.services.TemplateService;

import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class AppRunner implements CommandLineRunner {

    private final CourseService courseService;
    private final SemesterService semesterService;
    private final TemplateService templateService;

    public AppRunner(TemplateService templateService,
                     CourseService courseService,
                     SemesterService semesterService) {
        this.templateService = templateService;
        this.courseService = courseService;
        this.semesterService = semesterService;
    }

    @Override
    public void run(String @NonNull ... args) throws Exception {
        System.out.println("------------------------");
        System.out.println("Road2CS Project Baby!!!");
        System.out.println("------------------------");

        //Get the heavy template and print it
        Template mediumTemplateML = templateService.getTemplate("CS-4YEAR-MEDIUM-ML-2024");
        Template mediumTemplateWD = templateService.getTemplate("CS-4YEAR-MEDIUM-WD-2024");
        Template mediumTemplateGD = templateService.getTemplate("CS-4YEAR-MEDIUM-ML-2024");
        Template mediumTemplateDS = templateService.getTemplate("CS-4YEAR-MEDIUM-ML-2024");
        Template mediumTemplateCS = templateService.getTemplate("CS-4YEAR-MEDIUM-ML-2024");
        Template mediumTemplateSE = templateService.getTemplate("CS-4YEAR-MEDIUM-ML-2024");
        System.out.println(mediumTemplateML);
        System.out.println();
        System.out.println();
        System.out.println(mediumTemplateWD);
        System.out.println();
        System.out.println();
        System.out.println(mediumTemplateGD);
        System.out.println();
        System.out.println();
        System.out.println(mediumTemplateDS);
        System.out.println();
        System.out.println();
        System.out.println(mediumTemplateCS);
        System.out.println();
        System.out.println();
        System.out.println(mediumTemplateSE);
    }
}