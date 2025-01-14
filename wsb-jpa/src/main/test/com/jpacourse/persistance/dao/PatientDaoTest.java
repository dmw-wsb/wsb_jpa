package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.Gender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldUpdateVisitEntity() {
        // given
        long patientId = 2L;
        long doctorId = 2L;
        LocalDateTime visitTime = LocalDate.parse("2025-01-15").atTime(11, 30, 0);
        String visitDesc = "UpdatedVisitDescription";

        // assert state before update
        final List<VisitEntity> visitsBeforeUpdate = patientDao.getOne(patientId).getVisits();
        int patientVisitsBefore = visitsBeforeUpdate.size();
        assertThat(visitsBeforeUpdate.stream()
                .noneMatch(visit -> visit.getDescription().equals(visitDesc)))
                .isTrue();

        // when
        patientDao.addVisit(patientId, doctorId, visitTime, visitDesc);

        // then
        PatientEntity updatedPatient = patientDao.getOne(patientId);
        assertThat(updatedPatient.getVisits().size()).isEqualTo(patientVisitsBefore + 1);
        assertThat(updatedPatient.getVisits().stream()
                .filter(visit -> visit.getDescription().equals(visitDesc)).count())
                .isEqualTo(1);
    }

    @Transactional
    @Test
    public void testShouldFindPatientsByLastName() {
        // when
        List<PatientEntity> patients = patientDao.findByLastName("Kowalski");

        // then
        assertThat(patients).isNotEmpty();
        assertThat(patients.size()).isEqualTo(1); // Sprawdzamy, że jest jeden pacjent z nazwiskiem "Kowalski"
        assertThat(patients.get(0).getFirstName()).isEqualTo("Adam");
        assertThat(patients.get(0).getEmail()).isEqualTo("adam.kowalski@example.com");
    }





    @Transactional
    @Test
    public void testShouldFindWithMoreVisits() {
        // when
        List<PatientEntity> patients = patientDao.findWithMoreVisits(1);

        // then
        assertThat(patients).isNotEmpty();
        assertThat(patients.size()).isEqualTo(2); // Patients 1 and 2
        assertThat(patients.stream().map(PatientEntity::getId))
                .containsExactlyInAnyOrder(1L, 2L); // IDs of Patients 1 and 2
    }



    @Transactional
    @Test
    public void testShouldFindByGender() {
        // when
        List<PatientEntity> malePatients = patientDao.findByGender(Gender.MALE);
        List<PatientEntity> femalePatients = patientDao.findByGender(Gender.FEMALE);

        // then
        assertThat(malePatients.size()).isEqualTo(2); // Adam and Marek
        assertThat(femalePatients.size()).isEqualTo(1); // Ewa
    }
}
