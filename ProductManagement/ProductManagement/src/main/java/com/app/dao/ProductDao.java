package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Product;

public interface ProductDao extends JpaRepository<Product, Long> {
//for adding student details : use inherited api : save
	
}

//Your StudentDao interface extends the JpaRepository interface for the Student entity 
//with a primary key of type Long. 
//This means that your interface inherits a set of basic CRUD (Create, Read, Update, Delete) operations from the JpaRepository.