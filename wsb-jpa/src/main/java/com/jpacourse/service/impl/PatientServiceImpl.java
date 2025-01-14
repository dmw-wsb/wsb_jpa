package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static com.jpacourse.mapper.VisitsMapper.mapListToTO;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    /**
     * Finds a patient by their ID and maps it to a DTO.
     *
     * @param id The ID of the patient to find.
     * @return The mapped {@link PatientTO} object or null if not found.
     */
    @Override
    public PatientTO findById(final Long id) {
        PatientEntity entity = patientDao.findOne(id);
        if (entity == null) {
            return null; // Returning null for non-existent patient
        }
        return PatientMapper.mapToTO(entity);
    }

    /**
     * Deletes a patient by their ID.
     * Ensures cascade deletion of visits but retains related doctors.
     *
     * @param id The ID of the patient to delete.
     */
    @Override
    public void deleteById(final Long id) {
        if (!patientDao.exists(id)) {
            throw new IllegalArgumentException("Patient with ID " + id + " does not exist.");
        }
        patientDao.delete(id);
    }

    /**
     * Finds all visits of a patient by their ID and maps them to DTOs.
     *
     * @param id The ID of the patient whose visits are to be retrieved.
     * @return A list of {@link VisitTO} representing the patient's visits.
     */
    @Override
    public List<VisitTO> findVisitsOfPatient(final Long id) {
        PatientEntity entity = patientDao.findOne(id);
        if (entity == null) {
            throw new IllegalArgumentException("Patient with ID " + id + " not found.");
        }
        List<VisitEntity> visits = entity.getVisits();
        return mapListToTO(visits);
    }

    /**
     * Adds a visit to an existing patient.
     *
     * @param patientId   the ID of the patient
     * @param doctorId    the ID of the doctor
     * @param time        the date and time of the visit
     * @param description the description of the visit
     */
    @Transactional
    public void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime time, String description) {
        patientDao.addVisit(patientId, doctorId, time, description);
    }
}
