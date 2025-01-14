package com.jpacourse.service.impl;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.mapper.AddressMapper;
import com.jpacourse.persistence.dao.AddressDao;
import com.jpacourse.persistence.entity.AddressEntity;
import com.jpacourse.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressDao addressDao;

    @Autowired
    public AddressServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    /**
     * Finds an address by its ID and maps it to a DTO.
     *
     * @param id The ID of the address to find.
     * @return The mapped {@link AddressTO} or null if not found.
     */
    @Override
    public AddressTO findById(Long id) {
        AddressEntity entity = addressDao.findOne(id);
        if (entity == null) {
            throw new IllegalArgumentException("Address with ID " + id + " not found.");
        }
        return AddressMapper.mapToTO(entity);
    }
}
