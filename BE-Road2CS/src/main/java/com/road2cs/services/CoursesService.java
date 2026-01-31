package com.road2cs.services;

import com.road2cs.models.Course;
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
            /* Lower div CS courses */
            Map.entry("COMP110-L", new Course("COMP 110/L", "Introduction to Algorithms and Programming and Lab", 4)),
            Map.entry("COMP111A-L", new Course("COMP 111A/L", "Introduction to Algorithms and Programming A and Lab", 3)),
            Map.entry("COMP111B-L", new Course("COMP 111B/L", "Introduction to Algorithms and Programming B and Lab", 3)),
            Map.entry("COMP182-L", new Course("COMP 182/L", "Data Structures and Program Design and Lab", 4)),
            Map.entry("COMP122-L", new Course("COMP 122/L", "Computer Architecture and Assembly", 4)),
            Map.entry("PHIL230", new Course("PHIL 230", "Formal Logic", 3)),
            Map.entry("COMP282", new Course("COMP 282", "Advanced Data Structures", 3)),
            Map.entry("COMP222", new Course("COMP 222", "Computer Organization", 3)),
            Map.entry("COMP256-L", new Course("COMP 256/L", "Discrete Structures for Computer Science", 4)),

            /* Upper div CS courses */
            Map.entry("COMP310", new Course("COMP 310", "Automata", 3)),
            Map.entry("COMP322-L", new Course("COMP 322/l", "Introduction to Operating Systems", 4)),
            Map.entry("COMP324", new Course("COMP 324", "Computer Networking and Security", 3)),
            Map.entry("COMP333", new Course("COMP 333", "Concepts of Programming Languages", 3)),
            Map.entry("COMP380-L", new Course("COMP 380/L", "Introduction to Software Engineering", 3)),
            Map.entry("COMP482", new Course("COMP 482", "Algorithm Design and Analysis", 3)),
            Map.entry("COMP490-L", new Course("COMP 490/L", "Senior Design I", 3)),
            Map.entry("COMP491-L", new Course("COMP 491/L", "Senior Design II", 3)),

            /* Senior CS Electives */
            Map.entry("COMP440", new Course("COMP 440", "Database Design", 3)),

            /* Math courses */
            Map.entry("MATH102", new Course("MATH 102", "Pre-Calculus I", 3)),
            Map.entry("MATH105-L", new Course("MATH 105/L", "Pre-Calculus II", 4)),
            Map.entry("MATH150A-L", new Course("MATH 150A/L", "Calculus I", 5)),
            Map.entry("MATH150B-L", new Course("MATH 150B/L", "Calculus II", 5)),
            Map.entry("MATH262", new Course("MATH 262", "Linear Algebra", 4)),
            Map.entry("MATH340", new Course("MATH 340", "Introduction to Probability and Statistics", 4)),
            Map.entry("MATH482", new Course("MATH 482", "Combinatonial Algorithms", 3)),

            /* GE A1 courses */
            Map.entry("COMS151", new Course("COMS 151", "Fundamentals of Public Speaking", 3)),

            /* GE A2 courses */
            Map.entry("ENG115", new Course("ENG 115", "Approaches to University Writing", 3)),

            /* GE B1 courses */
            Map.entry("GEOL101", new Course("GEO 101", "Geology of Planet Earth", 3)),

            /* GE B2 courses */
            Map.entry("BIO106-L", new Course("BIO 106/L", "Biological Principles", 4)),
            Map.entry("BIO107-L", new Course("BIO 107/L", "Biological Principles II", 4)),

            /* GE B3 courses */
            Map.entry("GEOL102", new Course("GEO 102", "Geology of Planet Earth Lab", 1)),

            /* GE C1 courses */
            Map.entry("MUS107", new Course("MUS 107", "Music Today", 3)),

            /* GE C2 courses
            Double dips GE A2
            Map.entry("ENG115", new Course("ENG 115", "Approaches to University Writing", 3)),
             */

            /* GE C3 courses */
            Map.entry("HIST271", new Course("HIST 271", "US Since 1865", 3)),

            /* GE D1 courses */
            Map.entry("GEOG321", new Course("GEOG 321", "United States", 3)),
            Map.entry("ECON101", new Course("ECON 101", "Economics for Everyday Life", 3)),

            /* GE D3 courses */
            Map.entry("POLS155", new Course("POLS 155", "American Political Institutions", 3)),

            /* GE D4 courses - Social Sciences */
            Map.entry("ANTH150", new Course("ANTH 150", "Introduction to Anthropology", 3)),

            /* GE E courses - Lifelong Learning */
            Map.entry("COMP111B", new Course("COMP 111B", "Algorithms and Programming B", 2)),
            Map.entry("COMP111BL", new Course("COMP 111BL", "Algorithms and Programming B Lab", 1)),

            /* GE F courses - Comparative Cultural Studies */
            Map.entry("AAS100", new Course("AAS 100", "Introduction to Asian American Studies", 3)),
            Map.entry("COMS356", new Course("COMS 356", "Intercultural Communication", 3))

            /* Upper GE courses */
            //Upper Div CS: Map.entry("COMP310", new Course("COMP 310", "Automata, Languages and Computation", 3)), // Section B5 Upper Division
            //GE D1: Map.entry("GEOG321", new Course("GEOG 321", "United States", 3)), // Section D Upper Division
            //GE F: Map.entry("COMS356", new Course("COMS 356", "Intercultural Communication", 3)), // Section F Upper Division
    );

    public Course getCourse(String courseCode) {
        return courses.get(courseCode);
    }

    public Collection<Course> getAllCourses() {
        return courses.values();
    }
}
