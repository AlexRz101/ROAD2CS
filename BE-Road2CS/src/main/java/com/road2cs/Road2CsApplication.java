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

    private final CoursesService coursesService;
    private final SemestersService semestersService;
    private final TemplatesService templatesService;

    public Road2CsApplication(CoursesService coursesService,
                              SemestersService semestersService,
                              TemplatesService templatesService) {
        this.coursesService = coursesService;
        this.semestersService = semestersService;
        this.templatesService = templatesService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Road2CsApplication.class, args);
    }

    @Override
    public void run(String @NonNull ... args) throws Exception {
        System.out.println("------------------------");
        System.out.println("Road2CS Project Baby!!!");
        System.out.println("------------------------");

        //Get the heavy template and print it
        Template heavyTemplate = templatesService.getTemplate("CS-4YEAR-HEAVY-2024");
        Template mediumTemplate = templatesService.getTemplate("CS-4YEAR-MEDIUM-2024");
        Template lightTemplateSW = templatesService.getTemplate("CS-4YEAR-LIGHT-2024");
        Template regLightTemplate = templatesService.getTemplate("CS-5YEAR-LIGHT-2024");
        Template partTimeTemplate = templatesService.getTemplate("CS-6YEAR-LIGHT-2024");
        System.out.println(heavyTemplate);
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
        /*Print semester in order
        System.out.println("=== HEAVY LOAD PATH ===\n");
        for (int i = 1; i <= 8; i++) {
            Semester sem = semestersService.getSemester("heavySem" + i);
            System.out.println(sem);
        }
        */
    }
}
