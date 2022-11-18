import logo from './logo.svg';
import './App.css';
import DisplayUsers from './Components/users';
import Searchbus from './Components/Searchbus';
import DisplayBuses from './Components/buses';
import Header from './Components/Header';
import Routing from './Routes';
import Router from './Routes';
import LoginPage from './Pages/LoginPage';
import UserState from './Context/user/UserState';
import UserContext from './Context/user/UserContext';
import AdminHome from './Components/AdminHome';
import { OneBus } from './Components/BusList/OneBus';
import Register from './Components/Register';
// header('Access-Control-Allow-Origin: *');
// header('Access-Control-Allow-Methods: POST, GET , PUT , DELETE');

function App() {

  return (
    <div className="App">
      <header className="App-header">
      <UserState>
        {/* <DisplayUsers/> */}
        {/* <Searchbus/> */}
        {/* <DisplayBuses/> */}
         <Router/>
        {/* <LoginPage/> */}
        {/* <AdminHome></AdminHome> */}
        </UserState>
        {/* <OneBus/> */}
        {/* <ListBuses/> */}
        {/* <Register/> */}
        {/* <Register/> */}
        </header>
    </div>
  );
}

export default App;
