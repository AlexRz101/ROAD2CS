import { useState, useEffect } from "react";
import Accordion from "../components/Accordion.jsx";

const placeholderCourses = [
    {id: 1, title: "Comp 110+L", content: "Units: 4 \nRequirements\nnone", units: 4},
    {id: 2, title: "Math 150A", content: "Units: 5 \nRequirements\nnone", units: 5},
    {id: 3, title: "Comp 182+L", content: "Units: 4 \nRequirements\nComp 110+L", units: 4},
    {id: 4, title: "Comp 122+L", content: "Units: 4 \nRequirements\nComp 110+L", units: 4},
    {id: 5, title: "Phil 230", content: "Units: 3 \nRequirements\nnone", units: 3},
    {id: 6, title: "Math 150B", content: "Units: 5 \nRequirements\nMath150A", units: 5},
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