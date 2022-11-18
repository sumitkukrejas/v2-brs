import axios from "axios";

const USER_BASE_URL = "http://localhost:9090";

class UserService {
  viewAllUsers = () => {
    return axios.get(USER_BASE_URL + "/" + "viewAllUsers");
  };

  getUserByUserName = (userName) => {
    return axios.get(
      USER_BASE_URL + "/" + "getUserByUserName?userName=" + userName
    );
  };

  addUser = (data) => {
    return axios.post(USER_BASE_URL + "/" + "addUser", data);
  };

  updateUser = (data) => {
    return axios.put(USER_BASE_URL + "/" + "updateUser", data);
  };
  updateUserData = (data) => {
    return axios.put(USER_BASE_URL + "/" + "updateUserData", data);
  };
}
export default new UserService();
