package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    /**
     * Test do zadania: Dodawanie wizyty do pacjenta (kaskadowy update).
     */
    @Transactional
    @Test
    public void testShouldUpdateVisitEntity() {
        // given
        long patientId = 1L;
        long doctorId = 1L;
        LocalDateTime visitTime = LocalDate.parse("2024-12-30").atTime(10, 15, 25);
        String visitDesc = "FakeVisitDescription";

        // assert state before update
        PatientEntity patientBeforeUpdate = patientDao.findOne(patientId);
        List<VisitEntity> visitsBeforeUpdate = patientBeforeUpdate.getVisits();
        int patientVisitsBefore = visitsBeforeUpdate.size();
        assertThat(visitsBeforeUpdate.stream()
                .noneMatch(visit -> visit.getDescription().equals(visitDesc)))
                .isTrue();

        // when
        patientDao.addVisit(patientId, doctorId, visitTime, visitDesc);

        // then
        PatientEntity updatedPatient = patientDao.findOne(patientId);
        assertThat(updatedPatient.getVisits().size()).isEqualTo(patientVisitsBefore + 1);
        assertThat(updatedPatient.getVisits().stream()
                .filter(visit -> visit.getDescription().equals(visitDesc)).count())
                .isEqualTo(1);
    }

    /**
     * Test do zadania: Znajdź pacjentów po dodanym polu (data urodzenia).
     */
    @Test
    public void testFindByDateOfBirthBefore() {
        List<PatientEntity> patients = patientDao.findByDateOfBirthBefore(LocalDate.of(1990, 1, 1));
        assertFalse(patients.isEmpty());
        for (PatientEntity patient : patients) {
            assertTrue(patient.getDateOfBirth().isBefore(LocalDate.of(1990, 1, 1)));
        }
    }

    /**
     * Test do zadania: Równoległa modyfikacja encji (OptimisticLock).
     */
    @Test
    @Transactional
    public void testOptimisticLock() {
        PatientEntity patient = patientDao.findOne(1L);
        patient.setLastName("Nowakowski");

        // Simulate parallel transaction
        PatientEntity samePatient = patientDao.findOne(1L);
        samePatient.setLastName("Kowalski");
        patientDao.update(samePatient);

        // Try to save the modified patient
        assertThrows(OptimisticLockException.class, () -> {
            patientDao.update(patient);
        });
    }
}
