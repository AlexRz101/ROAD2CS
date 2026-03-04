import Header from './components/Header.jsx';
import Footer from './components/Footer.jsx';
import UserChoices from './rightpanel/UserInput.jsx';
import CourseList from './rightpanel/CourseList.jsx';
import Roadmap from './pages/Roadmap.jsx';
import { useState } from "react";

function App() {

  const [planRequest, setPlanRequest] = useState(null);
  return (
    <div className="flex flex-col h-screen overflow-hidden">

      <Header />

      {/* Main Layout */}
      <div className="flex flex-1"> 

        {/* Left Side (Roadmap) */}
        <div className="flex-[3] border-r border-gray-600 p-4 overflow-hidden">
          <Roadmap planRequest={planRequest} />

        </div>

        {/* Right Side Panel */}
        <div className="flex-[1.5] flex flex-col">

          <div className="border-b border-gray-600 p-4">
            <UserChoices onSubmit={setPlanRequest} />
          </div>

          <div className="flex-1 overflow-y-auto p-4">
            <CourseList />
          </div>
        </div>
      </div>

      <Footer />
    </div>
  );
}

export default App;