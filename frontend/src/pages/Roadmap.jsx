import { useState, useEffect } from "react";
import Card from '../components/Card.jsx';
import API from '../api/index.js';

export default function Roadmap({ planRequest, onDataLoaded, roadmapData }) {

  const [semesters, setSemesters] = useState([]);  

  //Update semesters whenever roadmapData changes (includes default load)
  useEffect(() => {
    if (!roadmapData) return;
    const sorted = [...roadmapData.template.semesters]
      .sort((a, b) => a.termNum - b.termNum);
    setSemesters(sorted);
  }, [roadmapData]);

  //Fetch when user submits a new request
  useEffect(() => {
    if (!planRequest) return;
    API.post('', planRequest)
      .then((res) => onDataLoaded(res.data))
      .catch((err) => console.error(err));
  }, [planRequest]);

  return (
    <div className="grid grid-cols-4 gap-4 p-4"> 
      {semesters.map((sem) => (
        <Card
          key={sem.termNum}
          semNum={sem.termNum}
          semType={sem.termName}        
          semUnits={sem.semUnits}
          courses={Object.values(sem.courses).map(c => c.courseId)}
        />
      ))}
    </div>
  );
}