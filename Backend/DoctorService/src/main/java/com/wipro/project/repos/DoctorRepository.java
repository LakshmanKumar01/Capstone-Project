package com.wipro.project.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.project.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	Doctor findByEmail(String email);
}
