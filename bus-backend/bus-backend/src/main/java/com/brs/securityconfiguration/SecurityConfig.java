//package com.brs.securityconfiguration;
//
//	import com.brs.service.Impl.MyUserDetailsService;
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.context.annotation.Bean;
//	import org.springframework.context.annotation.Configuration;
//	import org.springframework.http.HttpMethod;
//	import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//	import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//	import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//	import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//@Configuration
//	@EnableWebSecurity
//	public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	MyUserDetailsService userDetailsService;
//
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
////		http
////				.authorizeRequests()
////				.antMatchers(HttpMethod.GET, "/bus")
////				.hasRole("ADMIN")
////				.antMatchers(HttpMethod.DELETE, "/bus", "/deleteReservation", "/deleteUser")
////				.hasRole("ADMIN")
////				.antMatchers(HttpMethod.POST, "/bus", "/addReservation")
////				.hasRole("ADMIN")
////				.antMatchers(HttpMethod.PUT, "/bus", "/updateReservation", "/updateUser")
////				.hasRole("ADMIN")
////				.antMatchers(HttpMethod.GET, "/buses", "/viewAllReservation", "/viewReservation")
////				.hasRole("ADMIN")
////				.antMatchers(HttpMethod.GET, "/buses", "/viewFeedback", "/viewAllFeedBack", "/viewReservation", "/viewUser", "/viewAllUsers", "/searchBus")
////				.hasRole("USER")
////				.antMatchers(HttpMethod.GET, "/viewBusByType")
////				.hasRole("ADMIN")
////				.antMatchers(HttpMethod.GET, "/viewBusByType")
////				.hasRole("USER")
////				.antMatchers(HttpMethod.POST, "/addFeedback", "/addReservation", "/addUser")
////				.hasRole("USER")
////				.antMatchers(HttpMethod.PUT, "/updateFeedback", "/updateReservation")
////				.hasRole("USER")
////				.antMatchers(HttpMethod.DELETE, "/deleteReservation")
////				.hasRole("USER")
////				.and().formLogin();
//		http.httpBasic().disable();
////			http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
////					.antMatchers(HttpMethod.GET,"/bus")
////					.hasRole("USER")
////					.antMatchers(HttpMethod.GET,"/bus")
////					.hasRole("USER")
////					.antMatchers(HttpMethod.POST,"/addUser")
////					.hasRole("USER")
////					.and().formLogin();
//
////		}
//	}
//	@Override
//	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
////		auth.inMemoryAuthentication()
////				.withUser("user")
////				.password(passwordEncoder().encode("user"))
////				.roles("USER")
////				.and()
////				.withUser("admin")
////				.password(passwordEncoder().encode("admin"))
////				.roles("ADMIN");
//			auth.userDetailsService(userDetailsService);
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder () {
//		return NoOpPasswordEncoder.getInstance();
//	}
//}
//
