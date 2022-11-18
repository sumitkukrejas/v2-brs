import axios from "axios";

const USER_BASE_URL = "http://localhost:9090";

class ReservationService{

   viewAllReservation=()=>{
    return axios.get(USER_BASE_URL + "/" + "viewAllReservation");
   }

}
export default new ReservationService;
