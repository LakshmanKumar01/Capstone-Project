package com.wipro.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.project.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
