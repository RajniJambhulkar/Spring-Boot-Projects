package com.app.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class AppointmentDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	private String name;
	private String doctor;
	private LocalDate date;
	private LocalDateTime time;
}
