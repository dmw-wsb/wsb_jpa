package com.jpacourse.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id", nullable = false) // Klucz obcy w tabeli VISIT
	private PatientEntity patient;
	// One-sided relationship from the child side (child owns the relationship).

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id", nullable = false) // Klucz obcy w tabeli VISIT
	private DoctorEntity doctor;
	// One-sided relationship from the child side (child owns the relationship).

}
