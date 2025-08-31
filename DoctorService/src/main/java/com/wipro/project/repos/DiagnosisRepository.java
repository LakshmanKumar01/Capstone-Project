package com.wipro.project.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.project.entities.Diagnosis;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
	List<Diagnosis> findByAppointmentPatientId(Long patientId);
}
