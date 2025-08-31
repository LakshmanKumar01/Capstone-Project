package com.wipro.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.project.entity.Patient;
import com.wipro.project.service.PatientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;

	// Create a new patient
	@PostMapping("/add/patient")
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}

	// Get all patients
	@GetMapping("/getAllPatients")
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}

	// Get patient by ID
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
		Optional<Patient> patient = patientService.getPatientById(id);
		if (patient.isPresent()) {
			return ResponseEntity.ok(patient.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Update patient by ID
	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
		Optional<Patient> updatedPatient = patientService.updatePatient(id, patientDetails);
		if (updatedPatient.isPresent()) {
			return ResponseEntity.ok(updatedPatient.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Delete patient by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
		boolean isDeleted = patientService.deletePatient(id);
		if (isDeleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
