package com.jpacourse.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String addressLine1;

	@Column(nullable = false)
	private String addressLine2;

	@Column(nullable = false)
	private String postalCode;

	// Jednostronna relacja - adres nie wie, kto pod nim mieszka
	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL, optional = true)
	private DoctorEntity doctorResident;

	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL, optional = true)
	private PatientEntity patientResident;

	// Constructors
	public AddressEntity() {
	}

	public AddressEntity(String city, String addressLine1, String addressLine2, String postalCode) {
		this.city = city;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.postalCode = postalCode;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public DoctorEntity getDoctorResident() {
		return doctorResident;
	}

	public void setDoctorResident(DoctorEntity doctorResident) {
		this.doctorResident = doctorResident;
	}

	public PatientEntity getPatientResident() {
		return patientResident;
	}

	public void setPatientResident(PatientEntity patientResident) {
		this.patientResident = patientResident;
	}

	@Override
	public String toString() {
		return "AddressEntity{" +
				"id=" + id +
				", city='" + city + '\'' +
				", addressLine1='" + addressLine1 + '\'' +
				", addressLine2='" + addressLine2 + '\'' +
				", postalCode='" + postalCode + '\'' +
				'}';
	}
}
