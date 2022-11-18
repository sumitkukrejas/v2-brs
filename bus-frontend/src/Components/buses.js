import { Component } from "react";

const busbackend = [];
class DisplayBuses extends Component {
  state = {
    buses: [
      {
        busId: 100,
        busName: "HIMACHAL-EXPRESS",
        driverName: "JHON DOE",
        busType: "NON-AC",
        routeFrom: "SRINAGAR",
        routeTo: "SHIMLA",
        arrivalTime: "10:00:00",
        departureTime: "10:00:00",
        seats: 30,
        avaiableSeats: 30,
      },
      {
        busId: 100,
        busName: "HIMACHAL-EXPRESS",
        driverName: "JHON DOE",
        busType: "NON-AC",
        routeFrom: "SRINAGAR",
        routeTo: "SHIMLA",
        arrivalTime: "10:00:00",
        departureTime: "10:00:00",
        seats: 30,
        avaiableSeats: 30,
      },
    ],
  };

  render() {
    return (
      <div>
        {this.state.buses.map((props) => {
          return (
            <div>
              <h1>{props.busName}</h1>
            </div>
          );
        })}
      </div>
    );
  }
}
export default DisplayBuses;
