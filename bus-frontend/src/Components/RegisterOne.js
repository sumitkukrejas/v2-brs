import UserService from "../Services/UserService";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
function Register() {
  const navigate = useNavigate();
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
  const addUser = (data) => {
    UserService.addUser(data).then(
      (response) => {
        console.log(response);
        alert("User Added Successfully");
        navigate("/home");
      },
      (error) => {
        console.log(error);
        alert("Operation failed");
      }
    );
  };

  return (
    <>
      <div className=" col-md-12">
        <h1>Register </h1>
        <form className="row g-3 needs-validation" novalidate>
          {/* <div className="col-md-2">
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
</div> */}
          <div className="col-md-4">
            {/* <label for="validationCustom01" className="form-label">
            First name
          </label> */}
            <input
              type="text"
              className="form-control"
              placeholder="First Name"
              id="validationCustom01"
              name="firstName"
              value={user.firstName}
              required
              onChange={(e) => handleOnChange(e)}
            />
            <div className="valid-feedback">Looks good!</div>
          </div>
          <div className="col-md-4">
            {/* <label for="validationCustom02" className="form-label">
            Last name
          </label> */}
            <input
              type="text"
              className="form-control"
              placeholder="Last Name"
              id="validationCustom02"
              name="lastName"
              value={user.lastName}
              required
              onChange={(e) => handleOnChange(e)}
            />
            {/* <div className="valid-feedback">Looks good!</div> */}
          </div>
          <div className="col-md-4">
            {/* <label for="validationCustomUsername" className="form-label">
            Username
          </label> */}
            <div className="input-group has-validation">
              <span className="input-group-text" id="inputGroupPrepend"></span>
              <input
                type="text"
                className="form-control"
                placeholder="User Name"
                id="validationCustomUsername"
                value={user.userName}
                name="userName"
                aria-describedby="inputGroupPrepend"
                required
                onChange={(e) => handleOnChange(e)}
              />
              <div className="invalid-feedback">Please choose a username.</div>
            </div>
          </div>
          <div className="col-md-6">
            {/* <label for="validationCustom03" className="form-label">
            E-Mail
          </label> */}
            <input
              type="text"
              className="form-control"
              placeholder="E-mail"
              value={user.email}
              name="email"
              id="validationCustom03"
              required
              onChange={(e) => handleOnChange(e)}
            />
            <div className="invalid-feedback">
              Please provide a valid Email.
            </div>
          </div>
          <div className="col-md-3">
            {/* <label for="validationCustom04" className="form-label">
            Password
          </label> */}

            <input
              type="password"
              className="form-control"
              placeholder="Password"
              value={user.password}
              name="password"
              id="validationCustom05"
              required
              onChange={(e) => handleOnChange(e)}
            />
            {/* <div className="invalid-feedback">Please select a valid state.</div> */}
          </div>
          <div className="col-md-3">
            {/* <label for="validationCustom05" className="form-label">
            Contact
          </label> */}
            <input
              type="text"
              name="contact"
              placeholder="Contact"
              className="form-control"
              id="validationCustom05"
              value={user.contact}
              required
              onChange={(e) => handleOnChange(e)}
            />
            <div className="invalid-feedback">
              Please provide a valid Contact.
            </div>
          </div>
          <div className="col-5">
            <div className="form-check">
              <input
                className="form-check-input m"
                type="checkbox"
                value=""
                id="invalidCheck"
                required
                onChange={(e) => handleOnChange(e)}
              />
              <label className="form-check-label" for="invalidCheck">
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
              onClick={handleSubmit}
            >
              Submit form
            </button>
          </div>
        </form>
      </div>
    </>
  );
}
export default Register;
