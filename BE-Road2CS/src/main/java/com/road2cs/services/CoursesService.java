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
            Map.entry("MATH102", new Course("MATH 102", "Pre-Calculus I", 3)),
            Map.entry("MATH105-L", new Course("MATH 105/L", "Pre-Calculus II", 4)),
            Map.entry("MATH150A-L", new Course("MATH 150A/L", "Calculus I", 5)),
            Map.entry("MATH150B-L", new Course("MATH 150B/L", "Calculus II", 5)),
            Map.entry("MATH262", new Course("MATH 262", "Linear Algebra", 4)),
            Map.entry("COMP282", new Course("COMP 282", "Advanced Data Structures", 4)),
            Map.entry("COMP380-L", new Course("COMP 380/L", "Introduction to Software Engineering", 4)),
            Map.entry("COMP490-L", new Course("COMP 490/L", "Senior Design I", 3)),
            Map.entry("COMP491-L", new Course("COMP 491/L", "Senior Design II", 3)),
            Map.entry("COMP333", new Course("COMP 333", "Concepts of Programming Languages", 3)),
            Map.entry("COMP310", new Course("COMP 310", "Automata", 3)),
            Map.entry("COMP256-L", new Course("COMP 256/L", "Discrete Structures for Computer Science", 4)),
            Map.entry("COMP122-L", new Course("COMP 122/L", "Computer Architecture and Assembly", 4)),
            Map.entry("COMP222", new Course("COMP 222", "Computer Organization", 3)),
            Map.entry("COMP322-L", new Course("COMP 322/l", "Introduction to Operating Systems", 4)),
            Map.entry("PHIL230", new Course("PHIL 230", "Formal Logic", 3)),
            Map.entry("COMP482", new Course("COMP 482", "Algorithm Design and Analysis", 4)),
            Map.entry("MATH482", new Course("MATH 482", "Combinatonial Algorithms", 4)),
            Map.entry("MATH340", new Course("MATH 340", "Introduction to Probability and Statistics", 4)),
            Map.entry("COMS151", new Course("COMS 151", "Fundamentals of Public Speaking", 4)),
            Map.entry("ENG115", new Course("ENG 115", "Approaches to University Writing", 3)),
            Map.entry("GEO101", new Course("GEO 101", "Geology of Planet Earth", 4)),
            Map.entry("GEO102", new Course("GEO 102", "Geology of Planet Earth Lab", 4)),
            Map.entry("BIO106-L", new Course("BIO 106/L", "Biological Principles", 4)),
            Map.entry("BIO107-L", new Course("BIO 107/L", "Biological Principles II", 4))
            /*
            Key, ("Class name, "Class description", units)
             */

            /*

Section D1
AAS 210,350
FRS 201,220,221,304,361
AIS 222
ANTH 150,151,152,153,212,250, 262,302,305,319,341
CADV 150,310,320
CAS 309,310,368,369 CH S 261,331,
CH S 345,346,347,361,362,366
CJS 101,338
COMS 312,323 ECON 101,160,161,310,
ECON 311,360 FCS 141,253,256,318,340,357
FLIT 325 GEH 333 GEOG 107,150,170,301,330,351,370
GWS 110,220,222,300,320,340,351,370
HIST 110,111, 341,342,350,380,389
HSCI 132,345,369
JOUR 365
J S 318
LING 100,230,309,314CS
MKT 350
PHIL 305,324,391
POLS 156,225,310,350,380
PSY 150,
PSY 312,352,365
R S 240
RTM 278,301,352
SOC 150,200,305,324
SUST 300
URBS 150,310,380

Section D3
AAS 347
AFRS 161
CH S 260 445
POLS 155 355
R S 255

Section D4
AAS 347
AFRS 161
CH S 260 445
POLS 155 355 403 490CA
R S 255
             */
    );

    public Course getCourse(String courseCode) {
        return courses.get(courseCode);
    }

    public Collection<Course> getAllCourses() {
        return courses.values();
    }
}
