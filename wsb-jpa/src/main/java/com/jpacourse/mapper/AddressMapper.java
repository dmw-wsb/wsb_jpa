package com.jpacourse.mapper;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.persistence.entity.AddressEntity;

/**
 * Utility class for mapping between AddressEntity and AddressTO.
 */
public final class AddressMapper {

    private AddressMapper() {
        // Private constructor to prevent instantiation
    }

    /**
     * Maps an AddressEntity to an AddressTO.
     *
     * @param addressEntity the AddressEntity to map
     * @return the mapped AddressTO, or null if the input is null
     */
    public static AddressTO mapToTO(final AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }

        final AddressTO addressTO = new AddressTO();
        addressTO.setId(addressEntity.getId());
        addressTO.setAddressLine1(addressEntity.getAddressLine1());
        addressTO.setAddressLine2(addressEntity.getAddressLine2());
        addressTO.setCity(addressEntity.getCity());
        addressTO.setPostalCode(addressEntity.getPostalCode());

        return addressTO;
    }

    /**
     * Maps an AddressTO to an AddressEntity.
     *
     * @param addressTO the AddressTO to map
     * @return the mapped AddressEntity, or null if the input is null
     */
    public static AddressEntity mapToEntity(final AddressTO addressTO) {
        if (addressTO == null) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(addressTO.getId());
        addressEntity.setAddressLine1(addressTO.getAddressLine1());
        addressEntity.setAddressLine2(addressTO.getAddressLine2());
        addressEntity.setCity(addressTO.getCity());
        addressEntity.setPostalCode(addressTO.getPostalCode());

        return addressEntity;
    }
}
