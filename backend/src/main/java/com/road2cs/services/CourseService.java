package com.road2cs.services;

import com.road2cs.models.Course;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
How we will store our courses, using the official CSUN roadmap,
roadmap PDF, looking at our portal, etc.
 */
@Service
public class CourseService {

    private final Map<String, Course> courses;

    public CourseService() {
        this.courses = new HashMap<>();
        initializeCourses();
    }

    private void initializeCourses() {
        /* Lower div CS courses */
        courses.put("COMP110-L", new Course("COMP 110/L", "Introduction to Algorithms and Programming and Lab", 4));
        courses.put("COMP111A-L", new Course("COMP 111A/L", "Introduction to Algorithms and Programming A and Lab", 3));
        courses.put("COMP111B-L", new Course("COMP 111B/L", "Introduction to Algorithms and Programming B and Lab", 3));
        courses.put("COMP182-L", new Course("COMP 182/L", "Data Structures and Program Design and Lab", 4));
        courses.put("COMP122-L", new Course("COMP 122/L", "Computer Architecture and Assembly", 4));
        courses.put("PHIL230", new Course("PHIL 230", "Formal Logic", 3));
        courses.put("COMP282", new Course("COMP 282", "Advanced Data Structures", 3));
        courses.put("COMP222", new Course("COMP 222", "Computer Organization", 3));
        courses.put("COMP256-L", new Course("COMP 256/L", "Discrete Structures for Computer Science", 4));

        /* Upper div CS courses */
        courses.put("COMP310", new Course("COMP 310", "Automata", 3));
        courses.put("COMP322-L", new Course("COMP 322/l", "Introduction to Operating Systems", 4));
        courses.put("COMP324", new Course("COMP 324", "Computer Networking and Security", 3));
        courses.put("COMP333", new Course("COMP 333", "Concepts of Programming Languages", 3));
        courses.put("COMP380-L", new Course("COMP 380/L", "Introduction to Software Engineering", 3));
        courses.put("COMP482", new Course("COMP 482", "Algorithm Design and Analysis", 3));
        courses.put("COMP490-L", new Course("COMP 490/L", "Senior Design I", 3));
        courses.put("COMP491-L", new Course("COMP 491/L", "Senior Design II", 3));

        /* Senior CS Electives */
        courses.put("COMP440", new Course("COMP 440", "Database Design", 3));
        courses.put("COMP424", new Course("COMP 424", "Computer System Security", 3));
        courses.put("COMP429", new Course("COMP 429", "Computer Network Software", 3));
        courses.put("COMP430", new Course("COMP 430", "Language Design and Compilers", 3));
        courses.put("COMP442", new Course("COMP 442", "Machine Learning", 3));
        courses.put("COMP467", new Course("COMP 467", "Multimedia Systems", 3));
        courses.put("COMP484", new Course("COMP 484", "Web Engineering I", 2));
        courses.put("COMP484L", new Course("COMP 484L", "Web Engineering I Lab", 1));
        courses.put("COMP485", new Course("COMP 485", "Human-Computer Interaction", 3));
        courses.put("COMP494A", new Course("COMP 494A", "Academic Internship", 1));
        courses.put("COMP502", new Course("COMP 502", "Programming Data Science Analytics", 3));
        courses.put("COMP522", new Course("COMP 522", "Embedded Applications", 3));
        courses.put("COMP529", new Course("COMP 529", "Advanced Network Topics", 2));
        courses.put("COMP529L", new Course("COMP 529L", "Advanced Network Lab", 1));
        courses.put("COMP541", new Course("COMP 541", "Data Mining", 3));
        courses.put("COMP542", new Course("COMP 542", "Machine Learning", 3));
        courses.put("COMP545", new Course("COMP 545", "Cloud Computing", 3));
        courses.put("COMP565", new Course("COMP 565", "Advanced Computer Graphics", 3));
        courses.put("COMP569", new Course("COMP 569", "Artificial Intelligence", 3));
        courses.put("COMP583", new Course("COMP 583", "Software Engineering Management", 3));
        courses.put("COMP584", new Course("COMP 584", "Advanced Web Engineering", 3));
        courses.put("COMP585", new Course("COMP 585", "Graphical User Interfaces", 3));
        courses.put("COMP586", new Course("COMP 586", "Object-Oriented Software Development", 3));
        courses.put("COMP589", new Course("COMP 589", "Software Metrics", 3));

        /* Math courses */
        courses.put("MATH102", new Course("MATH 102", "Pre-Calculus I", 3));
        courses.put("MATH105-L", new Course("MATH 105/L", "Pre-Calculus II", 4));
        courses.put("MATH150A", new Course("MATH 150A", "Calculus I", 5));
        courses.put("MATH150B", new Course("MATH 150B", "Calculus II", 5));
        courses.put("MATH262", new Course("MATH 262", "Linear Algebra", 3));
        courses.put("MATH340", new Course("MATH 340", "Introduction to Probability and Statistics", 4));
        courses.put("MATH482", new Course("MATH 482", "Combinational Algorithms", 3));

        /* GE A1 courses */
        courses.put("COMS151", new Course("COMS 151", "Fundamentals of Public Speaking", 3));

        /* GE A2 courses */
        courses.put("ENG115", new Course("ENG 115", "Approaches to University Writing", 3));

        /* GE B1 courses */
        courses.put("GEOL101", new Course("GEO 101", "Geology of Planet Earth", 3));

        /* GE B2 courses */
        courses.put("BIOL106-L", new Course("BIO 106/L", "Biological Principles", 4));
        courses.put("BIOL107-L", new Course("BIO 107/L", "Biological Principles II", 4));

        /* GE B3 courses */
        courses.put("GEOL102", new Course("GEO 102", "Geology of Planet Earth Lab", 1));

        /* GE C1 courses */
        courses.put("MUS107", new Course("MUS 107", "Music Today", 3));

        /* GE C2 courses - Double dips GE A2 */
        // ENG115 already added above

        /* GE C3 courses */
        courses.put("HIST271", new Course("HIST 271", "US Since 1865", 3));

        /* GE D1 courses */
        courses.put("GEOG321", new Course("GEOG 321", "United States", 3));
        courses.put("ECON101", new Course("ECON 101", "Economics for Everyday Life", 3));

        /* GE D3 courses */
        courses.put("POLS155", new Course("POLS 155", "American Political Institutions", 3));

        /* GE D4 courses - Social Sciences */
        courses.put("ANTH150", new Course("ANTH 150", "Introduction to Anthropology", 3));

        /* GE E courses - Lifelong Learning */
        courses.put("COMP111B", new Course("COMP 111B", "Algorithms and Programming B", 2));
        courses.put("COMP111BL", new Course("COMP 111BL", "Algorithms and Programming B Lab", 1));

        /* GE F courses - Comparative Cultural Studies */
        courses.put("AAS100", new Course("AAS 100", "Introduction to Asian American Studies", 3));
        courses.put("COMS356", new Course("COMS 356", "Intercultural Communication", 3));

        /* Upper GE courses */
        //COMP310 already added above - Section B5 Upper Division
        //GEOG321 already added above - Section D Upper Division
        //COMS356 already added above - Section F Upper Division
    }

    public Course getCourse(String courseCode) {
        return courses.get(courseCode);
    }

    public Collection<Course> getAllCourses() {
        return courses.values();
    }
}