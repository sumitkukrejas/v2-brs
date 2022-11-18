import UserContext from "../Context/user/UserContext";
import { useContext } from "react";

function Welcome(){
    const context = useContext(UserContext)
    const {user , setuser} = context
    console.log(user)
    const fullName = user.userName

    return(
        <div>
            <h1> Welcome {fullName}</h1>
        </div>
    )
}
export default Welcome;