import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";
import "../CssStyle/Styles.css";
//import Navbar from "../Navbar/navbar";

function UpdateReservation() {
  const { id } = useParams();
  const URL = `http://localhost:9090/reservation?reservationId=${id}`;
  const URLL = `http://localhost:9090/updateReservation`;
  const navigate = useNavigate();

  useEffect(() => {
    getReservationById();
  }, []);
  const [reservation, setReservation] = useState({
    reservationId: "",
    reservationStatus: "",
    reservationType: "",
    reservationDate: "",
    reservationTime: "",
    source:"",
    destination:"",
    bus:"",
  });

  const onInputChange = (e) => {
    setReservation({ ...reservation, [e.target.name]: e.target.value });
  };
  const { reservationId, reservationStatus, reservationType, reservationDate, reservationTime, source, destination, bus} =
  reservation;

  const FormHandle = (e) => {
    e.preventDefault();
    updateDataToServer(reservation);
  };
  const updateDataToServer = (data) => {
    axios.put(URLL, data).then(
      (response) => {
        alert("Reservation Updated Successfully");
        navigate("/displayReservation");
      },
      (error) => {
        alert("Operation failed");
      }
    );
  };

  const getReservationById = async (e) => {
    const reservationInfo = await axios.get(URL);
    setReservation(reservationInfo.data);
  };

  return (
    <div >
      {/* <Navbar/> */}
     <div className="container" >
       <div className= "jumbotron w-75 mx-auto shadow p-5 mt-2 bg-light">
         <div >
           <h1 className="display-4 text-center">Update Reservation!</h1>
           <div>
             <form onSubmit={(e) => FormHandle(e)}>
               <div className="form-group">
                 <label for="exampleInputEmail1">Reservation Id</label>
                 <input
                   type="number"
                   className="form-control"
                   name="reservationId"
                   placeholder="Enter Reservation Id"
                   required
                   value={reservationId}
                   onChange={(e) => onInputChange(e)}
                 />
               </div>
               <div className="form-group">
                 <label for="exampleInputEmail1">Reservation Status</label>
                 <input
                   type="text"
                   className="form-control"
                   name="reservationStatus"
                   placeholder="Enter Reservation Status"
                   required
                   value={reservationStatus}
                   onChange={(e) => onInputChange(e)}
                 />
               </div>
               <div className="form-group">
                 <label for="exampleInputPassword1">Reservation Type</label>
                 <input
                   type="text"
                   className="form-control"
                   name="reservationType"
                   placeholder="Enter Reservation Type"
                   required
                   value={reservationType}
                   onChange={(e) => onInputChange(e)}
                 />
               </div>
               <div className="form-group">
                 <label for="exampleInputPassword1">Reservation Date</label>
                 <input
                   type="Date"
                   className="form-control"
                   name="reservationDate"
                   placeholder="Enter Reservation Date"
                   required
                   value={reservationDate}
                   onChange={(e) => onInputChange(e)}
                 />
               </div>
               <div className="form-group">
                 <label for="exampleInputPassword1">Reservation Time</label>
                 <input
                   type="Time"
                   className="form-control"
                   name="reservationTime"
                   placeholder="Enter Reservation Time"
                   required
                   value={reservationTime}
                   onChange={(e) => onInputChange(e)}
                 />
               </div>

               <div className="form-group">
                 <label for="exampleInputPassword1">source</label>
                 <input
                   type="text"
                   className="form-control"
                   name="source"
                   placeholder="Enter Source"
                   required
                   value={source}
                   onChange={(e) => onInputChange(e)}
                 />
               </div>

               <div className="form-group">
                 <label for="exampleInputPassword1">Destination</label>
                 <input
                   type="text"
                   className="form-control"
                   name="destination"
                   placeholder="Enter Destination"
                   required
                   value={destination}
                   onChange={(e) => onInputChange(e)}
                 />
               </div>

               {/* <div className="form-group">
                 <label for="exampleInputPassword1">Bus</label>
                 <input
                   type="text"
                   className="form-control"
                   name="bus"
                   placeholder="Enter Bus"
                   value={bus}
                   onChange={(e) => onInputChange(e)}
                 />
               </div> */}

               <div className="container text-center">
                 <button
                   id="addbtn"
                   type="submit"
                   className="btn text-center mr-2"
                 >
                   Update Now
                 </button>
               </div>
             </form>
           </div>
         </div>
       </div>
     </div>
   </div>
 );
}
export default UpdateReservation;