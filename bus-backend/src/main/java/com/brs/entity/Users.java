package com.brs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
@Entity
public class Users implements UserDetails {

	@Id
//	@NotEmpty(message="userName cannot be empty")
	private String userName;
	
//	@NotEmpty
//	@Size(min=7,message="minimum size should be atleast 7")
	private String password;
	
//	@NotEmpty(message="firstName entered cannot be empty")
	private String firstName;
	
//	@NotEmpty(message="lastName entered cannot be empty")
	private String lastName;
	
//	@NotNull
//	@Pattern(regexp="(0|91)?[7-9][0-9]{9}",message="contact entered is not valid")
	private String contact;
	
//	@NotEmpty
//	@Email(message="email entered is not valid")
	private String email;

	private String roles;

	//to be made as a list
//	@Valid
	@OneToMany( cascade = CascadeType.ALL)
	private List<Reservation> reservations;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(this.roles.split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
