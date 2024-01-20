package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.ApiResponse;
import com.app.dto.AppointmentDTO;
import com.app.entities.Appointment;

public interface AppointmentService {
	AppointmentDTO addAppointmentDetails(AppointmentDTO Appointment);
	List<AppointmentDTO> getAllAppointments();
	Optional<Appointment> getAppointment(Long id);
	Optional<Appointment> deleteAppointment(Long id);

	
	

}
