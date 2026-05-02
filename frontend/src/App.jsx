import Header from './components/Header.jsx';
import Footer from './components/Footer.jsx';
import UserChoices from './rightpanel/UserInput.jsx';
import CourseList from './rightpanel/CourseList.jsx';
import Roadmap from './pages/Roadmap.jsx';
import Popup from './components/Popup.jsx';
import { Helmet, HelmetProvider } from 'react-helmet-async';
import { useState, useEffect } from "react";
import API, { setBackendDownHandler } from './api/index.js';

const useWindowSize = () => {
  const [width, setWidth] = useState(window.innerWidth);

  useEffect(() => {
    const handleResize = () => setWidth(window.innerWidth);
    window.addEventListener('resize', handleResize);
    return () => window.removeEventListener('resize', handleResize);
  }, []);

  return width;
};

function App() {
  const [planRequest, setPlanRequest] = useState({
    years: 4,
    workload: "medium",
    chosenField: "software engineering",
    winter: false,
    summer: false
  });

  const [roadmapData, setRoadmapData] = useState(null);
  const [mobileView, setMobileView] = useState('roadmap');
  const [geOptions, setGeOptions] = useState({});
  const [geSelections, setGeSelections] = useState({});
  const [backendDown, setBackendDown] = useState(false);

  const width = useWindowSize();
  const isMobile = width < 768;
  const isTablet = width >= 768 && width < 1280;
  const isDesktop = width >= 1280;

  //Register interceptor handler
  useEffect(() => {
    setBackendDownHandler(setBackendDown);
  }, []);

  //Clear roadmap data when backend goes down so placeholder kicks in
  useEffect(() => {
    if (backendDown) setRoadmapData(null);
  }, [backendDown]);

  //Load saved swaps + GE options
  useEffect(() => {
    const saved = localStorage.getItem('geSelections');
    if (saved) setGeSelections(JSON.parse(saved));

    API.get('/api/courses')
      .then((res) => setGeOptions(res.data))
      .catch(() => {});
  }, []);

  //Fetch roadmap on submit
  useEffect(() => {
    if (!planRequest || backendDown) return;

    API.post('/api/roadmap', planRequest)
      .then((res) => setRoadmapData(res.data))
      .catch(() => {});
  }, [planRequest, backendDown]);

  // keep alive
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

  const roadmapProps = {
    planRequest,
    onDataLoaded: setRoadmapData,
    roadmapData,
    geOptions,
    geSelections,
    setGeSelections,
    isTablet,
    backendDown
  };

  const courseListProps = {
    roadmapData,
    geOptions,
    geSelections,
    setGeSelections,
    isTablet,
    backendDown
  };

  return (
    <HelmetProvider>
      <Helmet>
        <title>Road2CS - CS Roadmap for CSUN Students</title>
        <meta
          name="description"
          content="Plan your CSUN Computer Science degree with Road2CS. Visual roadmaps, course sequences, and degree planning for CS students."
        />
      </Helmet>

      <div className="flex flex-col h-screen">
        <Popup backendDown={backendDown} />
        <Header />

        {/* DESKTOP */}
        {isDesktop && (
          <div className="flex flex-1 overflow-hidden">

            <div className="flex-[3] border-r border-gray-600 p-4 overflow-auto">
              <Roadmap {...roadmapProps} />
            </div>

            <div className="flex-[1.5] flex flex-col overflow-hidden">
              <div className="border-b border-gray-600 p-4">
                <UserChoices onSubmit={setPlanRequest} backendDown={backendDown} />
              </div>

              <div className="flex-1 overflow-y-auto p-4">
                <CourseList {...courseListProps} />
              </div>
            </div>

          </div>
        )}

        {/* TABLET */}
        {isTablet && (
          <div className="flex flex-col flex-1 overflow-auto">

            <div className="border-b border-gray-600 p-4">
              <UserChoices onSubmit={handleSubmit} backendDown={backendDown} />
            </div>

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

            <div className="flex-1 overflow-auto p-4">
              {mobileView === 'roadmap' && <Roadmap {...roadmapProps} />}
              {mobileView === 'courses' && <CourseList {...courseListProps} />}
            </div>

          </div>
        )}

        {/* MOBILE */}
        {isMobile && (
          <div className="flex flex-col flex-1 overflow-auto">

            <div className="border-b border-gray-600 p-4">
              <UserChoices onSubmit={handleSubmit} backendDown={backendDown} />
            </div>

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

            <div className="flex-1 overflow-auto p-2">
              {mobileView === 'roadmap' && <Roadmap {...roadmapProps} />}
              {mobileView === 'courses' && <CourseList {...courseListProps} />}
            </div>

          </div>
        )}

        <Footer />
      </div>
    </HelmetProvider>
  );
}

export default App;