import UserContext from "../Context/user/UserContext";
import { useContext } from "react";
import Table from "react-bootstrap/Table";

function UserReservation() {
  const { user, setuser } = useContext(UserContext);

  const reservation = user.reservation;

  if (reservation.length === 0 || reservation === null) {
    return (
      <div>
        <h1>No Reservation Found</h1>
      </div>
    );
  } else {
    return (
      <div>
        <h3>Your Reservation </h3>
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
              <th>RESERVATION ID</th>
              <th>SOURCE</th>
              <th>DESTINATION</th>
              <th>BOARDING TIME</th>
              <th>BUS TYPE</th>
              <th>BUS NUMBER</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>{reservation.reservationId} </td>
              <td>{reservation.source} </td>
              <td>{reservation.destination}</td>

              <td>{reservation.reservationTime}</td>
              <td>{reservation.reservationType}</td>
              <td>{reservation.busId}</td>
            </tr>
          </tbody>
        </Table>
      </div>
    );
  }
}

export default UserReservation;
