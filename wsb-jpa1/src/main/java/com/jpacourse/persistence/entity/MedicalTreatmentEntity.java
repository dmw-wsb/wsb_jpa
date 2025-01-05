package com.jpacourse.persistence.entity;

import com.jpacourse.persistence.enums.TreatmentType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MEDICAL_TREATMENT")
public class MedicalTreatmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Description cannot be blank")
	@Column(nullable = false)
	private String description;

	@NotNull(message = "Treatment type cannot be null")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TreatmentType type;

	// Relacja dwustronna
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "visit_id", nullable = false)
	private VisitEntity visit;

	// Constructors
	public MedicalTreatmentEntity() {
	}

	public MedicalTreatmentEntity(String description, TreatmentType type, VisitEntity visit) {
		this.description = description;
		this.type = type;
		this.visit = visit;
	}

	// Getters and Setters
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

	public TreatmentType getType() {
		return type;
	}

	public void setType(TreatmentType type) {
		this.type = type;
	}

	public VisitEntity getVisit() {
		return visit;
	}

	public void setVisit(VisitEntity visit) {
		this.visit = visit;
	}

	@Override
	public String toString() {
		return "MedicalTreatmentEntity{" +
				"id=" + id +
				", description='" + description + '\'' +
				", type=" + type +
				'}';
	}
}
