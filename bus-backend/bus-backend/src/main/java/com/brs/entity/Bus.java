package com.brs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
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
	private int busId;
	
//	@NotEmpty
	private String busName;
	
//	@NotEmpty
//	private String driverName;
	
//	@NotEmpty
	private String busType;
	
//	@NotEmpty
	private String routeFrom;
	
//	@NotEmpty
	private String routeTo;

//	@NotNull
@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;

//	@NotNull
	private LocalTime arrivalTime;
	
//	@NotNull
	private LocalTime departureTime;
	
//	@NotNull
	private int seats;
	
//	@NotNull
	private int avaiableSeats;


	

}
