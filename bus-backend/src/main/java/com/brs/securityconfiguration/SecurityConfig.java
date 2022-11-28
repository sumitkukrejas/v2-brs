package com.brs.securityconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
				.antMatchers(HttpMethod.GET, "/bus")
				.hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/bus", "/deleteReservation", "/deleteUser")
				.hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/bus", "/addReservation")
				.hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/bus", "/updateReservation", "/updateUser")
				.hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/buses", "/viewAllReservation", "/viewReservation")
				.hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/buses", "/viewFeedback", "/viewAllFeedBack", "/viewReservation", "/viewUser", "/viewAllUsers", "/searchBus")
				.hasRole("USER")
				.antMatchers(HttpMethod.GET, "/viewBusByType")
				.hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/viewBusByType")
				.hasRole("USER")
				.antMatchers(HttpMethod.POST, "/addFeedback", "/addReservation")
				.hasRole("USER")
				.antMatchers(HttpMethod.PUT, "/updateFeedback", "/updateReservation")
				.hasRole("USER")
				.antMatchers(HttpMethod.DELETE, "/deleteReservation")
				.hasRole("USER")
                .antMatchers("/token", "/addUser").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(jwtAuthenticationFilter , UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
    }

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}