import { useState, useEffect } from "react";

export default function UserInput({ onSubmit }) {

    const [years, setYears] = useState("4");
    const [workload, setWorkload] = useState("medium");
    const [field, setField] = useState("software engineering");
    const [winter, setWinter] = useState(false); 
    const [summer, setSummer] = useState(false);

    useEffect(() => {
        if (years === "5") {
            setWorkload("light");
            setWinter(false);
            setSummer(false);
            return;
        }

        if (years === "6") {
            setWorkload("light");
            return;
        }

        if (years === "4") {
            if (workload === "heavy") {
                setWinter(false);
                setSummer(false);
            } else if (workload === "medium") {
                if (winter && summer) {
                    setSummer(false);
                }
            } else if (workload === "light") {
                setWinter(true);
                setSummer(true);
            }
        }
    }, [years, workload, winter, summer]);

    const lockWorkload = years === "5" || years === "6";

    const lockExtras =
        (years === "4" && workload === "heavy") ||
        (years === "4" && workload === "light") ||
        years === "5";

    const disableWinter = lockExtras;
    const disableSummer = lockExtras;

    const handleWinter = () => {
        if (years === "4" && workload === "medium") {
            setWinter(prev => !prev);
            setSummer(false);
        } else {
            setWinter(prev => !prev);
        }
    };

    const handleSummer = () => {
        if (years === "4" && workload === "medium") {
            setSummer(prev => !prev);
            setWinter(false);
        } else {
            setSummer(prev => !prev);
        }
    };

    const submit = (e) => {
        e.preventDefault();
        onSubmit({
            years: parseInt(years),
            workload,
            chosenField: field,
            winter,
            summer
        });
    };

    return (
        <form className="grid grid-cols-2" onSubmit={submit}>

            {/* Years */}
            <div className="flex">
                <label>Years:</label>
                <select
                    className="ml-2 w-max rounded-lg shadow-md border border-gray-400"
                    value={years}
                    onChange={(e) => setYears(e.target.value)}
                >
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                </select>
            </div>

            {/* Winter */}
            <div className={`flex items-center gap-x-1 ${disableWinter ? "opacity-40 cursor-not-allowed" : ""}`}>
                <label htmlFor="winter-checkbox">Winter</label>
                <input
                    id="winter-checkbox"
                    type="checkbox"
                    checked={winter}
                    disabled={disableWinter}
                    onChange={handleWinter}
                />
            </div>

            {/* Workload */}
            <div className="flex">
                <label>Workload:</label>
                <select
                    className={`ml-2 w-max rounded-lg shadow-md border border-gray-400 ${
                        lockWorkload ? "opacity-40 cursor-not-allowed" : ""
                    }`}
                    value={workload}
                    disabled={lockWorkload}
                    onChange={(e) => setWorkload(e.target.value)}
                >
                    <option value="light">Light</option>
                    <option value="medium">Medium</option>
                    <option value="heavy">Heavy</option>
                </select>
            </div>

            {/* Summer */}
            <div className={`flex items-center gap-x-1 ${disableSummer ? "opacity-40 cursor-not-allowed" : ""}`}>
                <label htmlFor="summer-checkbox">Summer</label>
                <input
                    id="summer-checkbox"
                    type="checkbox"
                    checked={summer}
                    disabled={disableSummer}
                    onChange={handleSummer}
                />
            </div>

            {/* Field */}
            <div className="flex flex-col">
                <label>Field of Study:</label>
                <select
                    className="flex w-max rounded-lg shadow-md border border-gray-400"
                    value={field}
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

            {/* Submit */}
            <button
                className="flex w-max items-center rounded-lg shadow-md border border-blue-300"
                type="submit"
            >
                Submit
            </button>

        </form>
    );
}