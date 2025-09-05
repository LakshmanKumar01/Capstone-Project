package com.wipro.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.project.dto.AppointmentDto;
import com.wipro.project.entity.Appointment;
import com.wipro.project.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@PostMapping("/book")
	public ResponseEntity<Appointment> bookAppointment(@RequestBody AppointmentDto appointmentDto) {
		Appointment appointment = appointmentService.bookAppointment(appointmentDto);
		return ResponseEntity.ok(appointment);
	}

	@GetMapping("/patient/{patientId}")
	public ResponseEntity<List<Appointment>> getPatientAppointments(@PathVariable Long patientId) {
		List<Appointment> appointments = appointmentService.getAppointmentsByPatient(patientId);
		return ResponseEntity.ok(appointments);
	}

	@GetMapping("/doctor/{doctorId}")
	public ResponseEntity<List<Appointment>> getDoctorAppointments(@PathVariable Long doctorId) {
		List<Appointment> appointments = appointmentService.getAppointmentsByDoctor(doctorId);
		return ResponseEntity.ok(appointments);
	}
}
