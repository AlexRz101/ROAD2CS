import { useState } from "react";

export default function Card({
  semNum,
  semType,
  courses,
  semUnits,
  geOptions = {},
  geSelections = {},
  setGeSelections
}) {
  const [openDropdown, setOpenDropdown] = useState(null);

  const toggleDropdown = (e, courseId) => {
    e.stopPropagation();
    setOpenDropdown(openDropdown === courseId ? null : courseId);
  };

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
    localStorage.setItem("geSelections", JSON.stringify(updated));
    setOpenDropdown(null);
  };

  return (
    <div className="w-40 md:w-56 p-2 md:p-4 text-sm md:text-base rounded-lg shadow-md border border-gray-200">

      <div className="flex flex-col items-center border-b border-gray-600">
        <p>Semester {semNum}, {semType}</p>
        <p>Total Units: {semUnits}</p>
      </div>

      <div className="pt-2">
        <ul className="space-y-2">

          {courses.map((course) => {
            const baseId = course.courseId;

            const options = geOptions?.[course.courseType] || [];
            const isOpen = openDropdown === baseId;

            const swapped = geSelections?.[baseId];
            const display = swapped?.courseId ?? course.courseId;

            return (
              <li key={baseId} className="relative flex items-center gap-1">

                <span className="truncate">{display}</span>

                {options.length > 0 && (
                  <button
                    onClick={(e) => toggleDropdown(e, baseId)}
                    className="text-blue-400 text-xs px-1"
                  >
                    ⇄
                  </button>
                )}

                {isOpen && (
  <div className="
    absolute z-50 mt-2 left-0
    w-56 max-w-[90vw]
    max-h-64 overflow-auto
    bg-gray-800 border border-gray-600 rounded-lg shadow-lg
  ">
                    {options.map((opt) => (
                      <button
                        key={opt.courseId}
                        onClick={() =>
                          handleSwap(baseId, opt, course.courseType)
                        }
                        className="w-full text-left px-3 py-2 text-sm hover:bg-gray-700"
                      >
                        {opt.courseId} — {opt.name}
                      </button>
                    ))}
                  </div>
                )}

              </li>
            );
          })}

        </ul>
      </div>
    </div>
  );
}