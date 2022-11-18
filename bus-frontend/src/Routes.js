import { BrowserRouter, Routes, Route } from "react-router-dom";
import Header from "./Components/Header";
import Searchbus from "./Components/Searchbus";
import DisplayUsers from "./Components/users";
import CreateReservationComponent from "./Components/createReservation";
import Currentuser from "./Components/CurrentUser";

import LoginPage from "./Pages/LoginPage";
import UserState from "./Context/user/UserState";
import AdminMenu from "./Components/AdminMenu";
import AdminHome from "./Components/AdminHome";
// import DisplayReservation from "./Components/BusList/DisplayReservation";
import ResevationList from "./Components/ReservationList";
import DisplayReservation from "./Components/BusList/DisplayReservation";
import DisplayBus from "./Components/displayBus";
import ListBuses from "./Components/BusList/DisplayBuses";
import CreateBus from "./Components/createBus";
import Welcome from "./Components/WelcomeUser";
import UserReservation from "./Components/UserReservation";
import UpdateBus from "./Components/updateBus";
import Register from "./Components/Register";
import ReservationList from "./Components/ReservationList";
import UpdateUser from "./Components/updateUser";
import UserList from "./Components/UserList";

function Router() {
  return (
    <div>
      <BrowserRouter>
        {/* <AdminHome/> */}
        <Routes>
          <Route exact path="/" element={<LoginPage />}></Route>
          <Route exact path="/register" element={<Register />}></Route>

          <Route exact path="/admin" element={<AdminHome />}>
            <Route exact path="/admin/" element={<Welcome />} />
            <Route exact path="/admin/users" element={<UserList />} />
            <Route exact path="/admin/buses" element={<DisplayBus />} />
            <Route
              exact
              path="/admin/reservations"
              element={<ReservationList />}
            />
            <Route exact path="/admin/addbus" element={<CreateBus />} />
            <Route exact path="/admin/upadte-bus/:id" element={<UpdateBus />} />
          </Route>
          <Route exact path="/home" element={<Header />}>
            <Route exact path="/home/" element={<Welcome />} />
            <Route exact path="/home/searchbus" element={<Searchbus />} />
            <Route exact path="/home/user" element={<Currentuser />} />
            <Route exact path="/home/updateuser" element={<UpdateUser />} />
            <Route
              exact
              path="/home/reservation"
              element={<UserReservation />}
            />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}
export default Router;
