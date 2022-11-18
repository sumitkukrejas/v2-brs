//package com.brs.service.Impl;
//
//import com.brs.entity.MyUserDetails;
//import com.brs.entity.Users;
//import com.brs.entity.Users1;
//import com.brs.repository.IUsersRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//
//
//	@Autowired
//	private IUsersRepository usersRepository;
//
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<Users1> users1= usersRepository.findByUserName(username);
//
//		users1.orElseThrow(()->new UsernameNotFoundException("user not found "+username));
//
//		return users1.map(MyUserDetails::new).get();
//		};
//	}
//
