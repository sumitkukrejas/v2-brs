import React from "react";
import Card from '@mui/material/Card';
import Typography from '@mui/material/Typography';
import CardContent from '@mui/material/CardContent';
import ReservationService from "../Services/ReservationService";

// const reservations=[
//     {
//         reservationId : 2, reservationStatus: 'djffd', reservationType:'hjjk', reservationDate:'9:10-07', reservationTime:'10:59:35', source:'mijjoj', destination:'huhuju',bus:'busrk' 
//     }
// ]

class DisplayReservation extends React.Component {

    state = {
        reservations : []
    };

    async componentDidMount(){
        ReservationService.viewAllReservation().then((Response) => {
            this.setState({ reservations: Response.data });
          });
    }


    render() {
        return (
            <div>
                {this.state.reservations.map((props) => {
                    //reservations.map((props) => {
                // users.map((props) => {
                    return (
                        <Card>
                            <CardContent>
                                {/* <Typography>userLoginId = {props.userLoginId}</Typography> */}
                                <Typography variant="h5"> reservationId = {props.reservationId}</Typography>
                                <Typography> reservationType = {props.reservationType}</Typography>
                                <Typography> reservationStatus = {props.reservationStatus}</Typography>
                                <Typography> reservationDate = {props.reservationDate}</Typography>
                                <Typography> reservationTime = {props.reservationTime}</Typography>
                                <Typography> source = {props.source}</Typography>
                                <Typography> destination = {props.destination}</Typography>
                                <Typography> bus = {props.bus}</Typography>
                            </CardContent>
                        </Card>
                    )
                })}
            </div>
        )
    }
}
export default DisplayReservation;