package com.jpacourse.persistence.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic DAO interface providing basic CRUD operations.
 *
 * @param <T> the type of the entity
 * @param <K> the type of the entity's primary key
 */
public interface Dao<T, K extends Serializable> {

    /**
     * Saves a new entity.
     *
     * @param entity the entity to save
     * @return the saved entity
     */
    T save(T entity);

    /**
     * Retrieves an entity by its ID, returning a reference without hitting the database.
     *
     * @param id the ID of the entity
     * @return the entity reference
     */
    T getOne(K id);

    /**
     * Retrieves an entity by its ID.
     *
     * @param id the ID of the entity
     * @return the entity or null if not found
     */
    T findOne(K id);

    /**
     * Retrieves all entities.
     *
     * @return a list of all entities
     */
    List<T> findAll();

    /**
     * Updates an existing entity.
     *
     * @param entity the entity to update
     * @return the updated entity
     */
    T update(T entity);

    /**
     * Deletes an entity.
     *
     * @param entity the entity to delete
     */
    void delete(T entity);

    /**
     * Deletes an entity by its ID.
     *
     * @param id the ID of the entity
     */
    void delete(K id);

    /**
     * Deletes all entities.
     */
    void deleteAll();

    /**
     * Counts the total number of entities.
     *
     * @return the number of entities
     */
    long count();

    /**
     * Checks if an entity exists by its ID.
     *
     * @param id the ID of the entity
     * @return true if the entity exists, false otherwise
     */
    boolean exists(K id);
}
