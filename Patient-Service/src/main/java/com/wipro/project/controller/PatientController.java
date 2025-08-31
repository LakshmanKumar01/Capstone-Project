package com.wipro.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	@PostMapping("/register")
	public Patient registerPatient(@RequestBody Patient patient) {
		return patientService.registerPatient(patient);
	}

	@GetMapping
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}

	@GetMapping("/{id}")
	public Optional<Patient> getPatient(@PathVariable Long id) {
		return patientService.getPatientById(id);
	}

	@PutMapping("/{id}")
	public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
		return patientService.updatePatient(id, patient);
	}

	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable Long id) {
		patientService.deletePatient(id);
	}
}