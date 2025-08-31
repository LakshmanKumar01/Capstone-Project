package com.wipro.project.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.project.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	List<Appointment> findByDoctorId(Long doctorId);
}
