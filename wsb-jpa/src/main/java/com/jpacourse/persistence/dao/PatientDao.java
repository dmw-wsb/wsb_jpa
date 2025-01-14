package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.enums.Gender;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DAO interface for managing PatientEntity operations.
 */
public interface PatientDao extends Dao<PatientEntity, Long> {

    /**
     * Adds a visit to the patient with the given ID.
     *
     * @param patientId   the ID of the patient
     * @param doctorId    the ID of the doctor
     * @param time        the date and time of the visit
     * @param description the description of the visit
     */
    void addVisit(long patientId, long doctorId, LocalDateTime time, String description);

    /**
     * Finds patients by their last name.
     *
     * @param lastName the last name to search for
     * @return a list of patients with the given last name
     */
    List<PatientEntity> findByLastName(String lastName);

    /**
     * Retrieves patients with more than a specified number of visits.
     *
     * @param visitCount the minimum number of visits
     * @return a list of patients who meet the criteria
     */
    @Query("SELECT p FROM PatientEntity p JOIN p.visits v GROUP BY p.id HAVING COUNT(v.id) > :visitCount")
    List<PatientEntity> findWithMoreVisits(@Param("visitCount") long visitCount);

    /**
     * Finds patients by their gender.
     *
     * @param g the gender to search for
     * @return a list of patients with the given gender
     */
    List<PatientEntity> findByGender(Gender g);
}
