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
            Map.entry("MATH102", new Course("MATH 102", "Pre-Calculus I", 4)),
            Map.entry("MATH105-L", new Course("MATH 105/L", "Pre-Calculus II", 4)),
            Map.entry("MATH150A-L", new Course("MATH 150A/L", "Calculus I", 4)),
            Map.entry("MATH150B-L", new Course("MATH 150B/L", "Calculus II", 4)),
            Map.entry("MATH262", new Course("MATH 262", "Linear Algebra", 4)),
            Map.entry("COMP282", new Course("COMP 282", "Advanced Data Structures", 4)),
            Map.entry("COMP380-L", new Course("COMP 380/L", "Introduction to Software Engineering", 4)),
            Map.entry("COMP490-L", new Course("COMP 490/L", "Senior Design I", 4)),
            Map.entry("COMP491-L", new Course("COMP 491/L", "Senior Design II", 4)),
            Map.entry("COMP333", new Course("COMP 333", "Concepts of Programming Languages", 4)),
            Map.entry("COMP310", new Course("COMP 310", "Automata", 4)),
            Map.entry("COMP256-L", new Course("COMP 256/L", "Discrete Structures for Computer Science", 4)),
            Map.entry("COMP122-L", new Course("COMP 122/L", "Computer Architecture and Assembly", 4)),
            Map.entry("COMP222", new Course("COMP 222", "Computer Organization", 4)),
            Map.entry("COMP322-L", new Course("COMP 322/l", "Introduction to Operating Systems", 4)),
            Map.entry("PHIL230", new Course("PHIL 230", "Formal Logic", 4)),
            Map.entry("COMP482", new Course("COMP 482", "Algorithm Design and Analysis", 4)),
            Map.entry("MATH482", new Course("MATH 482", "Combinatonial Algorithms", 4)),
            Map.entry("MATH340", new Course("MATH 340", "Introduction to Probability and Statistics", 4)),
            Map.entry("COMS151", new Course("COMS 151", "Fundamentals of Public Speaking", 4)),
            Map.entry("ENG115", new Course("ENG 115", "Approaches to University Writing", 4)),
            Map.entry("GEO101", new Course("GEO 101", "Geology of Planet Earth", 4)),
            Map.entry("GEO102", new Course("GEO 102", "Geology of Planet Earth Lab", 4)),
            Map.entry("BIO106-L", new Course("BIO 106/L", "Biological Principles", 4)),
            Map.entry("BIO107-L", new Course("BIO 107/L", "Biological Principles II", 4))
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
