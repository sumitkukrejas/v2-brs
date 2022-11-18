import React from "react";
import axios from "axios";

const BUS_BASE_URL = "http://localhost:9090";
class BusService{
searchBus = (source, distination) => {
  return axios.get(
    BUS_BASE_URL + "/" + "searchBuses?from=" + source + "&to=" + distination
  );
};

   viewAllBus=()=>{
    return axios.get(BUS_BASE_URL + "/" + "buses");
   }

   viewBus = (id)=>{
      return axios.get(`http://localhost:9090/bus/${id}`)
  }

  serachBus = (source, distination) => {
   return axios.get(
     BUS_BASE_URL + "/" + "searchBuses?from=" + source + "&to=" + distination
   )
 }

}
export default new BusService;
