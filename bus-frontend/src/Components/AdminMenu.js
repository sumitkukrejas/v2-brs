import { Link, Outlet } from "react-router-dom";
import "./styles.css";
import UserContext from "../Context/user/UserContext";
import { useContext } from "react";
import { Navigate } from "react-router-dom";
import { Button } from "@mui/material";
import { useNavigate } from "react-router-dom";
function AdminMenu() {
  const context = useContext(UserContext);

  const { user, setuser } = context;
  const Navigate = useNavigate();

  function logout() {
    setuser(null);
    console.log(user);
    Navigate("/");
  }
  return (
    <div >
      <nav>
        <Link to="/" className="site-title">
          Blue Bus
        </Link>
        <ul>
          <li>
            <Link to="/admin/users">All Users</Link>
          </li>
          <li>
            <Link to="/admin/buses">All Buses</Link>
          </li>
          <li>
            <Link to="/admin/reservations">All Reservations</Link>
          </li>
          <li>
            <Link to="/admin/addbus">Add Bus</Link>
          </li>
          <li>
            <Button onClick={logout}>Logout</Button>
          </li>
        </ul>
      </nav>
      <Outlet />
    </div>
  );
}
export default AdminMenu;
