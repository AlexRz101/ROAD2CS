import { useState } from "react";
import Accordion from "../components/Accordion.jsx";

//Placeholder courses to preview accordions
const accordionData = [
    {id: 1, title: "Comp 110+L", content: "Units: 4 \nRequirements\nnone"},
    {id: 2, title: "Math 150A", content: "Units: 5 \nRequirements\nnone"},
    {id: 3, title: "Comp 182+L", content: "Units: 4 \nRequirements\nComp 110+L"},
    {id: 4, title: "Comp 122+L", content: "Units: 4 \nRequirements\nComp 110+L"},
    {id: 5, title: "Phil 230", content: "Units: 3 \nRequirements\nnone"},
    {id: 6, title: "Math 150B", content: "Units: 5 \nRequirements\nMath150A"},
    {id: 7, title: "Course 7", content: "Units: 0 \nRequirements\nn/a"},
    {id: 8, title: "Course 8", content: "Units: 0 \nRequirements\nn/a"},
    {id: 9, title: "Course 9", content: "Units: 0 \nRequirements\nn/a"},
    {id: 10, title: "Course 10", content: "Units: 0 \nRequirements\nn/a"},
    {id: 11, title: "Course 11", content: "Units: 0 \nRequirements\nn/a"},
    {id: 12, title: "Course 12", content: "Units: 0 \nRequirements\nn/a"},
    {id: 13, title: "Course 13", content: "Units: 0 \nRequirements\nn/a"},
    {id: 14, title: "Course 14", content: "Units: 0 \nRequirements\nn/a"},
    {id: 15, title: "Course 15", content: "Units: 0 \nRequirements\nn/a"},
    {id: 16, title: "Course 16", content: "Units: 0 \nRequirements\nn/a"},
    {id: 17, title: "Course 17", content: "Units: 0 \nRequirements\nn/a"},
    {id: 18, title: "Course 18", content: "Units: 0 \nRequirements\nn/a"},
    {id: 19, title: "Course 19", content: "Units: 0 \nRequirements\nn/a"},
    {id: 20, title: "Course 20", content: "Units: 0 \nRequirements\nn/a"},
    {id: 21, title: "Course 21", content: "Units: 0 \nRequirements\nn/a"},
    {id: 22, title: "Course 22", content: "Units: 0 \nRequirements\nn/a"},
    {id: 23, title: "Course 23", content: "Units: 0 \nRequirements\nn/a"},
    {id: 24, title: "Course 24", content: "Units: 0 \nRequirements\nn/a"}
]

export default function CourseList() {
    const [expandedId, setExpandedId] = useState(null);

    const col1 = accordionData.slice(0, 6);
    const col2 = accordionData.slice(6, 12);
    const col3 = accordionData.slice(12, 18);

    const toggleExpand = (id) => {
        setExpandedId(expandedId === id ? null : id)
    }

    return (
        //Column 1, map all courses to it
        <div className="flex gap-4">
            <div className="flex flex-col space-y-2">
                {col1.map((item) => (
                    <Accordion
                    key={item.id}
                    {...item}
                    isExpanded={expandedId === item.id}
                    onToggle={() => toggleExpand(item.id)}
                    />
                ))}
            </div>

            {/*Column 2, map all courses to it*/}
            <div className="flex flex-col space-y-2">
                {col2.map((item) => (
                    <Accordion
                    key={item.id}
                    {...item}
                    isExpanded={expandedId === item.id}
                    onToggle={() => toggleExpand(item.id)}
                    />
                ))}
            </div>

            {/*Column 3, map all courses to it*/}
            <div className="flex flex-col space-y-2">
                {col3.map((item) => (
                    <Accordion
                    key={item.id}
                    {...item}
                    isExpanded={expandedId === item.id}
                    onToggle={() => toggleExpand(item.id)}
                    />
                ))}
            </div>
        </div>
    )
}