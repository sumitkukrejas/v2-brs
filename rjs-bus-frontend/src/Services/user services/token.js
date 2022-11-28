import axios from "axios"
import { BASE_URL } from "../BASE_URL"

export const token=(data)=>{
    return axios.post(BASE_URL+"token" , data);
}