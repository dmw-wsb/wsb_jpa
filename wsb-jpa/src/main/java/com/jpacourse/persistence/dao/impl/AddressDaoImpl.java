package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.AddressDao;
import com.jpacourse.persistence.entity.AddressEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Implementation of the AddressDao interface.
 * Provides CRUD operations and access to AddressEntity data.
 */
@Repository
public class AddressDaoImpl extends AbstractDao<AddressEntity, Long> implements AddressDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Finds an AddressEntity by its ID.
     *
     * @param id The ID of the address to find.
     * @return The found AddressEntity, or null if not found.
     */
    @Override
    public AddressEntity findById(Long id) {
        return entityManager.find(AddressEntity.class, id);
    }
}
