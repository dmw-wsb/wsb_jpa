package com.jpacourse.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.repository.PatientRepository;
import com.jpacourse.repository.VisitRepository;
import com.jpacourse.repository.DoctorRepository;
import com.jpacourse.dto.PatientTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @MockBean
    private PatientRepository patientRepository;

    @MockBean
    private VisitRepository visitRepository;

    @MockBean
    private DoctorRepository doctorRepository;

    @Transactional
    @Test
    public void testDeletingPatientCascadesToVisits() {
        Long patientId = 1L;
        PatientEntity patient = new PatientEntity();
        patient.setId(patientId);
        List<VisitEntity> visits = new ArrayList<>();
        VisitEntity visit = new VisitEntity();
        visits.add(visit);
        patient.setVisits(visits);

        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));

        patientService.deletePatient(patientId);

        verify(visitRepository, times(1)).deleteAll(visits);
        verify(patientRepository, times(1)).delete(patient);
        verify(doctorRepository, never()).delete(any(DoctorEntity.class));
    }

    @Test
    public void testFindPatientById() {
        Long patientId = 1L;
        PatientEntity patient = new PatientEntity();
        patient.setId(patientId);
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setPatientNumber("P12345");

        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));

        PatientTO patientTO = patientService.getPatientById(patientId);

        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getFirstName()).isEqualTo("John");
        assertThat(patientTO.getLastName()).isEqualTo("Doe");
        assertThat(patientTO.getPatientNumber()).isEqualTo("P12345");
        // Add further assertions as needed for additional fields or relationships
    }
}
