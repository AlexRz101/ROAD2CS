package com.road2cs.models;

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
    private Map<String, Course> courses;  //courseId -> Course
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

    //Add one course - use put() for HashMap
    public void addCourse(Course course) {
        this.courses.put(course.getCourseId(), course);
    }

    // Add multiple courses - loop and put each one
    public void addCourses(Map<String, Course> coursesToAdd) {
        this.courses.putAll(coursesToAdd);
    }

    // Alternatively, add from a Collection
    public void addCoursesFromCollection(Collection<Course> coursesToAdd) {
        for (Course course : coursesToAdd) {
            this.courses.put(course.getCourseId(), course);
        }
    }

    // Remove by Course object - use the courseId as key
    public void removeCourse(Course course) {
        this.courses.remove(course.getCourseId());
    }

    //Remove by courseId - HashMap makes this super easy!
    public void removeCourseById(String courseId) {
        this.courses.remove(courseId);
    }

    //Get a course by ID - fast O(1) lookup!
    public Course getCourse(String courseId) {
        return this.courses.get(courseId);
    }

    //Check if semester has a course
    public boolean hasCourse(String courseId) {
        return this.courses.containsKey(courseId);
    }

    //Get all courses as a Collection
    public Collection<Course> getAllCourses() {
        return this.courses.values();
    }

    //Get total credits - loop through values
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
}