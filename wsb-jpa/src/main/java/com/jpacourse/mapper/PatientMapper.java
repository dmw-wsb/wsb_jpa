package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.entity.PatientEntity;

public class PatientMapper {

    /**
     * Maps a PatientEntity to a PatientTO.
     *
     * @param patientEntity the PatientEntity to map
     * @return the mapped PatientTO, or null if the input is null
     */
    public static PatientTO mapToTO(final PatientEntity patientEntity) {
        if (patientEntity == null) {
            return null;
        }

        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setGender(patientEntity.getGender());
        patientTO.setAddress(AddressMapper.mapToTO(patientEntity.getAddress()));

        // Update reference to use VisitsMapper
        patientTO.setVisits(VisitsMapper.mapListToTO(patientEntity.getVisits()));

        return patientTO;
    }
}
