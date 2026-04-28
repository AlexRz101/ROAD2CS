import { useState, useEffect } from "react";
import Card from '../components/Card.jsx';
import API from '../api/index.js';
import { ResolveCourse } from "../utils/ResolveCourse";

//Roadmap.jsx
const placeholderSemesters = [
  {
    termNum: 1, termName: "Fall", semUnits: 15,
    courses: [
      { courseId: "COMP 110/L", name: "Introduction to Algorithms and Programming and Lab", credits: 4, courseType: "COMP_LOWER" },
      { courseId: "MATH 150A", name: "Calculus I", credits: 5, courseType: "MATH" },
      { courseId: "COMS 151", name: "Fundamentals of Public Speaking", credits: 3, courseType: "GE_A1" },
      { courseId: "ENGL 115", name: "Approaches to University Writing", credits: 3, courseType: "GE_A2" },
    ]
  },
  {
    termNum: 2, termName: "Spring", semUnits: 16,
    courses: [
      { courseId: "COMP 182/L", name: "Data Structures and Program Design and Lab", credits: 4, courseType: "COMP_LOWER" },
      { courseId: "COMP 122/L", name: "Computer Architecture and Assembly", credits: 4, courseType: "COMP_LOWER" },
      { courseId: "MATH 150B", name: "Calculus II", credits: 5, courseType: "MATH" },
      { courseId: "PHIL 230", name: "Formal Logic", credits: 3, courseType: "COMP_LOWER" },
    ]
  },
  {
    termNum: 3, termName: "Fall", semUnits: 14,
    courses: [
      { courseId: "COMP 282", name: "Advanced Data Structures", credits: 3, courseType: "COMP_LOWER" },
      { courseId: "COMP 222", name: "Computer Organization", credits: 3, courseType: "COMP_LOWER" },
      { courseId: "COMP 256/L", name: "Discrete Structures for Computer Science", credits: 4, courseType: "COMP_LOWER" },
      { courseId: "PHYS 220A/L", name: "General Physics and Lab", credits: 4, courseType: "GE_B1B3" },
    ]
  },
  {
    termNum: 4, termName: "Spring", semUnits: 16,
    courses: [
      { courseId: "MATH 262", name: "Linear Algebra", credits: 3, courseType: "MATH" },
      { courseId: "BIOL 106/L", name: "Biological Principles and Lab", credits: 4, courseType: "GE_B2B3" },
      { courseId: "PHIL 150", name: "Introduction to Philosophical Thought", credits: 3, courseType: "GE_C2" },
      { courseId: "POLS 155", name: "American Political Institutions", credits: 3, courseType: "GE_D3" },
      { courseId: "AAS 100", name: "Introduction to Asian American Studies", credits: 3, courseType: "GE_F" },
    ]
  },
  {
    termNum: 5, termName: "Fall", semUnits: 14,
    courses: [
      { courseId: "COMP 322/L", name: "Introduction to Operating Systems", credits: 4, courseType: "COMP_UPPER" },
      { courseId: "COMP 310", name: "Automata", credits: 3, courseType: "COMP_UPPER" },
      { courseId: "MATH 340", name: "Introduction to Probability and Statistics", credits: 4, courseType: "MATH" },
      { courseId: "MUS 107", name: "Music Today", credits: 3, courseType: "GE_C1" },
    ]
  },
  {
    termNum: 6, termName: "Spring", semUnits: 15,
    courses: [
      { courseId: "COMP 333", name: "Concepts of Programming Languages", credits: 3, courseType: "COMP_UPPER" },
      { courseId: "COMP 380/L", name: "Introduction to Software Engineering", credits: 3, courseType: "COMP_UPPER" },
      { courseId: "COMP 324", name: "Computer Networking and Security", credits: 3, courseType: "COMP_UPPER" },
      { courseId: "HIST 271", name: "The United States Since 1865", credits: 3, courseType: "GE_C3" },
      { courseId: "ECON 101", name: "Economics for Everyday Life", credits: 3, courseType: "GE_D1" },
    ]
  },
  {
    termNum: 7, termName: "Fall", semUnits: 15,
    courses: [
      { courseId: "COMP 490/L", name: "Senior Design I", credits: 3, courseType: "COMP_UPPER" },
      { courseId: "COMP 430", name: "Language Design and Compilers", credits: 3, courseType: "COMP_ELECTIVE" },
      { courseId: "COMP 440", name: "Database Design", credits: 3, courseType: "COMP_ELECTIVE" },
      { courseId: "GEOG 321", name: "United States", credits: 3, courseType: "GE_UPPER_D" },
      { courseId: "COMP 482", name: "Algorithm Design and Analysis", credits: 3, courseType: "COMP_UPPER" },
    ]
  },
  {
    termNum: 8, termName: "Spring", semUnits: 15,
    courses: [
      { courseId: "COMP 491/L", name: "Senior Design II", credits: 3, courseType: "COMP_UPPER" },
      { courseId: "COMP 583", name: "Software Engineering Management", credits: 3, courseType: "COMP_ELECTIVE" },
      { courseId: "COMP 585", name: "Graphical User Interfaces", credits: 3, courseType: "COMP_ELECTIVE" },
      { courseId: "COMP 586", name: "Object-Oriented Software Development", credits: 3, courseType: "COMP_ELECTIVE" },
      { courseId: "COMS 356", name: "Intercultural Communication", credits: 3, courseType: "GE_UPPER_F" },
    ]
  },
];

export default function Roadmap({
  planRequest,
  onDataLoaded,
  roadmapData,
  geSelections,
  isTablet
}) {

  const [semesters, setSemesters] = useState([]);

  useEffect(() => {
    if (!roadmapData) {
      setSemesters(placeholderSemesters);  //fallback when backend is down
      return;
    }

    const sorted = roadmapData.template.semesters
      .sort((a, b) => a.termNum - b.termNum)
      .map(sem => ({
        ...sem,
        courses: Object.values(sem.courses).map(c =>
          ResolveCourse(c, geSelections)
        )
      }));

      setSemesters(sorted);
  }, [roadmapData, geSelections]);

  return (
    <div className={`grid gap-2 justify-items-center ${
      isTablet ? 'grid-cols-3' : 'grid-cols-2 md:grid-cols-4'
    }`}>

      {semesters.map((sem) => (
        <Card
          key={sem.termNum}
          semNum={sem.termNum}
          semType={sem.termName}
          semUnits={sem.semUnits}

          courses={sem.courses.map(c => ({
            courseId: c.courseId,
            name: c.name,
            credits: c.credits,
            courseType: c.courseType
          }))}

        />
      ))}

    </div>
  );
}