import { OneBus } from "./OneBus";
// import styled from "styled-components";
import BusService from "../../Services/BusService";
import React, { useEffect, useState } from "react";

class ListBuses extends React.Component{

    state={
        buses : []
    };

    async componentDidMount(){
        BusService.viewAllBus().then((response)=>{
            console.log(response)
            this.setState({buses :response.data});
        });
    }
render(){
    return(
        <div>
            <div style = {{margin: "5px", display: "grid",gridGap: "5px", width: "100%", top: "0"}}>
                {
                    this.state.buses.map((e) => (
                        <OneBus key={e.busId} data={e}></OneBus>
                    ))
                }
        </div>
    </div>
    )
}

}
export default ListBuses;