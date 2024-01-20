package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.AppointmentDTO;
import com.app.service.AppointmentService;


@RestController
@RequestMapping("/appointments") 
public class AppointmentController {
	
	
	@Autowired
	private AppointmentService AppointmentService;

	public AppointmentController() {
		System.out.println("in ctor of " + getClass());
	}
	
	@PostMapping
	public ResponseEntity<?> addNewAppointment
	(@RequestBody AppointmentDTO dto) {
		System.out.println("in add appoinment " + dto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(AppointmentService.addAppointmentDetails(dto));
		} catch (RuntimeException e) {
			System.out.println("err " + e);
		
			return ResponseEntity.status
					(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	 
	@GetMapping("/")
	public ResponseEntity<?> getAppointment
	(@RequestBody AppointmentDTO dto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(AppointmentService.getAllAppointments());
		} catch (RuntimeException e) {
			System.out.println("err " + e);
	
			return ResponseEntity.status
					(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAppointmentById
	(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(AppointmentService.getAppointment(id));
		} catch (RuntimeException e) {
			System.out.println("err " + e);
		
			return ResponseEntity.status
					(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAppointmentById
	(@PathVariable Long id) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(AppointmentService.deleteAppointment(id));
		} catch (RuntimeException e) {
			System.out.println("err " + e);
			return ResponseEntity.status
					(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(e.getMessage()));
		}
	}
 
}
