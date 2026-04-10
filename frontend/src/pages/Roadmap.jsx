import { useState, useEffect } from "react";
import Card from '../components/Card.jsx';
import API from '../api/index.js';
import { ResolveCourse } from "../utils/ResolveCourse";

export default function Roadmap({
  planRequest,
  onDataLoaded,
  roadmapData,
  geSelections,
  isTablet
}) {

  const [semesters, setSemesters] = useState([]);

  useEffect(() => {
    if (!planRequest) return;

    API.post('/api/roadmap', planRequest)
      .then((res) => onDataLoaded(res.data))
      .catch((err) => console.error(err));
  }, [planRequest]);

  useEffect(() => {
    if (!roadmapData) return;

    const sorted = roadmapData.template.semesters
      .sort((a, b) => a.termNum - b.termNum)
      .map(sem => ({
        ...sem,
        courses: Object.values(sem.courses).map(c =>
          ResolveCourse(c, geSelections)
        )
      }));

    setSemesters(sorted);
  }, [roadmapData, geSelections]);

  return (
    <div className={`grid gap-2 justify-items-center ${
      isTablet ? 'grid-cols-3' : 'grid-cols-2 md:grid-cols-4'
    }`}>

      {semesters.map((sem) => (
        <Card
          key={sem.termNum}
          semNum={sem.termNum}
          semType={sem.termName}
          semUnits={sem.semUnits}

          // ✅ CRITICAL FIX: DO NOT REBUILD RAW DATA
          courses={sem.courses.map(c => ({
            courseId: c.courseId,
            name: c.name,
            credits: c.credits,
            courseType: c.courseType
          }))}

        />
      ))}

    </div>
  );
}