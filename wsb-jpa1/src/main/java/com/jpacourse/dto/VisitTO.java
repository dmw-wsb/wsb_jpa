package com.jpacourse.dto;

import com.jpacourse.persistence.enums.TreatmentType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class VisitTO implements Serializable {

    @NotNull(message = "Visit time cannot be null")
    private LocalDateTime time;

    @NotBlank(message = "Doctor's first name cannot be blank")
    private String doctorFirstName;

    @NotBlank(message = "Doctor's last name cannot be blank")
    private String doctorLastName;

    @NotNull(message = "Treatment types cannot be null")
    private List<TreatmentType> type;

    // No-args constructor
    public VisitTO() {
    }

    // Constructor with all fields
    public VisitTO(LocalDateTime time, String doctorFirstName, String doctorLastName, List<TreatmentType> type) {
        this.time = time;
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
        this.type = type;
    }

    // Getters and Setters
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public List<TreatmentType> getType() {
        return type != null ? Collections.unmodifiableList(type) : Collections.emptyList();
    }

    public void setType(List<TreatmentType> type) {
        this.type = type;
    }

    // Overrides for toString, equals, and hashCode
    @Override
    public String toString() {
        return "VisitTO{" +
                "time=" + time +
                ", doctorFirstName='" + doctorFirstName + '\'' +
                ", doctorLastName='" + doctorLastName + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisitTO visitTO = (VisitTO) o;

        if (!time.equals(visitTO.time)) return false;
        if (!doctorFirstName.equals(visitTO.doctorFirstName)) return false;
        if (!doctorLastName.equals(visitTO.doctorLastName)) return false;
        return type != null ? type.equals(visitTO.type) : visitTO.type == null;
    }

    @Override
    public int hashCode() {
        int result = time.hashCode();
        result = 31 * result + doctorFirstName.hashCode();
        result = 31 * result + doctorLastName.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
