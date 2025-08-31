package com.wipro.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.project.dto.AppointmentDto;
import com.wipro.project.entity.Appointment;
import com.wipro.project.repo.AppointmentRepository;

import java.util.List;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	// Book an appointment
	public Appointment bookAppointment(AppointmentDto dto) {
		Appointment appointment = Appointment.builder().patientId(dto.getPatientId()).doctorId(dto.getDoctorId())
				.appointmentDate(dto.getAppointmentDate()).status("Scheduled").notes(dto.getNotes()).build();
		return appointmentRepository.save(appointment);
	}

	// Get appointments by patient
	public List<Appointment> getAppointmentsByPatient(Long patientId) {
		return appointmentRepository.findByPatientId(patientId);
	}

	// Get appointments by doctor
	public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
		return appointmentRepository.findByDoctorId(doctorId);
	}

}
