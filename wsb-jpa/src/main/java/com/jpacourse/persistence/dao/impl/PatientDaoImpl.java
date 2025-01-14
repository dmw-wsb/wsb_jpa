package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of PatientDao with custom methods for handling patient data.
 */
@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Autowired
    private DoctorDao doctorDao;

    /**
     * Adds a visit to a patient with the specified doctor and details.
     *
     * @param patientId   ID of the patient.
     * @param doctorId    ID of the doctor.
     * @param time        Time of the visit.
     * @param description Description of the visit.
     */
    @Override
    public void addVisit(long patientId, long doctorId, LocalDateTime time, String description) {
        PatientEntity patient = getOne(patientId);

        VisitEntity newVisit = new VisitEntity();
        newVisit.setDescription(description);
        newVisit.setTime(time);
        newVisit.setDoctor(doctorDao.getOne(doctorId));
        newVisit.setPatient(patient);

        List<VisitEntity> visits = patient.getVisits();
        if (visits == null) {
            visits = new ArrayList<>();
        }
        visits.add(newVisit);
        patient.setVisits(visits);
        update(patient);
    }

    /**
     * Finds patients by their last name.
     *
     * @param lastName Last name to search for.
     * @return List of patients with the specified last name.
     */
    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    /**
     * Finds patients who have more than the specified number of visits.
     *
     * @param visitCount Minimum number of visits.
     * @return List of patients with more visits than the specified count.
     */
    @Override
    public List<PatientEntity> findWithMoreVisits(long visitCount) {
        String jpql = "SELECT p FROM PatientEntity p JOIN p.visits v GROUP BY p.id HAVING COUNT(v.id) > :visitCount";
        return entityManager.createQuery(jpql, PatientEntity.class)
                .setParameter("visitCount", visitCount)
                .getResultList();
    }

    /**
     * Finds patients by their gender.
     *
     * @param gender Gender to search for.
     * @return List of patients with the specified gender.
     */
    @Override
    public List<PatientEntity> findByGender(Gender gender) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE p.gender = :gender", PatientEntity.class);
        query.setParameter("gender", gender);
        return query.getResultList();
    }
}
