import { useState, useEffect } from "react";
import Accordion from "../components/Accordion.jsx";

//Used if the backend is down
const placeholderCourses = [
    //Semester 1 - Fall
    {id: "COMP110-L", title: "COMP 110/L", content: "Units: 4\nName: Introduction to Algorithms and Programming and Lab", units: 4},
    {id: "MATH150A", title: "MATH 150A", content: "Units: 5\nName: Calculus I", units: 5},
    {id: "COMS151", title: "COMS 151", content: "Units: 3\nName: Fundamentals of Public Speaking", units: 3},
    {id: "ENG115", title: "ENGL 115", content: "Units: 3\nName: Approaches to University Writing", units: 3},

    //Semester 2 - Spring
    {id: "COMP182-L", title: "COMP 182/L", content: "Units: 4\nName: Data Structures and Program Design and Lab", units: 4},
    {id: "COMP122-L", title: "COMP 122/L", content: "Units: 4\nName: Computer Architecture and Assembly", units: 4},
    {id: "MATH150B", title: "MATH 150B", content: "Units: 5\nName: Calculus II", units: 5},
    {id: "PHIL230", title: "PHIL 230", content: "Units: 3\nName: Formal Logic", units: 3},

    //Semester 3 - Fall
    {id: "COMP282", title: "COMP 282", content: "Units: 3\nName: Advanced Data Structures", units: 3},
    {id: "COMP222", title: "COMP 222", content: "Units: 3\nName: Computer Organization", units: 3},
    {id: "COMP256-L", title: "COMP 256/L", content: "Units: 4\nName: Discrete Structures for Computer Science", units: 4},
    {id: "PHYS220A-L", title: "PHYS 220A/L", content: "Units: 4\nName: General Physics and Lab", units: 4},

    //Semester 4 - Spring
    {id: "MATH262", title: "MATH 262", content: "Units: 3\nName: Linear Algebra", units: 3},
    {id: "BIOL106-L", title: "BIOL 106/L", content: "Units: 4\nName: Biological Principles and Lab", units: 4},
    {id: "PHIL150", title: "PHIL 150", content: "Units: 3\nName: Introduction to Philosophical Thought", units: 3},
    {id: "POLS155", title: "POLS 155", content: "Units: 3\nName: American Political Institutions", units: 3},
    {id: "AAS100", title: "AAS 100", content: "Units: 3\nName: Introduction to Asian American Studies", units: 3},

    //Semester 5 - Fall
    {id: "COMP322-L", title: "COMP 322/L", content: "Units: 4\nName: Introduction to Operating Systems", units: 4},
    {id: "COMP310", title: "COMP 310", content: "Units: 3\nName: Automata", units: 3},
    {id: "MATH340", title: "MATH 340", content: "Units: 4\nName: Introduction to Probability and Statistics", units: 4},
    {id: "MUS107", title: "MUS 107", content: "Units: 3\nName: Music Today", units: 3},

    //Semester 6 - Spring
    {id: "COMP333", title: "COMP 333", content: "Units: 3\nName: Concepts of Programming Languages", units: 3},
    {id: "COMP380-L", title: "COMP 380/L", content: "Units: 3\nName: Introduction to Software Engineering", units: 3},
    {id: "COMP324", title: "COMP 324", content: "Units: 3\nName: Computer Networking and Security", units: 3},
    {id: "HIST271", title: "HIST 271", content: "Units: 3\nName: The United States Since 1865", units: 3},
    {id: "ECON101", title: "ECON 101", content: "Units: 3\nName: Economics for Everyday Life", units: 3},

    //Semester 7 - Fall (SWE track)
    {id: "COMP490-L", title: "COMP 490/L", content: "Units: 3\nName: Senior Design I", units: 3},
    {id: "COMP430", title: "COMP 430", content: "Units: 3\nName: Language Design and Compilers", units: 3},
    {id: "COMP440", title: "COMP 440", content: "Units: 3\nName: Database Design", units: 3},
    {id: "GEOG321", title: "GEOG 321", content: "Units: 3\nName: United States", units: 3},
    {id: "COMP482", title: "COMP 482", content: "Units: 3\nName: Algorithm Design and Analysis", units: 3},

    //Semester 8 - Spring (SWE track)
    {id: "COMP491-L", title: "COMP 491/L", content: "Units: 3\nName: Senior Design II", units: 3},
    {id: "COMP583", title: "COMP 583", content: "Units: 3\nName: Software Engineering Management", units: 3},
    {id: "COMP585", title: "COMP 585", content: "Units: 3\nName: Graphical User Interfaces", units: 3},
    {id: "COMP586", title: "COMP 586", content: "Units: 3\nName: Object-Oriented Software Development", units: 3},
    {id: "COMS356", title: "COMS 356", content: "Units: 3\nName: Intercultural Communication", units: 3},
];

