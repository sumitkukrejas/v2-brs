import { Button } from "@mui/material";
import { Link, Navigate, Outlet } from "react-router-dom";
import "./styles.css";
import UserContext from "../Context/user/UserContext";
import { useContext } from "react";
import { useNavigate } from "react-router-dom";

function Header() {
  const context = useContext(UserContext);

  const { user, setuser } = context;
  const Navigate = useNavigate();
  function logout() {
    setuser(null);
    console.log(user);
    Navigate("/");
  }

  return (
    <div className="container2 col-md-12">
      
        <nav>
          <Link to="/" className="site-title">
            Blue Bus
          </Link>
          <ul>
            <li>
              <Link to="/home/searchbus">Search Bus</Link>
            </li>
            <li>
              <Link to="/home/user">Manage Account</Link>
            </li>
            <li>
              <Link to="/home/reservation">My Reservations</Link>
            </li>
            <li>
              <Button onClick={logout}>Logout</Button>
            </li>
          </ul>
        </nav>
        {/* <section id="nav-bar">
            <nav className="navbar navbar-expand-lg bg-light">  
                <div className="container-fluid">
                  <Link className="navbar-brand" to="/">BUS ADDA</Link>
                  <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <i className="fa fa-bars"></i>
                  </button>
                  <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav ml-auto">
                      <li className="nav-item">
                        <Link className="nav-link" to="/home/searchbus">HOME</Link>
                      </li>
                      <li className="nav-item">
                        <Link className="nav-link" to="/home/reservation">MY RESERVATION</Link>
                      </li>
                      <li className="nav-item">
                        <Link className="nav-link" to="/home/user">Manage Account</Link>
                      </li>
                      <li className="nav-item">
                        <Button className="nav-link" onClick={logout}>Logout</Button>
                      </li>
                    </ul>
                  </div>
                </div>
            </nav>
        </section> */}
        <Outlet />
      </div>
  );
}
export default Header;
