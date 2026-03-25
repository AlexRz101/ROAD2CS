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
                <div className="">
                    <a href='https://www.csun.edu'> <img src='/CSUN_logo.svg' className="h-16 mx-16 my-10"></img> </a>
                </div>
                {/*<div className="mx-16 my-10 text-Montserrat"> 
                    <div>{name}</div>
                    <div>{studentID}</div>
                    <div>{major}</div>
                </div>*/}  
                {/* Right: Road2CS Title Block */}
                <div className="mx-16 my-10 text-Montserrat text-right">
                    <div className="text-2xl font-bold italic">Road2CS</div>
                    <div className="text-lg">A CSUN Template-Based</div>
                    <div className="text-lg">Computer Science Roadmap</div>
                </div>
            </div>
        </div>
    )
}