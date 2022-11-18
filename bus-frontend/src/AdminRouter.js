import { BrowserRouter, Route } from "react-router-dom";
import Header from "./Components/Header";

function AdminRouter() {
  return (
    <div>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route exact path="/" element={<LoginPage />}></Route>
          <Route exact path="/home" element={<Searchbus />}></Route>
          <Route exact path="/users" element={<DisplayUsers />}></Route>
          <Route
            exact
            path="/reservations"
            element={<DisplayReservation />}
          ></Route>
          <Route
            exact
            path="/addreservation"
            element={<CreateReservationComponent />}
          ></Route>
          <Route exact path="/currentuser" element={<Currentuser />}></Route>
          <Route exact path="/login" element={<LoginPage />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}
