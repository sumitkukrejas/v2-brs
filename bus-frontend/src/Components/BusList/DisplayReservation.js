import { OneBus } from "./OneBus";
// import styled from "styled-components";
import BusService from "../../Services/BusService";
import ReservationService from "../../Services/ReservationService";
import React, { useEffect, useState } from "react";

class DisplayReservation extends React.Component {
  state = {
    reservation: [],
  };

  async componentDidMount() {
    ReservationService.viewAllReservation().then((response) => {
      console.log(response);
      this.setState({ buses: response.data });
    });
  }
  render() {
    return (
      <div>
        {/* <div
          style={{
            margin: "5px",
            display: "grid",
            gridGap: "5px",
            width: "100%",
            top: "0",
          }}
        >
          {this.state.buses.map((e) => (
            <OneBus key={e.busId} data={e}></OneBus>
          ))}
        </div> */}
      </div>
    );
  }
}
export default DisplayReservation;
// class DisplayReservation extends Component {
//   // Step 1:
//   constructor(props) {
//     super(props);
//     this.state = {
//       reservation: [],
//     };
//   }
//   //Step 2:
//   async componentDidMount() {
//     ReservationService.viewAllReservation().then((Response) => {
//       console.log(Response);
//       this.setState({ reservation: Response.data });
//     });
//   }
//   deleteReservation = (id) => {
//     axios.delete(`http://localhost:9090/reservation?reservationId=${id}`).then(
//       (response) => {
//         alert("Record Deleted Successfully");
//         this.setState({
//           reservation: this.state.reservation.filter(
//             (reservation) => reservation.reservationId !== id
//           ),
//         });
//       },
//       (error) => {
//         alert("Operation Failed Here");
//       }
//     );
//   };
//   render() {
//     return (
//       <div>
//         {/* <Navbar/> */}
//         <div className="container-fluid c1">
//           <div className="addbutton">
//             <button id="addbtn" className="btn" type="button">
//               <Link id="addbtn" to={"/SearchBus"}>
//                 Book New Reservation
//               </Link>
//             </button>
//           </div>
//           {this.state.reservation.length === 0
//             ? "No Record "
//             : this.state.reservation.map((reservation, index) => (
//                 <div className="row py-3">
//                   <div className="card col-6 des" key={reservation.id}>
//                     <div className="des">
//                       <div className="card-body" style={{ color: "black" }}>
//                         <h5 className="card-title">{index + 1}</h5>
//                         <h5 className="card-title">
//                           reservationDate &nbsp; :&nbsp;{" "}
//                           {reservation.reservationDate}
//                         </h5>
//                         <h5 className="card-text">
//                           Source &nbsp; : &nbsp; {reservation.source}
//                         </h5>
//                         <h5 className="card-text">
//                           Destination &nbsp; : &nbsp;{reservation.destination}
//                         </h5>
//                         <div className="d-grid gap-2">
//                           <button id="addbtn" className="btn" type="button">
//                             <Link
//                               id="addbtn"
//                               to={`/update-reservation/${reservation.reservationId}`}
//                             >
//                               Update
//                             </Link>{" "}
//                           </button>
//                           <button
//                             id="addbtn"
//                             className="btn"
//                             onClick={() => {
//                               this.deleteReservation(reservation.reservationId);
//                             }}
//                           >
//                             Delete
//                           </button>
//                         </div>
//                       </div>
//                     </div>
//                   </div>
//                 </div>
//               ))}
//         </div>
//       </div>
//     );
//   }
// }

// export default new DisplayReservation();
