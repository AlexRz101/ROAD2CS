import Header from './components/Header.jsx';
import Footer from './components/Footer.jsx';
import UserChoices from './rightpanel/UserInput.jsx';
import CourseList from './rightpanel/CourseList.jsx';
import Roadmap from './pages/Roadmap.jsx';
import Popup from './components/Popup.jsx';
import { Helmet, HelmetProvider } from 'react-helmet-async';
import { useState, useEffect } from "react";
import API from './api/index.js';

function App() {
  const [planRequest, setPlanRequest] = useState(null);
  const [roadmapData, setRoadmapData] = useState(null);
  const [mobileView, setMobileView] = useState('roadmap');

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

  const handleSubmit = (request) => {
    setPlanRequest(request);
    setMobileView('roadmap');
  };

  return (
    <HelmetProvider>
      <Helmet>
        <title>Road2CS – CS Roadmap for CSUN Students</title>
        <meta name="description" content="Plan your CSUN Computer Science degree with Road2CS. Visual roadmaps, course sequences, and degree planning for CS students." />
      </Helmet>

      <div className="flex flex-col h-screen">
        <Popup />
        <Header />

        {/* DESKTOP */}
        <div className="hidden md:flex flex-1 overflow-hidden">
          <div className="flex-[3] border-r border-gray-600 p-4 overflow-auto">
            <Roadmap planRequest={planRequest} onDataLoaded={setRoadmapData} roadmapData={roadmapData} />
          </div>
          <div className="flex-[1.5] flex flex-col overflow-hidden">
            <div className="border-b border-gray-600 p-4">
              <UserChoices onSubmit={setPlanRequest} />
            </div>
            <div className="flex-1 overflow-y-auto p-4">
              <CourseList roadmapData={roadmapData} />
            </div>
          </div>
        </div>

        {/* MOBILE */}
        <div className="flex md:hidden flex-col flex-1 overflow-auto">
          {/* User Input */}
          <div className="border-b border-gray-600 p-4">
            <UserChoices onSubmit={handleSubmit} />
          </div>

          {/* Toggle */}
          <div className="flex border-b border-gray-600">
            <button
              onClick={() => setMobileView('roadmap')}
              className={`flex-1 py-2 text-sm font-medium ${
                mobileView === 'roadmap'
                  ? 'border-b-2 border-blue-500 text-blue-500'
                  : 'text-gray-400'
              }`}
            >
              Roadmap
            </button>
            <button
              onClick={() => setMobileView('courses')}
              className={`flex-1 py-2 text-sm font-medium ${
                mobileView === 'courses'
                  ? 'border-b-2 border-blue-500 text-blue-500'
                  : 'text-gray-400'
              }`}
            >
              Courses
            </button>
          </div>

          {/* Content */}
<<<<<<< HEAD
          <div className="flex-1 overflow-auto">
=======
          <div className="flex-1 overflow-auto p-2">
>>>>>>> prod
            {mobileView === 'roadmap' && (
              <Roadmap planRequest={planRequest} onDataLoaded={setRoadmapData} roadmapData={roadmapData} />
            )}
            {mobileView === 'courses' && (
              <CourseList roadmapData={roadmapData} />
            )}
          </div>
        </div>

        <Footer />
      </div>
    </HelmetProvider>
  );
}

export default App;