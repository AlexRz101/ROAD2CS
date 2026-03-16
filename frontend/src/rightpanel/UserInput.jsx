import { useState, useEffect } from "react";

export default function UserInput({ onSubmit }) {
    const [years, setYears] = useState('4');
    const [workload, setWorkload] = useState('light');
    const [field, setField] = useState('software engineering');
    const [winter, setWinter] = useState(false);
    const [summer, setSummer] = useState(false);

    useEffect(() => {
        if (years === '4' && workload === 'heavy') {
            // 4 years heavy — gray everything out
            setWinter(false);
            setSummer(false);
        } else if (years === '4' && workload === 'medium') {
            // 4 years medium — gray everything out
            setWinter(false);
            setSummer(false);
        } else if (years === '4' && workload === 'light') {
            // 4 years light — auto-check both
            setWinter(true);
            setSummer(true);
        } else if (years === '5') {
            // 5 years — force light, gray out extras
            setWorkload('light');
            setWinter(false);
            setSummer(false);
        } else if (years === '6') {
            // 6 years — force light
            setWorkload('light');
        }
    }, [years, workload]);

    // Derived disabled states
    const lockExtras = 
        (years === '4' && (workload === 'heavy' || workload === 'medium')) ||
        years === '5';

    const lockWorkload = years === '5' || years === '6';

    const submit = (e) => {
        e.preventDefault();
        onSubmit({ years: parseInt(years), workload, chosenField: field, winter, summer });
    };

    return (
        <form className="grid grid-cols-2" onSubmit={submit}>

            <div className="flex">
                <label>Years:</label>
                <select
                    className="ml-2 w-max rounded-lg shadow-md border border-gray-400"
                    value={years}
                    required
                    onChange={(e) => setYears(e.target.value)}
                >
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                </select>
            </div>

            <div className={`flex items-center gap-x-1 ${lockExtras ? 'opacity-40 cursor-not-allowed' : ''}`}>
                <label htmlFor="winter-checkbox">Winter</label>
                <input
                    id="winter-checkbox"
                    type="checkbox"
                    checked={winter}
                    disabled={lockExtras}
                    onChange={() => setWinter(prev => !prev)}
                />
            </div>

            <div className="flex">
                <label>Workload:</label>
                <select
                    className={`ml-2 w-max rounded-lg shadow-md border border-gray-400 ${lockWorkload ? 'opacity-40 cursor-not-allowed' : ''}`}
                    value={workload}
                    required
                    disabled={lockWorkload}
                    onChange={(e) => setWorkload(e.target.value)}
                >
                    <option value="light">Light</option>
                    <option value="medium">Medium</option>
                    <option value="heavy">Heavy</option>
                </select>
            </div>

            <div className={`flex items-center gap-x-1 ${lockExtras ? 'opacity-40 cursor-not-allowed' : ''}`}>
                <label htmlFor="summer-checkbox">Summer</label>
                <input
                    id="summer-checkbox"
                    type="checkbox"
                    checked={summer}
                    disabled={lockExtras}
                    onChange={() => setSummer(prev => !prev)}
                />
            </div>

            <div className="flex flex-col">
                <label>Field of Study:</label>
                <select
                    className="flex w-max rounded-lg shadow-md border border-gray-400"
                    value={field}
                    required
                    onChange={(e) => setField(e.target.value)}
                >
                    <option value="software engineering">Software Engineering</option>
                    <option value="machine learning">Machine Learning</option>
                    <option value="web development">Web Development</option>
                    <option value="game development">Game Development</option>
                    <option value="data science">Data Science</option>
                    <option value="cybersecurity">Cybersecurity</option>
                </select>
            </div>

            <button
                className="flex w-max items-center rounded-lg shadow-md border border-blue-300"
                type="submit"
            >
                Submit
            </button>

        </form>
    );
}