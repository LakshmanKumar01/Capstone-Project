package com.wipro.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.project.DoctorServiceApplication;
import com.wipro.project.entities.Appointment;
import com.wipro.project.entities.Diagnosis;
import com.wipro.project.entities.Doctor;
import com.wipro.project.entities.Prescription;
import com.wipro.project.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

	private final DoctorServiceApplication doctorServiceApplication;
	@Autowired
	private DoctorService doctorService;

	DoctorController(DoctorServiceApplication doctorServiceApplication) {
		this.doctorServiceApplication = doctorServiceApplication;
	}

	@PostMapping("/login")
	public Doctor login(@RequestBody LoginRequest req) {
		return doctorService.login(req.getEmail(), req.getPassword());
	}

	@GetMapping("/{doctorId}/appointments")
	public List<Appointment> getAppointments(@PathVariable Long doctorId) {
		return doctorService.getAssignedAppointments(doctorId);
	}

	@PostMapping("/appointments/{appointmentId}/diagnosis")
	public Diagnosis updateDiagnosis(@PathVariable Long appointmentId, @RequestBody DiagnosisRequest req) {
		return doctorService.updateDiagnosis(appointmentId, req.getDetails());
	}

	@PostMapping("/appointments/{appointmentId}/prescription")
	public Prescription updatePrescription(@PathVariable Long appointmentId, @RequestBody PrescriptionRequest req) {
		return doctorService.updatePrescription(appointmentId, req.getMedicine(), req.getInstructions());
	}

	@GetMapping("/patients/{patientId}/diagnoses")
	public List<Diagnosis> getPatientDiagnoses(@PathVariable Long patientId) {
		return doctorService.getPatientDiagnoses(patientId);
	}

	@GetMapping("/patients/{patientId}/prescriptions")
	public List<Prescription> getPatientPrescriptions(@PathVariable Long patientId) {
		return doctorService.getPatientPrescriptions(patientId);
	}
}

class LoginRequest {
	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

class DiagnosisRequest {
	private String details;
	// getters and setters

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}

class PrescriptionRequest {
	private String medicine;
	private String instructions;

	// getters and setters
	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

}
