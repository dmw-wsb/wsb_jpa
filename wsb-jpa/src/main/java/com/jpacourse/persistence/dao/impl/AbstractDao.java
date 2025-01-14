package com.jpacourse.persistence.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.jpacourse.persistence.dao.Dao;
import org.springframework.transaction.annotation.Transactional;

/**
 * Abstract base class for Data Access Objects (DAO).
 * Provides generic CRUD operations for any entity type.
 *
 * @param <T> the type of the entity
 * @param <K> the type of the primary key
 */
@Transactional
public abstract class AbstractDao<T, K extends Serializable> implements Dao<T, K> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> domainClass;

	/**
	 * Saves a new entity in the database.
	 *
	 * @param entity the entity to be saved
	 * @return the persisted entity
	 */
	@Override
	public T save(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	/**
	 * Retrieves a reference to the entity without initializing it.
	 *
	 * @param id the primary key of the entity
	 * @return a reference to the entity
	 */
	@Override
	public T getOne(K id) {
		return entityManager.getReference(getDomainClass(), id);
	}

	/**
	 * Retrieves an entity by its primary key.
	 *
	 * @param id the primary key of the entity
	 * @return the found entity or null if not found
	 */
	@Override
	public T findOne(K id) {
		return entityManager.find(getDomainClass(), id);
	}

	/**
	 * Retrieves all entities of the specified type.
	 *
	 * @return a list of all entities
	 */
	@Override
	public List<T> findAll() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(getDomainClass());
		criteriaQuery.from(getDomainClass());
		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	/**
	 * Updates an existing entity.
	 *
	 * @param entity the entity to be updated
	 * @return the updated entity
	 */
	@Override
	public T update(T entity) {
		return entityManager.merge(entity);
	}

	/**
	 * Deletes a specific entity.
	 *
	 * @param entity the entity to be deleted
	 */
	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	/**
	 * Deletes an entity by its primary key.
	 *
	 * @param id the primary key of the entity
	 */
	@Override
	public void delete(K id) {
		entityManager.remove(getOne(id));
	}

	/**
	 * Deletes all entities of the specified type.
	 */
	@Override
	public void deleteAll() {
		entityManager.createQuery("DELETE FROM " + getDomainClassName()).executeUpdate();
	}

	/**
	 * Counts the total number of entities of the specified type.
	 *
	 * @return the total count of entities
	 */
	@Override
	public long count() {
		return (long) entityManager.createQuery("SELECT COUNT(*) FROM " + getDomainClassName()).getSingleResult();
	}

	/**
	 * Checks if an entity exists by its primary key.
	 *
	 * @param id the primary key of the entity
	 * @return true if the entity exists, false otherwise
	 */
	@Override
	public boolean exists(K id) {
		return findOne(id) != null;
	}

	/**
	 * Retrieves the domain class type.
	 *
	 * @return the domain class
	 */
	@SuppressWarnings("unchecked")
	protected Class<T> getDomainClass() {
		if (domainClass == null) {
			ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
			domainClass = (Class<T>) type.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	/**
	 * Retrieves the domain class name.
	 *
	 * @return the domain class name
	 */
	protected String getDomainClassName() {
		return getDomainClass().getName();
	}
}
