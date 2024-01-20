package com.app.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass // to tell hibernate following class is a
//common super class for all other entities n DO NOT generate any tables for it .
@Getter // Lombok getter
@Setter // lombo
@ToString // lombok toString
public class BaseEntity {
	@Id // primary key of entity
	@GeneratedValue(strategy = GenerationType.IDENTITY) // provides for specification of generation strategies for
														// primary key
	@Column(name = "id") // customizes col name
	private Long id;
}
