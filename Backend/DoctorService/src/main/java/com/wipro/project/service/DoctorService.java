package com.wipro.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.project.dto.PatientDto;
import com.wipro.project.dto.PatientMedicalHistoryDto;
import com.wipro.project.entities.Appointment;
import com.wipro.project.entities.Diagnosis;
import com.wipro.project.entities.Doctor;
import com.wipro.project.entities.Prescription;
import com.wipro.project.repos.AppointmentRepository;
import com.wipro.project.repos.DiagnosisRepository;
import com.wipro.project.repos.DoctorRepository;
import com.wipro.project.repos.PrescriptionRepository;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private DiagnosisRepository diagnosisRepository;
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	// 2
	private final PatientClient patientClient;
	
	public DoctorService(PatientClient patientClient) {
		this.patientClient = patientClient;
	}
	
	public PatientDto fetchpatient(Long patientId) {
		return patientClient.getPatientById(patientId);
	}
	public List<PatientMedicalHistoryDto> fetchpaPatientMedicalHistory(Long patientId){
		return patientClient.getMedicalHistory(patientId);
	}
	
	public Doctor login(String email, String password) {
		Doctor doc = doctorRepository.findByEmail(email);
		if (doc != null && doc.getPassword().equals(password)) {
			return doc;
		}
		throw new RuntimeException("Invalid login");
	}

	public List<Appointment> getAssignedAppointments(Long doctorId) {
		return appointmentRepository.findByDoctorId(doctorId);
	}

	public Diagnosis updateDiagnosis(Long appointmentId, String details) {
		Diagnosis diag = new Diagnosis();
		diag.setAppointment(appointmentRepository.findById(appointmentId).orElseThrow());
		diag.setDetails(details);
		return diagnosisRepository.save(diag);
	}

	public Prescription updatePrescription(Long appointmentId, String medicine, String instructions) {
		Prescription p = new Prescription();
		p.setAppointment(appointmentRepository.findById(appointmentId).orElseThrow());
		p.setMedicine(medicine);
		p.setInstructions(instructions);
		return prescriptionRepository.save(p);
	}

	public List<Diagnosis> getPatientDiagnoses(Long patientId) {
		return diagnosisRepository.findByAppointmentPatientId(patientId);
	}

	public List<Prescription> getPatientPrescriptions(Long patientId) {
		return prescriptionRepository.findByAppointmentPatientId(patientId);
	}
}