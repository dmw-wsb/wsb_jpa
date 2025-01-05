package com.jpacourse.dto;

import com.jpacourse.persistence.enums.Gender;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class PatientTO implements Serializable {

    private Long id;

    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @Pattern(regexp = "\\+?[0-9\\-\\s]{7,15}", message = "Invalid telephone number format")
    private String telephoneNumber;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Patient number cannot be blank")
    private String patientNumber;

    @NotNull(message = "Date of birth cannot be null")
    private LocalDate dateOfBirth;

    @NotNull(message = "Gender cannot be null")
    private Gender gender;

    private AddressTO address;

    private List<VisitTO> visits;

    // Constructors
    public PatientTO() {
    }

    public PatientTO(Long id, String firstName, String lastName, String telephoneNumber, String email, String patientNumber,
                     LocalDate dateOfBirth, Gender gender, AddressTO address, List<VisitTO> visits) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.patientNumber = patientNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.visits = visits;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public AddressTO getAddress() {
        return address;
    }

    public void setAddress(AddressTO address) {
        this.address = address;
    }

    public List<VisitTO> getVisits() {
        return visits != null ? Collections.unmodifiableList(visits) : Collections.emptyList();
    }

    public void setVisits(List<VisitTO> visits) {
        this.visits = visits;
    }

    // Overrides for toString, equals, and hashCode
    @Override
    public String toString() {
        return "PatientTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", patientNumber='" + patientNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", address=" + address +
                ", visits=" + visits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientTO patientTO = (PatientTO) o;

        if (!id.equals(patientTO.id)) return false;
        if (!firstName.equals(patientTO.firstName)) return false;
        if (!lastName.equals(patientTO.lastName)) return false;
        if (telephoneNumber != null ? !telephoneNumber.equals(patientTO.telephoneNumber) : patientTO.telephoneNumber != null)
            return false;
        if (email != null ? !email.equals(patientTO.email) : patientTO.email != null) return false;
        if (!patientNumber.equals(patientTO.patientNumber)) return false;
        if (!dateOfBirth.equals(patientTO.dateOfBirth)) return false;
        if (gender != patientTO.gender) return false;
        return address != null ? address.equals(patientTO.address) : patientTO.address == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (telephoneNumber != null ? telephoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + patientNumber.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
