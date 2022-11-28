import React, { useState } from "react";
import { TbBus } from "react-icons/tb";
import { Link } from "react-router-dom";
import {VscAccount} from "react-icons/vsc"
const Navbar = () => {
  const [dropDownOpen , setDropDownOpen] = useState(false)

  const onMouseEnter = () =>{
    setDropDownOpen(true)
  }
  const onMouseLeave = () =>{
    setDropDownOpen(false)
  }
  return (
    <nav className="items-center flex justify-between py-4 bg-gradient-to-b from-slate-900 to-cyan-900 text-white">
      <div className="flex gap-2">
        <div className="text-4xl ml-2">
          <TbBus />
        </div>
        <div className="font-bold text-2xl">
          <Link to="/home">Bus Adda</Link>
        </div>
      </div>
      <ul className="flex items-center pr-4 gap-3">
        <li>
          <Link to="/home/myreservations">My Trips</Link>
        </li>
        <li className="justify-end text-4xl ml-3" onMouseEnter={onMouseEnter} onMouseLeave={onMouseLeave}>
         
          <VscAccount className="relative"/>
          <div className={dropDownOpen ? "" : "hidden"}>
          <ul className="bg-white group-focus:block rounded-lg text-sm py-2- absolute right-0">
            <li className="block px-3 py-1 text-black hover:bg-indigo-500 hover:text-white">Manage Account</li>
            <li className="block px-3 py-1 text-black hover:bg-indigo-500 hover:text-white">Logout</li>
          </ul>
          </div>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
