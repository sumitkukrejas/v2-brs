package com.brs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Builder
@Data
@NoArgsConstructor 
@AllArgsConstructor
public class Reservation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationId;

	private String passenger;

	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate reservationDate;

	@JsonFormat(pattern = "HH:mm")
	private LocalTime reservationTime;

	private String source;

	private String destination;

	@OneToOne
//			(cascade = CascadeType.ALL)
	@NotNull
	private Bus bus;
}


// TODO: while adding reservation with only bus Id fix the return
