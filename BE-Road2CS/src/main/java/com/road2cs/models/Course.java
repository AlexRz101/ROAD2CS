package com.road2cs.models;

import lombok.Getter;
import lombok.Setter;

/*
The annotations are just Getter Setter cheat codes,
No need to write Getter and Setter boilerplate
 */
@Getter
@Setter
public class Course {
    private String courseId; //Comp 110, Comp 182...
    private String name; //Intro to CS, Data Structures and Algorithms...
    private int credits; //How many credits the course is

    //General course format
    public Course(String courseId, String name, int credits) {
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
    }
}
