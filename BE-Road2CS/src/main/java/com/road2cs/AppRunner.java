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
        Template heavyTemplateML = templateService.getTemplate("CS-4YEAR-HEAVY-ML-2024");
        Template heavyTemplateWD = templateService.getTemplate("CS-4YEAR-HEAVY-WD-2024");
        Template heavyTemplateGD = templateService.getTemplate("CS-4YEAR-HEAVY-ML-2024");
        Template heavyTemplateDS = templateService.getTemplate("CS-4YEAR-HEAVY-ML-2024");
        Template heavyTemplateCS = templateService.getTemplate("CS-4YEAR-HEAVY-ML-2024");
        Template heavyTemplateSE = templateService.getTemplate("CS-4YEAR-HEAVY-ML-2024");
        System.out.println(heavyTemplateML);
        System.out.println();
        System.out.println();
        System.out.println(heavyTemplateWD);
        System.out.println();
        System.out.println();
        System.out.println(heavyTemplateGD);
        System.out.println();
        System.out.println();
        System.out.println(heavyTemplateDS);
        System.out.println();
        System.out.println();
        System.out.println(heavyTemplateCS);
        System.out.println();
        System.out.println();
        System.out.println(heavyTemplateSE);
        /*
        Template mediumTemplate = templateService.getTemplate("CS-4YEAR-MEDIUM-2024");
        Template lightTemplateSW = templateService.getTemplate("CS-4YEAR-LIGHT-2024");
        Template regLightTemplate = templateService.getTemplate("CS-5YEAR-LIGHT-2024");
        Template partTimeTemplate = templateService.getTemplate("CS-6YEAR-LIGHT-2024");
        System.out.println();
        System.out.println();
        System.out.println(mediumTemplate);
        System.out.println();
        System.out.println();
        System.out.println(lightTemplateSW);
        System.out.println();
        System.out.println();
        System.out.println(regLightTemplate);
        System.out.println();
        System.out.println();
        System.out.println(partTimeTemplate);
         */
    }
}