const GE_TYPES = new Set([
    "GE_A1", "GE_A2", "GE_B1B3", "GE_B2B3", "GE_C1", 
    "GE_C2", "GE_C3", "GE_D1", "GE_D3", "GE_F"
]);

export default function CourseList({ roadmapData, isTablet, geOptions, geSelections, setGeSelections }) {

    const [expandedId, setExpandedId] = useState(null);
    const [openDropdownId, setOpenDropdownId] = useState(null);
    const [page, setPage] = useState(0);

    const COURSES_PER_PAGE = isTablet ? 12 : 10;

    useEffect(() => {
        setPage(0);
        setExpandedId(null);
        setOpenDropdownId(null);
    }, [roadmapData]);

    const isGE = (courseType) => GE_TYPES.has(courseType);

    const handleSwap = (originalCourseId, newCourse, courseType) => {
        const updated = {
            ...geSelections,
            [originalCourseId]: {
                courseId: newCourse.courseId,
                name: newCourse.name,
                credits: newCourse.credits,
                courseType,
            }
        };
        setGeSelections(updated);
        localStorage.setItem('geSelections', JSON.stringify(updated));
        setOpenDropdownId(null);
    };

    const activeCourses = roadmapData
        ? roadmapData.template.semesters.flatMap(sem =>
            Object.values(sem.courses).map(c => {
                const swapped = geSelections[c.courseId];
                const resolved = swapped
                    ? { ...c, courseId: swapped.courseId, name: swapped.name, credits: swapped.credits }
                    : c;
                return {
                    id: c.courseId,
                    title: resolved.courseId,
                    content: `Units: ${resolved.credits}\nName: ${resolved.name}`,
                    units: resolved.credits,
                    courseType: c.courseType,
                    isGE: isGE(c.courseType),
                    originalId: c.courseId,
                };
            })
        )
        : placeholderCourses;

    const totalUnits = activeCourses.reduce((sum, c) => sum + (c.units || 0), 0);

    const totalPages = Math.ceil(activeCourses.length / COURSES_PER_PAGE);
    const pageCourses = activeCourses.slice(page * COURSES_PER_PAGE, (page + 1) * COURSES_PER_PAGE);

    const col1 = pageCourses.slice(0, isTablet ? 6 : 5);
    const col2 = pageCourses.slice(isTablet ? 6 : 5, isTablet ? 12 : 10);

    const toggleExpand = (id) => {
        setExpandedId(expandedId === id ? null : id);
        setOpenDropdownId(null);
    };

    const toggleDropdown = (e, id) => {
        e.stopPropagation();
        setOpenDropdownId(openDropdownId === id ? null : id);
    };

    const renderCourse = (item, isRightCol = false) => {
        const options = geOptions[item.courseType] || [];
        const isDropdownOpen = openDropdownId === item.originalId;

        const swapButton = item.isGE && (
            <button
                onClick={(e) => toggleDropdown(e, item.originalId)}
                className="border border-blue-300 rounded-lg shadow-md px-2 py-0.5 text-xs"
            >
                Change GE
            </button>
        );

        return (
            <div key={item.id} className="relative">
                <Accordion
                    {...item}
                    isExpanded={expandedId === item.id}
                    onToggle={() => toggleExpand(item.id)}
                    swapButton={swapButton}
                />

                {isDropdownOpen && (
                    <div className={`absolute z-10 mt-1 w-56 bg-white border border-gray-400 rounded-lg shadow-md ${isRightCol ? 'right-0' : 'left-0'}`}>
                        {options.map((opt) => (
                            <button
                                key={opt.courseId}
                                onClick={() => handleSwap(item.originalId, opt, item.courseType)}
                                className="w-full text-left px-3 py-2 text-sm hover:bg-gray-100 text-gray-800"
                            >
                                {opt.courseId} — {opt.name} ({opt.credits} units)
                            </button>
                        ))}
                    </div>
                )}
            </div>
        );
    };

    return (
        <div className="flex flex-col gap-4">

            <div className="text-center font-bold text-lg">
                Total Units: {totalUnits}
            </div>

            <div className="flex justify-center gap-4">
                {[col1, col2].map((col, i) => (
                    <div key={i} className="flex flex-col space-y-2">
                        {col.map((item) => renderCourse(item, i === 1))}
                    </div>
                ))}
            </div>

            {totalPages > 1 && (
                <div className="flex justify-center items-center gap-4">
                    <button
                        onClick={() => { setPage(p => p - 1); setExpandedId(null); }}
                        disabled={page === 0}
                        className="px-3 py-1 rounded-lg border border-gray-300 disabled:opacity-30"
                    >
                        ←
                    </button>
                    <span>Page {page + 1} of {totalPages}</span>
                    <button
                        onClick={() => { setPage(p => p + 1); setExpandedId(null); }}
                        disabled={page === totalPages - 1}
                        className="px-3 py-1 rounded-lg border border-gray-300 disabled:opacity-30"
                    >
                        →
                    </button>
                </div>
            )}

        </div>
    );
}