package com.brs.controllers;

import java.util.List;

import javax.validation.Valid;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.brs.entity.Users;
import com.brs.service.interfaces.IUserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UsersController {
	@Autowired
	private IUserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/addUser") @SneakyThrows
	public Users addUsers(@Valid @RequestBody Users users)
	{
		users.setPassword(passwordEncoder.encode(users.getPassword()));

		return userService.addUser(users);
	}

	@GetMapping("/viewUser") @SneakyThrows
	public Users viewUsers(@RequestParam String userName)
	{
		return userService.viewUser(userName);
	}
	
	@GetMapping("/viewAllUsers")
	public List<Users> viewAllUsers()
	{
		return userService.viewAllUsers();
	}

	@DeleteMapping("/deleteUser") @SneakyThrows
	public Users deleteUser(@RequestParam String userName)
	{
		return userService.deleteUser(userName);
	}
	
	@PutMapping("/updateUser") @SneakyThrows
	public Users updateUser(@Valid @RequestBody Users user) {
		return userService.updateUser(user);
	}

	@GetMapping("/getUserByUserName") @SneakyThrows
	public Users getUserByUserName(@RequestParam String userName){return userService.getUserByUserName(userName);}

	@PutMapping("/updateUserData") @SneakyThrows
	public Users updateUserData(@Valid @RequestBody Users user) {
		return userService.updateUserData(user);
	}
}
