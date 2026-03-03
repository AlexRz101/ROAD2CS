import Header from './components/Header.jsx'
import Footer from './components/Footer.jsx'
import UserChoices from './rightpanel/UserInput.jsx'
import CourseList from './rightpanel/CourseList.jsx'
import Roadmap from './pages/Roadmap.jsx'

function App() {
  return (
    <div className="flex flex-col h-screen">
      <Header />
      {/* Main Layout */}
      <div className="flex flex-1">

        {/* Left Side */}
        <div className="w-72 border-r">
          <Roadmap />
        </div>

        {/* Right Side */}
        <div className="flex flex-col flex-1">

          <div className="border-b p-4">
            <UserChoices />
          </div>

          <div className="flex-1 overflow-y-auto p-4">
            <CourseList />
          </div>
        </div>
      </div>
      <Footer />
    </div>
  )
}

export default App