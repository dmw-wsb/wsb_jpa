package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import org.springframework.stereotype.Repository;

/**
 * Implementation of the DoctorDao interface.
 * Provides CRUD operations and access to DoctorEntity data.
 */
@Repository
public class DoctorDaoImpl extends AbstractDao<DoctorEntity, Long> implements DoctorDao {

}
