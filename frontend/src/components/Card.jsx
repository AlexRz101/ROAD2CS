export default function Card({ semNum, semType, courses, semUnits }) {
    return (
        <div className="w-40 md:w-56 p-2 md:p-4 text-sm md:text-base rounded-lg shadow-md border border-gray-200">
            <div className="flex flex-col items-center border-b border-gray-600"> 
                <p>Semester {semNum}, {semType}</p>
                <p>Total Units: {semUnits}</p>
            </div>
            <div className="pt-2">
                <ul className="space-y-1">
                    {courses.map((course) => (
                        <li key={course}>{course}</li>
                    ))}
                </ul>
            </div>
        </div>
    )
}