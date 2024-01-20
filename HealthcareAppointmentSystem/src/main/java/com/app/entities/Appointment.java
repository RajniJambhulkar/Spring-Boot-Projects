package com.app.entities;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table(name="appointments_table")

//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Appointment extends BaseEntity {
	

	@Column(length = 15)
	private String name;
	
	@Column(length = 15)
	private String doctor;	
	
	@Column(length = 15)
	private LocalDate date;
	
	@Column(nullable = false)
	private LocalDateTime time;

	public Appointment() {
		super();
		this.time = LocalDateTime.now();
	}
}
