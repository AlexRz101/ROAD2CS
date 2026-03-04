import { useState, useEffect } from "react";
import Card from '../components/Card.jsx';
import API from '../api/index.js';

export default function Roadmap({ planRequest }) {
  const [semesters, setSemesters] = useState([]);

  useEffect(() => {
    if (!planRequest) return;

    API.post('', planRequest)
      .then((res) => {
        const sorted = Object.values(res.data.template.semesters)
        .sort((a, b) => a.termNum - b.termNum);
        setSemesters(sorted);
      })
      .catch((err) => console.error(err));
  }, [planRequest]);

  return (
    <div className="grid grid-cols-4 gap-4 p-4 place-content-center h-full">
      {semesters.map((sem) => (
        <Card
          key={sem.termNum}
          semNum={sem.termNum}
          semType={sem.semType}
          semUnits={sem.totalCredits}
          courses={Object.values(sem.courses).map(c => c.courseId)}
        />
      ))}
    </div>
  );
}