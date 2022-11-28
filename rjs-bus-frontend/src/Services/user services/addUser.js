import { BASE_URL } from "../BASE_URL"
import axios from "axios"
const addUser=(data)=>{
    return axios.post(BASE_URL + "addUser" , data)
}
export default addUser;