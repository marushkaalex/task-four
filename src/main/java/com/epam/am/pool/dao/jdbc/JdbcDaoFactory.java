package com.epam.am.pool.dao.jdbc;

import com.epam.am.pool.dao.DaoException;
import com.epam.am.pool.dao.DaoFactory;
import com.epam.am.pool.dao.UserDao;
import com.epam.am.pool.db.ConnectionPool;
import com.epam.am.pool.db.ConnectionPoolException;

import java.sql.Connection;

public class JdbcDaoFactory extends DaoFactory {
    private Connection connection;

    public JdbcDaoFactory() throws DaoException {
        try {
            this.connection = ConnectionPool.getInstance().getConnection();
        } catch (ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public UserDao getUserDao() {
        return new JdbcUserDao(connection);
    }
}
