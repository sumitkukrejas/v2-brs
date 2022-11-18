// <<<<<<< HEAD

import { useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import UserContext from "../Context/user/UserContext";
import UserService from "../Services/UserService";
function UpdateUser() {
  const navigate = useNavigate();
  const context = useContext(UserContext);

  const [user, setuser] = useState(context);
  console.log(user.user);

  const [myuser, setmyuser] = useState(user.user);

  // const [newUser, setnewUser] = useState(second);
  const handleOnChange = (e) => {
    setmyuser({ ...myuser, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(myuser.userName);
    updateUser(myuser);
  };
  const updateUser = (data) => {
    UserService.updateUserData(data).then(
      (response) => {
        // console.log(response);
        alert("User Added Successfully");
        const data = response.data;

        // setuser({ user: response.data });
        setuser(data);
        console.log(data);
        console.log(user);
        navigate("/home");
      },
      (error) => {
        console.log(error);
        alert("Operation failed");
      }
    );
  };

  return (
    <div className="col-md-12">
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
          <h1>Update Your Details</h1>
          <label for="validationCustom01" className="form-label">
            First name
          </label>
          <input
            type="text"
            className="form-control"
            id="validationCustom01"
            name="firstName"
            value={user.firstName}
            required
            onChange={(e) => handleOnChange(e)}
          />
          <div className="valid-feedback">Looks good!</div>
        </div>
        <div className="col-md-4">
          <label for="validationCustom02" className="form-label">
            Last name
          </label>
          <input
            type="text"
            className="form-control"
            id="validationCustom02"
            name="lastName"
            value={user.lastName}
            required
            onChange={(e) => handleOnChange(e)}
          />
          {/* <div className="valid-feedback">Looks good!</div> */}
        </div>
        {/* <div className="col-md-4">
          <label for="validationCustomUsername" className="form-label">
            Username
          </label>
          <div className="input-group has-validation">
            <span className="input-group-text" id="inputGroupPrepend"></span>
            <input
              type="text"
              className="form-control"
              id="validationCustomUsername"
              value={user.userName}
              name="userName"
              aria-describedby="inputGroupPrepend"
              required
              onChange={(e) => handleOnChange(e)}
            />
            <div className="invalid-feedback">Please choose a username.</div>
          </div>
        </div> */}
        <div className="col-md-6">
          <label for="validationCustom03" className="form-label">
            E-Mail
          </label>
          <input
            type="text"
            className="form-control"
            value={user.email}
            name="email"
            id="validationCustom03"
            required
            onChange={(e) => handleOnChange(e)}
          />
        </div>
        <div className="col-md-3">
          <label for="validationCustom04" className="form-label">
            Password
          </label>

          <input
            type="password"
            className="form-control"
            value={user.password}
            name="password"
            id="validationCustom05"
            required
            onChange={(e) => handleOnChange(e)}
          />
          {/* <div className="invalid-feedback">Please select a valid state.</div> */}
        </div>
        <div className="col-md-3">
          <label for="validationCustom05" className="form-label">
            Contact
          </label>
          <input
            type="text"
            name="contact"
            className="form-control"
            id="validationCustom05"
            value={user.contact}
            required
            onChange={(e) => handleOnChange(e)}
          />
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
  );
}
export default UpdateUser;
