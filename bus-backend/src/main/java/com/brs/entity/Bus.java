package com.brs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})

public class Bus implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busId;

	private String busName;


	private String busType;
	

	private String routeFrom;
	
//	@NotEmpty
	private String routeTo;

//	@NotNull
//@JsonFormat(pattern="dd/MM/yyyy")
//	private LocalDate date;


//	@NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate arrivalDate;

	@JsonFormat(pattern = "HH:mm")
	private LocalTime arrivalTime;
	
//	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate departureDate;

	@JsonFormat(pattern = "HH:mm")
	private LocalTime departureTime;


	//	@NotNull
	private int seats;


//	@NotNull
	private int availableSeats;
}
