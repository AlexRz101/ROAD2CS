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
        //4-Year Medium Summer Templates
        Template medSummerML = templateService.getTemplate("CS-4YEAR-MEDIUM-SUMMER-ML-2024");
        Template medSummerWD = templateService.getTemplate("CS-4YEAR-MEDIUM-SUMMER-WD-2024");
        System.out.println("------Medium Summer Templates------");
        System.out.println(medSummerML);
        System.out.println(medSummerWD);
        System.out.println();

        //4-Year Medium Winter Templates
        Template medWinterML = templateService.getTemplate("CS-4YEAR-MEDIUM-WINTER-ML-2024");
        Template medWinterWD = templateService.getTemplate("CS-4YEAR-MEDIUM-WINTER-WD-2024");
        System.out.println("------Medium Winter Templates------");
        System.out.println(medWinterML);
        System.out.println(medWinterWD);
        System.out.println();

        //6-Year Part-Time Hybrid Templates
        Template partTimeHybridML = templateService.getTemplate("CS-PART-TIME-HYBRID-ML-2024");
        Template partTimeHybridWD = templateService.getTemplate("CS-PART-TIME-HYBRID-WD-2024");
        System.out.println("------Part-Time Hybrid Templates------");
        System.out.println(partTimeHybridML);
        System.out.println(partTimeHybridWD);
        System.out.println();

        //6-Year Part-Time Summer Templates
        Template partTimeSummerML = templateService.getTemplate("CS-PART-TIME-SUMMER-ML-2024");
        Template partTimeSummerWD = templateService.getTemplate("CS-PART-TIME-SUMMER-WD-2024");
        System.out.println("------Part-Time Summer Templates------");
        System.out.println(partTimeSummerML);
        System.out.println(partTimeSummerWD);
        System.out.println();

        //6-Year Part-Time Winter Templates
        Template partTimeWinterML = templateService.getTemplate("CS-PART-TIME-WINTER-ML-2024");
        Template partTimeWinterWD = templateService.getTemplate("CS-PART-TIME-WINTER-WD-2024");
        System.out.println("------Part-Time Winter Templates------");
        System.out.println(partTimeWinterML);
        System.out.println(partTimeWinterWD);
        System.out.println();
 */
    }
}