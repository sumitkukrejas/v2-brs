import React, { useState } from "react";
import { AiOutlineUser } from "react-icons/ai";
import { FiUserPlus } from "react-icons/fi";
import { HiOutlineMail } from "react-icons/hi";
import { BsFillTelephoneFill } from "react-icons/bs";
import { AiOutlineUnlock } from "react-icons/ai";
import addUser from "../../../Services/user services/addUser";
const SignUpForm = () => {

  const [signUpFormData , setSignUpFormData] = useState({
    firstName : "",
    lastName : "",
    userName : "",
    password : "",
    contact : "",
    email : "",
    roles : "ROLE_USER"
  })

  const handleOnChange=(e)=>{
    setSignUpFormData({
      ...signUpFormData,[e.target.name]:e.target.value
    })
  }
  
  const handleOnSubmit=(e)=>{
    e.preventDefault()
    addUser(signUpFormData).then((response)=>{
      console.log(response)
    })
  }

  return (
    <div className=" bg-geryish/70 rounded-xl w-fit px-10 mt-16 ml-32 shadow-md">
      <form onSubmit={handleOnSubmit}>
        <h4 className="text-center text-3xl pb-10 pt-5 font-bold hover:cursor-pointer">
          Sign up
        </h4>
        <div className="grid gap-y-3  place-items-center">
          <div className="flex gap-x-8">
            <div>
              <AiOutlineUser className="absolute text-lg mt-2 ml-2" />
              <input
              name="firstName"
              value={signUpFormData.firstName}
              onChange={handleOnChange}
                className="pl-9 w-32  h-8 rounded-md"
                type="text"
                placeholder="First Name"
              />
            </div>
            <div>
              <AiOutlineUser className="absolute text-lg mt-2 ml-2" />
              <input
              name="lastName"
              value={signUpFormData.lastName}
              onChange={handleOnChange}
                className="pl-9 w-32  h-8 rounded-md"
                type="text"
                placeholder="Last Name"
              />
            </div>
          </div>
          <div>
            <FiUserPlus className="absolute text-lg mt-2 ml-2" />
            <input
            name="userName"
            value={signUpFormData.userName}
            onChange={handleOnChange}
              className="gap pl-9 w-72  h-8 rounded-md"
              type="text"
              placeholder="Username"
            />
          </div>
          <div className="">
            <HiOutlineMail className="absolute text-lg mt-2 ml-2" />
            <input
            name="email"
            value={signUpFormData.email}
            onChange={handleOnChange}
              className="gap pl-9 w-72  h-8 rounded-md"
              type="text"
              placeholder="E-mail"
            />
          </div>
          <div className="">
            <BsFillTelephoneFill className="absolute text-lg mt-2 ml-2" />
            <input
            name="contact"
            value={signUpFormData.contact}
            onChange={handleOnChange}
              className="gap pl-9 w-72  h-8 rounded-md"
              type="text"
              placeholder="Contact"
            />
          </div>
          <div className="">
            <AiOutlineUnlock className="absolute text-lg mt-2 ml-2" />
            <input
            name="password"
            value={signUpFormData.password}
            onChange={handleOnChange}
              className="gap pl-9 w-72 h-8  rounded-md"
              type="password"
              placeholder="Password"
            />
          </div>
          <button 
          type="submit"
          className="border rounded-full py-1 pb-2 px-6 mx-14 mb-6 bg-slate-900 text-white">
            Sign Up
          </button>
        </div>
      </form>
    </div>
  );
};

export default SignUpForm;
