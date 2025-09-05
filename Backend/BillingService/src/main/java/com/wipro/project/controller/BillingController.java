package com.wipro.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.project.dto.BillingDto;
import com.wipro.project.entity.Billing;
import com.wipro.project.exceptions.BillingException;
import com.wipro.project.service.BillingService;

import java.util.List;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

	@Autowired
	private BillingService billingService;

	@PostMapping("/create")
	public ResponseEntity<?> createBill(@RequestBody BillingDto billDto) {
		try {
			Billing bill = billingService.createBill(billDto);
			return ResponseEntity.ok(bill);
		} catch (BillingException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@GetMapping("/patient/{patientId}")
	public ResponseEntity<List<Billing>> getBillsByPatient(@PathVariable Long patientId) {
		List<Billing> bills = billingService.getBillsByPatient(patientId);
		return ResponseEntity.ok(bills);
	}

	@PostMapping("/pay/{billId}")
	public ResponseEntity<?> payBill(@PathVariable Long billId) {
		try {
			Billing bill = billingService.payBill(billId);
			return ResponseEntity.ok(bill);
		} catch (BillingException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}
}
