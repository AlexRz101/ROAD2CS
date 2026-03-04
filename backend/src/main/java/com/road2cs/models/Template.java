package com.road2cs.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/*
What our templates should contain,
Basically the Template object
WIP
 */
@Getter
@Setter
public class Template {
    private String templateId;  // "CS-4YEAR-2024"
    private String name;  //"4 Years, medium, summer"
    private int years;
    private String workload;
    private boolean summer;
    private boolean winter;
    private Collection<Semester> semesters; //4 years = 8 sem, 5 years = 10 sem, 6 years = 12 sems

    /*
    templateId: equivalent to the hashmap key
    name: frontend friendly naming convention
    semesters: our stored semesters
     */
    public Template(String templateId, String name, int years, String workload,
                    boolean summer, boolean winter, Collection<Semester> semesters) {
        this.templateId = templateId;
        this.name = name;
        this.years = years;
        this.workload = workload;
        this.summer = summer;
        this.winter = winter;
        this.semesters = semesters;
    }

    //Get total credits
    public int getTotalCredits() {
        int total = 0;
        for (Semester semester : this.semesters) {
            total += semester.getTotalCredits();
        }
        return total;
    }

    /*
    Printing out the whole template in the run terminal
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        //Header with template info
        sb.append("========================================\n");
        sb.append("Template: ").append(name).append("\n");
        sb.append("ID: ").append(templateId).append("\n");
        sb.append("Duration: ").append(years).append(" years | ");
        sb.append("Workload: ").append(workload).append("\n");

        if (summer) sb.append("Includes summer sessions\n");
        if (winter) sb.append("Includes winter sessions\n");

        sb.append("Total Semesters: ").append(semesters.size()).append("\n");
        sb.append("Total Credits: ").append(getTotalCredits()).append(" units\n");
        sb.append("========================================\n\n");

        //Sort and display all semesters
        List<Semester> sortedSemesters = new ArrayList<>(semesters);
        sortedSemesters.sort(Comparator.comparingDouble(Semester::getTermNum));

        for (Semester semester : sortedSemesters) {
            sb.append(semester.toString());  //Uses Semester's toString()
            sb.append("\n");
        }

        return sb.toString();
    }

    /*
    Add a semester to the template
    Not used for now, maybe in the future on user input
     */
    public void addSemester(Semester semester) {
        this.semesters.add(semester);
    }
}
