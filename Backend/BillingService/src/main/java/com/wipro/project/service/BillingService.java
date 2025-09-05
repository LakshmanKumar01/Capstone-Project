package com.wipro.project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.project.dto.BillingDto;
import com.wipro.project.entity.Billing;
import com.wipro.project.exceptions.BillingException;
import com.wipro.project.repo.BillingRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class BillingService {

	@Autowired
	private BillingRepository billRepository;

	@Autowired
	private RestTemplate restTemplate;

	private static final String PATIENT_SERVICE_URL = "http://localhost:8080/api/patients/";

	// Create and save a bill after verifying patient exists via communication with
	// Patient Service
	public Billing createBill(BillingDto billDto) {
		// Verify patient exists in Patient Service
		try {
			restTemplate.getForObject(PATIENT_SERVICE_URL + billDto.getPatientId(), Object.class);
		} catch (Exception e) {
			log.error("Patient not found with ID: {}", billDto.getPatientId());
			throw new BillingException("Patient not found with id: " + billDto.getPatientId());
		}

		Billing bill = Billing.builder().patientId(billDto.getPatientId()).amount(billDto.getAmount())
				.billingDate(billDto.getBillingDate() == null ? LocalDateTime.now() : billDto.getBillingDate())
				.status("Pending").details(billDto.getDetails()).build();

		return billRepository.save(bill);
	}

	public List<Billing> getBillsByPatient(Long patientId) {
		return billRepository.findByPatientId(patientId);
	}

	public Billing payBill(Long billId) {
		Billing bill = billRepository.findById(billId)
				.orElseThrow(() -> new BillingException("Bill not found with id: " + billId));
		if ("Paid".equalsIgnoreCase(bill.getStatus())) {
			throw new BillingException("Bill is already paid");
		}
		bill.setStatus("Paid");
		return billRepository.save(bill);

	}
}

@Configuration
class AppConfig {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}