package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // used in the Java Persistence API (JPA) to mark a class as a persistent entity.
@Table(name="products")
//All below annotations are Lombok
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "mfgDate", callSuper = true)
public class Product extends BaseEntity {
	
	@Column(length = 15)
	private String name;
	
	@Column(length = 15)
	private String productCode;	
	
	@Column(length = 15)
	private String category;
	private LocalDate mfgDate;

}
