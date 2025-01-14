package com.jpacourse.dto;

import com.jpacourse.persistence.enums.TreatmentType;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class VisitTO implements Serializable {
    private LocalDateTime time;
    private String doctorName; // Pole dla nazwy lekarza
    private String doctorFirstName;
    private String doctorLastName;
    private List<TreatmentType> treatmentTypes;
    private String description;
    // Getter and Setter for 'time'
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    // Getter and Setter for 'doctorFirstName'
    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    // Getter and Setter for 'doctorLastName'
    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    // Getter and Setter for 'treatmentTypes'
    public List<TreatmentType> getTreatmentTypes() {
        return treatmentTypes;
    }

    public void setTreatmentTypes(List<TreatmentType> treatmentTypes) {
        this.treatmentTypes = treatmentTypes;
    }
    public String getDescription() {
        return description;
    }
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setDescription(String description) {
        this.description = description; // Setter for description
    }
}
