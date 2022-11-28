import React from "react";
import Navbar from "../../Components/Navbar";
import SearchBusForm from "./Features/SearchBusForm";
const HomePage = () => {
  return (
    <div>
      <Navbar />
      <div className=" h-screen bg-repeat bg-contain bg-[url('https://www.shutterstock.com/shutterstock/photos/518497315/display_1500/stock-vector-back-to-school-seamless-vector-pattern-good-for-textile-fabric-design-wrapping-paper-and-website-518497315.jpg')]">
        <div className="mx-36 h-screen bg-nav-black">
          <SearchBusForm/>
        </div>
      </div>
    </div>
  );
};

export default HomePage;
