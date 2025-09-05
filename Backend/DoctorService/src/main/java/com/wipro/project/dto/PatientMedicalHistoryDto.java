package com.wipro.project.dto;

public class PatientMedicalHistoryDto {
	private Long patientId;
	private String diagnosisDetails;
	private String prescriptions;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getDiagnosisDetails() {
		return diagnosisDetails;
	}

	public void setDiagnosisDetails(String diagnosisDetails) {
		this.diagnosisDetails = diagnosisDetails;
	}

	public String getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(String prescriptions) {
		this.prescriptions = prescriptions;
	}

}
