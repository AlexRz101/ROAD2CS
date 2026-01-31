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
public class CoursesService {

    private final Map<String, Course> courses;

    public CoursesService() {
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

        /* Math courses */
        courses.put("MATH102", new Course("MATH 102", "Pre-Calculus I", 3));
        courses.put("MATH105-L", new Course("MATH 105/L", "Pre-Calculus II", 4));
        courses.put("MATH150A-L", new Course("MATH 150A/L", "Calculus I", 5));
        courses.put("MATH150B-L", new Course("MATH 150B/L", "Calculus II", 5));
        courses.put("MATH262", new Course("MATH 262", "Linear Algebra", 4));
        courses.put("MATH340", new Course("MATH 340", "Introduction to Probability and Statistics", 4));
        courses.put("MATH482", new Course("MATH 482", "Combinational Algorithms", 3));

        /* GE A1 courses */
        courses.put("COMS151", new Course("COMS 151", "Fundamentals of Public Speaking", 3));
        courses.put("AAS151",  new Course("AAS 151",  "Fundamentals of Public Speaking", 3));
        courses.put("AFRS151", new Course("AFRS 151", "Freshman Speech Communication", 3));
        courses.put("CAS151",  new Course("CAS 151",  "Fundamentals of Public Speaking", 3));
        courses.put("CHS151",  new Course("CH S 151", "Freshman Speech Communication", 3));
        courses.put("QS151",   new Course("QS 151",   "Fundamentals of QS Public Speaking", 3));

        /* GE A2 courses */
        courses.put("ENG115", new Course("ENG 115", "Approaches to University Writing", 3));
        courses.put("AAS115",  new Course("AAS 115",  "Approaches to University Writing", 3));
        courses.put("AFRS115", new Course("AFRS 115", "Approaches to University Writing", 3));
        courses.put("CAS115",  new Course("CAS 115",  "Approaches to University Writing", 3));
        courses.put("CHS115",  new Course("CH S 115", "Approaches to University Writing", 3));
        courses.put("QS115",   new Course("QS 115",   "Approaches to University Writing", 3));

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
        courses.put("AFRS271", new Course("AFRS 271", "African American History to 1865", 3));
        courses.put("AFRS272", new Course("AFRS 272", "African American History Since 1865", 3));
        courses.put("AIS250", new Course("AIS 250", "American Indians and U.S. History", 3));
        courses.put("CHS245", new Course("CH S 245", "History of the Americas", 3));
        courses.put("ECON175", new Course("ECON 175", "Introduction to U.S. Economic History", 3));
        courses.put("HIST270", new Course("HIST 270", "The United States to 1865", 3));
        courses.put("HIST370", new Course("HIST 370", "Questions in American History to the Civil War", 3));
        courses.put("HIST371", new Course("HIST 371", "Questions in American History Since the Civil War", 3));
        courses.put("JOUR391", new Course("JOUR 391", "Free Press in the Digital Era", 3));
        courses.put("JS218", new Course("JS 218", "Jewish American History and Ideals", 3));
        courses.put("PHIL317", new Course("PHIL 317", "History of American Philosophy", 3));
        courses.put("RS256", new Course("R S 256", "American Religious History and Ideals", 3));

        /* GE D1 courses */
        courses.put("GEOG321", new Course("GEOG 321", "United States", 3));
        courses.put("ECON101", new Course("ECON 101", "Economics for Everyday Life", 3));

        /* GE D3 courses */
        courses.put("POLS155", new Course("POLS 155", "American Political Institutions", 3));

        /* GE D4 courses - Social Sciences */
        courses.put("ANTH150", new Course("ANTH 150", "Introduction to Anthropology", 3));
        courses.put("URBS150", new Course("URBS 150", "Discover the City", 3));
        courses.put("URBS310", new Course("URBS 310", "Growth and Sustainable Development of Cities", 3));
        courses.put("URBS380", new Course("URBS 380", "Los Angeles: Past, Present, Future", 3));
        courses.put("COMS312", new Course("COMS 312", "Health Communication", 3));
        courses.put("COMS323", new Course("COMS 323", "Group Communication", 3));

        /* GE E courses - Lifelong Learning */
        courses.put("COMP111B", new Course("COMP 111B", "Algorithms and Programming B", 2));
        courses.put("COMP111BL", new Course("COMP 111BL", "Algorithms and Programming B Lab", 1));

        /* GE F courses - Comparative Cultural Studies */
        courses.put("AAS100", new Course("AAS 100", "Introduction to Asian American Studies", 3));
        courses.put("COMS356", new Course("COMS 356", "Intercultural Communication", 3));
        courses.put("AAS102", new Course("AAS 102", "Introduction to Pacific Islands Studies", 3));
        courses.put("AAS340", new Course("AAS 340", "Asian American Women", 3));
        courses.put("AAS345", new Course("AAS 345", "Contemporary Issues in Asian American Studies", 3));
        courses.put("AAS360", new Course("AAS 360", "Asian American Immigration–Global Perspective", 3));
        courses.put("AAS362", new Course("AAS 362", "Asian Pacific Islander Desi American Experience", 3));
        courses.put("AFRS100", new Course("AFRS 100", "Introduction to Black Studies and Culture", 3));
        courses.put("AFRS226", new Course("AFRS 226", "Traditional African Cultures", 3));
        courses.put("AFRS300", new Course("AFRS 300", "Contemporary Issues in the African-American Community", 3));
        courses.put("AFRS320", new Course("AFRS 320", "The Black Personality", 3));
        courses.put("AFRS322", new Course("AFRS 322", "The Black Family", 3));
        courses.put("AFRS324", new Course("AFRS 324", "The Black Woman in Contemporary Times", 3));
        courses.put("AFRS325", new Course("AFRS 325", "The Black Man in Contemporary Times", 3));
        courses.put("AFRS366", new Course("AFRS 366", "Colonialism in Africa", 3));
        
        /*Computer Science Upper Division Elective (400 or 500 level)*/
        courses.put("COMP424", new Course("COMP 424", "Computer System Security", 3));
        courses.put("COMP429", new Course("COMP 429", "Computer Network Software", 3));
        courses.put("COMP542", new Course("COMP 542", "Machine Learning", 3));
        courses.put("COMP545", new Course("COMP 545", "Cloud Computing", 3));
        courses.put("COMP569", new Course("COMP 569", "Artificial Intelligence", 3));
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
