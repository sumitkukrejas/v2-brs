import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";
// import "../CssStyle/Styles.css";
//import Navbar from "../Navbar/navbar";

function UpdateBus() {
  const { id } = useParams();
  const URL = `http://localhost:8080/bus/id/${id}`;
  const URLL = `http://localhost:8080/bus`;
  const navigate = useNavigate();

  useEffect(() => {
    getBusById();
  }, []);
  const [buss, setBuss] = useState({
    busId: "",
    busName: "",
    busType: "",
    routeFrom: "",
    routeTo: "",
    date:"",
    arrivalTime:"",
    departureTime:"",
    seats:"",
    availableSeats:"",
  });

  const onInputChange = (e) => {
    setBuss({ ...buss, [e.target.name]: e.target.value });
  };
  const { busId,busName,busType,routeFrom,routeTo,date,arrivalTime,departureTime,seats,availableSeats} =   buss;

  const FormHandle = (e) => {
    e.preventDefault();
    updateDataToServer(buss);
  };
  const updateDataToServer = (data) => {
    axios.put(URLL, data).then(
      (response) => {
        alert("Bus Updated Successfully");
        navigate("/admin/buses");
      },
      (error) => {
        alert("Operation failed");
      }
    );
  };

  const getBusById = async (e) => {
    const busInfo = await axios.get(URL);
    setBuss(busInfo.data);
  };

    return (
        <div >
          {/* <Navbar/> */}
         <div className="container" >
           <div className= "jumbotron w-75 mx-auto shadow p-5 mt-2 bg-light">
             <div >
               <h1 className="display-4 text-center">Update Bus!</h1>
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
   
   
   
                   <div className="container text-center">
                     <button
                       id="addbtn"
                       type="submit"
                       className="btn text-center mr-2"
                     >
                       UPDATE BUS
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
export default UpdateBus;
