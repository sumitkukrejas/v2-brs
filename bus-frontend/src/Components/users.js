import React from "react";
import { Component } from "react";
import UserService from "../Services/UserService";
import axios from "axios";

// const users = [
//     {userLoginId:1 , userName:'hardcoder' , password:'passcode' , firstName:'ramesh' , lastName:'kumar' , contact:'9899898788' , email:'abc@gamil.com' , reservation:'res' , roles:'ROLE_USER'},
//     {userLoginId:2 , userName:'goodcoder' , password:'passcode' , firstName:'jay' , lastName:'kumar' , contact:'9899898799' , email:'xyz@gamil.com' , reservation:'reservation' , roles:'ROLE_USER'}
// ]

class DisplayUsers extends Component {
  constructor(props) {
    super(props);
    this.state = {
      users: [],
    };
  }

  componentDidMount() {
    UserService.viewAllUsers().then((Response) => {
      this.setState({ users: Response.data });
    });
  }
  deleteUser = (id) => {
    axios.delete(`http://localhost:9090/deleteUser?userId=${id}`).then(
      (response) => {
        alert("Record Deleted Successfully");
        this.setState({
          users: this.state.users.filter((users) => users.userLogiId !== id),
        });
      },
      (error) => {
        alert("Operation Failed Here");
      }
    );
  };

  render() {
    let tb_data = this.state.users.map((props) => {
      return (
        <tr key={props.id}>
          <td>{props.userLoginId}</td>
          <td>{props.userName}</td>
          <td>{props.password}</td>
          <td>{props.firstName}</td>
          <td>{props.lastName}</td>
          <td>{props.contact}</td>
          <td>{props.email}</td>
          <td>{props.reservation}</td>
          <td>{props.roles}</td>
          <td>
            <button
              id="addbtn"
              className="btn"
              onClick={() => {
                this.deleteUser(props.userLoginId);
              }}
            >
              Delete
            </button>
          </td>
        </tr>
      );
    });

    return (
      <div className="container">
        <table className="table table-striped">
          <thead>
            <tr>
              <th>userLoginId</th>
              <th>userName</th>
              <th>password</th>
              <th>firstName</th>
              <th>lastName</th>
              <th>contact</th>
              <th>email</th>
              <th>reservation</th>
              <th>roles</th>
              <th>Remove</th>
            </tr>
          </thead>
          <tbody>{tb_data}</tbody>
        </table>
      </div>
    );
  }
}
export default DisplayUsers;
