package com.wipro.project.service;

import java.util.List;
import java.util.Optional;

import com.wipro.project.entity.Patient;

public interface PatientService {

	Patient addPatient(Patient patient);

	List<Patient> getAllPatients();

	Optional<Patient> getPatientById(Long id);

	Optional<Patient> updatePatient(Long id, Patient patientDetails);

	boolean deletePatient(Long id);

}
