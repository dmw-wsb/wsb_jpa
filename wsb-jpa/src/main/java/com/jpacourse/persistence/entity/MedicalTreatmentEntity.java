package com.jpacourse.persistence.entity;

import com.jpacourse.persistence.enums.TreatmentType;

import javax.persistence.*;

@Entity
@Table(name = "MEDICAL_TREATMENT")
public class MedicalTreatmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 255)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 50)
	private TreatmentType type;

	// Bidirectional relationship: the treatment knows which visit it belongs to
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VISIT_ID", nullable = false)
	private VisitEntity visit;

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
