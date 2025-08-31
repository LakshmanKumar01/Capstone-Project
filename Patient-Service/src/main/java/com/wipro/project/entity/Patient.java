package com.wipro.project.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private Long contactInfo;
	private String email;

	public Patient(Long id, String name, String address, Long contactInfo, String email) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contactInfo = contactInfo;

		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(Long contactInfo) {
		this.contactInfo = contactInfo;
	}

}
