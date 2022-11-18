import { useContext, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Table from "react-bootstrap/Table";

import UserContext from "../Context/user/UserContext";

function Currentuser() {
  const navigate = useNavigate();

  const { user, setuser } = useContext(UserContext);
  return (
    <div className="container1 col-md-8">
      <h3>Your Details </h3>
      <Table
        className="table
        table-dark
        table-hover
        center
        table-striped-columns
        table-bordered"
      >
        <thead>
          <tr>
            <th>Full name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Role</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>
              {user.firstName} {user.lastName}
            </td>
            <td>{user.email}</td>
            <td>{user.contact}</td>
            <td>{user.roles}</td>
            <td>
              <button
                onClick={() => {
                  navigate("/home/updateuser");
                }}
              >
                Update Detials
              </button>
            </td>
          </tr>
        </tbody>
      </Table>
    </div>
  );
}
export default Currentuser;
