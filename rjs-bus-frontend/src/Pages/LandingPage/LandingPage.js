import React from "react";
import { Outlet } from "react-router-dom";
import LoginNavbar from "./Features/LoginNavbar";

const LandingPage = () => {
  return (
    
        <div className='bg-[url("https://images.pexels.com/photos/7245323/pexels-photo-7245323.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2")]
         w-full h-screen bg-center bg-cover mix-blend-overlay absolute'>
          <LoginNavbar />
          <Outlet/>
        </div>
     
  );
};

export default LandingPage;
