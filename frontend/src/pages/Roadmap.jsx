import Card from '../components/Card.jsx';

//Roadmap visualizer
export default function Roadmap() {
  return (

    //Div that makes a grid 
   <div className="grid grid-cols-4 gap-4 p-4 place-content-center h-full">

      {/* Placeholder Semesters */}
      <Card 
      semNum="1"
      semType="Fall"
      semUnits="3"
      courses={["Comp 110", "Math150A", "English"]}
      />

      <Card 
      semNum="2" 
      semType="Spring"
      semUnits="3"
      courses={["Comp 182", "Comp 122", "Math 150B"]}
      />

      <Card 
      semNum="3"
      semType="Fall"
      semUnits="3"
      courses={["Phil 230", "Bio 106+L", "Mus 107"]}
      />

      <Card 
      semNum="4"
      semType="Spring"
      semUnits="3"
      courses={["Course 1", "Course 2", "Course 3"]}
      />

      <Card 
      semNum="5"
      semType="Fall"
      semUnits="3"
      courses={["Course 1", "Course 2", "Course 3"]}
      />

      <Card 
      semNum="6"
      semType="Spring"
      semUnits="3"
      courses={["Comp 310", "Math 340", "Comp 380", "Comp 324", "Comp 333"]}
      />

      <Card 
      semNum="7"
      semType="Fall"
      semUnits="3"
      courses={["Course 1", "Course 2", "Course 3"]}
      />

      <Card 
      semNum="8"
      semType="Spring"
      semUnits="3"
      courses={["Course 1", "Course 2", "Course 3"]}
      />
    </div>
  );
}