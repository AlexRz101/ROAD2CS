package com.road2cs;

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

    public Road2CsApplication(CoursesService coursesService,
                              SemestersService semestersService) {
        this.coursesService = coursesService;
        this.semestersService = semestersService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Road2CsApplication.class, args);
    }

    @Override
    public void run(String @NonNull ... args) throws Exception {
        System.out.println("------------------------");
        System.out.println("Road2CS Project Baby!!!");
        System.out.println("------------------------");

        // Now you can use semestersService here!
        System.out.println(semestersService.getAllSemesters());
    }
}
