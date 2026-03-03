/*Card with parameters
Will have size parameters to accomdate for differnt
amount of courses and semesters.
*/
export default function Card({ semNum, semType, courses, semUnits }) {
    return (
        //Div to define the outer card design
        <div className="w-56 h-56 p-4 rounded-lg shadow-md border border-gray-200">
            {/*Div to define the inner card design*/}
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