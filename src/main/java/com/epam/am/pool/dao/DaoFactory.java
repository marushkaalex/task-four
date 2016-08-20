package com.epam.am.pool.dao;

public abstract class DaoFactory {
    public static DaoFactory getFactory() throws DaoException {
        try {
            // TODO get class name from properties
            String className = "com.epam.am.pool.dao.jdbc.JdbcDaoFactory";
            Class<?> factoryClass = Class.forName(className);
            return ((DaoFactory) factoryClass.newInstance());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new DaoException(e);
        }
    }

    public abstract UserDao getUserDao();
}
