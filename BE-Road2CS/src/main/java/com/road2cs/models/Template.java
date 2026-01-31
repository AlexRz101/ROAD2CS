package com.road2cs.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

/*
What our templates should contain,
Basically the Template object
WIP
 */
/*
List of objects, get which semester it is, which template is it
 */
@Getter
@Setter
public class Template {
    private String templateId;  // "CS-4YEAR-2024"
    private int years;
    private String workload;
    private boolean summer;
    private boolean winter;
    private String name;        //"4 Years, medium, summer"
    private Collection<Semester> semesters; //4 years = 8 sem, 5 years = 10 sem, 6 years = 12 sems

    public Template(String templateId, int years, String workload, boolean summer,
                    boolean winter, String name, Collection<Semester> semesters) {
        this.templateId = templateId;
        this.years = years;
        this.workload = workload;
        this.summer = summer;
        this.winter = winter;
        this.name = name;
        this.semesters = semesters != null ? semesters : new ArrayList<>();
    }

    //Add a semester to the template
    public void addSemester(Semester semester) {
        this.semesters.add(semester);
    }
}
