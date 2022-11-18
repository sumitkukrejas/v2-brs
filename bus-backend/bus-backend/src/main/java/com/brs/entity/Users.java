package com.brs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
@Entity
public class Users  {
	@Id
	private int userLoginId;
	
	@NotEmpty(message="userName cannot be empty")
	private String userName;
	
	@NotEmpty
	@Size(min=7,message="minimum size should be atleast 7")
	private String password;
	
	@NotEmpty(message="firstName entered cannot be empty")
	private String firstName;
	
	@NotEmpty(message="lastName entered cannot be empty")
	private String lastName;
	
	@NotNull
	@Pattern(regexp="(0|91)?[7-9][0-9]{9}",message="contact entered is not valid")
	private String contact;
	
	@NotEmpty 
	@Email(message="email entered is not valid")
	private String email;
	
	//to be made as a list
	@OneToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="ReservationID")
//	@Valid
	private Reservation reservation;

	private String roles;


}
