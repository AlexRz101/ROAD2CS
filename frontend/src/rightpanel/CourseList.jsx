import { useState, useEffect } from "react";
import Accordion from "../components/Accordion.jsx";

const COURSES_PER_PAGE = 8;

const placeholderCourses = [
    {id: 1, title: "Comp 110+L", content: "Units: 4 \nRequirements\nnone", units: 4},
    {id: 2, title: "Math 150A", content: "Units: 5 \nRequirements\nnone", units: 5},
    {id: 3, title: "Comp 182+L", content: "Units: 4 \nRequirements\nComp 110+L", units: 4},
    {id: 4, title: "Comp 122+L", content: "Units: 4 \nRequirements\nComp 110+L", units: 4},
    {id: 5, title: "Phil 230", content: "Units: 3 \nRequirements\nnone", units: 3},
    {id: 6, title: "Math 150B", content: "Units: 5 \nRequirements\nMath150A", units: 5},
];

export default function CourseList({ roadmapData }) {
    const [expandedId, setExpandedId] = useState(null);
    const [page, setPage] = useState(0);

    // Reset when new data loads
    useEffect(() => {
        setPage(0);
        setExpandedId(null);
    }, [roadmapData]);

    // Build courses from roadmapData if available, otherwise use placeholders
    const activeCourses = roadmapData
        ? roadmapData.template.semesters.flatMap(sem =>
            Object.values(sem.courses).map(c => ({
                id: c.courseId,
                title: c.courseId,
                content: `Units: ${c.credits}\nName: ${c.name}`,
                units: c.credits
            }))
          )
        : placeholderCourses;

    const totalUnits = roadmapData
        ? roadmapData.units
        : placeholderCourses.reduce((sum, c) => sum + (c.units || 0), 0);

    const totalPages = Math.ceil(activeCourses.length / COURSES_PER_PAGE);
    const pageCourses = activeCourses.slice(page * COURSES_PER_PAGE, (page + 1) * COURSES_PER_PAGE);

    const col1 = pageCourses.slice(0, 4);
    const col2 = pageCourses.slice(4, 8);

    const toggleExpand = (id) => {
        setExpandedId(expandedId === id ? null : id);
    };

    return (
        <div className="flex flex-col gap-4">

            {/* Total units */}
            <div className="text-center font-bold text-lg">
                Total Units: {totalUnits}
            </div>

            {/* Columns */}
            <div className="flex justify-center gap-4">
                {[col1, col2].map((col, i) => (
                    <div key={i} className="flex flex-col space-y-2">
                        {col.map((item) => (
                            <Accordion
                                key={item.id}
                                {...item}
                                isExpanded={expandedId === item.id}
                                onToggle={() => toggleExpand(item.id)}
                            />
                        ))}
                    </div>
                ))}
            </div>

            {/* Pagination */}
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