package com.brs.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.brs.entity.Reservation;
import com.brs.service.interfaces.IUserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brs.dao.UsersDao;
import com.brs.entity.Users;
import com.brs.exceptions.UserNotFoundException;

@Service
@Transactional
public class UsersServiceImpl implements IUserService {
	
	@Autowired
	private UsersDao usersDao;

	@Autowired ReservationServiceImpl reservationService;

	@Override
	@SneakyThrows
	public Users addUser(Users users) {
		int id = users.getUserLoginId();
		Optional<Users> user =usersDao.findById(id);
		if(!user.isPresent())
		{
			 usersDao.save(users);
			 return users;
		}
		else
		{
			throw new Exception("USER ID EXITS ");
		}


		
	}

	@Override
	@SneakyThrows
	public Users updateUser(Users users) {
		int userId = users.getUserLoginId();
		Optional<Users> user = usersDao.findById(userId);
		if(user.isPresent())
		{
			Users userToUpdate = user.get();
			
			userToUpdate.setContact(users.getContact());
			userToUpdate.setEmail(users.getEmail());
			userToUpdate.setFirstName(users.getFirstName());
			userToUpdate.setLastName(users.getLastName());
			userToUpdate.setPassword(users.getPassword());
			userToUpdate.setUserName(users.getUserName());
			userToUpdate.setReservation(users.getReservation());


//			if( users.getReservation().getReservationId()==userToUpdate.getReservation().getReservationId())
//			{
//				Reservation r = reservationService.updateReservation(users.getReservation());
//				userToUpdate.setReservation(r);
//			}
//			else
////
//
//			{
//				userToUpdate.setReservation(users.getReservation());
//			}

			return userToUpdate;
		}
		else {
			throw new UserNotFoundException("NO SUCH USER");

		}
		
		
		
	}

	@Override
	public List<Users> viewAllUsers() {
		return usersDao.findAll();
		
	}

	@Override
	@SneakyThrows
	public Users deleteUser(int userId){
		Optional<Users> user = usersDao.findById(userId);
		
		if(user.isPresent())
		{
			Users userToDelete = user.get();
			usersDao.deleteById(userToDelete.getUserLoginId());
			return userToDelete;
		}
		else {
			throw new UserNotFoundException("NO SUCH USER");
		}
		
	}

	@Override
	@SneakyThrows
	public Users viewUser(int userId){
		Optional<Users> user = usersDao.findById(userId);
		if(user.isPresent())
		{
			System.out.println("user found");
			return user.get();
		}
		else {
			throw new UserNotFoundException("NO SUCH USER");
		}
	}

	@Override
	public Users getUserByUserName(String userName) throws UserNotFoundException {
		Optional<Users> user = usersDao.findByUserName(userName);
		if(user.isPresent())
		{
			System.out.println("user found");
			return user.get();
		}
		else {
			throw new UserNotFoundException("NO SUCH USER");
		}
	}


	@SneakyThrows
	public Users updateUserData(Users users) {
		int userId = users.getUserLoginId();
		Optional<Users> user = usersDao.findById(userId);
		if (user.isPresent()) {
			Users userToUpdate = user.get();

			userToUpdate.setContact(users.getContact());
			userToUpdate.setEmail(users.getEmail());
			userToUpdate.setFirstName(users.getFirstName());
			userToUpdate.setLastName(users.getLastName());
			userToUpdate.setPassword(users.getPassword());
			userToUpdate.setUserName(users.getUserName());



//			if( users.getReservation().getReservationId()==userToUpdate.getReservation().getReservationId())
//			{
//				Reservation r = reservationService.updateReservation(users.getReservation());
//				userToUpdate.setReservation(r);
//			}
//			else
////
//
//			{
//				userToUpdate.setReservation(users.getReservation());
//			}

			return userToUpdate;
		} else {
			throw new UserNotFoundException("NO SUCH USER");

		}
	}


}
