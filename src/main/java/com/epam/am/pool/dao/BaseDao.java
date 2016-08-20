package com.epam.am.pool.dao;

public interface BaseDao<T> {
    void save(T model) throws DaoException;

    void delete(T model) throws DaoException;

    T findById(Long id) throws DaoException;
}
