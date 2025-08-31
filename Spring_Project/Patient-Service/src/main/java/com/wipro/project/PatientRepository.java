package com.wipro.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.project.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
