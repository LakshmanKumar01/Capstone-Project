package com.wipro.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.project.entity.Patient;
import com.wipro.project.repo.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientRepository patientRepository;

	public Patient registerPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	public Optional<Patient> getPatientById(Long id) {
		return patientRepository.findById(id);
	}

	public Patient updatePatient(Long id, Patient updatedPatient) {
		Optional<Patient> patientOpt = patientRepository.findById(id);
		if (patientOpt.isPresent()) {
			Patient patient = patientOpt.get();
			patient.setName(updatedPatient.getName());
			patient.setEmail(updatedPatient.getEmail());
			patient.setContactInfo(updatedPatient.getContactInfo());
			patient.setAddress(updatedPatient.getAddress());
			return patientRepository.save(patient);
		} else {
			throw new RuntimeException("Patient not found");
		}
	}

	public void deletePatient(Long id) {
		patientRepository.deleteById(id);
	}
}