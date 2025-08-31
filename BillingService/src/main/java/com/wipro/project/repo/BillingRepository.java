package com.wipro.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.project.entity.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long> {
	List<Billing> findByPatientId(Long patientId);
}
