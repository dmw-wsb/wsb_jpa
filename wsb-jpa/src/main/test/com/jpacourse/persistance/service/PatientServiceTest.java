package com.jpacourse.persistance.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.dao.AddressDao;
import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.Gender;
import com.jpacourse.service.PatientService;
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
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private VisitDao visitDao;

    @Test
    @Transactional
    public void testShouldFindPatientByIdOrReturnNull() {
        // given
        PatientTO patientTO = patientService.findById(2L);
        PatientTO shouldBeNull = patientService.findById(-99L);

        // then
        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getId()).isEqualTo(2L);
        assertThat(patientTO.getFirstName()).isEqualTo("Ewa");
        assertThat(patientTO.getLastName()).isEqualTo("Novak"); // Updated to match database
        assertThat(patientTO.getTelephoneNumber()).isEqualTo("+4811112222");
        assertThat(patientTO.getEmail()).isEqualTo("ewa.novak@example.com");
        assertThat(patientTO.getPatientNumber()).isEqualTo("PAT002");
        assertThat(patientTO.getDateOfBirth()).isEqualTo(LocalDate.parse("1985-05-15"));
        assertThat(patientTO.getGender()).isEqualTo(Gender.FEMALE);

        assertThat(shouldBeNull).isNull();
    }

    @Transactional
    @Test
    public void testShouldDeleteVisitsNotDoctorsWhenDeletePatient() {
        // given
        Long patientId = 2L; // Patient to delete
        Long doctorId1 = 1L; // Example doctor IDs to validate
        Long doctorId2 = 2L;
        Long doctorId3 = 3L;

        // Fetch patient and visits
        var patient = patientDao.findOne(patientId);
        assertThat(patient).isNotNull(); // Ensure the patient exists

        List<VisitEntity> visitsBeforeDelete = patient.getVisits();
        assertThat(visitsBeforeDelete.size()).isEqualTo(2); // Patient ID 2 has 2 visits in data.sql

        // Ensure the initial state of doctors
        assertThat(doctorDao.findOne(doctorId1)).isNotNull();
        assertThat(doctorDao.findOne(doctorId2)).isNotNull();
        assertThat(doctorDao.findOne(doctorId3)).isNotNull();

        // Count total visits before deletion
        int totalVisitsBefore = visitDao.findAll().size();
        assertThat(totalVisitsBefore).isEqualTo(5); // Total visits from data.sql

        // when
        patientService.deleteById(patientId);

        // then
        // Verify the patient is deleted
        assertThat(patientDao.findOne(patientId)).isNull();

        // Verify all associated visits are removed
        for (VisitEntity visit : visitsBeforeDelete) {
            assertThat(visitDao.findOne(visit.getId())).isNull();
        }

        // Verify total visit count has decreased by 2 (visits associated with the deleted patient)
        assertThat(visitDao.findAll().size()).isEqualTo(totalVisitsBefore - 2);

        // Ensure no doctors are deleted
        assertThat(doctorDao.findOne(doctorId1)).isNotNull();
        assertThat(doctorDao.findOne(doctorId2)).isNotNull();
        assertThat(doctorDao.findOne(doctorId3)).isNotNull();
    }


    @Transactional
    @Test
    public void testShouldFindAllPatientVisits() {
        // Given
        Long patientId = 3L;

        // When
        List<VisitTO> visits = patientService.findVisitsOfPatient(patientId);

        // Then
        assertThat(visits).isNotEmpty();
        assertThat(visits.size()).isEqualTo(1);
        VisitTO visit = visits.get(0);
        assertThat(visit.getDescription()).isEqualTo("Skin consultation");
        assertThat(visit.getTime()).isEqualTo(LocalDateTime.of(2024, 12, 4, 12, 0));
        assertThat(visit.getDoctorName()).isEqualTo("Jane Doe");
    }

}
