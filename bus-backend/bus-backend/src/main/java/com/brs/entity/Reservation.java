package com.brs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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


	private int reservationId;
	

	private String reservationStatus;
	

	private String reservationType;

	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate reservationDate;
	

	private LocalTime reservationTime;
	

	private String source;
	

	private String destination;


	private int busId;
}
