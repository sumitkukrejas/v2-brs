import React, { useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
// import Table from "react-bootstrap/Table";
import UserContext from "../Context/user/UserContext";
import UserService from "../Services/UserService";

const ResultTable = ({ data }) => {
  const navigate = useNavigate();
  const [userName, setuserName] = useState("");

  const context = useContext(UserContext);

  const [user, setuser] = useState(context);

  const [loading, setloading] = useState(true);
  const [first, setfirst] = useState();
  const reservation = {
    reservationId: "",
    reservationStatus: "",
    reservationDate: "",
    reservationType: "",
    source: "",
    destination: "",
    reservationTime: "",
    busId: 0,
  };

  const [reser, setreser] = useState(reservation);

  const updateUser = async (u) => {
    console.log(u);
    await UserService.updateUser(u)
      .then((response) => {
        console.log(response.data);
        const reser = response.data.reservation.reservationId;
        console.log(reser);

        alert("Your Reservation has been booked ! with ID as " + `${reser}`);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleClick = () => {
    // console.log(user);
    // const x = user.user;
    // console.log(x);
    // console.log(x.email);
    // x.userLoginId = 1;
    // console.log(x.userLoginId);

    // console.log(data[0]);
    reservation.reservationId = Math.floor(Math.random() * 1000);
    console.log(reservation.reservationId);
    reservation.busId = data[0].busId;
    data[0].avaiableSeats -= 1;
    reservation.source = data[0].routeFrom;
    reservation.destination = data[0].routeTo;
    reservation.reservationTime = data[0].departureTime;

    reservation.reservationType = data[0].busType;
    reservation.reservationDate = data[0].date;
    reservation.reservationStatus = "booked";
    user.user.reservation = reservation;
    setreser(reservation);
    console.log(reser);
    setuser({ ...user, reservation: reser });
    console.log(user.user);
    // console.log(x.reservation);
    // const myUser =JSON.parse(user.user)
    // console.log(myUser)
    updateUser(user.user);
  };

  return (
    <>
      <div>
        <table
          className="table



table-dark



table-hover



center



table-striped-columns



table-bordered"
        >
          <thead>
            <tr>
              <th>From</th>
              <th>To</th>

              <th>Type</th>
              <th>Departure</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {data.map((item) => (
              <tr key={item.id}>
                <td>{item.routeFrom}</td>
                <td>{item.routeTo}</td>
                <td>{item.busType}</td>
                <td>{item.departureTime}</td>

                <td>
                  {" "}
                  <button onClick={handleClick}>BOOKNOW</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default ResultTable;
