import { useState, useEffect } from "react";
import Card from '../components/Card.jsx';
import API from '../api/index.js';

export default function Roadmap({ planRequest, onDataLoaded, roadmapData }) {

  const [semesters, setSemesters] = useState([]);  

  useEffect(() => {
    if (!roadmapData) return;
    const sorted = [...roadmapData.template.semesters]
      .sort((a, b) => a.termNum - b.termNum);
    setSemesters(sorted);
  }, [roadmapData]);

  useEffect(() => {
    if (!planRequest) return;
    API.post('/api/roadmap', planRequest)
      .then((res) => onDataLoaded(res.data))
      .catch((err) => console.error(err));
  }, [planRequest]);

  return (
    <div className="grid grid-cols-2 md:grid-cols-4 gap-4 p-4 pb-4">
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