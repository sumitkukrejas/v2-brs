import axios from "axios";

async function getCityData(){
    const respose = await axios.post("https://countriesnow.space/api/v0.1/countries/cities" , {"country":"india"})
    return respose.data.data;
}
export default getCityData;