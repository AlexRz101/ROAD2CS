package com.road2cs.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

@Getter
@Setter
public class Semester {
    private int termNum; //which term it is
    private String termName; //fall/spring/summer/winter

    @JsonIgnore
    private Map<String, Course> courses;  //courseId to Course
    private int semUnits;

    //Constructor - initialize with empty HashMap
    public Semester(int termNum, String termName) {
        this.termNum = termNum;
        this.termName = termName;
        this.courses = new HashMap<>();
    }

    //Constructor - initialize with existing courses
    public Semester(int termNum, String termName, Map<String, Course> courses) {
        this.termNum = termNum;
        this.termName = termName;
        this.courses = courses != null ? courses : new HashMap<>();
    }

    //Helper methods
    public void addCourse(Course course) {
        this.courses.put(course.getCourseId(), course);
    }

    //Add multiple courses
    public void addCourses(Map<String, Course> coursesToAdd) {
        this.courses.putAll(coursesToAdd);
    }

    //Or add from a Collection
    public void addCoursesFromCollection(Collection<Course> coursesToAdd) {
        for (Course course : coursesToAdd) {
            this.courses.put(course.getCourseId(), course);
        }
    }

    public void removeCourseById(String courseId) {
        this.courses.remove(courseId);
    }

    public Course getCourse(String courseId) {
        return this.courses.get(courseId);
    }

    public boolean hasCourse(String courseId) {
        return this.courses.containsKey(courseId);
    }

    public Collection<Course> getAllCourses() {
        return this.courses.values();
    }

    //Get total credits
    public int getTotalCredits() {
        int total = 0;
        for (Course course : this.courses.values()) {
            total += course.getCredits();
        }
        return total;
    }

    //Get course count
    public int getCourseCount() {
        return this.courses.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Semester ").append(termNum).append(" (").append(termName).append(")\n");
        sb.append("Courses: ").append(getCourseCount()).append(" | Total Units: ").append(getTotalCredits()).append("\n");

        for (Course course : courses.values()) {
            sb.append("  - ").append(course.getCourseId()).append(": ").append(course.getName())
                    .append(" (").append(course.getCredits()).append(" units)\n");
        }

        return sb.toString();
    }
}