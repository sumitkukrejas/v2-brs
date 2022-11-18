// import { Showseat } from '../../ShowSeat/Showseat';
import styled from "styled-components";
// import {useState} from "react";
function OneBus (data) {
    // const data = {
    //     "busId": 2,
    //     "busName": "haryana roadways",
    //     "busType": "sleeper",
    //     "routeFrom": "Delhi",
    //     "routeTo": "mumbai",
    //     "date": "2022-10-20",
    //     "arrivalTime": "10:23:50",
    //     "departureTime": "15:33:50",
    //     "seats": 100,
    //     "avaiableSeats": 100
    // }
    console.log(data)
    const Main_container = styled.div`
        top: 0;
        width: 80%;
        text-align:center;
        height: 200px;
        border: 1px solid gray;
        display: grid;
        // grid-template-rows: 80% 20%;
        :hover {
            box-shadow: 0 0px 10px orange;
        }
    `
    const Container = styled.div`
        // border: 1px solid black;
        display: grid;
        grid-template-columns: 30% 10% 10% 10% 10% 10% 10%;
    `
    const ViewSeat_btn = styled.div`
        // border: 1px solid black;
        height: 45px;
    `
    const Name_container = styled.div`
        // border: 1px solid black;
    `
    const Travel = styled.h3`
    
    `
    const Name = styled.p`
    
    `
    const Icon= styled.img`
        width: 20px;
        height: 20px;
    `
    const Departure_container = styled.div`
        // border: 1px solid black;
    `
    const Departure_time = styled.h2`
    
    `
    const Departure_address  = styled.p`
    
    `
    const Duration = styled.div`
        // border: 1px solid black;
    `
    const Duration_time = styled.p`
    
    `
    const Arrival_container = styled.div`
        // border: 1px solid black;
    `
    const Arriaval_time = styled.h3`
    `
    const Arriaval_address  = styled.p`
    
    `
    const Rating_container = styled.div`
        // border: 1px solid black;
    `
    const Rating = styled.div`
        // padding: 20px;
        width: 30px;
        margin-top: 20px;
        margin-left: 40px;
        border-radius: 3px;
        // height: 20px;
        background-color: green;
        color: white;
        font-weight: bold;
    `
    const Fare_container = styled.div`
        // border: 1px solid black;
    `
    const Ticket_price = styled.h2`
    
    `
    const Seat_container = styled.div`
        padding-left: 70px;
    `
    const Seat = styled.p`
    
    `
    const Span = styled.span`
        margin-left: 20px;
    `
    const Toggle_button = styled.button`
        float: right;
        background-color: tomato;
        color: white;
        padding: 5px;
        text-align: center;
        cursor : pointer;
        width: 150px;
        height: 40px;
        font-size: 20px;
    `
    const Seat_div = styled.div`
        border: 1px solid black;
        // height: 200px;
    `
    return (
        <Main_container>
            <Container>
                <Name_container>
                    <Travel>{data.data.busName}</Travel>   
                </Name_container>
                <Departure_container>
                    <Departure_time>{data.data.departureTime} Hours</Departure_time>
                    <Departure_address>{data.data.routeFrom}</Departure_address>
                </Departure_container>
                <Departure_container>
                    <Departure_time>{data.data.arrivalTime} Hours</Departure_time>
                    <Departure_address>{data.data.routeTo}</Departure_address>
                </Departure_container>
                <Seat_container>
                    <Seat>{data.data.avaiableSeats}</Seat>
                    Seats available
                </Seat_container>
            </Container>
            <ViewSeat_btn>
                
                <Toggle_button>Book Seat</Toggle_button>
            </ViewSeat_btn>
        </Main_container>
    )
}
export {OneBus};