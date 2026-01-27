package com.road2cs.services;

import com.road2cs.storage.Course;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

/*
How we will store our courses, using the official CSUN roadmap,
roadmap PDF, looking at our portal, etc.
 */
@Service
public class CoursesService {

    private final Map<String, Course> courses = Map.ofEntries(
            Map.entry("COMP110-L", new Course("COMP 110/L", "Introduction to Algorithms and Programming and Lab ", 4)),
            Map.entry("COMP182-L", new Course("COMP 182/L", "Data Structures and Program Design and Lab", 4)),
            Map.entry("MATH102", new Course("MATH 102", "Pre-Calculus I", 4))
            //Follow the format like above, Map.entry("Course") should be program friendly
            //Anything in new Course("...") doesn't have to be program friendly, it's more for frontend
            //Focus on this for now, get all courses from your portal and available roadmaps
    );

    public Course getCourse(String courseCode) {
        return courses.get(courseCode);
    }

    public Collection<Course> getAllCourses() {
        return courses.values();
    }
}