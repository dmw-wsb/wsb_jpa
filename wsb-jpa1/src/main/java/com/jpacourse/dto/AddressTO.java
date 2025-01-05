package com.jpacourse.dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddressTO implements Serializable {

    private Long id;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "Address line 1 cannot be blank")
    @Size(max = 255, message = "Address line 1 cannot exceed 255 characters")
    private String addressLine1;

    private String addressLine2;

    @NotBlank(message = "Postal code cannot be blank")
    private String postalCode;

    // No-args constructor
    public AddressTO() {
    }

    // Constructor with all fields
    public AddressTO(Long id, String city, String addressLine1, String addressLine2, String postalCode) {
        this.id = id;
        this.city = city;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "AddressTO{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressTO addressTO = (AddressTO) o;

        if (!id.equals(addressTO.id)) return false;
        if (!city.equals(addressTO.city)) return false;
        if (!addressLine1.equals(addressTO.addressLine1)) return false;
        if (addressLine2 != null ? !addressLine2.equals(addressTO.addressLine2) : addressTO.addressLine2 != null)
            return false;
        return postalCode.equals(addressTO.postalCode);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + addressLine1.hashCode();
        result = 31 * result + (addressLine2 != null ? addressLine2.hashCode() : 0);
        result = 31 * result + postalCode.hashCode();
        return result;
    }
}
