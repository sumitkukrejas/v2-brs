package com.brs.service.interfaces;

import java.util.List;

import com.brs.entity.Users;
import com.brs.exceptions.BusNotFoundException;
import com.brs.exceptions.UnModifiableException;
import com.brs.exceptions.UserNotFoundException;
import com.brs.exceptions.ReservationNotFoundException;

public interface IUserService {
	
	public Users addUser(Users users);
	public Users updateUser(Users users) throws UserNotFoundException, ReservationNotFoundException, UnModifiableException, BusNotFoundException;
	public List<Users> viewAllUsers();
	public Users deleteUser(int userId) throws UserNotFoundException;
	public Users viewUser(int userId) throws UserNotFoundException;

	public Users getUserByUserName(String userName) throws UserNotFoundException;

	public Users updateUserData(Users users) throws UserNotFoundException, ReservationNotFoundException, UnModifiableException, BusNotFoundException;




}
