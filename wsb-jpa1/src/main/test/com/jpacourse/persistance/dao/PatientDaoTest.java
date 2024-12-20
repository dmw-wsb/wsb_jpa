package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PatientDaoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PatientDao patientDao;

    @Test
    void testAddVisitToPatient() {
        // Given
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient = entityManager.persistFlushFind(patient);

        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("Jane");
        doctor.setLastName("Smith");
        doctor = entityManager.persistFlushFind(doctor);

        LocalDateTime visitDate = LocalDateTime.now();
        String description = "Routine check-up";

        // When
        patientDao.addVisitToPatient(patient.getId(), doctor.getId(), visitDate, description);

        // Then
        entityManager.flush();  // Ensures all pending changes are applied to the database
        PatientEntity fetchedPatient = patientDao.findById(patient.getId()).orElseThrow();
        assertThat(fetchedPatient.getVisits()).isNotEmpty();
        assertThat(fetchedPatient.getVisits().get(0).getDescription()).isEqualTo(description);
    }
}
