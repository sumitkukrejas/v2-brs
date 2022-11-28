package com.brs.service.interfaces;

import java.util.List;

import com.brs.entity.Users;
import com.brs.exceptions.BusNotFoundException;
import com.brs.exceptions.UnModifiableException;
import com.brs.exceptions.UserNotFoundException;
import com.brs.exceptions.ReservationNotFoundException;

public interface IUserService {
	
	Users addUser(Users users);

	Users updateUser(Users users) throws UserNotFoundException, ReservationNotFoundException, UnModifiableException, BusNotFoundException;

	List<Users> viewAllUsers();

	Users deleteUser(String userName) throws UserNotFoundException;

	Users viewUser(String userName) throws UserNotFoundException;

	Users getUserByUserName(String userName) throws UserNotFoundException;

	Users updateUserData(Users users) throws UserNotFoundException, ReservationNotFoundException, UnModifiableException, BusNotFoundException;

}
