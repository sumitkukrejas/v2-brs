import React, { useState } from "react";
import { FaUserAlt } from "react-icons/fa";
import { RiLockPasswordFill } from "react-icons/ri";
import { useNavigate } from "react-router-dom";
import { token } from "../../../Services/user services/token";

const LoginForm = () => {
const navigate = useNavigate();
const [loginFormData , setLoginFormData] = useState({
  userName : "",
  password : "",
})

const handleOnChange=(e)=>{
  setLoginFormData({
    ...loginFormData,[e.target.name]:e.target.value
  })
}

const handleOnSubmit=(e)=>{
  e.preventDefault()
  token(loginFormData).then((response)=>{
    localStorage.setItem("token" , response.data.token)
    navigate("/home")
  })
}

  return (
    <div className="m-auto w-fit mt-24 ml-32 bg-geryish/70 p-10 border-1 rounded-xl shadow-md">
      <form onSubmit={handleOnSubmit}>
        <h4 className="text-center text-3xl pb-10 font-bold hover:cursor-pointer">
          Sign in
        </h4>
        <div className="grid gap-5">
          <div className="w-14">
            <FaUserAlt className="absolute mt-2 ml-2 " />
            <input
              value={loginFormData.userName}
              onChange={handleOnChange}
              name="userName"
              type="text"
              className="border h-8 pl-7 rounded-md placeholder:text-black"
              placeholder="Username"
            />
          </div>
          <div>
            <div>
              <RiLockPasswordFill className="absolute mt-2 ml-2 text-lg" />
              <input
              value={loginFormData.password}
              onChange={handleOnChange}
              name="password"
                type="password"
                className="border h-8  pl-7 rounded-md placeholder:text-black"
                placeholder="Password"
              />
            </div>
            <p className="text-sm text-blue-800 font-bold pl-24">
              forgot password?
            </p>
          </div>
          <button
            type="submit"
            className="border rounded-full py-1 pb-2 mx-14 bg-slate-900 text-white "
          >
            Login
          </button>
        </div>
      </form>
    </div>
  );
};

export default LoginForm;
