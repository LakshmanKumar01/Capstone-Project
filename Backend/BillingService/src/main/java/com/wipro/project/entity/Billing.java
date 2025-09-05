package com.wipro.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bills")

@Builder
public class Billing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long patientId; // Link to patient

	private Double amount;

	private String status; // e.g., "Pending", "Paid"

	private LocalDateTime billingDate;

	private String details; // Optional description

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDateTime billingDate) {
		this.billingDate = billingDate;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Billing(Long id, Long patientId, Double amount, String status, LocalDateTime billingDate, String details) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.amount = amount;
		this.status = status;
		this.billingDate = billingDate;
		this.details = details;
	}

	public Billing() {
		super();
	}

}
