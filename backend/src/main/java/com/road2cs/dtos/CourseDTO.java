package com.road2cs.dtos;

import com.road2cs.models.Course;
import lombok.Getter;

@Getter
public class CourseDTO {
    private final String courseId;
    private final String name;
    private final String courseType;
    private final int credits;

    public CourseDTO(Course course) {
        this.courseId = course.getCourseId();
        this.name = course.getName();
        this.courseType = course.getCourseType();
        this.credits = course.getCredits();
    }
}