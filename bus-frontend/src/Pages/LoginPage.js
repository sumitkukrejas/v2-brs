import { Component, createContext, useContext } from "react";
import { useState } from "react";
import UserContext from "../Context/user/UserContext";
import UserService from "../Services/UserService";
import "./LoginPage.css";
import { useNavigate } from "react-router-dom";
import Bus from "../bus-png3.png";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faBusSimple, faCoffee } from "@fortawesome/free-solid-svg-icons";

const LoginPage = (props) => {
  const [userName, setuserName] = useState("");

  const context = useContext(UserContext);

  const { user, setuser } = context;

  const navigate = useNavigate();

  const handleOnChange = (event) => {
    setuserName(event.target.value);
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
        }
      })
      .catch((error) => {
        console.log("INVALID USER");
      });
  };

  const handleOnClickRegister = (res) => {
    res.preventDefault();
    navigate("/register");
  };

  return (
    <div>
      <div className="page-body">
        <div className="container col-md-3 mt-5">
          <form className="sign-in-form">
            <i className="bi bi-bus-front"></i>
            <h4>
              Welcome back! to BUS ADDA
              <FontAwesomeIcon icon={faBusSimple} id="icon" />
            </h4>
            <h2>Sign in</h2>
            <div className="form-floating mb-1" id="input-field">
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
              id="btn1"
              type="submit"
              onClick={handleOnClick}
            >
              Sign In
            </button>
            {/* <button className="w-100 btn btn-lg btn-primary" type="submit" onClick={handleOnClickRegister}>Sign Up</button> */}
            <p className="mt-5 mb-3 text-muted">&copy; bus adda</p>
          </form>
        </div>

        {/* <div className="container col-md-3 mt-5">
              <form className="sign-up-form">
                <i className="bi bi-bus-front"></i>
                <h2 className="h3 mb-3 fw-normal">Help us to make things Easier for You</h2>
                <h2 className="h3 mb-3 fw-normal">Sign Up</h2>
                <div className="form-floating mb-1" id="input-field">
                  <input type="email" className="form-control" id="floatingInput" placeholder="name@example.com" onChange={handleOnChange}  value={userName}/>
                  <label for="floatingInput">Username</label>
                </div>
                <div className="form-floating">
                  <input type="password" className="form-control" id="floatingPassword" placeholder="Password"/>
                  <label for="floatingPassword">Password</label>
                </div>

                <button className="w-100 btn btn-lg btn-primary" id="btn1" type="submit" onClick={handleOnClick}>Sign Up</button>
                <p className="mt-5 mb-3 text-muted">&copy; bus adda</p>
              </form>
            </div> */}
        {/* ----------------------------------panel-------------------------- */}
        <div class="panels-container">
          <div class="panel left-panel">
            <div class="content">
              <h3>
                New on BUS ADDA?
                <FontAwesomeIcon icon={faBusSimple} id="icon" />
              </h3>
              <p>
                Welcome to Online Adda of Bus Reservation...... Book your Ticket
                on a Single Click
              </p>
              <button
                class="btn transparent"
                id="sign-up-btn"
                type="submit"
                onClick={handleOnClickRegister}
              >
                Sign up
              </button>
            </div>
            <img src={Bus} className="image6" alt="" width="100" />
          </div>
          <div class="panel right-panel">
            <div class="content">
              <button
                class="btn transparent"
                id="sign-in-btn"
                onClick={handleOnClick}
              >
                Sign in
              </button>
            </div>
            <img src="img/register.svg" class="image" alt="" />
          </div>
        </div>
        {/* --------------------------------------panel------------------------ */}
      </div>
    </div>
  );
};
export default LoginPage;
