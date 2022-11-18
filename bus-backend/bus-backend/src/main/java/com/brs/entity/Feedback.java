package com.brs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder 

public class Feedback implements Serializable {
	@Id
	private int feedBackId;
	
	@NotNull
	private int driverRating;
 	
	@NotNull
	private int serviceRating;
	
	@NotNull
	private int overallRating;
	
	@NotEmpty
	private String comments;
	
	@NotNull
	private LocalDate feedbackdate;
	
	@OneToOne(targetEntity = Users.class , cascade = CascadeType.ALL)
	@Valid
	private Users users;
	
	
	@OneToOne(targetEntity = Bus.class , cascade = CascadeType.ALL)
	@Valid
	private Bus bus;
}
