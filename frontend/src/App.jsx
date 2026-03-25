import Header from './components/Header.jsx';
import Footer from './components/Footer.jsx';
import UserChoices from './rightpanel/UserInput.jsx';
import CourseList from './rightpanel/CourseList.jsx';
import Roadmap from './pages/Roadmap.jsx';
import Popup from './components/Popup.jsx';

import { useState, useEffect } from "react";
import API from './api/index.js';

function App() {
  const [planRequest, setPlanRequest] = useState(null);
  const [roadmapData, setRoadmapData] = useState(null);

  useEffect(() => {
    const defaultRequest = {
      years: 4,
      workload: "medium",
      chosenField: "software engineering",
      winter: false,
      summer: false
    };
    API.post('/api/roadmap', defaultRequest)
      .then((res) => setRoadmapData(res.data))
      .catch((err) => console.error(err));
  }, []);

  useEffect(() => {
    const keepAlive = setInterval(() => {
      API.post('/api/roadmap', {
        years: 4,
        workload: "medium",
        chosenField: "software engineering",
        winter: false,
        summer: false
      }).catch(() => {});
    }, 10 * 60 * 1000);

    return () => clearInterval(keepAlive);
  }, []);

  return (
    <div className="flex flex-col h-screen">

      <Popup />
      <Header />

      <div className="flex flex-1 overflow-hidden">

        <div className="flex-[3] border-r border-gray-600 p-4 overflow-auto">
          <Roadmap planRequest={planRequest} onDataLoaded={setRoadmapData} roadmapData={roadmapData}/>
        </div>

        <div className="flex-[1.5] flex flex-col overflow-hidden">
          <div className="border-b border-gray-600 p-4">
            <UserChoices onSubmit={setPlanRequest} />
          </div>
          <div className="flex-1 overflow-y-auto p-4">
            <CourseList roadmapData={roadmapData}/>
          </div>
        </div>

      </div>

      <Footer />
    </div>
  );
}

export default App;