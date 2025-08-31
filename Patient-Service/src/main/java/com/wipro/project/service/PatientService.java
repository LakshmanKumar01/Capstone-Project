package com.wipro.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wipro.project.entity.Patient;

@Service
public interface PatientService {

	Patient registerPatient(Patient patient);

	List<Patient> getAllPatients();

	Optional<Patient> getPatientById(Long id);

	Patient updatePatient(Long id, Patient patient);

	void deletePatient(Long id);

}
