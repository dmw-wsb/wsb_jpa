package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.TreatmentType;

import java.util.ArrayList;
import java.util.List;

public class VisitsMapper {
    public static VisitTO mapToTO(final VisitEntity visitEntity)
    {
        if (visitEntity == null)
        {
            return null;
        }
        final VisitTO patientsVisitTO = new VisitTO();
        patientsVisitTO.setTime(visitEntity.getTime());
        patientsVisitTO.setDoctorFirstName(visitEntity.getDoctor().getFirstName());
        patientsVisitTO.setDoctorLastName(visitEntity.getDoctor().getLastName());

        List<TreatmentType> typeList = new ArrayList<>();
        for(MedicalTreatmentEntity mte : visitEntity.getTreatments())
        {
            typeList.add(mte.getType());
        }
        patientsVisitTO.setType(typeList);

        return patientsVisitTO;
    }

    public static List<VisitTO> mapListToTO(final List<VisitEntity> visits)
    {
        List<VisitTO> result = new ArrayList<>();
        if(visits!=null){
            for(VisitEntity visit : visits)
            {
                result.add(mapToTO(visit));
            }
        }
        return result;
    }
}
