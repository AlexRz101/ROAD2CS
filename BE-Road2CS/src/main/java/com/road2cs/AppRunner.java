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
        Template lightTemplateML = templateService.getTemplate("CS-4YEAR-LIGHT-ML-2024");
        Template lightTemplateWD = templateService.getTemplate("CS-4YEAR-LIGHT-WD-2024");
        Template lightTemplateGD = templateService.getTemplate("CS-4YEAR-LIGHT-GD-2024");
        Template lightTemplateDS = templateService.getTemplate("CS-4YEAR-LIGHT-DS-2024");
        Template lightTemplateCS = templateService.getTemplate("CS-4YEAR-LIGHT-CS-2024");
        Template lightTemplateSE = templateService.getTemplate("CS-4YEAR-LIGHT-SE-2024");

        System.out.println(lightTemplateML);
        System.out.println();
        System.out.println();
        System.out.println(lightTemplateWD);
        System.out.println();
        System.out.println();
        System.out.println(lightTemplateGD);
        System.out.println();
        System.out.println();
        System.out.println(lightTemplateDS);
        System.out.println();
        System.out.println();
        System.out.println(lightTemplateCS);
        System.out.println();
        System.out.println();
        System.out.println(lightTemplateSE);
    }
}