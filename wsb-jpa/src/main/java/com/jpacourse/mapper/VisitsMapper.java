package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.TreatmentType;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper class for transforming VisitEntity objects into VisitTO objects.
 */
public class VisitsMapper {

    /**
     * Maps a single VisitEntity to a VisitTO.
     *
     * @param visitEntity the VisitEntity to map
     * @return the mapped VisitTO, or null if the input is null
     */
    public static VisitTO mapToTO(final VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }

        final VisitTO visitTO = new VisitTO();

        // Map basic fields
        visitTO.setTime(visitEntity.getTime());
        visitTO.setDescription(visitEntity.getDescription());

        // Map doctor's full name
        if (visitEntity.getDoctor() != null) {
            String doctorName = visitEntity.getDoctor().getFirstName() + " " + visitEntity.getDoctor().getLastName();
            visitTO.setDoctorName(doctorName);
        }

        // Extract treatment types
        List<TreatmentType> treatmentTypes = new ArrayList<>();
        if (visitEntity.getTreatments() != null) {
            for (MedicalTreatmentEntity treatment : visitEntity.getTreatments()) {
                treatmentTypes.add(treatment.getType());
            }
        }
        visitTO.setTreatmentTypes(treatmentTypes);

        return visitTO;
    }

    /**
     * Maps a list of VisitEntity objects to a list of VisitTO objects.
     *
     * @param visitEntities the list of VisitEntity objects to map
     * @return a list of mapped VisitTO objects
     */
    public static List<VisitTO> mapListToTO(List<VisitEntity> visitEntities) {
        List<VisitTO> visitTOList = new ArrayList<>();
        if (visitEntities != null) {
            for (VisitEntity visit : visitEntities) {
                VisitTO mappedVisit = mapToTO(visit);
                if (mappedVisit != null) {
                    visitTOList.add(mappedVisit);
                }
            }
        }
        return visitTOList;
    }
}
