import React, { Component } from "react";
import { Link } from "react-router-dom";
import BusService from "../Services/BusService";
import axios from "axios";
import "../CssStyles/Styles.css";
import { Button } from "@mui/material";
import ReservationService from "../Services/ReservationService";
//import Navbar from "../Navbar/navbar";

class ReservationList extends Component {
  // Step 1:
  constructor(props) {
    super(props);
    this.state = {
      reservationList: [],
    };
  }
  //Step 2:
  componentDidMount() {
    ReservationService.viewAllReservation().then((Response) => {
      this.setState({ reservationList: Response.data });
    });
  }
  deleteResevation = (id) => {
    axios
      .delete(`http://localhost:9090/deleteReservation?reservationId=${id}`)
      .then(
        (response) => {
          alert("Record Deleted Successfully");
          this.setState({
            reservationList: this.state.reservationList.filter(
              (reservation) => reservation.reservationId !== id
            ),
          });
        },
        (error) => {
          alert("Operation Failed Here");
        }
      );
  };
  render() {
    return (
      <div>
        <table className="table table-dark table-hover center table-striped-columns table-bordered">
          <thead>
            <tr>
              <th scope="col sno">#</th>
              <th>RESERVATION ID</th>
              <th>SOURCE</th>
              <th>DESTINATION</th>
              <th>BOARDING DATE</th>
              <th>BOARDING TIME</th>
              <th>BUS TYPE</th>
              <th>BUS NUMBER</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
            {this.state.reservationList.length === 0
              ? "No Record "
              : this.state.reservationList.map((reservation, index) => (
                  <tr key={reservation.id}>
                    <th scope="row">{index + 1}</th>
                    <td>{reservation.reservationId}</td>
                    <td>{reservation.source} </td>
                    <td>{reservation.destination}</td>
                    <td>{reservation.reservationDate}</td>
                    <td>{reservation.reservationTime}</td>
                    <td>{reservation.reservationType}</td>
                    <td>{reservation.busId}</td>
                    <td>
                      <Button
                        onClick={() => {
                          this.deleteResevation(reservation.reservationId);
                        }}
                      >
                        Delete
                      </Button>
                    </td>
                  </tr>
                ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default ReservationList;
