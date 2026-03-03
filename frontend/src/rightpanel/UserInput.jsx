import { useState } from "react";

export default function UserInput() {
    const [years, setYears] = useState('4');
    const [workload, setWorkload] = useState('light');
    const [field, setField] = useState('software engineering');
    const [winter, setWinter] = useState(false);
    const [summer, setSummer] = useState(false);

    const submit = (e) => {
        e.preventDefault();
        const planRequest = { years, workload, field, winter, summer };
        console.log(planRequest);
    }

    return (
        <form className="grid grid-cols-2" onSubmit={submit}>

            <div className="flex">
                <label>Years:</label>
                <select className="ml-2 w-max flex w-max items-center 
                rounded-lg shadow-md border border-gray-400" 
                required onChange={(e) => setYears(e.target.value)}>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                </select>
            </div>

            <div className="flex items-center gap-x-1">
                <label htmlFor="winter-checkbox">Winter</label>
                <input
                    id="winter-checkbox"
                    type="checkbox"
                    checked={winter}
                    onChange={() => setWinter(prev => !prev)}
                />
            </div>

            <div className="flex">
                <label>Workload: </label>
                <select className="ml-2 w-max items-center 
                rounded-lg shadow-md border border-gray-400" 
                required onChange={(e) => setWorkload(e.target.value)}>
                    <option value="light">Light</option>
                    <option value="medium">Medium</option>
                    <option value="heavy">Heavy</option>
                </select>
            </div>

            <div className="flex items-center gap-x-1">
                <label htmlFor="summer-checkbox">Summer</label>
                <input
                    id="summer-checkbox"
                    type="checkbox"
                    checked={summer}
                    onChange={() => setSummer(prev => !prev)}
                />
            </div>

            <div className="flex flex-col">
                <label>Field of Study:</label>
                <select className="flex w-max items-center 
                rounded-lg shadow-md border border-gray-400" 
                required onChange={(e) => setField(e.target.value)}>
                    <option value="software engineering">Software Engineering</option>
                    <option value="machine learning">Machine Learning</option>
                    <option value="web development">Web Development</option>
                    <option value="game development">Game Development</option>
                    <option value="data science">Data Science</option>
                    <option value="cybersecurity">Cybersecurity</option>
                </select>
            </div>

            <button 
            className="flex w-max items-center 
            rounded-lg shadow-md border border-blue-300" 
            type="submit">Submit</button>

        </form>
    )
}