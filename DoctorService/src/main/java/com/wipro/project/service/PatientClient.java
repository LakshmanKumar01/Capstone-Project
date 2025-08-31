package com.wipro.project.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.project.dto.PatientDto;
import com.wipro.project.dto.PatientMedicalHistoryDto;

@FeignClient(name = "PATIENT-SERVICE",url="${patient.service.url}")
public interface PatientClient {
	
	@GetMapping("/api/patients/{id}")
	PatientDto getPatientById(@PathVariable("id") Long id);
	
	@GetMapping("/api/patients/{id}/medical-history")
	List<PatientMedicalHistoryDto> getMedicalHistory(@PathVariable("id") Long id);
}
