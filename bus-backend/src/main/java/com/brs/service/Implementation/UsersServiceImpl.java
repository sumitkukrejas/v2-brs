package com.brs.service.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.brs.entity.Reservation;
import com.brs.repository.IReservationRepository;
import com.brs.repository.IUsersRepository;
import com.brs.service.interfaces.IUserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brs.entity.Users;
import com.brs.exceptions.UserNotFoundException;

@Service
@Transactional
public class UsersServiceImpl implements IUserService {
	
	@Autowired
	private IUsersRepository usersRepository;

	@Autowired ReservationServiceImpl reservationService;

	@Autowired
	IReservationRepository reservationRepository;

	@Override
	@SneakyThrows
	public Users addUser(Users users) {
		String userName = users.getUsername();
		Optional<Users> user =usersRepository.findById(userName);
		if(!user.isPresent())
		{
			 usersRepository.save(users);
			 return users;
		}
		else
		{
			throw new Exception("USERNAME EXITS ");
		}


		
	}

	@Override
	@SneakyThrows
	public Users updateUser(Users users) {

		String userName = users.getUsername();
		//looking for username provided in the databse table
		Optional<Users> user = usersRepository.findById(userName);
		if(user.isPresent())
		{
			Users userToUpdate = user.get();
			userToUpdate.setContact(users.getContact());
			userToUpdate.setEmail(users.getEmail());
			userToUpdate.setFirstName(users.getFirstName());
			userToUpdate.setLastName(users.getLastName());
			userToUpdate.setPassword(users.getPassword());
			userToUpdate.setUserName(users.getUsername());


			List<Reservation> reservationList =  users.getReservations();
			List<Reservation> updatedReservationList = new ArrayList<>();
			List<Reservation> nonUpdatedReservationList = user.get().getReservations();

			// if reservation already exists we update the reservation

			for(Reservation reservation : reservationList){
				Optional<Reservation> existingReservation = reservationRepository.findById(reservation.getReservationId());

				if(existingReservation.isPresent())
				{
					reservationService.updateReservation(reservation);
					Reservation updatedReservation = reservationRepository.findById(reservation.getReservationId()).get();
					updatedReservationList.add(updatedReservation);
				}
				//if not we add that reservation to the updated reservation list for a user
				else{
					updatedReservationList.add(reservation);
				}
			}

			//if a user choose to delete a reservation he will not pass that reservation in the argument and it will
			//remove that reservation for the reservation list in users object
			//but it won't delete the reservation from the reservation table
			//so here we are checking if all the reservation have a corresponding user
			//if not we delete that reservation
			for(Reservation reservationOld : nonUpdatedReservationList){
				boolean delete = true;
				int reservationOldId = reservationOld.getReservationId();

				for(Reservation reservationNew : updatedReservationList){
					if(reservationOldId == reservationNew.getReservationId()) {
						delete = false;
						break;
					}
				}
				if(delete){
					reservationRepository.deleteById(reservationOldId);
				}

			}

				userToUpdate.setReservations(updatedReservationList);
			return userToUpdate;
		}
		else {
			throw new UserNotFoundException("NO SUCH USER");

		}
		
		
		
	}

	@Override
	public List<Users> viewAllUsers() {
		return usersRepository.findAll();
		
	}

	@Override
	@SneakyThrows
	public Users deleteUser(String userName){
		Optional<Users> user = usersRepository.findById(userName);
		
		if(user.isPresent())
		{
			Users userToDelete = user.get();
			usersRepository.deleteById(userToDelete.getUsername());
			return userToDelete;
		}
		else {
			throw new UserNotFoundException("NO SUCH USER");
		}
		
	}

	@Override
	@SneakyThrows
	public Users viewUser(String userName){
		Optional<Users> user = usersRepository.findById(userName);
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
		Optional<Users> user = usersRepository.findByUserName(userName);
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
		String userName = users.getUsername();
		Optional<Users> user = usersRepository.findById(userName);
		if (user.isPresent()) {
			Users userToUpdate = user.get();

			userToUpdate.setContact(users.getContact());
			userToUpdate.setEmail(users.getEmail());
			userToUpdate.setFirstName(users.getFirstName());
			userToUpdate.setLastName(users.getLastName());
			userToUpdate.setPassword(users.getPassword());
			userToUpdate.setUserName(users.getUsername());



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
