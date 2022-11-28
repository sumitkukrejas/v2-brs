import { BASE_URL } from "../BASE_URL"
import axios from "axios"
const searchBus=(from , to , date)=>{
    return axios.get(BASE_URL + "searchBus" +"?from="+{from}+"&to="+{to}+"&departure="+{date})
}
export default searchBus;