package com.wipro.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.project.PatientRepository;
import com.wipro.project.entity.Patient;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl {

	@Autowired
	private PatientRepository patientRepository;

	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public Optional<Patient> getPatientById(Long id) {
		return patientRepository.findById(id);
	}

	public Optional<Patient> updatePatient(Long id, Patient patientDetails) {
		return patientRepository.findById(id).map(patient -> {
			patient.setName(patientDetails.getName());
			patient.setEmail(patientDetails.getEmail());
			patient.setContactInfo(patientDetails.getContactInfo());
			return patientRepository.save(patient);
		});
	}

	public boolean deletePatient(Long id) {
		return patientRepository.findById(id).map(patient -> {
			patientRepository.delete(patient);
			return true;
		}).orElse(false);
	}
}