package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

/**
 * Implementation of the VisitDao interface for VisitEntity.
 * Extends AbstractDao to provide basic CRUD operations.
 */
@Repository
public class VisitDaoImpl extends AbstractDao<VisitEntity, Long> implements VisitDao {
}
