package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.AddressEntity;

/**
 * DAO interface for `AddressEntity`.
 * Extends the generic DAO interface to provide basic CRUD operations for `AddressEntity`.
 */
public interface AddressDao extends Dao<AddressEntity, Long> {

    /**
     * Finds an `AddressEntity` by its ID.
     *
     * @param id The ID of the address to find.
     * @return The found `AddressEntity`, or `null` if not found.
     */
    AddressEntity findById(Long id);
}
