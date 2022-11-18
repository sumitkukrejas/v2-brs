import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

import "../CssStyles/Styles.css";
//import Navbar from "../Navbar/navbar";

function CreateBus() {
  const navigate = useNavigate();
  const [buss, setBuss] = useState({
    busId: "",
    busName: "",
    busType: "",
    routeFrom: "",
    routeTo: "",
    date: "",
    arrivalTime: "",
    departureTime: "",
    seats: "",
    availableSeats: "",
  });
  const onInputChange = (e) => {
    setBuss({ ...buss, [e.target.name]: e.target.value });
  };
  const {
    busId,
    busName,
    busType,
    routeFrom,
    routeTo,
    date,
    arrivalTime,
    departureTime,
    seats,
    availableSeats,
  } = buss;

  const FormHandle = (e) => {
    e.preventDefault();
    addDataToServer(buss);
  };
  const addDataToServer = (data) => {
    axios.post("http://localhost:9090/addbus", data).then(
      (response) => {
        console.log(response);
        alert("Bus Added Successfully");
        navigate("/admin/buses");
      },
      (error) => {
        console.log(error);
        alert("Operation failed");
      }
    );
  };
  return (
    <>
      {/* <Navbar/> */}
      <div className="container11 col-md-12">
        <div className="jumbotron w-75 mx-auto shadow p-5 mt-2">
          <div>
            <h1 className="display-4 text-center">Add Bus!</h1>
            <div>
              <form onSubmit={(e) => FormHandle(e)}>
                <div className="form-group">
                  <label for="exampleInputEmail1">Bus Id</label>
                  <input
                    type="number"
                    className="form-control"
                    name="busId"
                    placeholder="Enter bus Id"
                    required
                    value={busId}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputEmail1">Bus Name</label>
                  <input
                    type="text"
                    className="form-control"
                    name="busName"
                    placeholder="Enter Bus Name "
                    required
                    value={busName}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Bus Type</label>
                  <input
                    type="text"
                    className="form-control"
                    name="busType"
                    placeholder="Enter Bus Type"
                    required
                    value={busType}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">routeFrom</label>
                  <input
                    type="text"
                    className="form-control"
                    name="routeFrom"
                    placeholder="Enter routeFrom"
                    required
                    value={routeFrom}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">routeTo</label>
                  <input
                    type="text"
                    className="form-control"
                    name="routeTo"
                    placeholder="Enter routeTo"
                    required
                    value={routeTo}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div className="form-group">
                  <label for="exampleInputPassword1">date</label>
                  <input
                    type="Date"
                    className="form-control"
                    name="date"
                    placeholder="Enter date"
                    required
                    value={date}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div className="form-group">
                  <label for="exampleInputPassword1">arrivalTime</label>
                  <input
                    type="time"
                    className="form-control"
                    name="arrivalTime"
                    placeholder="Enter arrivalTime"
                    required
                    value={arrivalTime}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div className="form-group">
                  <label for="exampleInputPassword1">departureTime</label>
                  <input
                    type="time"
                    className="form-control"
                    name="departureTime"
                    placeholder="Enter departureTime"
                    value={departureTime}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div className="form-group">
                  <label for="exampleInputPassword1">seats</label>
                  <input
                    type="number"
                    className="form-control"
                    name="seats"
                    placeholder="Enter seats"
                    required
                    value={seats}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div className="form-group">
                  <label for="exampleInputPassword1">availableSeats</label>
                  <input
                    type="number"
                    className="form-control"
                    name="availableSeats"
                    placeholder="Enter availableSeats"
                    required
                    value={availableSeats}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div className=" text-center">
                  <button
                    id="addbtn"
                    type="submit"
                    className="btn text-center mr-2"
                  >
                    ADD BUS
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
export default CreateBus;
