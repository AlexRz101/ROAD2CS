package com.road2cs.services;

import com.road2cs.models.Course;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final Map<String, Course> courses;

    public CourseService() {
        this.courses = new HashMap<>();
        initializeCourses();
    }

    private void initializeCourses() {
        /* Lower div CS courses */
        courses.put("COMP110-L", new Course("COMP_LOWER", "COMP 110/L", "Introduction to Algorithms and Programming and Lab", 4));
        courses.put("COMP111A-L", new Course("COMP_LOWER", "COMP 111A/L", "Introduction to Algorithms and Programming A and Lab", 3));
        courses.put("COMP111B-L", new Course("COMP_LOWER", "COMP 111B/L", "Introduction to Algorithms and Programming B and Lab", 3));
        courses.put("COMP182-L", new Course("COMP_LOWER", "COMP 182/L", "Data Structures and Program Design and Lab", 4));
        courses.put("COMP122-L", new Course("COMP_LOWER", "COMP 122/L", "Computer Architecture and Assembly", 4));
        courses.put("PHIL230", new Course("COMP_LOWER", "PHIL 230", "Formal Logic", 3));
        courses.put("COMP282", new Course("COMP_LOWER", "COMP 282", "Advanced Data Structures", 3));
        courses.put("COMP222", new Course("COMP_LOWER", "COMP 222", "Computer Organization", 3));
        courses.put("COMP256-L", new Course("COMP_LOWER", "COMP 256/L", "Discrete Structures for Computer Science", 4));

        /* Upper div CS courses */
        courses.put("COMP310", new Course("COMP_UPPER", "COMP 310", "Automata", 3));
        courses.put("COMP322-L", new Course("COMP_UPPER", "COMP 322/L", "Introduction to Operating Systems", 4));
        courses.put("COMP324", new Course("COMP_UPPER", "COMP 324", "Computer Networking and Security", 3));
        courses.put("COMP333", new Course("COMP_UPPER", "COMP 333", "Concepts of Programming Languages", 3));
        courses.put("COMP380-L", new Course("COMP_UPPER", "COMP 380/L", "Introduction to Software Engineering", 3));
        courses.put("COMP482", new Course("COMP_UPPER", "COMP 482", "Algorithm Design and Analysis", 3));
        courses.put("COMP490-L", new Course("COMP_UPPER", "COMP 490/L", "Senior Design I", 3));
        courses.put("COMP491-L", new Course("COMP_UPPER", "COMP 491/L", "Senior Design II", 3));

        /* Senior CS Electives: Dynamic */
        courses.put("COMP440", new Course("COMP_ELECTIVE", "COMP 440", "Database Design", 3));
        courses.put("COMP424", new Course("COMP_ELECTIVE", "COMP 424", "Computer System Security", 3));
        courses.put("COMP429", new Course("COMP_ELECTIVE", "COMP 429", "Computer Network Software", 3));
        courses.put("COMP430", new Course("COMP_ELECTIVE", "COMP 430", "Language Design and Compilers", 3));
        courses.put("COMP442", new Course("COMP_ELECTIVE", "COMP 442", "Machine Learning", 3));
        courses.put("COMP467", new Course("COMP_ELECTIVE", "COMP 467", "Multimedia Systems", 3));
        courses.put("COMP484-L", new Course("COMP_ELECTIVE", "COMP 484/L", "Web Engineering I and Lab ", 3));
        courses.put("COMP485", new Course("COMP_ELECTIVE", "COMP 485", "Human-Computer Interaction", 3));
        courses.put("COMP494A", new Course("COMP_ELECTIVE", "COMP 494A", "Academic Internship", 1));
        courses.put("COMP502", new Course("COMP_ELECTIVE", "COMP 502", "Programming Data Science Analytics", 3));
        courses.put("COMP522", new Course("COMP_ELECTIVE", "COMP 522", "Embedded Applications", 3));
        courses.put("COMP529", new Course("COMP_ELECTIVE", "COMP 529", "Advanced Network Topics", 2));
        courses.put("COMP529L", new Course("COMP_ELECTIVE", "COMP 529L", "Advanced Network Lab", 1));
        courses.put("COMP541", new Course("COMP_ELECTIVE", "COMP 541", "Data Mining", 3));
        courses.put("COMP542", new Course("COMP_ELECTIVE", "COMP 542", "Machine Learning", 3));
        courses.put("COMP545", new Course("COMP_ELECTIVE", "COMP 545", "Cloud Computing", 3));
        courses.put("COMP565", new Course("COMP_ELECTIVE", "COMP 565", "Advanced Computer Graphics", 3));
        courses.put("COMP569", new Course("COMP_ELECTIVE", "COMP 569", "Artificial Intelligence", 3));
        courses.put("COMP583", new Course("COMP_ELECTIVE", "COMP 583", "Software Engineering Management", 3));
        courses.put("COMP584", new Course("COMP_ELECTIVE", "COMP 584", "Advanced Web Engineering", 3));
        courses.put("COMP585", new Course("COMP_ELECTIVE", "COMP 585", "Graphical User Interfaces", 3));
        courses.put("COMP586", new Course("COMP_ELECTIVE", "COMP 586", "Object-Oriented Software Development", 3));
        courses.put("COMP589", new Course("COMP_ELECTIVE", "COMP 589", "Software Metrics", 3));

        /* Math courses: Dynamic */
        courses.put("MATH102", new Course("MATH", "MATH 102", "Pre-Calculus I", 3));
        courses.put("MATH105-L", new Course("MATH", "MATH 105/L", "Pre-Calculus II", 4));
        courses.put("MATH150A", new Course("MATH", "MATH 150A", "Calculus I", 5));
        courses.put("MATH150B", new Course("MATH", "MATH 150B", "Calculus II", 5));
        courses.put("MATH262", new Course("MATH", "MATH 262", "Linear Algebra", 3));
        courses.put("MATH340", new Course("MATH", "MATH 340", "Introduction to Probability and Statistics", 4));
        courses.put("MATH482", new Course("MATH", "MATH 482", "Combinational Algorithms", 3));

        /* GE A1 courses: Dynamic */
        courses.put("COMS151", new Course("GE_A1", "COMS 151", "Fundamentals of Public Speaking: Communication Studies", 3));
        courses.put("AAS151", new Course("GE_A1", "AAS 151", "Fundamentals of Public Speaking: Asian American Studies", 3));
        courses.put("AFRS151", new Course("GE_A1", "AFRS 151", "Freshman Speech Communication: Africana Studies", 3));
        courses.put("QS151", new Course("GE_A1", "QS 151", "Fundamentals of QS Public Speaking", 3));
        courses.put("CHS151", new Course("GE_A1", "CHS 151", "Freshman Speech Communication: Chicano Studies", 3));

        /* GE A2 courses: Dynamic */
        courses.put("ENG115", new Course("GE_A2", "ENGL 115", "Approaches to University Writing: English", 3));
        courses.put("AAS115", new Course("GE_A2", "AAS 115", "Approaches to University Writing: Asian American Studies", 3));
        courses.put("AFRS115", new Course("GE_A2", "AFRS 115", "Approaches to University Writing: Africana Studies", 3));
        courses.put("QS115", new Course("GE_A2", "QS 115", "Approaches to University Writing: Queer Studies ", 3));
        courses.put("CHS115", new Course("GE_A2", "CHS 115", "Approaches to University Writing: Chicano Studies", 3));

        /* GE B1/B3 - Physical Science with Lab; Dynamic */
        courses.put("CHEM101-D-L", new Course("GE_B1B3", "CHEM 101/D/L", "Principles of Chemistry, Problem Solving and Lab", 5));
        courses.put("GEOG101-102", new Course("GE_B1B3", "GEOG 101/102", "The Physical Environment and Lab", 4));
        courses.put("GEOG103-105", new Course("GE_B1B3", "GEOG 103/105", "Physical Geography and Lab", 4));
        courses.put("GEOL101-102", new Course("GE_B1B3", "GEOL 101/102", "Geology of Planet Earth and Lab", 4));
        courses.put("PHYS220A-L", new Course("GE_B1B3", "PHYS 220A/L", "General Physics and Lab", 4));

        /* GE B2/B3 - Life Science with Lab: Dynamic */
        courses.put("BIOL106-L", new Course("GE_B2B3", "BIOL 106/L", "Biological Principles and Lab", 4));
        courses.put("BIOL107-L", new Course("GE_B2B3", "BIOL 107/L", "Biological Principles II and Lab", 4));
        courses.put("GEOL110-112", new Course("GE_B2B3", "GEOL 110/112", "Fossil Record of Ancient Life and Lab", 4));

        /* GE C1 courses: Dynamic */
        courses.put("MUS107", new Course("GE_C1", "MUS 107", "Music Today", 3));
        courses.put("ART110", new Course("GE_C1", "ART 110", "World Arts: The Western Tradition", 3));
        courses.put("ART124A", new Course("GE_C1", "ART 124A", "Drawing I", 3));
        courses.put("MUS105", new Course("GE_C1", "MUS 105", "Understanding Music", 3));
        courses.put("TH110", new Course("GE_C1", "TH 110", "Introduction to Theatre: Text/Drama/Performance", 3));

        /* GE C2 courses: Dynamic */
        courses.put("ENGL255", new Course("GE_C2", "ENGL 255", "Introduction to Literature", 3));
        courses.put("ENGL275", new Course("GE_C2", "ENGL 275", "Major American Writers", 3));
        courses.put("PHIL150", new Course("GE_C2", "PHIL 150", "Introduction to Philosophical Thought", 3));
        courses.put("PHIL201", new Course("GE_C2", "PHIL 201", "Ancient Philosophy", 3));
        courses.put("PHIL202", new Course("GE_C2", "PHIL 202", "Modern Philosophy", 3));

        /* GE C3 courses: Dynamic */
        courses.put("HIST271", new Course("GE_C3", "HIST 271", "The United States Since 1865", 3));
        courses.put("AFRS271", new Course("GE_C3", "AFRS 271", "African-American History to 1865", 3));
        courses.put("AFRS272", new Course("GE_C3", "AFRS 272", "African-American History Since 1865", 3));
        courses.put("HIST270", new Course("GE_C3", "HIST 270", "The United States to 1865", 3));
        courses.put("ECON175", new Course("GE_C3", "ECON 175", "Introduction to U.S. Economic History", 3));

        /* GE D1 courses: Fixed, GEOG 321 and ANTH150 cover this */
        courses.put("ANTH150", new Course("GE_D1", "ANTH 150", "The Human Adventure: Introduction to Anthropology", 3));

        /* GE D3 + D4 courses: Fixed */
        courses.put("POLS155", new Course("GE_D3", "POLS 155", "American Political Institutions", 3));

        /* GE E courses: NO NEED, FRESHMEN COMP CLASS COVERS!!
        courses.put("HSCI131", new Course("GE_E", "HSCI 131", "Health and Society", 3));
        courses.put("FIN102", new Course("GE_E", "FIN 102", "Financial Literacy", 3));
        courses.put("COMS150", new Course("GE_E", "COMS 150", "Introduction to Communication Studies", 3));
        courses.put("CCE200", new Course("GE_E", "CCE 200", "Introduction to Civic and Community Engagement", 3));
         */

        /* GE F courses: Dynamic, COMS 356 covers half the requirement */
        courses.put("AAS100", new Course("GE_F", "AAS 100", "Introduction to Asian American Studies", 3));
        courses.put("AFRS100", new Course("GE_F", "AFRS 100", "Introduction to Black Studies and Culture", 3));
        courses.put("ANTH108", new Course("GE_F", "ANTH 108", "Latin American Cultures", 3));
        courses.put("CHS100", new Course("GE_F", "CHS 100", "Chicana/o Culture", 3));
        courses.put("SPAN101", new Course("GE_F", "SPAN 101", "Elementary Spanish I", 4));

        /* Upper GE courses - Fixed */
        courses.put("GEOG321", new Course("GE_UPPER_D", "GEOG 321", "United States", 3));
        courses.put("COMS356", new Course("GE_UPPER_F", "COMS 356", "Intercultural Communication", 3));
        //COMP310 already added above as upper div GE B5
    }

    public List<Course> getCoursesByType(String courseType) {
        return courses.values().stream()
                .filter(c -> c.getCourseType().equals(courseType))
                .collect(Collectors.toList());
    }

    public Course getRandomCourseByType(String courseType) {
        List<Course> options = getCoursesByType(courseType);
        return options.get(new Random().nextInt(options.size()));
    }

    public Course getCourse(String courseCode) {
        return courses.get(courseCode);
    }

    public Collection<Course> getAllCourses() {
        return courses.values();
    }
}