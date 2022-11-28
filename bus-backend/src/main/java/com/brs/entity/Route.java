package com.brs.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
public class Route implements Serializable {
	@Id
	private int routeId;
	
	@NotEmpty
	private String routeFrom;
	
	@NotEmpty
	private String routeTo;
	
	@NotNull
	private int distance;
	
	@OneToMany( cascade = CascadeType.ALL) 
	@JoinColumn(name="routeBusId")
	@Valid
	private List<Bus> buses;

}
