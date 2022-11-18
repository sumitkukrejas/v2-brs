import { Component, createContext, useContext } from "react";
import { useState } from "react";
import UserContext from "../Context/user/UserContext";
import UserService from "../Services/UserService";

import { useNavigate } from "react-router-dom";

const LoginPage = () => {
  const [userName, setuserName] = useState("");

  const context = useContext(UserContext);

  const { user, setuser } = context;

  const navigate = useNavigate();

  const handleOnChange = (event) => {
    setuserName(event.target.value);
    console.log(userName);
  };

  const handleOnClick = (res) => {
    res.preventDefault();

    UserService.getUserByUserName(userName)
      .then((Response) => {
        setuser(Response.data);
        console.log(user);
        if (user.userLoginId !== null && user.roles === "ROLE_ADMIN") {
          navigate("/admin");
        } else if (user.userLoginId !== null && user.roles === "ROLE_USER") {
          navigate("/home");
        } else {
          alert("invalid username");
        }
      })
      .catch((error) => {
        alert("invalid user");
      });
  };

  const handleOnClickRegister = (res) => {
    res.preventDefault();
    navigate("/register");
  };

  return (
    <div>
      <form>
        <div className="container col-md-3 mt-5">
          <form>
            <i className="bi bi-bus-front"></i>
            <h1 className="h3 mb-3 fw-normal">Please sign in</h1>

            <div className="form-floating mb-1">
              <input
                type="email"
                className="form-control"
                id="floatingInput"
                placeholder="name@example.com"
                onChange={handleOnChange}
                value={userName}
              />
              <label for="floatingInput">Username</label>
            </div>
            <div className="form-floating">
              <input
                type="password"
                className="form-control"
                id="floatingPassword"
                placeholder="Password"
              />
              <label for="floatingPassword">Password</label>
            </div>

            <div className="checkbox mb-3">
              <label>
                <input type="checkbox" value="remember-me" /> Remember me
              </label>
            </div>
            <button
              className="w-100 btn btn-lg btn-primary"
              type="submit"
              onClick={handleOnClick}
            >
              Sign in
            </button>
            <button
              className="w-100 btn btn-lg btn-primary"
              type="submit"
              onClick={handleOnClickRegister}
            >
              Sign up
            </button>
            <p className="mt-5 mb-3 text-muted">&copy; bus adda</p>
          </form>
        </div>
      </form>
    </div>
  );
};
export default LoginPage;
