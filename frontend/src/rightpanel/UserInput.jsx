import { useState } from "react";
export default function UserInput() {
    const [years, setYears] = useState('4');
    const [workload, setWorkload] = useState('light');
    const [winter, setWinter] = useState(false);
    const [summer, setSummer] = useState(false);

    const submit = (e) => {
        e.preventDefault();
        const planRequest = { years, workload, winter, summer };
        console.log(planRequest);
    }

    return (

        <div>
            <form onSubmit={submit}>
                <label>Years:</label>
                <input
                    type="number"
                    required
                    name="years"
                    value={years}
                    onChange={(e) => setYears(e.target.value)} />
                <label>Workload: </label>
                <select onChange={(e) => setWorkload(e.target.value)} required>
                    <option value="light">Light</option>
                    <option value="medium">Medium</option>
                    <option value="heavy">Heavy</option>
                </select>
                <label htmlfor="winter-checkbox">Winter</label>
                <input id="winter-checkbox" checked={winter} onChange={(e) => setWinter(prev => !prev)} type="checkbox"></input>
                <label htmlfor="summer-checkbox">Summer</label>
                <input id="summer-checkbox" checked={summer} onChange={(e) => setSummer(prev => !prev)} type="checkbox"></input>
                <button>Submit</button>
            </form>
        </div>
    )
}