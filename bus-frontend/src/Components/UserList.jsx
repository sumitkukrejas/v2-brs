import React, { Component } from "react";
import axios from "axios";
import "../CssStyles/Styles.css";
import { Button } from "@mui/material";
import UserService from "../Services/UserService";

class UserList extends Component {
  // Step 1:
  constructor(props) {
    super(props);
    this.state = {
      userList: [],
    };
  }
  //Step 2:
  componentDidMount() {
    UserService.viewAllUsers().then((Response) => {
      this.setState({ userList: Response.data });
    });
  }
  deleteUser = (id) => {
    axios.delete(`http://localhost:9090/deleteUser?userId=${id}`).then(
      (response) => {
        alert("Record Deleted Successfully");
        this.setState({
          userList: this.state.userList.filter(
            (user) => user.userLoginId !== id
          ),
        });
      },
      (error) => {
        alert("Operation Failed Here");
      }
    );
  };
  render() {
    return (
      <div>
        <table className="table table-dark table-hover center table-striped-columns table-bordered">
          <thead>
            <tr>
              <th scope="col sno">#</th>
              <th>USER ID</th>
              <th>FIRST NAME</th>
              <th>LAST NAME</th>
              <th>USERNAME</th>
              <th>E-MAIL</th>
              <th>PASSWORD</th>
              <th>CONTACT</th>
              <th>ROLE</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
            {this.state.userList.length === 0
              ? "No Record "
              : this.state.userList.map((user, index) => (
                  <tr key={user.userLoginId}>
                    <th scope="row">{index + 1}</th>
                    <td>{user.userLoginId}</td>
                    <td>{user.firstName} </td>
                    <td>{user.lastName}</td>
                    <td>{user.userName}</td>
                    <td>{user.email}</td>
                    <td>{user.password}</td>
                    <td>{user.contact}</td>
                    <td>{user.roles}</td>
                    <td>
                      <Button
                        onClick={() => {
                          this.deleteUser(user.userLoginId);
                        }}
                      >
                        Delete
                      </Button>
                    </td>
                  </tr>
                ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default UserList;
