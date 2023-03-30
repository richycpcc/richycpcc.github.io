import React,{useState} from "react";
import Button from "./components/Button";
import './App.css';

function App() {
  const [count, setCount] = useState(0);
  const [ savedCounts, setSavedCounts] = useState([]);

  let addCount = () => {
    setCount(count + 1);
  };

  //count will never go negative
  let minusCount = () =>{
    if (count > 0){ 
    setCount(count - 1);
    }
  };

  let resetCount = () =>{
    setCount(0);
  }

  let saveCount = () =>{
    setSavedCounts([...savedCounts, count]);
    resetCount();
  }

  return (
    <div className="App">
      <h1>Lap Counter</h1>
      <h2>Count: {count}</h2>
      <div className = "buttons">
        <Button title = {"Decrease"} action = {minusCount} />
        <Button title = {"Increase"} action = {addCount} />
        <Button title = {"Reset"} action = {resetCount} />
        <Button title = {"Save"} action = {saveCount} />
      </div>  
      <div className = "logs">
        <ol>
          {savedCounts.map((savedCount, index)=>(
            <li key = {index}>{savedCount}</li>
          ))}
        </ol>
      </div>
    </div>
  );
}

export default App;
