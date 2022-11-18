import React, { Component } from "react";
import { Link } from "react-router-dom";
import BusService from "../Services/BusService";
import axios from "axios";
import "../CssStyles/Styles.css";
import { Button } from "@mui/material";
//import Navbar from "../Navbar/navbar";

class DisplayBus extends Component {
  // Step 1:
  constructor(props) {
    super(props);
    this.state = {
      bus: [],
    };
  }
  //Step 2:
  componentDidMount() {
    BusService.viewAllBus().then((Response) => {
      this.setState({ bus: Response.data });
    });
  }
  deleteBus = (id) => {
    axios.delete(`http://localhost:9090/bus?busId=${id}`).then(
      (response) => {
        alert("Record Deleted Successfully");
        this.setState({
          bus: this.state.bus.filter((bus) => bus.busId !== id),
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
              <th scope="col">Bus Name</th>
              <th scope="col">Type</th>
              <th scope="col">From</th>
              <th scope="col">To</th>
              <th scope="col">Arrival Time</th>

              <th scope="col">Seats</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
            {this.state.bus.length === 0
              ? "No Record "
              : this.state.bus.map((bus, index) => (
                  <tr key={bus.id}>
                    <th scope="row">{index + 1}</th>
                    <td>{bus.busName}</td>
                    <td>{bus.busType}</td>
                    <td>{bus.routeFrom}</td>
                    <td>{bus.routeTo}</td>
                    <td>{bus.arrivalTime}</td>

                    <td>{bus.seats}</td>
                    <td>
                      <Button type="button">
                        <Link to={`/admin/update-bus/${bus.busId}`}>
                          Update
                        </Link>
                      </Button>
                      <Button
                        onClick={() => {
                          this.deleteBus(bus.busId);
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

export default DisplayBus;
