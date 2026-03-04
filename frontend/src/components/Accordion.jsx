//Accordion component for course list
export default function Accordion({ title, content, 
    isExpanded, onToggle }) {
    return (
        
        //Div for the base accordion
        <div className={`bg-white w-40 rounded-3xl
        overflow-hidden transition-all duration-300 
        rounded-lg shadow-md border border-gray-200 ${
            isExpanded ? "max-h-96" : "max-h-16"
        }`}>

            {/*Div for the course name*/}
            <div className="flex justify-center items-start 
            px-4 pt-5 pb-2 cursor-pointer" onClick={onToggle}>
                <div className="text-2x1 font-bold">
                    {title}
                </div>
            </div>

            {/*Div for the content within the expanded accordion */}
            <div className={`flex justify-center overflow-hidden 
                transition-all duration-300 whitespace-pre-line ${isExpanded ? 
                "opacity-100" : "opacity-0"}`}>
                <div>{content}</div>
            </div>

        </div>
    )
}