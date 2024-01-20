package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AppointmentDao;
import com.app.dto.ApiResponse;
import com.app.dto.AppointmentDTO;
import com.app.entities.Appointment;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDao appointmentDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public AppointmentDTO addAppointmentDetails(AppointmentDTO dto) {
		Appointment Appointment = mapper.map(dto, Appointment.class);
	
		return mapper.map
				(appointmentDao.save(Appointment), AppointmentDTO.class);
	}

	@Override
	public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> Appointments = appointmentDao.findAll();

        return Appointments.stream()
                .map(Appointment -> mapper.map(Appointment, AppointmentDTO.class)).collect(Collectors.toList());

	}

	@Override
	public Optional<Appointment> getAppointment(Long id) {
	   Optional<Appointment> ref = appointmentDao.findById(id);
		return ref;
	}

	@Override
	public Optional<Appointment> deleteAppointment(Long id) {
		Optional<Appointment> ref = appointmentDao.findById(id);
		if(ref.isPresent())
		{
			appointmentDao.deleteById(id);
		}
		return ref;
	}

//	@Override
//	public ApiResponse updateAppointment(Long id,String name) {
//		Optional<Appointment> ref = appointmentDao.findById(id);
//		if(ref.isPresent())
//		{
//		Appointment data=ref.get();
//         data.setName(name);
//         ApiResponse res=new ApiResponse();
//         res.setMessage("name updated successfully");
//         return res;
//		
//		}
//		else {
//			
//			return null;
//		}
//	}

}
