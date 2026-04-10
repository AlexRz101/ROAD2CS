import { useState, useEffect, useRef } from "react";

export default function UserInput({ onSubmit }) {

    const [years, setYears] = useState(() => localStorage.getItem('pref_years') || "4");
    const [workload, setWorkload] = useState(() => localStorage.getItem('pref_workload') || "medium");
    const [field, setField] = useState(() => localStorage.getItem('pref_field') || "software engineering");
    const [winter, setWinter] = useState(() => localStorage.getItem('pref_winter') === "true");
    const [summer, setSummer] = useState(() => localStorage.getItem('pref_summer') === "true");

    useEffect(() => {
        const savedYears = localStorage.getItem('pref_years');
        if (savedYears) {
            onSubmit({
                years: parseInt(years),
                workload,
                chosenField: field,
                winter,
                summer,
            });
        }
    }, []);

    const isMounted = useRef(false);

    useEffect(() => {
        if (!isMounted.current) {
            isMounted.current = true;
            return;
        }

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
        localStorage.setItem('pref_years', years);
        localStorage.setItem('pref_workload', workload);
        localStorage.setItem('pref_field', field);
        localStorage.setItem('pref_winter', winter);
        localStorage.setItem('pref_summer', summer);
        onSubmit({ years: parseInt(years), workload, chosenField: field, winter, summer });
    };

    return (
        <form className="grid grid-cols-2 gap-x-10 gap-y-1 text-sm md:text-base" onSubmit={submit}>

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