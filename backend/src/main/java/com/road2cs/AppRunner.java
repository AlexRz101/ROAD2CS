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

        /*
        //Get the heavy template and print it
        Template ptTemplateML = templateService.getTemplate("CS-PART-TIME-ML-2024");
        Template ptTemplateWD = templateService.getTemplate("CS-PART-TIME-WD-2024");
        Template ptTemplateGD = templateService.getTemplate("CS-PART-TIME-GD-2024");
        Template ptTemplateDS = templateService.getTemplate("CS-PART-TIME-DS-2024");
        Template ptTemplateCS = templateService.getTemplate("CS-PART-TIME-CS-2024");
        Template ptTemplateSE = templateService.getTemplate("CS-PART-TIME-SE-2024");

        System.out.println(ptTemplateML);
        System.out.println();
        System.out.println();
        System.out.println(ptTemplateWD);
        System.out.println();
        System.out.println();
        System.out.println(ptTemplateGD);
        System.out.println();
        System.out.println();
        System.out.println(ptTemplateDS);
        System.out.println();
        System.out.println();
        System.out.println(ptTemplateCS);
        System.out.println();
        System.out.println();
        System.out.println(ptTemplateSE);
         */
    }
}