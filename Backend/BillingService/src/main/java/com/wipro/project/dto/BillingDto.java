package com.wipro.project.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BillingDto {
	private Long patientId;
	private Double amount;
	private LocalDateTime billingDate;
	private String details;
}
