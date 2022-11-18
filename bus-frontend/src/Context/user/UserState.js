import React, { useState } from "react";
import UserContext from "./UserContext";

const UserState = (props) => {
  const userinitial = {
    userLoginId: null,
    userName: "",
    password: "",
    firstName: "",
    lastName: "",
    contact: "",
    email: "",
    reservation: ["barkat"],
    roles: "",
  };

  const [user, setuser] = useState(userinitial);

  return (
    <UserContext.Provider value={{ user, setuser }}>
      {props.children}
    </UserContext.Provider>
  );
};

export default UserState;
