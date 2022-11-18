import UserService from "../Services/UserService";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faBusSimple,
  faCoffee,
  faMailBulk,
  faPhone,
  faUser,
  faUserNinja,
  faUserPlus,
  faUserSecret,
} from "@fortawesome/free-solid-svg-icons";
import Bus from "../bus-png3.png";

function Register() {
  // const navigate = useNavigate();
  const [user, setUser] = useState({
    userLoginId: Math.floor(Math.random() * 999),
    userName: "",
    password: "",
    firstName: "",
    lastName: "",
    contact: "",
    email: "",
    reservation: null,
    roles: "ROLE_USER",
  });
  const handleOnChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(user);
    addUser(user);
  };
  const navigate = useNavigate();
  const handleOnClickLogin = (res) => {
    res.preventDefault();
    navigate("/");
  };
  const addUser = (data) => {
    UserService.addUser(data).then(
      (response) => {
        console.log(response);
        alert("REGISTERED - KINDLY LOGIN");
        // navigate("/");
      },
      (error) => {
        console.log(error);
        alert("Operation failed");
      }
    );
  };

  return (
    <div className="page-body">
      <div className="container col-md-8">
        <form className="row g-3 needs-validation" novalidate>
          <h2>Sign Up</h2>
          <div className="input-field">
            <div className="input-group has-validation">
              <span className="input-group-text" id="inputGroupPrepend">
                <FontAwesomeIcon icon={faUserPlus} id="icon" />
              </span>
              <input
                type="text"
                className="form-control"
                id="validationCustom01"
                name="firstName"
                placeholder="First Name"
                value={user.firstName}
                required
                onChange={(e) => handleOnChange(e)}
              />
              <div className="valid-feedback">Looks good!</div>
            </div>
          </div>
          <div className="input-field">
            <div className="input-group has-validation">
              <span className="input-group-text" id="inputGroupPrepend">
                <FontAwesomeIcon icon={faUser} id="icon" />
              </span>
              <input
                type="text"
                className="form-control"
                id="validationCustom02"
                name="lastName"
                placeholder="Last Name"
                value={user.lastName}
                required
                onChange={(e) => handleOnChange(e)}
              />
              {/* <div className="valid-feedback">Looks good!</div> */}
            </div>
          </div>
          <div className="input-field">
            <div className="input-group has-validation">
              <span className="input-group-text" id="inputGroupPrepend">
                <FontAwesomeIcon icon={faUserNinja} id="icon" />
              </span>
              <input
                type="text"
                className="form-control"
                id="validationCustomUsername"
                placeholder="User Name"
                value={user.userName}
                name="userName"
                aria-describedby="inputGroupPrepend"
                required
                onChange={(e) => handleOnChange(e)}
              />
              <div className="invalid-feedback">Please choose a username.</div>
            </div>
          </div>
          <div className="input-field">
            <div className="input-group has-validation">
              <span className="input-group-text" id="inputGroupPrepend">
                <FontAwesomeIcon icon={faMailBulk} id="icon" />
              </span>
              <input
                type="text"
                className="form-control"
                value={user.email}
                name="email"
                id="validationCustom03"
                placeholder="Email ID"
                required
                onChange={(e) => handleOnChange(e)}
              />
              <div className="invalid-feedback">
                Please provide a valid Email.
              </div>
            </div>
          </div>
          <div className="input-field">
            <div className="input-group has-validation">
              <span className="input-group-text" id="inputGroupPrepend">
                <FontAwesomeIcon icon={faUserSecret} id="icon" />
              </span>
              <input
                type="password"
                className="form-control"
                value={user.password}
                name="password"
                id="validationCustom05"
                placeholder="Password"
                required
                onChange={(e) => handleOnChange(e)}
              />
              {/* <div className="invalid-feedback">Please select a valid state.</div> */}
            </div>
          </div>
          <div className="input-field">
            <div className="input-group has-validation">
              <span className="input-group-text" id="inputGroupPrepend">
                <FontAwesomeIcon icon={faPhone} id="icon" />
              </span>
              <input
                type="text"
                name="contact"
                className="form-control"
                id="validationCustom05"
                placeholder="Contact No."
                value={user.contact}
                required
                onChange={(e) => handleOnChange(e)}
              />
              <div className="invalid-feedback">
                Please provide a valid Contact.
              </div>
            </div>
          </div>
          <div className="input-field">
            <div className="form-check">
              <input
                className="form-check-input m"
                type="checkbox"
                value=""
                id="invalidCheck"
                required
                onChange={(e) => handleOnChange(e)}
              />
              <label className="Checkbox" for="invalidCheck">
                Agree to terms and conditions
              </label>
              <div className="invalid-feedback">
                You must agree before submitting.
              </div>
            </div>
          </div>
          <div className="col-12">
            <button
              className="btn btn-primary"
              type="submit"
              id="btn2"
              onClick={handleSubmit}
            >
              Submit form
            </button>
          </div>
        </form>
      </div>

      {/* ----------------------------------panel-------------------------- */}
      <div class="panels-container">
        <div class="panel left-panel">
          <div class="content">
            <h3>One of us ?</h3>
            <p>
              Look like you are already a member of BUS ADDA{" "}
              <FontAwesomeIcon icon={faBusSimple} id="icon" />
              Just Sign in and Enjoy our Services
            </p>
            <button
              class="btn transparent"
              id="sign-in-btn"
              type="submit"
              onClick={handleOnClickLogin}
            >
              Sign In
            </button>
          </div>
          <img src={Bus} className="image6" alt="" width="100" />
        </div>
      </div>
      {/* --------------------------------------panel------------------------ */}
    </div>
  );
}
export default Register;

{
  /* <div className="col-md-2">
          <label for="validationCustom01" className="form-label">
                      Unique Number
          </label>
          <input
                      type="number"
                      className="form-control"
                      id="validationCustom01"
                      value={userLoginId}
                      required
                      onChange={handleOnChange}
                    />
          <div className="valid-feedback">Looks good!</div>
          </div> */
}
