const name = "Placeholder User's Name"
const studentID = "Placeholder Student ID"
const major = "Computer Science"

export default function Header() {
    return (
        <div className="border-b border-gray-600">
            <div className="flex justify-between items-center">
                <div className="">
                    <a href='https://www.csun.edu'> <img src='/CSUN_logo.svg' className="h-16 m-16"></img> </a>
                </div>
                <div className="m-16 text-Montserrat"> 
                    <div>{name}</div>
                    <div>{studentID}</div>
                    <div>{major}</div>
                </div>    
            </div>
        </div>
    )
}