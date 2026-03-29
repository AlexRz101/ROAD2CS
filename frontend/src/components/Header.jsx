/*
Leave here for potential CSUN integration
const name = "Placeholder User's Name"
const studentID = "Placeholder Student ID"
const major = "Computer Science"
*/
export default function Header() {
    return (
        <div className="border-b border-gray-600">
            <div className="flex justify-between items-center">
                <div>
                    <a href='https://www.csun.edu'>
                        <img src='/CSUN_logo.svg' className="h-6 md:h-10 mx-4 my-4 md:mx-16 md:my-4" />
                    </a>
                </div>
                <div className="mx-4 my-4 md:mx-16 md:my-4 text-Montserrat text-right">
                    <h1 className="text-lg md:text-2xl font-bold italic">Road2CS</h1>
                    <div className="text-sm md:text-lg">A CSUN Template-Based</div>
                    <div className="text-sm md:text-lg">Computer Science Roadmap</div>
                </div>
            </div>
        </div>
    )
}