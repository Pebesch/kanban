import './App.css'
import BoardList from "./components/BoardList.tsx";
import Login from "./components/Login.tsx";
import Register from "./components/Register.tsx";

function App() {
  return (
    <>
        <Register></Register>
        <Login></Login>
        <BoardList></BoardList>
    </>
  )
}

export default App
