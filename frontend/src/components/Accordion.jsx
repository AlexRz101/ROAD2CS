//Accordion component for course list
export default function Accordion({ title, content, isExpanded, onToggle }) {

    return (
        
        //Div for the base accordion
        <div className={`bg-white w-56 rounded-lg
            overflow-hidden transition-all duration-300 
            shadow-md border border-gray-200 ${
            isExpanded ? "max-h-96" : "max-h-20"
        }`}>

            <div className="flex justify-center items-start 
                px-6 pt-5 pb-2 cursor-pointer" onClick={onToggle}>
                <div className="text-base font-bold"> {title} </div>
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